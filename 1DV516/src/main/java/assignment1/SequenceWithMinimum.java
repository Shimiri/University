package assignment1;

public class SequenceWithMinimum implements A1SequenceWithMinimum {
    private ListNode<Integer> leftMost;
    private ListNode<Integer> rightMost;

    public SequenceWithMinimum() {
        leftMost = new ListNode<>(0);
        rightMost = leftMost;
    }

    public SequenceWithMinimum(Integer value) {
        leftMost = new ListNode<>(value);
        rightMost = leftMost;
    }

    @Override
    public void insertRight(Integer value) {
        ListNode<Integer> node = new ListNode<>(value);
        rightMost.right = node;
        node.left = rightMost;
        rightMost = node;
    }

    @Override
    public Integer removeRight() {
        int value = rightMost.item;

        ListNode<Integer> node = rightMost.left;
        node.right = null;
        rightMost = node;

        return value;
    }

    @Override
    public void insertLeft(Integer value) {
        ListNode<Integer> node = new ListNode<>(value);
        leftMost.left = node;
        node.right = leftMost;
        leftMost = node;
    }

    @Override
    public Integer removeLeft() {
        int value = leftMost.item;

        ListNode<Integer> node = leftMost.right;
        node.left = null;
        leftMost = node;

        return value;
    }

    @Override
    public Integer findMinimum() {
        ListNode<Integer> current = leftMost;
        Integer minValue = current.item;
        while (true) {
            if (current.item < minValue) {
                minValue = current.item;
            }
            if (current.right == null)
                break;
            current = current.right;
        }
        return minValue;
    }
}
