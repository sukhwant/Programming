package mission.red.interviewbit;

public class isPalindrome {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }

        public ListNode(final int val, final ListNode next) {
            this.val = val;
            this.next = next;
        }
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
                ListNode x = new ListNode(temp.val);
                x.next = reverse;
                reverse = x;
            }
            temp = temp.next;
        }
        return reverse;
    }

    public boolean lPalin(ListNode head) {
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
        ListNode root = new ListNode(1, new ListNode(2, new ListNode(1)));
        System.out.println(new isPalindrome().lPalin(root));

    }
}
