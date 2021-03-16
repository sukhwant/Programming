package mission.red.interviewbit;

import java.util.LinkedList;
import java.util.List;

public class ReverseListK {

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

    public ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        ListNode reverse = null;
        while (temp != null) {
            if (reverse == null) {
                reverse = new ListNode(temp.val);
            } else {
                ListNode curr = new ListNode(temp.val);
                curr.next = reverse;
                reverse = curr;
            }
            temp = temp.next;
        }
        return reverse;
    }

    public ListNode reverseList(ListNode input, int k) {

        List<ListNode> subLists = new LinkedList<>();

        ListNode curr = input;
        subLists.add(input);
        while (curr != null) {
            for (int i = 0; i < k-1 && curr != null; i++) {
                curr = curr.next;
            }
            subLists.add(curr.next);
            ListNode temp = curr.next;
            curr.next = null;
            curr = temp;
        }

        List<ListNode> reversedLists = new LinkedList<>();
        for (ListNode node : subLists) {
            ListNode reverse = reverse(node);
            reversedLists.add(reverse);
        }

        ListNode reversed = null;
        ListNode endPtr = null;

        for (ListNode node : reversedLists) {

            ListNode temp = node;
            if (reversed == null) {
                reversed = node;
                endPtr = node;
            } else {
                endPtr.next = node;
            }

            while (temp != null) {
                endPtr = temp;
                temp = temp.next;
            }
        }
        return reversed;
    }

    public static void main(String[] args) {
        ListNode reverse = new ReverseListK().reverseList(new ListNode(6, new ListNode(10,
            new ListNode(0,
            new ListNode(3, new ListNode(4, new ListNode(8, null)))))), 3);
        System.out.println("Hello...");
    }

}
