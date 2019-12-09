package javatutorial.datastructure.list;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LinkedListTest {

    @Test
    public void addFront_should_addInFront(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addFront(1);
        list.addFront(2);
        list.addFront(3);

        Assertions.assertEquals(list.removeFromFront(), 3);
        Assertions.assertEquals(list.removeFromFront(), 2);
        Assertions.assertEquals(list.removeFromFront(), 1);
    }

    @Test
    public void addLast_should_addInLast(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        Assertions.assertEquals(list.removeFromFront(), 1);
        Assertions.assertEquals(list.removeFromFront(), 2);
        Assertions.assertEquals(list.removeFromFront(), 3);
    }

    @Test
    public void addAllFront_should_addInFront(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addAllFront(getCollectionToAdd());

        Assertions.assertEquals(list.removeFromFront(), 3);
        Assertions.assertEquals(list.removeFromFront(), 2);
        Assertions.assertEquals(list.removeFromFront(), 1);
    }

    @Test
    public void addAlllast_should_addAtLast(){
        LinkedList<Integer> list = new LinkedList<>();
        list.addAllLast(getCollectionToAdd());

        Assertions.assertEquals(list.removeFromFront(), 1);
        Assertions.assertEquals(list.removeFromFront(), 2);
        Assertions.assertEquals(list.removeFromFront(), 3);
    }

    private ArrayList<Integer> getCollectionToAdd() {
        ArrayList<Integer> elementsToAdd = new ArrayList<>();
        elementsToAdd.add(1);
        elementsToAdd.add(2);
        elementsToAdd.add(3);
        return elementsToAdd;
    }
}
