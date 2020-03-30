package io.humb1t;

import java.util.ArrayList;
import java.util.Arrays;
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
                List<Class> notDepricatedInterfacesTMP;
                List<String> notDepricatedClasses = new ArrayList<>();
                List<String> notDepricatedInterfaces = new ArrayList<>();
                boolean findClass = false;

                Class clazzTMP = clazz.getSuperclass();
                while(!findClass)
                {
                    Class clazzTMPIn = clazz.getSuperclass();
                    if (clazzTMPIn.isAnnotationPresent(Deprecated.class)) {
                        notDepricatedClasses.add(clazzTMPIn.getSimpleName());
                        findClass = true;
                    }
                    else
                    {
                        clazzTMP = clazzTMPIn;
                    }
                }
                notDepricatedInterfacesTMP = Arrays.asList(clazz.getInterfaces());
                if(!notDepricatedInterfacesTMP.isEmpty()) {
                    for (Class c : notDepricatedInterfacesTMP) {
                        notDepricatedInterfaces.add(c.getName());
                    }
                }

                System.out.print("Класс объекта " + o2.getClass().getSimpleName()+ "устарел, ");
                if(!notDepricatedClasses.isEmpty())
                {
                    System.out.print("вы можете использовать следующие родительские классы: ");
                    for (String s:notDepricatedClasses) {
                        System.out.println(s);
                    }
                }
                else if (!notDepricatedInterfaces.isEmpty())
                {
                    System.out.print("вы можете использовать следующие родительские интерфейсы: ");
                    for (String s:notDepricatedInterfaces) {
                        System.out.println(s);
                    }
                }
                else {
                    System.out.println("но у класса нет не устаревших родительских классов или интерфейсов");
                }

            }
        }
    }
}