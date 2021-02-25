package mission.red.leetcode.challenge.feburary;

import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
            this.random = null;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    public Node copyRandomList(Node head) {

        if(head == null)
            return null;

        Map<Integer, Node> map = new HashMap<>();

        Node newHead = copyList(head, map);

        Node iter1 = head;
        Node iter2 = newHead;
        while(iter1 != null){

            Node rand = iter1.random;
            if(rand != null)
                iter2.random = map.get(rand.val);

            iter1 = iter1.next;
            iter2 = iter2.next;
        }
        return newHead;
    }

    private Node copyList(final Node head, Map<Integer, Node> map) {
        if(head == null)
            return null;
        if(head.next == null){
            Node temp = new Node(head.val, null);
            map.put(head.val, temp);
            return temp;
        }
        Node previous = copyList(head.next, map);
        Node temp = new Node(head.val);
        temp.next = previous;
        map.put(head.val, temp);
        return temp;
    }

    public static void main(String[] args) {

        Node head = new Node(7, new Node(13, new Node(11, new Node(10, new Node(1)))));

        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        System.out.println(new CopyRandomList().copyRandomList(head));
    }
}
