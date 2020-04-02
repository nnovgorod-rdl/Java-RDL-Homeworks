package pks.chain.chain;

import pks.chain.exceptions.NotOurNumber;

public interface LevelChain {
    void setNextChain(LevelChain nextChain);

    void separation(NumberFromArray numberFromArray) throws NotOurNumber;
}
