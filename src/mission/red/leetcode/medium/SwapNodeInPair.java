package mission.red.leetcode.medium;

public class SwapNodeInPair {


    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    
    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }

    private ListNode helper(ListNode head) {
        if(head == null)
            return null;
        if(head.next == null)
            return head;
        ListNode temp = head;
        head = head.next;
        temp.next = head.next;
        head.next = temp;
        temp.next = helper(temp.next);

        return head;
    }

    public static void main(String[] args) {

        ListNode node = new ListNode(1);
        ListNode reverse = new SwapNodeInPair().swapPairs(node);
        System.out.println("Hello World....");
    }
}
