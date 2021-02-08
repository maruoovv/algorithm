import java.util.*;

class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node head;
    private Node tail;
    private int currentSize = 0;
    private Map<Integer, Node> cache = new HashMap<>();
    private int capacity;

    public LRUCache(int capacity) {
        head = new Node(-1, -1, null, null);
        tail = new Node(-1, -1, null, null);

        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = cache.get(key);

        if (node == null) return -1;

        moveToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            Node newNode = new Node(key, value, null, null);

            cache.put(key, newNode);
            add(newNode);

            currentSize++;

            if (currentSize > capacity) {
                Node tail = popTail();
                cache.remove(tail.key);
                currentSize--;
            }

        } else {
            node.value = value;
            moveToHead(node);

        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        add(node);
    }

    private void add(Node node) {
        node.next = head.next;
        head.next.prev = node;

        head.next = node;
        node.prev = head;
    }

    private Node popTail() {
        Node lastNode = tail.prev;

        removeNode(lastNode);
        return lastNode;
    }

    private void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
}


