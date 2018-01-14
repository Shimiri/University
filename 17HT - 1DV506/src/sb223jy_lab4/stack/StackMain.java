package sb223jy_lab4.stack;

import java.util.Iterator;

public class StackMain {
    public static void main(String[] args) {
        Stack stack = new ArrayStack();
        System.out.println("Stack is empty: " + stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.pop();
        stack.pop();
        System.out.println("Stack peek: " + stack.peek());
        System.out.println("Stack size: " + stack.size());

        Iterator<Object> iterator = stack.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
