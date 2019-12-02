package javatutorial.datastructure;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Heap<T extends Comparable<T>> {

    private static final int DEFAULT_CAPACITY = 10;

    private T[] heapArray;
    private int size;
    private Map<T, Integer> positionMap;

    @SuppressWarnings("unchecked")
    public Heap() {
        this.positionMap = new HashMap<>();
        this.heapArray = (T[]) new Comparable[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private int parent(int i) {
        return i / 2;
    }

    private int leftChild(int i) {
        return 2 * i;
    }

    private int rightChild(int i) {
        return 2 * i + 1;
    }

    private T[] resize() {
        return Arrays.copyOf(heapArray, heapArray.length * 2);
    }

    private void heapify(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left <= this.size && heapArray[left].compareTo(heapArray[index]) < 0) {
            smallest = left;
        }

        if (right <= this.size && heapArray[right].compareTo(heapArray[smallest]) < 0) {
            smallest = right;
        }

        if (smallest != index) {
            // swap node and largest...
            T temp = heapArray[index];
            heapArray[index] = heapArray[smallest];
            positionMap.put(heapArray[smallest], index);
            heapArray[smallest] = temp;
            positionMap.put(temp, smallest);
            heapify(smallest);
        }
    }

    private void bubbleUp(int index) {
        int parent = parent(index);

        // while parent greater than this index
        while (parent > 0 && heapArray[parent].compareTo(heapArray[index]) > 0) {

            // swap parent and child
            T temp = heapArray[index];
            heapArray[index] = heapArray[parent];
            positionMap.put(heapArray[parent], index);
            heapArray[parent] = temp;
            positionMap.put(temp, parent);

            index = parent;
            parent = parent(index);
        }
    }

    public void insert(T data) {

        if (this.size >= heapArray.length - 1) {
            heapArray = this.resize();
        }

        this.size++;
        this.heapArray[size] = data;
        positionMap.put(data, size);
        bubbleUp(size);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }
        return heapArray[1];
    }

    public int getSize() {
        return size;
    }

    public T getMin() {
        T result = peek();
        heapArray[1] = heapArray[size];
        heapArray[size] = null;
        this.size--;
        heapify(1);
        return result;

    }

    public void decreaseKey(T oldData, T newData) {
        int index = findIndex(oldData);
        heapArray[index] = newData;
        while (index > 1 && heapArray[parent(index)].compareTo(heapArray[index]) > 0) {

            // swap parent and index
            T temp = heapArray[index];
            heapArray[index] = heapArray[parent(index)];
            positionMap.put(heapArray[parent(index)], index);
            heapArray[parent(index)] = temp;
            positionMap.put(temp, parent(index));

            index = parent(index);
        }
    }

    private int findIndex(T data) {
        return positionMap.get(data);
    }

}
