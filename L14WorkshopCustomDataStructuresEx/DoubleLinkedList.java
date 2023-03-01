package L14WorkshopCustomDataStructuresEx;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoubleLinkedList {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node node = new Node(element);
        if (!isEmpty()) {
            this.head.prev = node;
            node.next = this.head;
        } else {
            this.tail = node;
        }
        this.head = node;
        this.size++;
    }

    public void addLast(int element) {
        if (!isEmpty()) {
            Node node = new Node(element);
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = node;
            this.size++;
        } else {
            addFirst(element);
        }
    }

    public int get(int index) {
        isValidIndex(index);
        Node currentNode;
        int counter = 0;
        if (this.size / 2 < index) {
            currentNode = this.tail;
            while (counter != (this.size - 1) - index) {
                currentNode = currentNode.prev;
                counter++;
            }
        } else {
            currentNode = this.head;
            while (counter != index) {
                currentNode = currentNode.next;
                counter++;
            }
        }
        return currentNode.value;
    }

    public int removeFirst() {
        checkSize();
        Node currentNode = this.head;
        this.head = currentNode.next;
        this.head.prev = null;
        this.size--;
        if (isEmpty()) {
            this.head = null;
            this.tail = null;
        }
        return currentNode.value;
    }

    public int removeLast() {
        checkSize();
        if (this.size < 2) {
            removeFirst();
        }
        Node currentNode = this.tail;
        int result = currentNode.value;
        this.tail = currentNode.prev;
        this.tail.next = null;
        this.size--;
        return result;
    }

    public void isValidIndex(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("No such index in the list");
        }
    }

    public void checkSize() {
        if (isEmpty()) {
            throw new IllegalArgumentException("The List is Empty!");
        }
    }

    public void forEach(Consumer<Integer> consumer) {
        Node currentNode = this.head;
        while (currentNode != null) {
            consumer.accept(currentNode.value);
            currentNode = currentNode.next;
        }
    }

    public int[] toArray() {
        List<Integer> result = new ArrayList<>();
        forEach(result::add);
        return result.stream().mapToInt(e -> e).toArray();
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
