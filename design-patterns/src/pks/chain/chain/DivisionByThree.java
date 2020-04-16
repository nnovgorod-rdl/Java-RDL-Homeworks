package pks.chain.chain;

import pks.chain.exceptions.NotOurNumber;

import static java.lang.System.out;

public class DivisionByThree implements LevelChain {

    public void setNextChain(LevelChain nextChain) {
    }

    public void separation(NumberFromArray numberFromArray) throws NotOurNumber {
        if (numberFromArray.getNumber() % 3 == 0) {
            out.println("You are on the third line. It's our number");
        } else {
            throw new NotOurNumber("WTF! Something wrong!");
        }
    }
}
