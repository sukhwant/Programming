package mission.red.geeksforgeeks.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/box-stacking-problem-dp-22/
 * 
 * @author sukhwanp
 *
 */
public class BoxStacking {

    private static class Box {
        int height;
        int width;
        int length;
        int area;

        public Box(int height, int width, int length) {
            super();
            this.height = height;
            this.width = width;
            this.length = length;

            this.area = this.length * this.width;
        }

        @Override
        public String toString() {
            return "Box [area=" + area + ", height=" + height + ", width=" + width + ", length=" + length + "]";
        }

    }

    public static void main(String[] args) {

        ArrayList<Box> boxes = new ArrayList<>();
        boxes.add(new Box(4, 6, 7));
        boxes.add(new Box(1, 2, 3));
        boxes.add(new Box(4, 5, 6));
        boxes.add(new Box(10, 12, 32));

        BoxStacking boxStacking = new BoxStacking();
        System.out.println(boxStacking.getmaxHeight(boxes));
    }

    private List<Box> getAllRotation(Box box) {
        ArrayList<Box> boxes = new ArrayList<>();
        boxes.add(new Box(box.length, box.width, box.height));
        boxes.add(new Box(box.height, box.length, box.width));
        boxes.add(new Box(box.width, box.height, box.length));

        return boxes;
    }

    private int getmaxHeight(ArrayList<Box> boxes) {

        ArrayList<Box> allPossibleBoxes = new ArrayList<>();
        for (Box box : boxes) {
            allPossibleBoxes.addAll(getAllRotation(box));
        }

        allPossibleBoxes.sort((x, y) -> y.area - x.area);

        for (Box box : allPossibleBoxes) {

            System.out.println(box);
        }
        int[] maxHeight = new int[allPossibleBoxes.size()];

        for (int i = 0; i < allPossibleBoxes.size(); i++) {
            maxHeight[i] = allPossibleBoxes.get(i).height;
        }

        for (int i = 0; i < allPossibleBoxes.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (allPossibleBoxes.get(i).length < allPossibleBoxes.get(j).length
                        && allPossibleBoxes.get(i).width < allPossibleBoxes.get(j).width) {
                    maxHeight[i] = Math.max(maxHeight[i], maxHeight[j] + allPossibleBoxes.get(i).height);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < maxHeight.length; i++) {
            max = Math.max(max, maxHeight[i]);
        }

        return max;
    }
}
