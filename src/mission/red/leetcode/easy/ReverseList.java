package mission.red.leetcode.easy;

public class ReverseList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static ListNode reverseList(ListNode head) {
        if(head == null)
            return null;
        ListNode temp = head;
        ListNode reverse = null;
        while(temp != null){
            if(reverse == null){
                reverse = new ListNode(temp.val);
            } else{
                reverse = new ListNode(temp.val, reverse);
            }
            temp = temp.next;
        }
        return reverse;
    }

    public static void main(String[] args) {
        ListNode reverse = reverseList(new ListNode(1, new ListNode(2, new ListNode(3))));
        System.out.println("Hello...");
    }

}
