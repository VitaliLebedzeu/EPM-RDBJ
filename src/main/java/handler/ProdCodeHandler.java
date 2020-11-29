package handler;

import annotation.ProdCode;

import java.lang.reflect.Method;

public class ProdCodeHandler {

    public void initializeObject(String path) throws Exception {
        Class<?> clazz = Class.forName(path);
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ProdCode.class)) {
                method.setAccessible(true);
                method.invoke(clazz);
            }
        }
    }
}
