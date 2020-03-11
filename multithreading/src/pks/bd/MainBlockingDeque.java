package pks.bd;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class MainBlockingDeque {
    static final int STEP = 20;
    static final int MAX_INT_VALUE = 100;
    static Random random = new Random();
    public static void main(String[] args) {
        BlockingDeque<Integer> integerBlockingDeque = new LinkedBlockingDeque<>();
    }
}
