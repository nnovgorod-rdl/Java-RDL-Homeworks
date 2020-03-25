package Task1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        NormalClass normalClass1 = new NormalClass("Class1 Normal");
        NormalClass normalClass2 = new NormalClass("Class1 Normal");
        DeprecatedClass deprecatedClass1 = new DeprecatedClass("Class3 - deprecated");
        DeprecatedClass deprecatedClass2 = new DeprecatedClass("Class4 - deprecated");

        List list = new ArrayList();
        list.add(normalClass1);
        list.add(normalClass2);
        list.add(deprecatedClass1);
        list.add(deprecatedClass2);

        List result = new ArrayList();
        try {
            findDeprecatedClassed(list);
        } catch (NoSuchFieldException e) {
            e.getMessage();
        }catch (IllegalAccessException e){
            e.getMessage();
        }

    }

    private static List findDeprecatedClassed(List someArray) throws NoSuchFieldException, IllegalAccessException {
        List resultList = new ArrayList();
        System.out.println("Size of a input list: " + someArray.size());
        for (Object clazz : someArray) {
            if (clazz.getClass().isAnnotationPresent(Deprecated.class)) {
                Field privateStringField = clazz.getClass().getDeclaredField("name");
                privateStringField.setAccessible(true);
                System.out.println((String) privateStringField.get(clazz));
                resultList.add(clazz);
            }
        }
        System.out.println("Size of a result list : " + resultList.size());
        return resultList;
    }
}
