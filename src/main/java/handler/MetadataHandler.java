package handler;

import annotation.ThisCodeSmells;
import org.apache.commons.lang3.StringUtils;
import tool.ReflectionApi;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MetadataHandler {

    public String getClassMetadata(String classPath) {
        Class<?> clazz = ReflectionApi.getClass(classPath);
        StringBuilder stringBuilder = new StringBuilder("Class:\n");
        if (clazz != null) {
            Arrays.stream(clazz.getDeclaredAnnotations()).forEach(a -> stringBuilder.append(a.toString()).append(StringUtils.LF));
            stringBuilder.append(Modifier.toString(clazz.getModifiers())).append(StringUtils.SPACE).append(clazz.getSimpleName()).append(" extends ");
            Class<?> superClass = clazz.getSuperclass();
            if (superClass != null) {
                stringBuilder.append(clazz.getSuperclass().getSimpleName()).append(" implements ");
            }
            Arrays.stream(clazz.getInterfaces()).forEach(i -> stringBuilder.append(i.getSimpleName()));

            stringBuilder.append(StringUtils.LF).append("Class Fields:\n");
            stringBuilder.append(getFieldsMetadata(clazz.getDeclaredFields()));

            stringBuilder.append("Class Constructors:\n");
            stringBuilder.append(getConstructorsMetadata(clazz.getDeclaredConstructors()));

            stringBuilder.append("Class Methods:\n");
            stringBuilder.append(getMethodsMetadata(clazz.getDeclaredMethods())).append(StringUtils.LF);
        }
        return stringBuilder.toString();
    }

    @ThisCodeSmells
    private static String getFieldsMetadata(Field[] fields) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(fields).forEach(f -> {
            f.setAccessible(true);
            Arrays.stream(f.getDeclaredAnnotations()).forEach(a -> stringBuilder.append(a.toString()).append(StringUtils.LF));
            stringBuilder.append(Modifier.toString(f.getModifiers())).append(StringUtils.SPACE).append(f.getType().getSimpleName())
                         .append(StringUtils.SPACE).append(f.getName()).append(StringUtils.LF);
        });
        return stringBuilder.toString();
    }

    @ThisCodeSmells
    private static String getConstructorsMetadata(Constructor<?>[] constructors) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(constructors).forEach(c -> {
            c.setAccessible(true);
            Arrays.stream(c.getDeclaredAnnotations()).forEach(a -> stringBuilder.append(a.toString()).append(StringUtils.LF));
            stringBuilder.append(Modifier.toString(c.getModifiers())).append(StringUtils.SPACE).append(c.getName()).append("(");
            Arrays.stream(c.getParameters())
                  .forEach(p -> stringBuilder.append(p.getType().getSimpleName()).append(StringUtils.EMPTY).append(p.getName()).append(", "));
            stringBuilder.append(")").append(StringUtils.LF);;
        });
        return stringBuilder.toString();
    }

    @ThisCodeSmells
    public static String getMethodsMetadata(Method[] methods) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(methods).forEach(m -> {
            m.setAccessible(true);
            Arrays.stream(m.getDeclaredAnnotations()).forEach(a -> stringBuilder.append(a.toString()).append(StringUtils.LF));
            stringBuilder.append(Modifier.toString(m.getModifiers())).append(StringUtils.SPACE).append(m.getReturnType().getSimpleName())
                         .append(StringUtils.SPACE).append(m.getName()).append("(");
            Arrays.stream(m.getParameters())
                  .forEach(p -> stringBuilder.append(p.getType().getSimpleName()).append(StringUtils.SPACE).append(p.getName()));
            stringBuilder.append(")").append(StringUtils.LF);
        });
        return stringBuilder.toString();
    }
}
