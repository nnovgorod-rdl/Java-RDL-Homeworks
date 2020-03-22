package io.humb1t;

import java.util.ArrayList;
import java.util.List;

public class Task2Implementation {
    List<Object> list = new ArrayList<>();

    //Метод работы с аннотацие Deprecated
    public void filterMethod(ArrayList<Object> inputList) throws ClassNotFoundException {
        //iterate object, try to find object, instance of class annotated like Deprecated and put this object in list
        for (Object o : inputList) {
            if (o.getClass().isAnnotationPresent(Deprecated.class)) {
                list.add(o);
            }
        }
        //iterate object in our new list with object annotated Deprecated and print offer to use super class without annotation Deprecated
        for (Object o2 : list) {
            Class clazz = o2.getClass().getSuperclass();
            if (!clazz.isAnnotationPresent(Deprecated.class)) {
                System.out.println("Класс объекта " + o2.getClass().getSimpleName() + "устарел, вы можете использовать не устаревший родительский класс " + clazz.getName());
            }
        }
    }
}