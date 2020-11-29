package task1.handler;

import task1.annotation.ThisCodeSmells;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class ThisCodeSmellsHandler {

    private static Map<String, Integer> smellsCodeLog;

    public void printSmeltCodeByObject(Object object) {
        if (Objects.isNull(object)) {
            System.err.println("The object to code smells investigation is null");
        }
        smellsCodeLog = new HashMap<>();
        Class<?> clazz = object.getClass();
        if (clazz.isAnnotationPresent(ThisCodeSmells.List.class)) {
            ThisCodeSmells[] reviewerList = clazz.getDeclaredAnnotation(ThisCodeSmells.List.class).value();
            String reviewers = getReviewers(reviewerList);
            String smellsCodeName = "class: " + clazz.getSimpleName() + " (reviewer = " + reviewers + ")";
            logSmellsCode(smellsCodeName, reviewerList.length);
        }
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ThisCodeSmells.List.class)) {
                field.setAccessible(true);
                ThisCodeSmells[] reviewerList = field.getDeclaredAnnotation(ThisCodeSmells.List.class).value();
                String reviewers = getReviewers(reviewerList);
                String smellsCodeName = "class: " + clazz.getSimpleName() + "\nfield: " + field.getName() + " (reviewer = " + reviewers + ")";
                logSmellsCode(smellsCodeName, reviewerList.length);
            }
        }
        for (Constructor<?> constructor : clazz.getDeclaredConstructors()) {
            if (constructor.isAnnotationPresent(ThisCodeSmells.List.class)) {
                constructor.setAccessible(true);
                ThisCodeSmells[] reviewerList = constructor.getDeclaredAnnotation(ThisCodeSmells.List.class).value();
                String reviewers = getReviewers(reviewerList);
                String smellsCodeName = "class: " + clazz.getSimpleName() + "\nconstructor: " + constructor
                        .getName() + " (reviewer = " + reviewers + ")";
                logSmellsCode(smellsCodeName, reviewerList.length);
            }
        }
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ThisCodeSmells.List.class)) {
                method.setAccessible(true);
                ThisCodeSmells[] reviewerList = method.getDeclaredAnnotation(ThisCodeSmells.List.class).value();
                String reviewers = getReviewers(reviewerList);
                String smellsCodeName = "class: " + clazz.getSimpleName() + "\nmethod: " + method.getName() + " (reviewer = " + reviewers + ")";
                logSmellsCode(smellsCodeName, reviewerList.length);
            }
        }
        System.out.println("All smells code:");
        smellsCodeLog.entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
    }

    private String getReviewers(ThisCodeSmells[] reviewerList) {
        return Arrays.stream(reviewerList).map(ThisCodeSmells::reviewer).collect(Collectors.joining(", "));
    }

    private void logSmellsCode(String smellCode, int reviewersCount) {
        if (smellsCodeLog.containsKey(smellCode)) {
            int newEntry = smellsCodeLog.get(smellCode) + reviewersCount;
            smellsCodeLog.replace(smellCode, newEntry);
        } else {
            smellsCodeLog.put(smellCode, reviewersCount);
        }
    }
}
