package io.humb1t;

import io.humb1t.library.Library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
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

        /**
         * second task
         */
        try (AutoCloseableTest autoCloseableTest = new AutoCloseableTest()) {
            autoCloseableTest.printMessage("reading resource...");
        } catch (Exception e) {
            e.getStackTrace();
        }

        /**
         * third task
         * Explanation: class fields are initialized with default values or with values passed as parameters. But when
         * exception is thrown in constructor, creation of new instance finishes. Half-created class is allocated in heap,
         * but reference to it is not returned. So the reference's value is undefined (it's not null) and debugger doesn't see it
         * (Cannot find local variable library). Partially initialized object will be collected by garbage collector.
         */
        Library library;
        try {
            library = new Library();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

    /**
     * first task
     */
    public static class LifeCycleAction {
        public void execute() throws LifeCycleActionExecutionException, AccessDeniedException, ExecutionException {
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
