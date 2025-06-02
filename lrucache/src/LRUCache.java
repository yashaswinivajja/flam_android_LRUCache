import java.util.HashMap;

public class LRUCache {
    private static class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final HashMap<Integer, Node> map;
    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1); // Dummy head
        tail = new Node(-1, -1); // Dummy tail
        connect(head, tail);     // Head <-> Tail
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        moveToFront(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            moveToFront(node);
            return;
        }
        if (map.size() >= capacity) {
            Node toRemove = tail.prev;
            detach(toRemove);
            map.remove(toRemove.key);
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insertAfter(head, newNode);
    }

    private void moveToFront(Node node) {
        detach(node);
        insertAfter(head, node);
    }

    private void insertAfter(Node prevNode, Node newNode) {
        Node nextNode = prevNode.next;
        connect(prevNode, newNode);
        connect(newNode, nextNode);
    }

    private void detach(Node node) {
        connect(node.prev, node.next);
    }

    private void connect(Node first, Node second) {
        if (first != null) first.next = second;
        if (second != null) second.prev = first;
    }
}
