package mission.red.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

/**
 * https://www.interviewbit.com/problems/add-one-to-number/
 */
public class AddOne {

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        int carry = 1;
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = A.size() - 1; i >= 0; i--) {
            result.add((A.get(i) + carry) % 10);
            carry = (A.get(i) + carry) / 10;
        }
        if(carry > 0){
            result.add(carry);
        }

        while (result.get(result.size()-1) == 0) {
            result.remove(result.size()-1);
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {

        ArrayList<Integer> input = new ArrayList<>();
        input.add(0);
        input.add(2);
        input.add(3);
        ArrayList<Integer> result = new AddOne().plusOne(input);
        System.out.println(result);
    }
}
