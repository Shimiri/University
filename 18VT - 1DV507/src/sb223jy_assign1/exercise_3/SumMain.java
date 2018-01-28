package sb223jy_assign1.exercise_3;

public class SumMain {
    public static void main(String[] args) {
        System.out.println(sum(28000));
    }

    private static int sum(int n) {
        int[] data = new int[n];
        for (int i = 0; i < data.length; i++) {
            data[i] = (i + 1);
        }
        return addRecursively(data);
    }

    private static int addRecursively(int[] data) {
        int[] left = new int[(int) Math.ceil((data.length / 2.0))];
        int[] right = new int[(data.length / 2)];
        if (data.length == 1)
            return data[0];
        else {
            for (int i = 0; i < left.length; i++) {
                left[i] = data[i];
            }
            for (int i = 0; i < data.length / 2; i++) {
                right[i] = data[(int) Math.ceil((i + (data.length / 2.0)))];
            }
        }
        return addRecursively(left) + addRecursively(right);
    }
}
