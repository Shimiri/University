package sb223jy_assign1.exercise_1;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {
    private int capacity;

    public ArrayIntStack() {
        capacity = values.length;
    }

    public ArrayIntStack(int capacity) {
        values = new int[capacity];
        this.capacity = capacity;
    }

    @Override
    public void push(int n) {
        checkCapacity();
        values[size++] = n;
    }

    @Override
    public int pop() throws IndexOutOfBoundsException {
        if (!isEmpty()) {
            int tmp = values[size() - 1];
            values[--size] = 0;
            return tmp;
        } else
            throw new IndexOutOfBoundsException();
    }

    @Override
    public int peek() throws IndexOutOfBoundsException {
        if (!isEmpty()) {
            return values[size() - 1];
        }
        else
            throw new IndexOutOfBoundsException();
    }

    private void checkCapacity() {
        if ((size() + 1) > capacity) {
            resize();
            capacity = values.length;
        }
    }
}
