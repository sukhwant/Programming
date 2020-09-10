package mission.red.leetcode.easy;

public class CycleInList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode pointer1 = head;
        ListNode pointer2 = head;

        while(true){
            if(pointer1 == null || pointer2 == null ||
                pointer1.next == null || pointer2.next == null || pointer2.next.next == null){
                return false;
            }
            pointer1 = pointer1.next;
            pointer2 = pointer2.next.next;

            if(pointer1 == pointer2){
                return true;
            }
        }
    }

    public static void main(String[] args) {

    }
}
