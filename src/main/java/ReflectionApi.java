import org.apache.commons.lang3.RandomStringUtils;
import task1.model.vehicle.air.AirVehicleType;
import task1.model.vehicle.air.MilitaryAirVehicleType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ReflectionApi {

    private static final String FIELD_NOT_EXIST_MESSAGE_FORMAT = "The '%s' class does not contain '%s' field.\n";
    private static final String CLASS_NOT_EXIST_MESSAGE_FORMAT = "The '%s' class is not exist.\n";
    private static final String CLASS_NOT_HAS_CONSTRUCTOR_MESSAGE_FORMAT = "The '%s' class does not have the '%s' constructor.\n";

    public static Object createAirVehicle(String className) {
        Class<?> clazz = getClass(className);
        Constructor<?> constructor = getClassConstructor(clazz);
        return createInstance(constructor);
    }

    public static <C> void setAllClassFields(C c, Class<?> clazz) {
        Field[] fields = clazz.getFields();
        fillFields(c, fields);

        Field[] declaredFields = clazz.getDeclaredFields();
        fillFields(c, declaredFields);

        Class<?> superClass = clazz.getSuperclass();
        if (superClass.getFields().length != 0 || superClass.getDeclaredFields().length != 0) {
            setAllClassFields(c, superClass);
        }
    }

    public static <C> void setClassField(C c, Class<?> clazz, String fieldName, Object... values) {
        Field field = null;
        try {
            field = clazz.getDeclaredField(fieldName);
        } catch (NoSuchFieldException e) {
            System.err.printf(FIELD_NOT_EXIST_MESSAGE_FORMAT, clazz.getSimpleName(), e.getMessage());
        }
        if (field == null) {
            Class<?> superClass = clazz.getSuperclass();
            if (superClass.getFields().length != 0 | superClass.getDeclaredFields().length != 0) {
                setClassField(c, superClass, fieldName, values);
            } else {
                System.err.printf(FIELD_NOT_EXIST_MESSAGE_FORMAT, clazz.getSimpleName(), new NoSuchFieldException().getMessage());
            }
        } else {
            field.setAccessible(true);
            setField(c, field, values);
        }
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
        if (clazz == null) {
            System.err.printf(CLASS_NOT_EXIST_MESSAGE_FORMAT, new ClassNotFoundException().getMessage());
        } else {
            try {
                return clazz.getConstructor();
            } catch (NoSuchMethodException e) {
                System.err.printf(CLASS_NOT_HAS_CONSTRUCTOR_MESSAGE_FORMAT, clazz.getSimpleName(), e.getMessage());
            }
        }
        return null;
    }

    private static Object createInstance(Constructor<?> constructor) {
        if (constructor == null) {
            System.err.printf("The '%s' constructor is not exist.\n", new NoSuchMethodException().getMessage());
        } else {
            try {
                return constructor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                System.err.println(Arrays.toString(e.getStackTrace()));
            }
        }
        return null;
    }

    private static <C> void setField(C c, Field field, Object... values) {
        Arrays.stream(values).forEach(value -> {
            try {
                field.set(c, value);
            } catch (IllegalAccessException e) {
                System.err.println(Arrays.toString(e.getStackTrace()));
            }
        });
    }

    private static <C> void fillFields(C c, Field[] fields) {
        Arrays.stream(fields).forEach(f -> {
            f.setAccessible(true);
            String fieldName = f.getType().getSimpleName();
            switch (fieldName) {
                case "String": setField(c, f, RandomStringUtils.randomAlphabetic(6));
                    break;

                case "double": setField(c, f, Math.random() * 100);
                    break;

                case "int": setField(c, f, (int) (Math.random() * 1000));
                    break;

                case "boolean": setField(c, f, true);
                    break;

                case "MilitaryAirVehicleType": setField(c, f, MilitaryAirVehicleType.FIGHTER);
                    break;

                case "AirVehicleType": setField(c, f, AirVehicleType.PLANE);
                    break;

                default: setField(c, f, (Object) null);
            }
        });
    }
}
