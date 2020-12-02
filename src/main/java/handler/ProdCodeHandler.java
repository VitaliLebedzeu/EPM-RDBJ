package handler;

import annotation.ProdCode;
import tool.ReflectionApi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ProdCodeHandler {

    public void invokeMethod(String classPath) {
        Class<?> clazz = ReflectionApi.getClass(classPath);
        if (clazz != null) {
            for (Method method : clazz.getDeclaredMethods()) {
                if (method.isAnnotationPresent(ProdCode.class)) {
                    method.setAccessible(true);
                    runInNewThread(method, clazz);
                }
            }
        }
    }

    public void runInNewThread(Method method, Class<?> clazz) {
        try {
            method.invoke(clazz);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
