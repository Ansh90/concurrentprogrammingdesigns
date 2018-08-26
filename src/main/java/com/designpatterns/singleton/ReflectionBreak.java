package com.designpatterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionBreak {

    public static void main(String[] input) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        LazyInitializationSingleton instanceOne = LazyInitializationSingleton.getInstance();
        LazyInitializationSingleton instanceTwo = null;

        Constructor[] constructors = LazyInitializationSingleton.class.getConstructors();

        for (Constructor constructor : constructors) {
            constructor.setAccessible(true);
            instanceTwo = (LazyInitializationSingleton) constructor.newInstance();
        }
        System.out.println(instanceOne);
        System.out.println(instanceTwo);

    }
}
