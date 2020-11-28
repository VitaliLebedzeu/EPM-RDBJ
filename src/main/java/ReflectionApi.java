import org.apache.commons.lang3.RandomStringUtils;
import task1.model.vehicle.air.AirVehicleType;
import task1.model.vehicle.air.MilitaryAirVehicleType;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ReflectionApi {

    public static Object createAirVehicle(String className) {
        Class<?> clazz = getClass(className);
        Constructor<?> constructor = getClassConstructor(clazz);
        return createInstance(constructor);
    }

    private static Class<?> getClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    private static Constructor<?> getClassConstructor(Class<?> clazz) {
        if (clazz == null) {
            System.err.println(new ClassNotFoundException().getMessage());
        } else {
            try {
                return clazz.getConstructor();
            } catch (NoSuchMethodException e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    private static Object createInstance(Constructor<?> constructor) {
        if (constructor == null) {
            System.err.println(new NoSuchMethodException().getMessage());
        } else {
            try {
                return constructor.newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }
}
