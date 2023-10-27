package CommonAlgorithms;

public class ImplementLinkedList {

  static class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {

      private final T value;
      private Node<T> next;

      public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
      }
    }

    public void add(T value) {
      var node = new Node<T>(value, null);
      if (head == null) {
        this.head = node;
        this.tail = node;
      }
      if (tail != node) {
        this.tail.next = node;
        this.tail = node;
      }
    }

    public void remove(int i) {
      var j = 0;
      Node<T> prevNode = null;
      var currentNode = this.head;
      while (currentNode != null && j != i) {
        prevNode = currentNode;
        currentNode = currentNode.next;
        j++;
      }
      if (i == j) {
        if (prevNode == null) {
          this.head = currentNode.next;
        } else {
          prevNode.next = currentNode.next;
        }
        if (currentNode.next == null) {
          this.tail = prevNode;
        }
      } else {
        throw new IllegalArgumentException("The node with %d index doesn't exist.".formatted(i));
      }
    }

    public T get(int i) {
      var j = 0;
      var currentNode = this.head;
      while (currentNode != null && j != i) {
        currentNode = currentNode.next;
        j++;
      }
      if (i == j) {
        return currentNode.value;
      } else {
        throw new IllegalArgumentException("The node with %d index doesn't exist.".formatted(i));
      }
    }
  }

  public static void main(String[] args) {
    var list = new LinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(4);
    list.add(5);

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));
    System.out.println(list.get(3));
    System.out.println(list.get(4));
    System.out.println();

    list.remove(0);
    list.remove(2);

    System.out.println(list.get(0));
    System.out.println(list.get(1));
    System.out.println(list.get(2));
  }
}
