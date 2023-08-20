package heap;

import linkedlist.LinkedList;
import linkedlist.ListNode;

import java.util.*;

public class MergeKSortedLinkedList {
    static class Pair {
        int num;
        ListNode node;
        Pair(int num, ListNode node) {
            this.num = num;
            this.node = node;
        }
    }
    public static ListNode mergeKLists(List<ListNode> list) {
        if(list.isEmpty()) {
            return null;
        }
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p.num));
        for(ListNode node : list) {
            minHeap.add(new Pair(node.val, node));
        }

        ListNode head = null, curr = null;
        while(!minHeap.isEmpty()) {
            Pair pair = Objects.requireNonNull(minHeap.poll());
            if(head == null) {
                head = pair.node;
                curr = head;
            } else if(curr != null){
                curr.next = pair.node;
                curr = curr.next;
            }
            if(pair.node != null && pair.node.next != null) {
                minHeap.add(new Pair(pair.node.next.val, pair.node.next));
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode h1 = LinkedList.arrayToLinkedList(new int[]{1,10,20});
        ListNode h2 = LinkedList.arrayToLinkedList(new int[]{4,11,13});
        ListNode h3 = LinkedList.arrayToLinkedList(new int[]{3,8,9});
        ListNode head = mergeKLists(Arrays.asList(h1, h2, h3));
        LinkedList.print(head); // 1 -> 3 -> 4 -> 8 -> 9 -> 10 -> 11 -> 13 -> 20
    }
}
