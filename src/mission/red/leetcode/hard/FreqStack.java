package mission.red.leetcode.hard;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class FreqStack {

    int maxFrequency;
    private Map<Integer, Stack<Integer>> frequencyStack;
    private Map<Integer, Integer> freqMap;

    public FreqStack() {
        this.frequencyStack = new HashMap<>();
        this.freqMap = new HashMap<>();
        maxFrequency = 0;
    }

    public void push(int x) {
        int freq = freqMap.getOrDefault(x, 0) + 1;
        maxFrequency = Math.max(maxFrequency, freq);
        freqMap.put(x, freq);

        Stack<Integer> currStack = frequencyStack.getOrDefault(freq, new Stack<>());
        currStack.push(x);
        frequencyStack.put(freq, currStack);
    }

    public int pop() {

        Stack<Integer> currMaxStack = frequencyStack.get(maxFrequency);
        Integer currElement = currMaxStack.pop();
        freqMap.put(currElement, freqMap.get(currElement) - 1);
        if (frequencyStack.get(maxFrequency).isEmpty()) {
            maxFrequency--;
        }
        return currElement;
    }

    public static void main(String[] args) {
        FreqStack stack = new FreqStack();
        stack.push(5);
        stack.push(7);
        stack.push(5);
        stack.push(7);
        stack.push(4);
        stack.push(5);

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
