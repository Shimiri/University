package sb223jy_assign3.exercise_1;

public class EuclidianMain {
    public static void main(String[] args) {
        System.out.println("GCD: " + doEuclid(5, 25));
    }

    private static int doEuclid(int a, int b) {
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int q = 1, r;
        do {
            r = a - (b * q++);
        } while (r > b);

        return r;
    }
}
