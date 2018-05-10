package sb223jy_assign4.exercise_5;

public class BinaryIntHeap {
    private int[] tree;
    private int size;

    public BinaryIntHeap() {
        tree = new int[8];
    }

    public void insert(int n) {
        if (++size == tree.length)
            resize();
        tree[size - 1] = n;
        bubbleUp();
    }

    private void bubbleUp() {
        int index = size - 1;
        while (index > 0 && tree[index] < tree[getParent(index)]) {
            swap(index, getParent(index));
            index = getParent(index);
        }
    }

    public int pullHighest() {
        int top = tree[0];
        tree[0] = tree[size - 1];
        tree[size - 1] = 0;
        size--;
        bubbleDown();
        return top;
    }

    private void bubbleDown() {
        int index = 0;
        do {
            int leftChild = tree[getLeftChildIndex(index)];
            int rightChild = tree[getRightChildIndex(index)];
            if (tree[index] > leftChild) {
                swap(index, getLeftChildIndex(index));
                index = getLeftChildIndex(index);
            } else if (tree[index] > rightChild){
                swap(index, getRightChildIndex(index));
                index = getRightChildIndex(index);
            } else
                break;
        } while (getLeftChildIndex(index) < size - 1 && getRightChildIndex(index) < size - 1);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    private void resize() {
        int[] temp = new int[tree.length * 2];
        System.arraycopy(tree, 0, temp, 0, tree.length);
        tree = temp;
    }

    private int getLeftChildIndex(int index) {
        return (index * 2) + 1;
    }

    private int getRightChildIndex(int index) {
        return (index * 2) + 2;
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private void swap(int a, int b) {
        int temp = tree[a];
        tree[a] = tree[b];
        tree[b] = temp;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int n : tree) {
            if (n != 0)
                sb.append(n).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }
}
