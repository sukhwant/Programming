package mission.red.leetcode.medium;

public class AddLinkedList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode ptr1 = l1;
        ListNode ptr2 = l2;

        ListNode result = null;
        ListNode ptr3 = null;

        int carry = 0;

        while(ptr1 != null && ptr2 != null){

            if(result == null){
                result = new ListNode();
                ptr3 = result;
            }
            else {
                ptr3.next = new ListNode();
                ptr3 = ptr3.next;
            }

            int first = ptr1.val;
            int second = ptr2.val;

            ptr3.val = (first + second + carry)%10;
            carry = (first + second + carry)/10;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        while(ptr1 != null){
            if(result == null){
                result = new ListNode();
                ptr3 = result;
            }
            else {
                ptr3.next = new ListNode();
                ptr3 = ptr3.next;
            }

            int first = ptr1.val;

            ptr3.val = (first + carry)%10;
            carry = (first + carry)/10;
            ptr1 = ptr1.next;
        }

        while(ptr2 != null){
            if(result == null){
                result = new ListNode();
                ptr3 = result;
            }
            else {
                ptr3.next = new ListNode();
                ptr3 = ptr3.next;
            }

            int first = ptr2.val;

            ptr3.val = (first + carry)%10;
            carry = (first + carry)/10;
            ptr2 = ptr2.next;
        }

        if(carry != 0){
            ptr3.next = new ListNode();
            ptr3 = ptr3.next;
            ptr3.val = carry;
        }

        return result;
    }

    public static void main(String[] args) {
        // (2 -> 4 -> 3) + (5 -> 6 -> 4)
        // 7 -> 0 -> 8
        // 342 + 465 = 1807.

        ListNode first = new ListNode(2, new ListNode(4, new ListNode(3, new ListNode(1))));
        ListNode second = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode ans = new AddLinkedList().addTwoNumbers(first, second);
        System.out.println("Hello");

    }
}
