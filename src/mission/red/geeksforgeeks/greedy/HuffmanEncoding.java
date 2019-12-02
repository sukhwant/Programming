package mission.red.geeksforgeeks.greedy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * https://www.geeksforgeeks.org/huffman-coding-greedy-algo-3/
 * 
 * @author sukhwanp
 *
 */
public class HuffmanEncoding {

    @Getter
    @Setter
    @AllArgsConstructor
    public static class Letter {
        private char character;
        private int frequency;
    }

    @Getter
    @Setter
    public static class HuffManNode {
        private char character;
        private int frequency;

        private HuffManNode left;
        private HuffManNode right;

        public HuffManNode(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {

        List<Letter> letters = new LinkedList<>();

        letters.add(new Letter('a', 5));
        letters.add(new Letter('b', 9));
        letters.add(new Letter('c', 12));
        letters.add(new Letter('d', 13));
        letters.add(new Letter('e', 16));
        letters.add(new Letter('f', 45));

        encode(letters);
    }

    private static void encode(List<Letter> letters) {

        PriorityQueue<HuffManNode> queue = new PriorityQueue<>((x, y) -> x.frequency - y.frequency);
        HuffManNode root = null;

        for (Letter letter : letters) {
            queue.add(new HuffManNode(letter.character, letter.frequency));
        }

        while (queue.size() > 1) {
            HuffManNode firstNode = queue.poll();
            HuffManNode secondNode = queue.poll();

            HuffManNode node = new HuffManNode('-', firstNode.frequency + secondNode.frequency);

            node.left = firstNode;
            node.right = secondNode;

            root = node;

            queue.add(node);
        }

        Map<Character, String> codeMap = new HashMap<>();
        printNode(root, "", codeMap);

        System.out.println("hello");
        codeMap.entrySet().stream().forEach(x -> System.out.println(x.getKey() + " " + x.getValue()));
    }

    private static void printNode(HuffManNode root, String code, Map<Character, String> codeMap) {
        if (root.left == null && root.right == null && Character.isLetter(root.character)) {
            codeMap.put(root.character, code);
            return;
        }

        printNode(root.left, code + '0', codeMap);
        printNode(root.right, code + '1', codeMap);
    }

}
