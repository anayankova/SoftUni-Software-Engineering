package phonebook.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public final class CrazyMapper {

    public static <D> D createMapping(Object source, Class<D> returnClass)
            throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Object toReturn = returnClass.getConstructors()[0].newInstance();
        for (Field declaredField : source.getClass().getDeclaredFields()) {
            declaredField.setAccessible(true);
            Object value = declaredField.get(source);
            Field field = toReturn.getClass().getDeclaredField(declaredField.getName());
            field.setAccessible(true);
            field.set(toReturn,value);
            
        }
        return (D) toReturn;

    }
}
