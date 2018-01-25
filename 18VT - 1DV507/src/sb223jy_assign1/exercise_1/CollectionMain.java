package sb223jy_assign1.exercise_1;

public class CollectionMain {
    public static void main(String[] args) {
        sb223jy_assign1.exercise_1.ArrayIntList list = new sb223jy_assign1.exercise_1.ArrayIntList(10);
        for (int i = 0; i < 12; i++) {
            list.add(i + 1);
        }

        list.addAt(5, 11);
        list.remove(6);
        System.out.println("List.get(): " + list.get(10));
        System.out.println("List.indexOf(): " + list.indexOf(11));


        sb223jy_assign1.exercise_1.ArrayIntStack stack = new sb223jy_assign1.exercise_1.ArrayIntStack();
        for (int i = 0; i < 12; i++) {
            stack.push(i);
        }

        for (int i = 0; i < 5; i++) {
            stack.pop();
        }

        System.out.println("Stack.peek(): " + stack.peek());
    }
}
