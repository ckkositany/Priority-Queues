import java.util.*;

public class PriorityQueue<T> {
    private final List<Node<T>> heap;

    public PriorityQueue() {
        this.heap = new ArrayList<>();
    }

    public void add(T value, int priority) {
        heap.add(new Node<>(value, priority));
        bubbleUp(heap.size() - 1);
    }

    public T remove() {
        if (heap.isEmpty()) {
            throw new NoSuchElementException("Priority queue is empty");
        }
        T result = heap.get(0).value;
        if (heap.size() > 1) {
            heap.set(0, heap.remove(heap.size() - 1));
            bubbleDown(0);
        } else {
            heap.remove(0);
        }
        return result;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void bubbleUp(int index) {
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            if (heap.get(index).priority >= heap.get(parentIndex).priority) {
                break;
            }
            Collections.swap(heap, index, parentIndex);
            index = parentIndex;
        }
    }

    private void bubbleDown(int index) {
        int size = heap.size();
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int smallest = index;

            if (leftChild < size && heap.get(leftChild).priority < heap.get(smallest).priority) {
                smallest = leftChild;
            }
            if (rightChild < size && heap.get(rightChild).priority < heap.get(smallest).priority) {
                smallest = rightChild;
            }
            if (smallest == index) {
                break;
            }
            Collections.swap(heap, index, smallest);
            index = smallest;
        }
    }

    private static class Node<T> {
        T value;
        int priority;

        Node(T value, int priority) {
            this.value = value;
            this.priority = priority;
        }
    }
}