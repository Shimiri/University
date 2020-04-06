package assignment1;

public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
    public T item;
    public Node<T> leftChild;
    public Node<T> rightChild;
    public Node(T value) {
        item = value;
    }

    @Override
    public int compareTo(Node<T> t) {
        return item.compareTo(t.item);
    }
}
