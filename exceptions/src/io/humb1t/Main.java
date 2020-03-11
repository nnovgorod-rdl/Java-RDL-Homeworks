package io.humb1t;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        //Find out - what's a value inside your variable. Write down your thoughts
/*
* Probably variable mc2 - is null, because instance of class MyResource isn't
assigned, because there is throwing an exception
Sorry for my bad English!
*
 */
        try {
            MyResource mc2 = new MyResource();
        } catch (MyOwnException e) {
            e.printStackTrace();
        }

        try (MyResource mc = new MyResource()) {
            mc.somefunctional();
        } catch (Exception e) {
            e.printStackTrace();
        }


        try {
            new LifeCycleAction().execute();
        } catch (LifeCycleActionExecutionException | AccessDeniedException e) {
            System.err.println(e.getLocalizedMessage());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try (FileInputStream fileInputStream = new FileInputStream(args[0])) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class LifeCycleAction {
        public void execute() throws LifeCycleActionExecutionException, AccessDeniedException {
            throw new LifeCycleActionExecutionException();
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
