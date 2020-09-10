package mission.red.leetcode.easy;

import mission.red.leetcode.easy.ReverseList.ListNode;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 */
public class MergeSortedList {

    public static ListNode addLast(ListNode head, int x) {
        if (head == null) {
            head = new ListNode(x);
        } else {
            ListNode node = new ListNode(x);

            // go to last.
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }

            // Add the new node at last.
            temp.next = node;
        }
        return head;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode merged = null;
        ListNode lastNode = merged;
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        while (temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
                if(merged == null) {
                    merged = new ListNode(temp1.val);
                    lastNode = merged;
                }
                else {
                    lastNode.next = new ListNode(temp1.val);
                    lastNode = lastNode.next;
                }
                temp1 = temp1.next;
            } else {
                if(merged == null) {
                    merged = new ListNode(temp2.val);
                    lastNode = merged;
                }
                else {
                    lastNode.next = new ListNode(temp2.val);
                    lastNode = lastNode.next;
                }
                temp2 = temp2.next;
            }
        }

        if (temp1 != null) {
            while(temp1 != null) {
                if(merged == null) {
                    merged = new ListNode(temp1.val);
                    lastNode = merged;
                }
                else {
                    lastNode.next = new ListNode(temp1.val);
                    lastNode = lastNode.next;
                }
                temp1 = temp1.next;
            }
        }

        if (temp2 != null) {
            while(temp2 != null){
                if(merged == null) {
                    merged = new ListNode(temp2.val);
                    lastNode = merged;
                }
                else {
                    lastNode.next = new ListNode(temp2.val);
                    lastNode = lastNode.next;
                }
                temp2 = temp2.next;
            }
        }
        return merged;
    }

    public static void main(String[] args) {

        ListNode l1 = null;

        ListNode l2 = new ListNode(1);
        addLast(l2, 3);
        addLast(l2, 4);
        addLast(l2, 5);

        ListNode mergedList = mergeTwoLists(l1, l2);
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
