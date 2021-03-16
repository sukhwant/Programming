package mission.red.interviewbit;


import java.util.LinkedList;

public class RemoveNthFromList {

    public static class ListNode {

        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        public ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode removeNthFromEnd(ListNode root, int n) {

        ListNode endPtr = root;
        ListNode currPtr = root;
        int i = 0;

        if (root == null) {
            return null;
        }

        while (i < n && currPtr != null) {
            currPtr = currPtr.next;
            i++;
        }

        if (currPtr == null) {
            ListNode temp = root;
            root = root.next;
            temp.next = null;
            return root;
        }

        while (currPtr.next != null) {
            endPtr = endPtr.next;
            currPtr = currPtr.next;
        }

        ListNode temp = endPtr.next;
        endPtr.next = endPtr.next.next;
        temp.next = null;
        return root;
    }

    public static void main(String[] args) {

        ListNode root = new ListNode(1, null);

        System.out.println(new RemoveNthFromList().removeNthFromEnd(root, 1));
    }
}
