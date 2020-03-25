package Task2;

import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        list.add(new ParentA("ParentA"));
        list.add(new ParentB("ParentB"));
        list.add(new AChild1("AChild1"));
        list.add(new AChild2("AChild2"));
        list.add(new AChild3("AChild3 - deprecated"));
        list.add(new BChild1("BChild1"));
        list.add(new BChild1("BChild2"));
        list.add(new AChild3("AChild4 - deprecated"));
        //list.add(new ParentC("ParentC - deprecated"));
        list.add(new CChild1("CChild1 - deprecated"));
        list.add(new CChild2("CChild2"));

        try {
            List<Object> result = getNonDeprecatedChildClasses(list);
        } catch (NoSuchFieldException e) {
            e.getMessage();
        } catch (IllegalAccessException e) {
            e.getMessage();
        }


    }

    //в данном методе мы определяем все классы с аннотацией @Deprecated

    private static List findDeprecatedClassed(List someArray) throws NoSuchFieldException, IllegalAccessException {
        List<Object> resultList = new ArrayList();
        for (Object clazz : someArray) {
            if (clazz.getClass().isAnnotationPresent(Deprecated.class)) {
                resultList.add(clazz);
            }
        }
        return resultList;
    }


    /*Метод возвращает список всех не Deprecated сhild-ов у Parent-ов Deprecated класса
    На первом этапе мы передали ему массив классов.
    далее проходимся по всем Deprecated классам из листа, который возвращает метод findDeprecatedClassed
    если Parent не имеет аннотации @Deprecated, то идем дальше, иначе выводим на экран, что Parent - @Deprecated.
    После проходимся по всем объектам из исходного листа и проверяем, действительно ли для них наш Parent родительский класс и не имеют ли они сами аннотации  @Deprecated.
    Если все ок то  идет проверка, есть ли объект  в результирующем списке ( поскольку, например, как у меня, в исходном листе есть 2 экземпляра Deprecated класса с общим родителем
    ( AChild3("AChild3 - deprecated") и AChild3("AChild4 - deprecated") с родителем ParentA("ParentA"), и получается что для "AChild3 - deprecated" мы вернем AChild1 , AChild2, и для
    "AChild4 - deprecated") тоже самое), и чтобы повторно их не добавлять выполняем проверку). Если объекта нет, добавляет в результирующий список.

    В конце метод возвращает список объектов, которые прошли все проверки

    для набора
        List<Object> list = new ArrayList<>();
        list.add(new ParentA("ParentA"));
        list.add(new ParentB("ParentB"));
        list.add(new AChild1("AChild1"));
        list.add(new AChild2("AChild2"));
        list.add(new AChild3("AChild3 - deprecated"));
        list.add(new BChild1("BChild1"));
        list.add(new BChild1("BChild2"));
        list.add(new AChild3("AChild4 - deprecated"));
        list.add(new CChild1("CChild1 - deprecated"));
        list.add(new CChild2("CChild2"));

        мы получим
        Start method getNonDeprecatedChildClasses

        We take AChild3 - deprecated class
        Parent of "AChild3 - deprecated" class. It doesn't have a @Deprecated annotation
        Child list:
        AChild1
        AChild2

        We take AChild4 - deprecated class
        Parent of "AChild4 - deprecated" class. It doesn't have a @Deprecated annotation
        Child list:
        AChild1 already added in result list
        AChild2 already added in result list


        Class "CChild1 - deprecated" has a @Deprecated superClass "class Task2.ParentC"

        Size of result list: 2

        нашел для себя забавный момент. У меня ParentC - Deprecated, имеет 2 чилда: CChild1 - @Deprecated и CChild2
        и если мы и ParentC - Deprecated добавим стартовый список
        List<Object> list = new ArrayList<>();
        list.add(new ParentA("ParentA"));
        list.add(new ParentB("ParentB"));
        list.add(new AChild1("AChild1"));
        list.add(new AChild2("AChild2"));
        list.add(new AChild3("AChild3 - deprecated"));
        list.add(new BChild1("BChild1"));
        list.add(new BChild1("BChild2"));
        list.add(new AChild3("AChild4 - deprecated"));
        list.add(new ParentC("ParentC - deprecated"));
        list.add(new CChild1("CChild1 - deprecated"));
        list.add(new CChild2("CChild2"));

        то получим результат
        Start method getNonDeprecatedChildClasses

        We take AChild3 - deprecated class
        Parent of "AChild3 - deprecated" class. It doesn't have a @Deprecated annotation
        Child list:
        AChild1
        AChild2

        We take AChild4 - deprecated class
        Parent of "AChild4 - deprecated" class. It doesn't have a @Deprecated annotation
        Child list:
        AChild1 already added in result list
        AChild2 already added in result list

        We take ParentC - deprecated class
        Parent of "ParentC - deprecated" class. It doesn't have a @Deprecated annotation
        Child list:
        ParentA
        ParentB
        AChild1 already added in result list
        AChild2 already added in result list
        BChild1
        BChild2
        CChild2


        Class "CChild1 - deprecated" has a @Deprecated superClass "class Task2.ParentC"

        Size of result list:7

        понятно, что это все потому что все классы наледуются от Object. Просто забавят такие моменты.

     */

    private static List<Object> getNonDeprecatedChildClasses(List<Object> startArrayOfAllClasses) throws NoSuchFieldException, IllegalAccessException {
        List<Object> resultList = new ArrayList<>();
        System.out.println("Start method getNonDeprecatedChildClasses");
        for (Object deprecatedClazz : findDeprecatedClassed(startArrayOfAllClasses)) {
            Field privateStringField = deprecatedClazz.getClass().getDeclaredField("name");
            privateStringField.setAccessible(true);

            Class parentClass = deprecatedClazz.getClass().getSuperclass();
            System.out.println();
            if (!parentClass.isAnnotationPresent(Deprecated.class)) {
                System.out.println("We take " + privateStringField.get(deprecatedClazz) + " class");
                System.out.println("Parent of \"" + privateStringField.get(deprecatedClazz) + "\" class. It doesn't have a @Deprecated annotation");
                System.out.println("Child list:");
                for (Object clazz : startArrayOfAllClasses) {
                    if (parentClass.isAssignableFrom(clazz.getClass()) && !clazz.getClass().equals(parentClass) && !clazz.getClass().isAnnotationPresent(Deprecated.class)) {
                        Field privateField = clazz.getClass().getDeclaredField("name");
                        privateField.setAccessible(true);
                        if (!resultList.contains(clazz)) {
                            resultList.add(clazz);
                            System.out.println(privateField.get(clazz));
                        } else {
                            System.out.println(privateField.get(clazz) + " already added in result list");

                        }
                    }
                }
            } else {
                System.out.println();
                System.out.println("Class \"" + privateStringField.get(deprecatedClazz) + "\" has a @Deprecated superClass \"" + parentClass + "\"");
            }
        }
        System.out.println();
        System.out.println("Size of result list:" + resultList.size());
        return resultList;
    }
}
