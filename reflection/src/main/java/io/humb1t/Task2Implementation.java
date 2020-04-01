package io.humb1t;

import org.reflections.Reflections;

import java.util.*;

public class Task2Implementation {
    List<Object> list = new ArrayList<>();

    public int filterMethod(List<Object> inputList) throws ClassNotFoundException {
        for (Object o : inputList) {
            if (o.getClass().isAnnotationPresent(Deprecated.class)) {
                list.add(o);
            }
        }
        for (Object obj : list) {
            Class sc = obj.getClass().getSuperclass();
            System.out.println("Object instanced of Deprecated Class - " + obj.getClass().getName());
            System.out.println("You can use implementations of superClass:");
            if (!obj.getClass().getSuperclass().isAnnotationPresent(Deprecated.class) ) {
                Reflections reflections = new Reflections(sc.getPackageName());
                Set<Class> setC = reflections.getSubTypesOf(sc);
                for (Class c : setC) {
                    if (!c.isAnnotationPresent(Deprecated.class)) {
                        System.out.println("You can use implements of Superclass - " + c.getName());
                    }
                }
            }

            System.out.println("You can use implementations of interface:");
            List<Class> listI = Arrays.asList(obj.getClass().getInterfaces());
            if (listI.size() != 0) {
                for (Class interf:listI) {
                    Reflections reflectionsI = new Reflections(interf.getPackageName());
                    Set<Class> setImpl = reflectionsI.getSubTypesOf(interf);
                    for (Class c : setImpl) {
                        if (!c.isAnnotationPresent(Deprecated.class)) {
                            System.out.println(c.getName());
                        }
                    }
                }
            }
        }
        return 1;
    }
}
