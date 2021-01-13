import java.lang.IndexOutOfBoundsException;
import java.util.*;

public class MyLinkedList {
    private int size;
    private Node start, end;
    public MyLinkedList() {
        size = 0;
        start = null;
        end = null;
    }
    public int size() {
        return size;
    }
    public boolean add(String value) {
        Node node = new Node(value);
        node.setNext(null);
        node.setPrev(end);
        if (start == null) {
            start = node;
        }
        if (end != null) {
            end.setNext(node);
        }
        end = node;
        size++;
        return true;
    }
    public void add(int index, String value) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index > size) throw new IndexOutOfBoundsException();
        Node node = new Node(value);
        if (size == 0) {
            add(value);
            return;
        }
        if (index == size) {
            node.setPrev(end);
            end.setNext(node);
            end = node;
        } else if (index == 0) {
            node.setNext(start);
            start.setPrev(node);
            start = node;
        } else {
            Node current = start;
            for (int i=0; i< index; i++) {
                current = current.getNext();
            }
            Node prev = current.getPrev();
            node.setNext(current);
            node.setPrev(prev);
            current.setPrev(node);
            prev.setNext(node);
        }
        size++;
    }
    public String get(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index >= size) throw new IndexOutOfBoundsException();
        Node current = start;
        for (int i=0; i< index; i++) {
            current = current.getNext();
        }
        return current.getData();
    }
    public String set(int index, String value) {
        return "";
    }
    public String toString() {
        String result = "";
        Node current = start;
        String delimiter = "";
        while (current != null) {
            result = result + delimiter + current.getData();
            delimiter = "\n";
            current = current.getNext();
        }
        return result;
    }
    public String toStringReversed() {
        String result = "";
        Node current = end;
        String delimiter = "";
        while (current != null) {
            result = result + delimiter + current.getData();
            delimiter = "\n";
            current = current.getPrev();
        }
        return result;
    }
    public String remove(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        if (index >= size) throw new IndexOutOfBoundsException();
        String removed;
        if (size == 1) {
            removed = start.getData();
            start = null;
            end = null;
        } else if (index == size-1) {
            removed = end.getData();
            end = end.getPrev();
            end.setNext(null);
        } else if (index == 0) {
            removed = start.getData();
            start = start.getNext();
            start.setPrev(null);
        } else {
            Node current = start;
            for (int i=0; i< index; i++) {
                current = current.getNext();
            }
            Node prev = current.getPrev();
            Node next = current.getNext();
            prev.setNext(next);
            next.setPrev(prev);
            removed = current.getData();
        }
        size--;
        return removed;
    }
    public void extend(MyLinkedList other) {
        this.size = this.size + other.size;
        Node end = this.end;
        Node start = other.start;
        start.setNext(end);
        end.setPrev(start);
        other.size = 0;
    }
}
