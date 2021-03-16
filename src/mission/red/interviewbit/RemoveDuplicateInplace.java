package mission.red.interviewbit;

import java.util.ArrayList;

public class RemoveDuplicateInplace {

    public int removeDuplicates(ArrayList<Integer> input) {

        if (input.isEmpty()) {
            return 0;
        }

        int currentIndex = 1;
        int currElement = input.get(0);

        for (int i = 1; i < input.size(); i++) {
            if (input.get(i) != currElement) {
                input.set(currentIndex++, input.get(i));
            }
            currElement = input.get(i);
        }

        int toRemove = input.size() - currentIndex;

        for (int i = 0; i < toRemove; i++) {
            input.remove(input.size()-1);
        }
        return currentIndex;
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(1);
        input.add(2);
        input.add(2);
        input.add(2);
        input.add(3);
        input.add(3);
        input.add(3);

        System.out.println(new RemoveDuplicateInplace().removeDuplicates(input));
    }
}
