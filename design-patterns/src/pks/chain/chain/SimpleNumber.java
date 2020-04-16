package pks.chain.chain;

import pks.chain.exceptions.NotOurNumber;

import static java.lang.System.out;

public class SimpleNumber implements LevelChain {
    private LevelChain chain;

    public void setNextChain(LevelChain nextChain) {
        this.chain = nextChain;
    }

    public void separation(NumberFromArray numberFromArray) throws NotOurNumber {
        out.println("First line is here.");
        if (isPrime(numberFromArray.getNumber())) {
            out.println("Is Prime number");
        } else {
            out.println("Go to second line.");
            this.chain.separation(numberFromArray);
        }
    }

    boolean isPrime(int n) {
        //самый простой, неоптимизированный способ поиска простого числа
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
