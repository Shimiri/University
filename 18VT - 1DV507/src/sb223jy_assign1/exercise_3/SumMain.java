package sb223jy_assign1.exercise_3;

public class SumMain {
    public static void main(String[] args) {
        System.out.println("Sum: " + addRecursively(5));
    }

    private static int addRecursively(int n) {
        if (n == 1)
            return 1;
        else
            return n + addRecursively((n - 1));
    }
}
