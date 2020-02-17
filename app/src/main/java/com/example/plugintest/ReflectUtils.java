package com.example.plugintest;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by yds
 * on 2020/2/14.
 */
public class ReflectUtils {
    public static Field getField(Class<?> clazz, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            return field;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Object getStaticFieldObject(String className,String fieldName){
        return getFieldObject(className,null,fieldName);
    }
    public static Object getFieldObject(String className, Object obj, String fieldName) {
        try {
            Class<?> clazz = Class.forName(className);
            return getFieldObject(clazz, obj, fieldName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getFieldObject(Class<?> clazz, Object obj, String fieldName) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            return field.get(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object getFieldObject(Object obj, String fieldName) {
        return getFieldObject(obj.getClass(), obj, fieldName);
    }

    public static void setFieldObject(Object obj, String fieldName, Object fieldValue) {
        setFieldObject(obj.getClass(), obj, fieldName, fieldValue);
    }

    public static void setFieldObject(Class<?> clazz, Object obj, String fieldName, Object fieldValue) {
        try {
            Field field = clazz.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void setFieldObject(String className, Object obj, String fieldName, Object fieldValue) {
        try {
            Class<?> clazz = Class.forName(className);
            setFieldObject(clazz,obj,fieldName,fieldValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object invokeMethod(Object obj,String methodName,Class[] pareTypes,Object[] pareValues){
        if(obj==null){
            return null;
        }
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName,pareTypes);
            method.setAccessible(true);
            return method.invoke(obj,pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object invokeStaticMethod(String className,String methodName){
        Class[] pareTypes = new Class[]{};
        Class[] pareValues = new Class[]{};
        return invokeMethod(className,methodName,pareTypes,pareValues);
    }
    public static Object invokeStaticMethod(String className,String methodName,Class[] pareTypes,Object[] pareValues){
        try {
            Class<?> clazz = Class.forName(className);
            Method method = clazz.getDeclaredMethod(methodName,pareTypes);
            method.setAccessible(true);
            return method.invoke(null,pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Object invokeStaticMethod(Object obj,String methodName,Class[] pareTypes,Object[] pareVlues){
        if (obj == null) {
            return null;
        }
        try {
            Method method = obj.getClass().getDeclaredMethod(methodName,pareTypes);
            method.setAccessible(true);
            return method.invoke(null,pareVlues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object createObject(String className){
        Class[] pareTypes = new Class[]{};
        Object[] pareValues = new Object[]{};
        try {
            Class clazz = Class.forName(className);
            return createObject(clazz,pareTypes,pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    public static Object createObject(Class<?> clazz){
        Class[] pareTypes = new Class[]{};
        Object[] pareValues = new Object[]{};
        return createObject(clazz,pareTypes,pareValues);
    }

    public static Object createObject(Class<?> clazz,Class[] pareTypes,Object[] pareValues){
        try {
            Constructor cts = clazz.getDeclaredConstructor(pareTypes);
            cts.setAccessible(true);
            return cts.newInstance(pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object createObject(String className,Class[] pareTypes,Object[] pareValues){
        try {
            Class<?> clazz = Class.forName(className);
            return createObject(clazz,pareTypes,pareValues);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Object createObject(String className,Class pareType,Object pareValue){
        Class[] pareTypes = new Class[]{pareType};
        Object[] pareValues = new Object[]{pareValue};
        return createObject(className,pareTypes,pareValues);
    }


}
