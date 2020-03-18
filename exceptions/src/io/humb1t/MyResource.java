package io.humb1t;

public class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("I close myself!");
    }
    public void somefunctional()
    {
        System.out.println("Ku");
    }

    public MyResource() throws MyOwnException{

    }
}