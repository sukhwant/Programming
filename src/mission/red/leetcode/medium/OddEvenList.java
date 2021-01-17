package mission.red.leetcode.medium;

public class OddEvenList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode oddEvenList(ListNode head) {

        ListNode result = head;
        ListNode ptr = head.next;

        while(ptr != null){

            result.next = ptr.next;
            result = result.next;
            ptr.next = ptr.next.next;

            if(ptr.next == null){
                break;
            }
            ptr = ptr.next;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,
            new ListNode(5, new ListNode(6, new ListNode(7)))))));

        System.out.println(new OddEvenList().oddEvenList(first));

    }

}
