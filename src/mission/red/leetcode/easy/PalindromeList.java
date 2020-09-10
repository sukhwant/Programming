package mission.red.leetcode.easy;

public class PalindromeList {

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

    public boolean isPalindrome(ListNode head) {
        ListNode reverse = reverseList(head);
        ListNode headPointer = head;
        ListNode reversePointer = reverse;

        while(headPointer != null){
            if(headPointer.val != reversePointer.val){
                return false;
            }
            reversePointer = reversePointer.next;
            headPointer = headPointer.next;
        }
        return true;
    }

    public static void main(String[] args) {

    }

}
