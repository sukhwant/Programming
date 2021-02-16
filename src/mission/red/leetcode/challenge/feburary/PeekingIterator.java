package mission.red.leetcode.challenge.feburary;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer peekedElement;
    boolean hasPeaked;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        peekedElement = null;
        hasPeaked = false;
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {

        if(hasPeaked){
            return peekedElement;
        }

        peekedElement = iterator.next();
        hasPeaked = true;
        return peekedElement;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(hasPeaked){
            hasPeaked = false;
            return peekedElement;
        }

        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return hasPeaked || iterator.hasNext();
    }
}
