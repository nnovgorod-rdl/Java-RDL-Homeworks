package pks.chain;

import pks.chain.chain.*;
import pks.chain.exceptions.NotOurNumber;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

import static java.lang.System.out;

public class MainChain {

    static final int NUMBERS_SIZE = 10;
    static final int MIN_NUMBER = 100;
    static final int NUMBER_FOR_RANDOM = 10000000;
    static final int[] numbers = new int[NUMBERS_SIZE];
    static final HashSet<Integer> hashSet = new HashSet<>();
    static final Random random = new Random();

    public static void main(String[] args) {
        initNumbers();

        LevelChain first = new SimpleNumber();
        LevelChain second = new DivisionByTwo();
        LevelChain third = new DivisionByThree();
        first.setNextChain(second);
        second.setNextChain(third);

        for (int i = 0; i < numbers.length; i++) {
            int numberFromArray = numbers[i];
            out.println("=================");
            out.println("It's " + (i + 1) + " number. numberFromArray = " + numberFromArray);
            try {
                first.separation(new NumberFromArray(numberFromArray));
            } catch (NotOurNumber e) {
                out.println(e.toString());
            }
            out.println("=================");
        }
    }

    static void initNumbers() {
        //вероятность мала, но сначала set, что бы не было повторов
        while (hashSet.size() < NUMBERS_SIZE) {
            hashSet.add(MIN_NUMBER + random.nextInt(NUMBER_FOR_RANDOM));
        }

        //простенький способ перевода в массив
        int i = 0;
        for (int n : hashSet) {
            numbers[i++] = n;
        }
        out.println(Arrays.toString(numbers));
    }


}
