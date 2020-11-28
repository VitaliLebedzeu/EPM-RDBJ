import org.apache.commons.lang3.RandomStringUtils;
import task1.model.vehicle.air.AirVehicleType;
import task1.model.vehicle.air.MilitaryAirVehicleType;

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

    public static Object createClass(String className) {
        return createClass(className, null);
    }

    public static <R> Object createClass(String className, R r) {
        Class<?> clazz = getClass(className);
        if (r == null) {
            Constructor<?> constructor = getClassConstructor(clazz);
            return createInstance(constructor);
        } else {
            Constructor<?> constructor = getClassConstructor(clazz, r.getClass());
            return createInstance(constructor, r);
        }
    }

    public static <C> void setAllClassFields(C c, Class<?> clazz) {
        Field[] fields = clazz.getFields();
        setAllClassFields(c, fields);

        Field[] declaredFields = clazz.getDeclaredFields();
        setAllClassFields(c, declaredFields);

        Class<?> superClass = clazz.getSuperclass();
        if (superClass.getFields().length != 0 || superClass.getDeclaredFields().length != 0) {
            setAllClassFields(c, superClass);
        }
    }

    public static <C> void setClassField(C c, Class<?> clazz, String fieldName, Object value) {
        Field field = getField(clazz, fieldName);
        if (field == null) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass.getFields().length != 0 | superClass.getDeclaredFields().length != 0) {
                setClassField(c, superClass, fieldName, value);
            } else {
                System.err.printf(FIELD_NOT_EXIST_MESSAGE_FORMAT, clazz.getSimpleName(), new NoSuchFieldException().getMessage());
            }
        } else {
            field.setAccessible(true);
            setField(c, field, value);
        }
    }

    @SafeVarargs
    public static <C, V> void invokeVoidClassMethod(C c, String methodName, V... values) {
        Method method = null;
        try {
            method = (values == null) ? c.getClass().getMethod(methodName) : c.getClass().getMethod(methodName, values.getClass());
        } catch (NoSuchMethodException e) {
            System.err.printf(METHOD_NOT_EXIST_MESSAGE_FORMAT, c.getClass().getSimpleName(), e.getMessage());
        }
        if (method != null) {
            try {
                if (values == null) {
                    method.invoke(c);
                } else {
                    method.invoke(c, (Object) values);
                }
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <C, T> T invokeClassMethod(C c, String methodName) {
        Method method = null;
        try {
            method = c.getClass().getMethod(methodName);
        } catch (NoSuchMethodException e) {
            System.err.printf(METHOD_NOT_EXIST_MESSAGE_FORMAT, c.getClass().getSimpleName(), e.getMessage());
        }
        T t = null;
        if (method != null) {
            try {
                t = (T) method.invoke(c);
            } catch (IllegalAccessException | InvocationTargetException e) {
                System.err.println(Arrays.toString(e.getStackTrace()));
            }

        }
        return t;
    }

    private static Class<?> getClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.err.printf(CLASS_NOT_EXIST_MESSAGE_FORMAT, e.getMessage());
        }
        return null;
    }

    private static Constructor<?> getClassConstructor(Class<?> clazz) {
        return getClassConstructor(clazz, null);
    }

    private static Constructor<?> getClassConstructor(Class<?> clazz, Class<?> constructorClass) {
        Constructor<?> constructor = null;
        if (clazz == null) {
            System.err.printf(CLASS_NOT_EXIST_MESSAGE_FORMAT, new ClassNotFoundException().getMessage());
        } else {
            try {
                constructor = (constructorClass == null) ? clazz.getConstructor() : clazz.getConstructor(constructorClass);
            } catch (NoSuchMethodException e) {
                System.err.printf(CLASS_NOT_HAS_CONSTRUCTOR_MESSAGE_FORMAT, clazz.getSimpleName(), e.getMessage());
            }
        }
        return constructor;
    }

    private static Object createInstance(Constructor<?> constructor) {
        return createInstance(constructor, (Object) null);
    }

    private static <V> Object createInstance(Constructor<?> constructor, V v) {
        Object object = null;
        if (constructor == null) {
            System.err.printf("The '%s' constructor is not exist.\n", new NoSuchMethodException().getMessage());
        } else {
            try {
                object = (v == null) ? constructor.newInstance() : constructor.newInstance(v);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                System.err.println(Arrays.toString(e.getStackTrace()));
            }
        }
        return object;
    }

    private static Field getField(Class<?> clazz, String fieldName) {
        Field field = null;
        try {
            field = clazz.getField(fieldName);
        } catch (NoSuchFieldException e) {
            System.err.printf(FIELD_NOT_EXIST_MESSAGE_FORMAT, clazz.getSimpleName(), e.getMessage());
        }
        if (field == null) {
            try {
                field = clazz.getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                System.err.printf(FIELD_NOT_EXIST_MESSAGE_FORMAT, clazz.getSimpleName(), e.getMessage());
            }
        }
        return field;
    }

    private static <C> void setField(C c, Field field, Object value) {
        try {
            field.set(c, value);
        } catch (IllegalAccessException e) {
            System.err.println(Arrays.toString(e.getStackTrace()));
        }
    }

    private static <C> void setAllClassFields(C c, Field[] fields) {
        Arrays.stream(fields).forEach(f -> {
            f.setAccessible(true);
            String fieldName = f.getType().getSimpleName();
            switch (fieldName) {
                case "String":
                    setField(c, f, RandomStringUtils.randomAlphabetic(6));
                    break;

                case "double":
                    setField(c, f, Math.random() * 100);
                    break;

                case "int":
                    setField(c, f, (int) (Math.random() * 1000));
                    break;

                case "boolean":
                    setField(c, f, true);
                    break;

                case "MilitaryAirVehicleType":
                    setField(c, f, MilitaryAirVehicleType.FIGHTER);
                    break;

                case "AirVehicleType":
                    setField(c, f, AirVehicleType.PLANE);
                    break;

                default:
                    setField(c, f, null);
            }
        });
    }
}
