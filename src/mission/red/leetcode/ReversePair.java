package mission.red.leetcode;

/**
 * 
 * https://leetcode.com/problems/reverse-pairs/
 * 
 * @author sukhwanp
 *
 */
public class ReversePair {

    private Node tree;

    public class Node {
        int value;
        int numGreaterOrEqual;
        Node left;
        Node right;

        public Node(int value, int numGreaterOrEqual) {
            this.value = value;
            this.numGreaterOrEqual = numGreaterOrEqual;
            this.left = null;
            this.right = null;
        }

    }

    private Node search(Node root, int key) {
        if (root == null) {
            return null;
        } else if (root.value >= key) {
            return root;
        } else if (key > root.value) {
            return search(root.right, key);
        } else {
            return search(root.left, key);
        }
    }

    public int getReversePairCount(int[] input) {

        int ans = 0;
        for (int i = 0; i < input.length; i++) {
            int numToSearch = 2 * input[i] + 1;
            Node node = search(tree, numToSearch);
            if (node != null) {
                ans += node.numGreaterOrEqual;
            }

            insert(input[i]);
        }
        return ans;
    }

    private void insert(int val) {
        Node temp = tree;
        Node parent = null;

        while (temp != null) {
            parent = temp;
            if (val > temp.value) {
                temp = temp.right;
                parent.numGreaterOrEqual++;
            } else if (val < temp.value) {
                temp = temp.left;
                temp.numGreaterOrEqual += parent.numGreaterOrEqual;
            } else {
                break;
            }
        }

        if (tree == null) {
            tree = new Node(val, 1);
        } else if (Integer.compare(parent.value, val) > 0) {
            parent.left = new Node(val, 1);
        } else if (Integer.compare(parent.value, val) < 0) {
            parent.right = new Node(val, 1);
        } else {
            parent.numGreaterOrEqual++;
        }
    }

    public static void main(String[] args) {
        int[] input = { 2, 4, 3, 5, 1 };

        System.out.println(new ReversePair().getReversePairCount(input));
    }
}
