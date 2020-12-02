import annotation.ProdCode;
import handler.MetadataHandler;
import handler.ProdCodeHandler;
import handler.ThisCodeSmellsHandler;
import org.apache.commons.lang3.StringUtils;
import runner.DefaultRunner;

import java.io.File;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String DOT = ".";
    private static final String JAVA_EXTENSION = ".java";
    private static final String ROOT_PATH = new File(StringUtils.EMPTY).getAbsolutePath();

    public static void main(String[] args) {
        ProdCodeHandler prodCodeHandler = new ProdCodeHandler();
        initRunner(ROOT_PATH, p -> prodCodeHandler.invokeMethod((String) p));
    }

    @ProdCode
    private static void metaDataRunner() {
        StringBuilder stringBuilder = new StringBuilder("All project metadata:").append(StringUtils.LF);
        stringBuilder.append(DefaultRunner.DELIMITER).append(StringUtils.LF);

        MetadataHandler metadataHandler = new MetadataHandler();
        initRunner(ROOT_PATH, p -> stringBuilder.append(metadataHandler.getClassMetadata((String) p)));

        System.out.println(stringBuilder.toString());
    }

    @ProdCode
    private static void codeSmellsRunner() {
        StringBuilder stringBuilder = new StringBuilder("All smelly code:").append(StringUtils.LF);
        stringBuilder.append(DefaultRunner.DELIMITER).append(StringUtils.LF);

        ThisCodeSmellsHandler thisCodeSmellsHandler = new ThisCodeSmellsHandler();
        initRunner(ROOT_PATH, thisCodeSmellsHandler::collectSmellyCode);
        thisCodeSmellsHandler.getSortedSmellyCodeTableByVote().forEach((k, v) -> stringBuilder.append(k).append(" - ").append(v).append(StringUtils.LF));

        System.out.println(stringBuilder.toString());
    }

    @SuppressWarnings("unchecked")
    private static <T> void initRunner(String path, Consumer<T> consumer) {
        File file = new File(path);
        if (file.isFile() && getFileExtension(file).equals(JAVA_EXTENSION)) {
            consumer.accept((T) convertPathToClassPath(file));
        } else {
            String[] files = file.list();
            if (files != null) {
                Arrays.stream(files).forEach(f -> {
                    File newFile = new File(file.getAbsolutePath() + File.separator + f);
                    initRunner(newFile.getPath(), consumer);
                });
            }
        }
    }

    private static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(DOT) != -1 && fileName.lastIndexOf(DOT) != 0)
            return fileName.substring(fileName.lastIndexOf(DOT));
        else return StringUtils.EMPTY;
    }

    private static String convertPathToClassPath(File file) {
        String path = file.getPath();
        String pattern = "(?<=java\\\\)([\\s\\S]+?)(?=.java)";
        Matcher matcher = Pattern.compile(pattern).matcher(path);
        return (matcher.find()) ? path.substring(matcher.start(), matcher.end()).replace("\\", ".") : StringUtils.EMPTY;
    }
}
