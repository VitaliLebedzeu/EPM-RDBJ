package tool;

import annotation.ThisCodeSmells;
import model.vehicle.air.AirVehicleType;
import model.vehicle.air.MilitaryAirVehicleType;
import org.apache.commons.lang3.RandomStringUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflectionApi {

    private static final String FIELD_NOT_EXIST_MESSAGE_FORMAT = "The '%s' class does not have '%s' field.\n";
    private static final String CLASS_NOT_EXIST_MESSAGE_FORMAT = "The '%s' class is not exist.\n";
    private static final String CLASS_NOT_HAS_CONSTRUCTOR_MESSAGE_FORMAT = "The '%s' class does not have the '%s' constructor.\n";
    private static final String METHOD_NOT_EXIST_MESSAGE_FORMAT = "The '%s' class does not have '%s' method.\n";

    public static Object createClass(String className, Object... initArgs) {
        Class<?> clazz = getClass(className);
        Class<?>[] parameterTypes = Arrays.stream(initArgs).map(Object::getClass).toArray(Class<?>[]::new);
        Constructor<?> constructor = getClassConstructor(clazz, parameterTypes);
        return createInstance(constructor, initArgs);
    }

    public static void setClassField(Object object, Class<?> clazz, String fieldName, Object value) {
        Field field = getField(clazz, fieldName);
        if (field == null) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass.getFields().length != 0 | superClass.getDeclaredFields().length != 0) {
                setClassField(object, superClass, fieldName, value);
            } else {
                System.err.printf(FIELD_NOT_EXIST_MESSAGE_FORMAT, clazz.getSimpleName(), new NoSuchFieldException().getMessage());
            }
        } else {
            field.setAccessible(true);
            setField(object, field, value);
        }
    }

    public static void setAllClassFields(Object object, Class<?> clazz) {
        Field[] declaredFields = clazz.getDeclaredFields();
        setAllFields(object, declaredFields);
        Class<?> superClass = clazz.getSuperclass();
        if (superClass.getFields().length != 0 || superClass.getDeclaredFields().length != 0) {
            setAllClassFields(object, superClass);
        }
    }

    @ThisCodeSmells
    @SafeVarargs
    public static <A> void invokeVoidClassMethod(Object object, String methodName, A... initArgs) {
        Method method = getMethod(object, methodName, initArgs);
        invokeMethod(method, object, initArgs);
    }

    @ThisCodeSmells
    @SuppressWarnings("unchecked")
    public static <A, T> T invokeClassMethod(Object object, String methodName, A... initArgs) {
        Method method = getMethod(object, methodName, initArgs);
        return (T) invokeMethod(method, object, initArgs);
    }

    @SafeVarargs
    public static <V> Object invokeMethod(Method method, Object object, V... initArgs) {
        try {
            return (initArgs == null || initArgs.length == 0)
                    ? method.invoke(object)
                    : method.invoke(object, (Object) initArgs);
        } catch (IllegalAccessException | InvocationTargetException e) {
            System.err.println("[" + e.getClass().getSimpleName() + "] Application does not have access to the '"
                    + e.getMessage() + "' method.");
        }
        return null;
    }

    public static Class<?> getClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.err.printf(CLASS_NOT_EXIST_MESSAGE_FORMAT, e.getMessage());
        }
        return null;
    }

    private static Constructor<?> getClassConstructor(Class<?> clazz, Class<?>... parameterTypes) {
        try {
            return (parameterTypes == null || parameterTypes.length == 0)
                    ? clazz.getDeclaredConstructor()
                    : clazz.getDeclaredConstructor(parameterTypes);
        } catch (NoSuchMethodException e) {
            System.err.printf(CLASS_NOT_HAS_CONSTRUCTOR_MESSAGE_FORMAT, clazz.getSimpleName(), e.getMessage());
        }
        return null;
    }

    private static Object createInstance(Constructor<?> constructor, Object... initArgs) {
        try {
            return (initArgs == null || initArgs.length == 0)
                    ? constructor.newInstance()
                    : constructor.newInstance(initArgs);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
        return null;
    }

    private static Field getField(Class<?> clazz, String fieldName) {
        try {
            return clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            System.err.printf(FIELD_NOT_EXIST_MESSAGE_FORMAT, clazz.getSimpleName(), e.getMessage());
        }
        return null;
    }

    private static void setField(Object object, Field field, Object value) {
        try {
            field.set(object, value);
        } catch (IllegalAccessException e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }

    private static void setAllFields(Object object, Field[] fields) {
        Arrays.stream(fields).forEach(f -> {
            f.setAccessible(true);
            String fieldName = f.getType().getSimpleName();
            switch (fieldName) {
                case "String" -> setField(object, f, RandomStringUtils.randomAlphabetic(6));
                case "double" -> setField(object, f, Math.random() * 100);
                case "int" -> setField(object, f, (int) (Math.random() * 1000));
                case "boolean" -> setField(object, f, true);
                case "MilitaryAirVehicleType" -> setField(object, f, MilitaryAirVehicleType.FIGHTER);
                case "AirVehicleType" -> setField(object, f, AirVehicleType.PLANE);
                default -> setField(object, f, null);
            }
        });
    }

    @SafeVarargs
    private static <A> Method getMethod(Object object, String methodName, A... initArgs) {
        try {
            return (initArgs == null || initArgs.length == 0)
                    ? object.getClass().getMethod(methodName)
                    : object.getClass().getMethod(methodName, initArgs.getClass());
        } catch (NoSuchMethodException e) {
            System.err.printf(METHOD_NOT_EXIST_MESSAGE_FORMAT, object.getClass().getSimpleName(), e.getMessage());
        }
        return null;
    }
}
