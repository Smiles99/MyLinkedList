import java.lang.IndexOutOfBoundsException;

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
        if (index >= size) throw new IndexOutOfBoundsException();
        Node node = new Node(value);
        Node current = start;
        for (int i=0; i< index; i++) {
            current = current.getNext();
        }
        node.setNext(current);
        node.setPrev(current.getPrev());
        current.setPrev(node);
        if (index == 0) {
            start = node;
        }
        if (index == size - 1) {
            end = node;
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
    public String reversedToString() {
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
}
