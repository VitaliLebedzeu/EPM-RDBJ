package handler;

import annotation.ThisCodeSmells;
import tool.ReflectionApi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ThisCodeSmellsHandler {

    private static Map<String, Integer> smellyCodeTable;

    public ThisCodeSmellsHandler() {
        smellyCodeTable = new HashMap<>();
    }

    public void collectSmellyCode(String classPath) {
        Class<?> clazz = ReflectionApi.getClass(classPath);
        if (clazz != null) {
            collect(clazz);
        }
    }

    public Map<String, Integer> getSortedSmellyCodeTableByVote() {
        return smellyCodeTable.entrySet().stream().sorted(Map.Entry.comparingByValue())
                              .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    private void collect(Class<?> clazz) {
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
    }

    private String getReviewers(ThisCodeSmells[] reviewerList) {
        return Arrays.stream(reviewerList).map(ThisCodeSmells::reviewer).collect(Collectors.joining(", "));
    }

    private void logSmellsCode(String smellCode, int reviewersCount) {
        if (smellyCodeTable.containsKey(smellCode)) {
            int newEntry = smellyCodeTable.get(smellCode) + reviewersCount;
            smellyCodeTable.replace(smellCode, newEntry);
        } else {
            smellyCodeTable.put(smellCode, reviewersCount);
        }
    }
}
