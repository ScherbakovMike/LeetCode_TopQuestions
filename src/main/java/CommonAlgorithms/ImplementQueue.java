package CommonAlgorithms;

public class ImplementQueue {

  private static class Queue<T> {

    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {

      private final T value;
      private Node<T> prev;

      public Node(T value, Node<T> prev) {
        this.value = value;
        this.prev = prev;
      }
    }

    public void add(T value) {
      var node = new Node<>(value, null);
      if (head == null) {
        head = node;
      } else {
        tail.prev = node;
      }
      tail = node;
    }

    public T poll() {
      if (this.tail == null) {
        throw new IllegalArgumentException("The stack is empty");
      }
      var node = this.head;
      this.head = this.head.prev;
      return node.value;
    }
  }

  public static void main(String[] args) {
    var stack = new Queue<Integer>();
    stack.add(1);
    stack.add(2);
    stack.add(3);
    stack.add(4);
    System.out.println(stack.poll());
    System.out.println(stack.poll());
    System.out.println(stack.poll());
    System.out.println(stack.poll());
    System.out.println(stack.poll());
  }
}
