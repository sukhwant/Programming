package mission.red.interviewbit;


public class RemoveDuplicates2 {

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

    public ListNode deleteDuplicates(ListNode root) {

        ListNode ptr1 = root;
        ListNode ptr2 = root.next;

        while (ptr2 != null) {
            if (ptr1.next.val == ptr2.val) {
                //DO CleanUp... from temp to ptr3
            } else {
                ptr1.next = ptr2;
                ptr1 = ptr1.next;
            }
            ptr2 = ptr2.next;
        }
        return root;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3,
            new ListNode(4, new ListNode(4, new ListNode(5)))))));

        ListNode ans = new RemoveDuplicates2().deleteDuplicates(root);
        System.out.println("Hello");
    }
}
