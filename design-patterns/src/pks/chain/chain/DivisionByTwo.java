package pks.chain.chain;

import pks.chain.exceptions.NotOurNumber;

import static java.lang.System.out;

public class DivisionByTwo implements LevelChain {
    private LevelChain chain;

    public void setNextChain(LevelChain nextChain) {
        this.chain = nextChain;
    }

    public void separation(NumberFromArray numberFromArray) throws NotOurNumber {
        if (numberFromArray.getNumber() % 2 == 0) {
            out.println("Second line! It's even number!");
        } else {
            out.println("Go to third line.");
            this.chain.separation(numberFromArray);
        }
    }
}
