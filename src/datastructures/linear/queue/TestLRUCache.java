package datastructures.linear.queue;

import java.util.HashMap;
import java.util.Map;

class Node {
    int key;
    int value;
    Node prev;
    Node next;
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
class LRUCache {
    private Map<Integer, Node> map = new HashMap<>();
    private int capacity, count;
    private Node head, tail;
    LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        head.prev = null;
        tail.next = null;
        count = 0;
    }
    private void deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }
    int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }
    void set(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            addToHead(node);
        }
        else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity)
                count++;
            else {
                map.remove(tail.prev.key);
                deleteNode(tail.prev);
            }
            addToHead(node);
        }
    }
}
public class TestLRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(1, 10);
        cache.set(2, 20);
        System.out.println("Value for the key: 1 is " + cache.get(1));
        cache.set(3, 30);
        System.out.println("Value for the key: 2 is " + cache.get(2));
        cache.set(4, 40);
        System.out.println("Value for the key: 1 is " + cache.get(1));
        System.out.println("Value for the key: 3 is " + cache.get(3));
        System.out.println("Value for the key: 4 is " + cache.get(4));
    }
}
