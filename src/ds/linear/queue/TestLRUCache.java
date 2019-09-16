package ds.linear.queue;

import java.util.HashMap;
import java.util.Map;

/*
 * When the cache is full and requires more room the system will purge the item with the lowest reference frequency.
 */

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
    private void _deleteNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void _addToHead(Node node) {
        node.next = head.next;
        node.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    /*
     * Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     */
    int get(int key) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            _deleteNode(node);
            _addToHead(node);
            return node.value;
        }
        return -1;
    }
    
    /*
     * Set or insert the value if the key is not already present.
     * When the cache reaches its capacity, it should invalidate the least frequently used item before inserting a new item.
     * For the purpose of this problem, when there is a tie (i.e., two or more keys that have the same frequency),
     * the least recently used key would be evicted.
     */
    void put(int key, int value) {
        if (map.get(key) != null) {
            Node node = map.get(key);
            node.value = value;
            _deleteNode(node);
            _addToHead(node);
        }
        else {
            Node node = new Node(key, value);
            map.put(key, node);
            if (count < capacity)
                count++;
            else {
                map.remove(tail.prev.key);
                _deleteNode(tail.prev);
            }
            _addToHead(node);
        }
    }
}
public class TestLRUCache {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3.
        cache.put(4, 4);    // evicts key 1.
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}
