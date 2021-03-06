import java.util.NoSuchElementException;

/**
 * Singly Linked List Implementation
 * @author Nauman Ahmad
 */
 public class SLinkedList <T> {
    private Node <T> head;
    private int size;

    public void addFirst(T value) {
        Node tmp = new Node <T> (value);

        if (head == null) {
            head = tmp;
        } else {
            tmp.next = head;
            head = tmp;
        }
        size++;
    }

    public void addLast(T value) {
        Node tmp = new Node <T> (value);

        if (head == null) {
            head = tmp;
        } else {
            Node current = head;
            while (current.next != null)
                current = current.next;
            current.next = tmp;
        }
        size++;
    }

    public void addAtIndex(T value, int index) {
        Node <T> current = getNodeAtIndex(index);

        T tmp = current.data;
        Node <T> tmpNode = new Node<>(tmp);

        current.data = value;
        tmpNode.next = current.next;
        current.next = tmpNode;
        size++;
    }

    public void removeFirst() {
        checkIsEmpty();
        head = head.next;
    }

    public void removeLast() {
        checkIsEmpty();
        Node current = head;

        while (current.next.next != null)
            current = current.next;
        current.next = null;
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException();
    }

    private void checkIsEmpty() {
        if (size == 0)
            throw new NoSuchElementException();
    }

    public int getSize() { return size; }

    public void clear() { head = null; }

    private Node getNodeAtIndex(int index) {
        checkIndex(index);
        Node <T> current = head;

        int counter = 0;
        while (counter < index) {
            current = current.next;
            counter++;
        }

        return current;
    }

    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    public int indexOf(T value) {
        int counter = 0;
        Node <T> current = head;

        while (current != null) {
            if (current.data.equals(value))
                return counter;
            current = current.next;
            counter++;
        }

        return -1;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) getNodeAtIndex(index).data;
    }

    @Override
    public String toString() {
        StringBuilder content = new StringBuilder("[");
        Node current = head;

        while (current.next != null) {
            content.append(current.data).append(",");
            current = current.next;
        }
        content.append(current.data, "]");
        return content.toString();
    }

    private class Node <E> {
        public E data;
        public Node <E> next;

        Node(E data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }
}
