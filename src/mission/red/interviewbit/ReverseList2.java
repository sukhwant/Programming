package mission.red.interviewbit;

public class ReverseList2 {

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

    public ListNode reverseOpt(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode reversed = null;
        while (temp != null) {
            temp = temp.next;
            head.next = reversed;
            reversed = head;
            head = temp;
        }
        return reversed;
    }

    public ListNode reverseBetween(ListNode root, int m, int n) {

        ListNode temp = root;

        for (int i = 0; i < m - 1; i++) {
            temp = temp.next;
        }

        int i = 0;
        ListNode head = temp;
        ListNode reversed = null;
        while (i++ < n && temp != null) {
            temp = temp.next;
            head.next = reversed;
            reversed = head;
            head = temp;
        }
        return null;
    }

    public static void main(String[] args) {

    }
}
