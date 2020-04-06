package assignment1;

public class ListNode<T> {
    public ListNode<T> left;
    public ListNode<T> right;
    public T item;

    public ListNode(T value) {
        this.item = value;
    }
}
