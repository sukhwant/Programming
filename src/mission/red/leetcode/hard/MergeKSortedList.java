package mission.red.leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/merge-k-sorted-lists/
 *
 */
public class MergeKSortedList {

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

    /**
     *
     * Solution:
     * complexity - O(k.N) where N = total number of nodes
     */
    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode mergedList = null;

        ListNode[] temp = new ListNode[lists.length];
        System.arraycopy(lists, 0, temp, 0, lists.length);

        int smallestIndex = findSmallestNode(temp);
        while (smallestIndex != -1) {
            ListNode smallest = temp[smallestIndex];
            mergedList = addLast(mergedList, smallest.val);
            temp[smallestIndex] = smallest.next;
            smallestIndex = findSmallestNode(temp);
        }

        return mergedList;
    }

    private static int findSmallestNode(final ListNode[] temp) {

        boolean answer = Arrays.stream(temp)
            .allMatch(Objects::isNull);
        if (answer) {
            return -1;
        }

        int smallestIndex = 0;
        for (int i = 0; i < temp.length; i++) {
            if (compare(temp[i], temp[smallestIndex])) {
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    private static boolean compare(final ListNode l1, final ListNode l2) {
        if (l1 == null) {
            return false;
        }
        if (l2 == null) {
            return true;
        }

        return (l1.val < l2.val);
    }

    /**
     *
     * Solution: Min Heap Solution
     * complexity - O(N.log k) where N = total number of nodes
     */
    public static ListNode mergeKListsPriorityQueue(ListNode[] lists) {
        ListNode mergedList = new ListNode(-1);
        ListNode lastNode = mergedList;

        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        priorityQueue.addAll(Arrays.stream(lists).filter(Objects::nonNull).collect(Collectors.toList()));

        while(!priorityQueue.isEmpty()){
            ListNode smallest = priorityQueue.poll();
            lastNode.next = new ListNode(smallest.val);
            lastNode = lastNode.next;
            if(smallest.next != null) {
                priorityQueue.add(smallest.next);
            }
        }
        return mergedList.next;
    }

    public static void main(String[] args) {

        ListNode[] lists = new ListNode[3];

        ListNode l1 = null;
        lists[0] = l1;

        ListNode mergedList = mergeKListsPriorityQueue(lists);
    }

    private static class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
