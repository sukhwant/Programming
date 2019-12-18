package mission.red.leetcode.medium;

public class DeepCopy {

    public static void main(String[] args) {

    }

    public Node copyRandomList(Node head) {
        Node copyHead = new Node();
        Node currHead = copyHead;

        Node temp = head;
        while (temp != null) {
            Node neNode = new Node(head.val, null, null);
        }
        return null;
    }


    public class Node {

        int val;
        Node next;
        Node random;

        Node() {
        }

        Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    }
}
