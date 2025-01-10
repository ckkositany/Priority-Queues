import java.util.*;

/**
 * A generic Priority Queue Abstract Data Type (ADT) implementation using a min-heap.
 * Elements in the priority queue are stored and retrieved based on their priority values.
 *
 * @param <T> the type of elements stored in the priority queue
 */
public class PriorityQueueADT<T> {

    /**
     * A private static inner class representing a node in the priority queue.
     * Each node contains an element and its associated priority.
     *
     * @param <T> the type of element stored in the node
     */
    private static class Node<T> implements Comparable<Node<T>> {
        /** The element stored in the node. */
        T element;

        /** The priority associated with the element. */
        double priority;

        /**
         * Constructs a new node with the specified element and priority.
         *
         * @param element the element to store
         * @param priority the priority value associated with the element
         */
        Node(T element, double priority) {
            this.element = element;
            this.priority = priority;
        }

        /**
         * Compares this node's priority with another node's priority.
         *
         * @param other the node to compare with
         * @return a negative value if this node's priority is less than the other's,
         *         zero if they are equal, and a positive value otherwise
         */
        @Override
        public int compareTo(Node<T> other) {
            return Double.compare(this.priority, other.priority);
        }
    }

    /** The priority queue implemented as a min-heap. */
    private final PriorityQueue<Node<T>> pq = new PriorityQueue<>();

    /** A map to track elements and their nodes for efficient access. */
    private final Map<T, Node<T>> entryFinder = new HashMap<>();

    /**
     * Inserts an element into the priority queue with the specified priority.
     *
     * @param element the element to insert
     * @param priority the priority associated with the element
     * @throws IllegalArgumentException if the element is already in the priority queue
     */
    public void insert(T element, double priority) {
        if (entryFinder.containsKey(element)) {
            throw new IllegalArgumentException("Element already exists in the priority queue.");
        }
        Node<T> node = new Node<>(element, priority);
        entryFinder.put(element, node);
        pq.add(node);
    }

    /**
     * Removes and returns the element with the highest priority (lowest priority value).
     *
     * @return the element with the highest priority
     * @throws NoSuchElementException if the priority queue is empty
     */
    public T remove() {
        while (!pq.isEmpty()) {
            Node<T> node = pq.poll();
            if (entryFinder.remove(node.element) != null) {
                return node.element;
            }
        }
        throw new NoSuchElementException("Priority Queue is empty");
    }

    /**
     * Checks whether the priority queue is empty.
     *
     * @return {@code true} if the priority queue is empty, {@code false} otherwise
     */
    public boolean isEmpty() {
        return entryFinder.isEmpty();
    }
}
