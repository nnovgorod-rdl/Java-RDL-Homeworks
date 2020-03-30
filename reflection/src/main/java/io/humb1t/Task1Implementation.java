package io.humb1t;

import java.util.ArrayList;
import java.util.List;

public class Task1Implementation {
    public List<Object> list = new ArrayList<>();

    //Метод работы с аннотацие Deprecated
    public void filterMethod(List<Object> inputList) throws ClassNotFoundException {
        //iterate object, try to find object, instance of class annotated like Deprecated and put this object in list
        for (Object o : inputList) {
            if (o.getClass().isAnnotationPresent(Deprecated.class)) {
                list.add(o);
            }
        }
    }
}
