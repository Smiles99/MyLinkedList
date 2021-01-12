public class Node{
    public Node(String value){

    }
    private String data;
    private Node next,prev;
    private String getData() {
        return Node.data;
    }
    private void setData(String newData) {
        Node.data = newData;
    }
    private Node getNext() {
        return Node.next;
    }
    private void setNext(Node newNext) {
        Node.next = newNext;
    }
    private Node getPrev() {
        return Node.prev;
    }
    private void setPrev(Node newPrev) {
        Node.prev = newPrev;
    }
}
