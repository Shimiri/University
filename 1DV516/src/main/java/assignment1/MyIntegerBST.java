package assignment1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MyIntegerBST implements A1Tree {
    private Node<Integer> root;

    public Node<Integer> getRoot() {
        return root;
    }

    public MyIntegerBST() {
        root = new Node<>(0);
    }

    public MyIntegerBST(Integer value) {
        root = new Node<>(value);
    }

    @Override
    public void insert(Integer value)  {
        Node<Integer> current = root;
        do {
            if (value > current.item) {
                if (current.rightChild == null) {
                    current.rightChild = new Node<>(value);
                    return;
                }
                current = current.rightChild;
            }
            else if (value < current.item) {
                if (current.leftChild == null) {
                    current.leftChild = new Node<>(value);
                    return;
                }
                current = current.leftChild;
            }
            else
                return;
        } while (true);
    }

    public boolean contains(Integer value) {
        if (root.item.equals(value))
            return true;

        Node<Integer> next = traverseChildren(value, root);
        while (next != null) {
            if (next.item.equals(value))
                return true;
            next = traverseChildren(value, next);
        }
        return false;
    }

    private Node<Integer> traverseChildren(Integer value, Node<Integer> current) {
        if (current == null)
            return null;

        if (value > current.item)
            return current.rightChild;
        else if (value < current.item)
            return current.leftChild;
        else
            return null;
    }

    @Override
    public Integer mostSimilarValue(Integer value) {
        Node<Integer> parent = root;
        int minDifference = Math.abs(value - parent.item);
        int mostSimilarValue = parent.item;
        while (minDifference != 0) {
            int leftChildDiff = Integer.MAX_VALUE;
            int rightChildDiff = Integer.MAX_VALUE;

            if (isNotNull(parent.leftChild)) {
                 leftChildDiff = Math.abs(value - parent.leftChild.item);
                 if (leftChildDiff < minDifference) {
                     minDifference = leftChildDiff;
                     mostSimilarValue = parent.leftChild.item;
                 }
            }

            if (isNotNull(parent.rightChild)) {
                 rightChildDiff = Math.abs(value - parent.rightChild.item);
                 if (rightChildDiff < minDifference) {
                     minDifference = rightChildDiff;
                     mostSimilarValue = parent.rightChild.item;
                 }
            }

            if (leftChildDiff < rightChildDiff)
                parent = parent.leftChild;
            else if (rightChildDiff < leftChildDiff)
                parent = parent.rightChild;
            else
                break;
        }
        return mostSimilarValue;
    }

    private boolean isNotNull(Node<Integer> node) {
        return node != null;
    }


    @Override
    public void printByLevels() {
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);

        int depth = 0;

        StringBuilder sb = new StringBuilder();
        while (queue.size() != 0) {
            depth += 1;
            int nodeLevelCount = queue.size();

            while (nodeLevelCount > 0) {
                Node<Integer> current = queue.remove();
                sb.append(current.item).append(" ");
                addChildren(queue, current);
                nodeLevelCount--;
            }
            System.out.println("Depth " + depth + ": " + sb.toString());
            sb = new StringBuilder();
        }
    }

    private void addChildren(Queue<Node<Integer>> queue, Node<Integer> node) {
        if (node.leftChild != null)
            queue.add(node.leftChild);
        if (node.rightChild != null)
            queue.add(node.rightChild);
    }
}
