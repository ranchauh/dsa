package linkedlist;

import java.util.HashMap;
import java.util.Map;


public class LRUCache {

    private DoublyLinkedList dll;
    private Map<Integer, Node> map;
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        dll = new DoublyLinkedList();
        dll.head = new Node(-1, -1);
        dll.tail = new Node(-1, -1);
        dll.head.next = dll.tail;
        dll.tail.prev = dll.head;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            return map.get(key).value;
        } else {
            return -1;
        }
    }

    public void set(int key, int value) {
        Node newNode = new Node(key, value);
        if(map.containsKey(key)) {
            Node node = map.get(key);
            deleteNode(node);
        } else {
            if(map.size() == capacity) {
                Node node = dll.head.next;
                deleteNode(node);
                map.remove(node.key);
            }
        }
        insertBack(newNode);
        map.put(key, newNode);
    }

    private void insertBack(Node node) {
        node.prev = dll.tail.prev;
        node.next = dll.tail;
        dll.tail.prev.next = node;
        dll.tail.prev = node;
    }

    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void print() {
        Node hc = this.dll.head.next;
        while(hc.next != null) {
            System.out.print(hc.value);
            hc = hc.next;
            if(hc.next != null) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.set(2, 1);
        lruCache.set(2, 2);
        lruCache.print();
        System.out.println(lruCache.get(2)); // 2
        lruCache.set(1, 1);
        lruCache.set(4, 1);
        lruCache.print();
        System.out.println(lruCache.get(2)); // -1
    }

    public static void main2(String[] args) {
        LRUCache lruCache = new LRUCache(6);
        for(int i=1; i<=6; i++) {
            lruCache.set(i, i);
        }
        lruCache.print(); // 1 -> 2 -> 3 -> 4 -> 5 -> 6
        lruCache.set(7, 7);
        lruCache.print(); // 2 -> 3 -> 4 -> 5 -> 6 -> 7
        lruCache.set(5, 5);
        lruCache.print(); // 2 -> 3 -> 4 -> 6 -> 7 -> 5
        System.out.println(lruCache.get(10)); // -1
        System.out.println(lruCache.get(2)); // 2
    }
}

