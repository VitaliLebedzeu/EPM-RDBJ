package handler;

import annotation.ThisCodeSmells;
import org.apache.commons.lang3.StringUtils;
import tool.ReflectionApi;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MetadataHandler {

    private final List<String> fullMetadata;

    public MetadataHandler() {
        this.fullMetadata = new ArrayList<>();
    }

    public List<String> getFullMetadata() {
        return fullMetadata;
    }

    public void collectClassMetadata(String classPath) {
        Class<?> clazz = ReflectionApi.getClass(classPath);
        String metadata = "Class:" + StringUtils.LF;
        if (clazz != null) {
            metadata += getAnnotationsMetadata(clazz.getDeclaredAnnotations());
            metadata += Modifier.toString(clazz.getModifiers()) + StringUtils.SPACE + clazz.getSimpleName();
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null) {
                metadata += " extends " + clazz.getSuperclass().getSimpleName();
            }
            Class<?>[] interfaces = clazz.getInterfaces();
            if (interfaces.length != 0) {
                metadata += Arrays.stream(interfaces).map(Class::getSimpleName)
                                  .collect(Collectors.joining(StringUtils.SPACE, " implements ", StringUtils.EMPTY));
            }
            metadata += getFieldsMetadata(clazz.getDeclaredFields());
            metadata += getConstructorsMetadata(clazz.getDeclaredConstructors());
            metadata += getMethodsMetadata(clazz.getDeclaredMethods());
        }
        fullMetadata.add(metadata + StringUtils.LF + StringUtils.LF);
    }

    @ThisCodeSmells
    private static String getFieldsMetadata(Field[] fields) {
        return fields.length == 0 ? StringUtils.EMPTY
                : Arrays.stream(fields).map(f -> {
            f.setAccessible(true);
            String metadata = getAnnotationsMetadata(f.getDeclaredAnnotations());
            metadata += Modifier.toString(f.getModifiers()) + StringUtils.SPACE + f.getType().getSimpleName() + StringUtils.SPACE + f.getName();
            return metadata;
        }).collect(Collectors.joining(StringUtils.LF, StringUtils.LF, StringUtils.EMPTY));
    }

    @ThisCodeSmells
    private static String getConstructorsMetadata(Constructor<?>[] constructors) {
        return constructors.length == 0 ? StringUtils.EMPTY
                : Arrays.stream(constructors).map(c -> {
            c.setAccessible(true);
            String metadata = getAnnotationsMetadata(c.getDeclaredAnnotations());
            metadata += Modifier.toString(c.getModifiers()) + StringUtils.SPACE + c.getName();
            metadata += getParametersMetadata(c.getParameters());
            return metadata;
        }).collect(Collectors.joining(StringUtils.LF, StringUtils.LF, StringUtils.EMPTY));
    }

    @ThisCodeSmells
    public static String getMethodsMetadata(Method[] methods) {
        return methods.length == 0 ? StringUtils.EMPTY
                : Arrays.stream(methods).map(m -> {
            m.setAccessible(true);
            String metadata = getAnnotationsMetadata(m.getDeclaredAnnotations());
            metadata += Modifier.toString(m.getModifiers()) + StringUtils.SPACE + m.getReturnType().getSimpleName() + StringUtils.SPACE + m.getName();
            metadata += getParametersMetadata(m.getParameters());
            return metadata;
        }).collect(Collectors.joining(StringUtils.LF, StringUtils.LF, StringUtils.EMPTY));
    }

    private static String getAnnotationsMetadata(Annotation[] annotations) {
        return annotations.length == 0 ? StringUtils.EMPTY
                : Arrays.stream(annotations).map(Annotation::toString).collect(Collectors.joining(StringUtils.LF, StringUtils.EMPTY, StringUtils.LF));
    }

    private static String getParametersMetadata(Parameter[] parameters) {
        return Arrays.stream(parameters).map(p -> p.getType().getSimpleName() + StringUtils.SPACE + p.getName())
                     .collect(Collectors.joining(StringUtils.SPACE, "(", ")"));
    }
}
