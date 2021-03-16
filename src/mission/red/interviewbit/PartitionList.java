package mission.red.interviewbit;

import mission.red.interviewbit.RemoveDuplicates2.ListNode;

public class PartitionList {

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

    public ListNode partition2(ListNode root, int B) {

        ListNode small = null;
        ListNode smallEnd = null;

        ListNode large = null;
        ListNode largeEnd = null;

        ListNode temp = root;

        while (temp != null) {
            if(temp.val < B){

            }
        }
        return null;
    }
    public ListNode partition(ListNode root, int B) {

        ListNode small = null;
        ListNode smallEnd = null;

        ListNode large = null;
        ListNode largeEnd = null;

        ListNode temp = root;

        while (temp != null) {

            if (temp.val >= B) {
                if (large == null) {
                    large = new ListNode(temp.val);
                    largeEnd = large;
                } else {
                    largeEnd.next = new ListNode(temp.val);
                    largeEnd = largeEnd.next;
                }
            } else {
                if (small == null) {
                    small = new ListNode(temp.val);
                    smallEnd = small;
                } else {
                    smallEnd.next = new ListNode(temp.val);
                    smallEnd = smallEnd.next;
                }
            }
            temp = temp.next;
        }
        if (smallEnd != null) {
            smallEnd.next = large;
            return small;
        }
        return large;
    }

    public static void main(String[] args) {

        ListNode input = new ListNode(1,
            new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));

        ListNode res = new PartitionList().partition(input, 3);
        System.out.println();
    }
}
