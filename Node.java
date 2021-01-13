public class Node {
  public Node(String value) {
    data = value;
    next = null;
    prev = null;
  }
  private String data;
  private Node next, prev;
  public String getData() {
    return data;
  }
  public void setData(String value) {
    data = value;
  }
  public Node getNext() {
    return next;
  }
  public void setNext(Node node) {
    next = node;
  }
  public Node getPrev() {
    return prev;
  }
  public void setPrev(Node node) {
    prev = node;
  }
}
