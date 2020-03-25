package Task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.TypeVariable;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        Class c = new Order().getClass();
        Class os = OrderStatus.PROCESSING.getClass();
        Class primitiveClass = boolean.class;
//        Class orderClassByName = Class.forName("io.humb1t.Main.Order");
//        Class arrayClassByStrangeName = Class.forName("[L.io.humb1t.Main.Order;");
        Class voidClass = Void.TYPE;

        final Class<Processor> processorClass = Processor.class;
        System.out.println("Canonical name: " + processorClass.getCanonicalName());
        System.out.println("Modifiers: " + Modifier.toString(processorClass.getModifiers()));
        System.out.println("Type parameters:");
        for (TypeVariable<Class<Processor>> typeParameter : processorClass.getTypeParameters()) {
            System.out.println(typeParameter);
        }

        try {
            Class mainClass = Main.class;
            Method mainMethod = c.getMethod("main");
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        }

        try {
            Class<?> mainClass = Main.class;
            Method mainMethod = c.getMethod("main");
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        }

        Class<?> classWithPrivateNoArgsConstructor = Class.forName("Task1.Main.ClassWithPrivateNoArgsConstructor");
        try {
            classWithPrivateNoArgsConstructor.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            classWithPrivateNoArgsConstructor.getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public enum OrderStatus {
        PROCESSING
    }

    public static class Order {

    }

    protected class Processor<E> {
        E processingElement;
    }

    public class ClassWithPrivateNoArgsConstructor {
        private ClassWithPrivateNoArgsConstructor(){
        }
    }
}
