package javatutorial.datastructure;

public class PriorityQueue<T extends Comparable<T>> {

    private Heap<T> heap;

    public PriorityQueue() {
        this.heap = new Heap<>();
    }

    public void enqueue(T data) {
        heap.insert(data);
    }

    public T dequeue() {
        return heap.getMin();
    }

    public void decreaseValue(T oldData, T newData) {
        heap.decreaseKey(oldData, newData);
    }

    public int getSize() {
        return heap.getSize();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }
}
