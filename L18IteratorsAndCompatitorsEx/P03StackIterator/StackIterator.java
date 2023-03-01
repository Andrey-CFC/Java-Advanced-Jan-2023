package L18IteratorsAndCompatitorsEx.P03StackIterator;

import javax.naming.OperationNotSupportedException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class StackIterator implements Iterable {
    private Integer[] elements;
    private int currentIndex;

    public StackIterator() {
        this.elements = new Integer[20];
        this.currentIndex = 0;
    }

    public void push(int element) {
        this.elements[this.currentIndex++] = element;
    }

    public int pop() throws OperationNotSupportedException {
        try {
            Integer element = this.elements[this.currentIndex - 1];
            this.elements[this.currentIndex - 1] = null;
            this.currentIndex--;
            return element;
        } catch (ArrayIndexOutOfBoundsException ex) {

            throw new OperationNotSupportedException();
        }

    }


    @Override
    public Iterator iterator() {
        return new CustomStackIterator();
    }

    @Override
    public void forEach(Consumer action) {
//        if (currentIndex <= 0) {
//            try {
//                throw new OperationNotSupportedException("No elements");
//            } catch (OperationNotSupportedException e) {
//                System.out.println(e.getMessage());
//            }
//        }
        Iterator iterator = iterator();
        while (iterator.hasNext()) {
            action.accept(iterator.next());
        }
    }

    private class CustomStackIterator implements Iterator {
        private int index = currentIndex;

        @Override
        public boolean hasNext() {
            return index > 0;
        }

        @Override
        public Object next() {
            if (hasNext()) {
                return elements[--index];
            }
            throw new NoSuchElementException();
        }
    }
}
