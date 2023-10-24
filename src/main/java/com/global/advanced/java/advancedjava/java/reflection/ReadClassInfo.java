package com.global.advanced.java.advancedjava.java.reflection;

import com.global.advanced.java.advancedjava.java.MyFirstAnno;
import com.global.advanced.java.advancedjava.java.TestClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReadClassInfo {
    public static void main(String[] args) throws Exception {
        Class<TestClass> classLoc = TestClass.class;
        try {
            Class<TestClass> classLoc2 = (Class<TestClass>) Class.forName("com.global.advanced.java.advancedjava.java.TestClass");
        } catch (ClassNotFoundException eParam) {
            throw new RuntimeException(eParam);
        }

        Field[]                declaredFieldsLoc = classLoc.getDeclaredFields();
        Constructor<TestClass> constructorLoc    = classLoc.getConstructor();
        TestClass              testClassLoc      = constructorLoc.newInstance();

        for (Field declaredFieldLoc : declaredFieldsLoc) {
            System.out.println("Field : " + declaredFieldLoc.getName() + " type : " + declaredFieldLoc.getType());
            Object oLoc = declaredFieldLoc.get(testClassLoc);
            if (declaredFieldLoc.getType() == String.class) {
                declaredFieldLoc.setAccessible(true);
                declaredFieldLoc.set(testClassLoc,
                                     "deneme");
            }
        }
        Field str1Loc = classLoc.getDeclaredField("str1");

        Method[] declaredMethodsLoc = classLoc.getDeclaredMethods();
        for (Method declaredMethodLoc : declaredMethodsLoc) {
            System.out.println("Method : "
                               + declaredMethodLoc.getName()
                               + " ret : "
                               + declaredMethodLoc.getReturnType()
                               + " params : "
                               + Arrays.asList(declaredMethodLoc.getParameterTypes()));

            Annotation[] annotationsLoc = declaredMethodLoc.getAnnotations();
            if (annotationsLoc != null){
                System.out.println("*********** ANNO : " + annotationsLoc.getClass().getName());
            }
            MyFirstAnno annotationLoc = declaredMethodLoc.getAnnotation(MyFirstAnno.class);
            if (annotationLoc != null){
                System.out.println("Val1 : " + annotationLoc.value1() + "Val2 : " + annotationLoc.value2());
            }
            if (declaredMethodLoc.getName().equals("method")){
                System.out.println("-----------------------------");
                Object invokeLoc = declaredMethodLoc.invoke(testClassLoc,
                                                            new Object[]{"osman",
                                                                         "yaycıoğlu"
                                                            });
                System.out.println("Method ret : " + invokeLoc);
            }
        }

        System.out.println("TestClass : " + (testClassLoc == null ? "null" : testClassLoc.toString()));
    }
}
