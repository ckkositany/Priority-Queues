import java.util.*;

public class CustomPriorityQueue<T> {
    private static class Node<T> implements Comparable<Node<T>> {
        private T value;
        private int priority;
        private long count;

        public Node(T value, int priority, long count) {
            this.value = value;
            this.priority = priority;
            this.count = count;
        }

        @Override
        public int compareTo(Node<T> other) {
            if (this.priority != other.priority) {
                return Integer.compare(this.priority, other.priority);
            }
            return Long.compare(this.count, other.count);
        }
    }

    private PriorityQueue<Node<T>> minHeap;
    private Map<T, Node<T>> entryFinder;
    private long counter;

    public CustomPriorityQueue() {
        this.minHeap = new PriorityQueue<>();
        this.entryFinder = new HashMap<>();
        this.counter = 0;
    }

    public void insert(T value, int priority) {
        if (entryFinder.containsKey(value)) {
            remove(value);
        }
        Node<T> node = new Node<>(value, priority, counter++);
        entryFinder.put(value, node);
        minHeap.add(node);
    }

    public void remove(T value) {
        Node<T> node = entryFinder.remove(value);
        if (node != null) {
            node.value = null; // Mark as removed
        }
    }

    public T pop() {
        while (!minHeap.isEmpty()) {
            Node<T> node = minHeap.poll();
            if (node.value != null) {
                entryFinder.remove(node.value);
                return node.value;
            }
        }
        throw new NoSuchElementException("Pop from an empty priority queue");
    }

    public void changePriority(T value, int priority) {
        insert(value, priority);
    }

    public boolean isEmpty() {
        return entryFinder.isEmpty();
    }

    public static void main(String[] args) {
        CustomPriorityQueue<String> pq = new CustomPriorityQueue<>();
        pq.insert("A", 3);
        pq.insert("B", 1);
        pq.insert("C", 2);

        assert pq.pop().equals("B") : "Failed Test Case 1";
        pq.changePriority("C", 0);
        assert pq.pop().equals("C") : "Failed Test Case 2";
        assert pq.pop().equals("A") : "Failed Test Case 3";

        try {
            pq.pop();
        } catch (NoSuchElementException e) {
            System.out.println("Passed Empty Queue Test");
        }

        System.out.println("All test cases passed.");
    }
}
