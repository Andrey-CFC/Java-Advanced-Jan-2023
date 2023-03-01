package L14WorkshopCustomDataStructuresEx;

import java.util.function.Consumer;

public class LinkedListWithTail {
    private Node head;
    private Node tail;
    private int size;

    public void addFirst(int element) {
        Node node = new Node(element);
        if (!isEmpty()) {
            node.next = this.head;
        } else {
            this.tail = node;
        }
        this.head = node;
        this.size++;
    }

    public void addLast(int element) {
        Node node = new Node(element);
        if (!isEmpty()) {
            Node currentNode = this.tail;
            currentNode.next = node;
            this.tail = currentNode.next;
        } else {
            this.head = node;
            this.tail = node;
        }
        this.size++;
    }

    public int get(int index) {
        isValidIndex(index);
        int counter = 0;
        Node currentNode = this.head;
        while (counter != index) {
            currentNode = currentNode.next;
            counter++;
        }
        return currentNode.value;
    }

    public int removeFirst() {
        checkSize();
        Node currentNode = this.head;
        this.head = currentNode.next;
        this.size--;
        if (isEmpty()) {
            this.head = null;
            this.tail = null;
        }

        return currentNode.value;
    }

    public int removeLast() {
        checkSize();
        if (size < 2) {
            removeFirst();
        }
        Node currentNode = this.head;
        while (currentNode.next.next != null) {
            currentNode = currentNode.next;
        }
        int result = currentNode.next.value;
        currentNode.next = null;
        this.tail = currentNode;
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
        int[] result = new int[this.size];
        Node currentNode = this.head;
        for (int i = 0; i < result.length; i++) {
            result[i] = currentNode.value;
            currentNode = currentNode.next;
        }
        return result;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }
}
