package javatutorial.datastructure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 
 * @author sukhwanp
 *
 */
public class DataStructureTest {

    @Setter
    @Getter
    @AllArgsConstructor
    public static class ModelClass implements Comparable<ModelClass> {

        int number;

        @Override
        public int compareTo(ModelClass o) {
            return this.number - o.number;
        }

    }

    public static void main(String[] args) {

        Heap<ModelClass> heap = new Heap<>();

        heap.insert(new ModelClass(1));
        heap.insert(new ModelClass(5));
        heap.insert(new ModelClass(-3));
        heap.insert(new ModelClass(2));
        heap.insert(new ModelClass(8));
        heap.insert(new ModelClass(-13));
        heap.insert(new ModelClass(-1));
        heap.insert(new ModelClass(0));
        heap.insert(new ModelClass(10));

        heap.decreaseKey(new ModelClass(5), new ModelClass(-20));

        System.out.println(heap.getMin());
        System.out.println(heap.getMin());
        System.out.println(heap.getMin());
        System.out.println(heap.getMin());
        System.out.println(heap.getMin());
        System.out.println(heap.getMin());
        System.out.println(heap.getMin());
        System.out.println(heap.getMin());
        System.out.println(heap.getMin());

        System.out.println(heap.getMin());

    }
}
