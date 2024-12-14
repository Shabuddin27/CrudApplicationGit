package com.shab.projects.crud_app.utils;

import java.lang.reflect.Field;

public class ReflectionUtils {

    public static void copyNonNullProperties(Object source, Object target) {
        Class<?> sourceClass = source.getClass();
        Class<?> targetClass = target.getClass();

        Field[] fields = sourceClass.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(source);
                if (value != null) {
                    Field targetField = targetClass.getDeclaredField(field.getName());
                    targetField.setAccessible(true);
                    targetField.set(target, value);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
