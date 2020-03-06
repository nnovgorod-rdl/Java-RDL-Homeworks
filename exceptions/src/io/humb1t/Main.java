package io.humb1t;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        try {
            new LifeCycleAction().execute();
        } catch (LifeCycleActionStartException | LifeCycleActionExecutionException | AccessDeniedException e) {
            System.err.println(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        /*
        Что бы здесь не "вылетало" с Exception, прописал в настройках данного Main Working Directory
         E:\Git\Java-RDL-Homeworks\exceptions\src\io\humb1t, создал там file.txt и добавил
         его в Program Arguments
         */
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
/*
Если раскоментировать human, то программа завершится Exception'ом NotCorrectAgeException,
т.к. мы пытаемся присвоить "неправильное" значение.
До этого момента, конструктор Класса, как бы "создает" объект, со значениями переменных класса,
по умолчанию, в моем классе это ing age, со значением по умолчанию 0
 */
//        Human human = new Human(-1, Gender.MALE);
        Human humanNormal = new Human(0, Gender.MALE);


        try (RollCallOfHuman rollCallOfHuman = new RollCallOfHuman()) {
            rollCallOfHuman.rollCall();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    /*
    Создал исключение LifeCycleActionStartException, и "выбросил" его, "пробросил" его... блин... как правильно то?!
     */
    public static class LifeCycleAction {
        public void execute() throws LifeCycleActionStartException, LifeCycleActionExecutionException, AccessDeniedException {
            throw new LifeCycleActionStartException("This is LifeCycleActionStartException");
        }
    }

    public static class LifeCycleActionExecutionException extends Exception {
    }


    public void exceptionVsResult() {
        final String result1 = (String) this.returnResult().value;
        final String result2 = returnOptional().orElse("");
        String result3 = "";
        try {
            result3 = returnValueOrThrowException();
        } catch (AccessDeniedException e) {
        }
    }

    private Result returnResult() {
        return Result.OK.setValue("OK");
    }

    private Optional<String> returnOptional() {
        return Optional.of("OK");
    }

    private String returnValueOrThrowException() throws AccessDeniedException {
        return "OK";
    }
}
