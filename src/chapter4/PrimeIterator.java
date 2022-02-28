package chapter4;

import java.util.Iterator;

public class PrimeIterator implements Iterator {

    private int lastPrime = 1;

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        return lastPrime = Prime.nextPrimeFrom(lastPrime);
    }

    @Override
    public void remove() {
        throw new RuntimeException("Fundamental nature of the universe exception");
    }

}
