package mission.red.interviewbit;


import mission.red.interviewbit.ReverseListK.ListNode;

public class RotateList {

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

    public ListNode rotateRight(ListNode root, int k) {

        ListNode temp = root;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        temp = root;
        k = k % size;

        for (int i = 0; i < k; i++) {
            temp = temp.next;
        }

        ListNode curr = root;

        while (temp.next != null) {
            temp = temp.next;
            curr = curr.next;
        }

        temp.next = root;
        root = curr.next;
        curr.next = null;
        return root;
    }

    public static void main(String[] args) {

        ListNode ans = new RotateList().rotateRight(new ListNode(1, new ListNode(2,
            new ListNode(3,
                new ListNode(4, new ListNode(5, new ListNode(6, null)))))), 2);

        System.out.println("Hello.");

    }
}
