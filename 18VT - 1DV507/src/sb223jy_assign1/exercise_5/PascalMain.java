package sb223jy_assign1.exercise_5;

public class PascalMain {
    public static void main(String[] args) {
        int[] row = pascalRow(5);
        for (int n : row) {
            if (n != 0)
                System.out.print(n + " ");
        }
    }

    private static int[] pascalRow(int n) {
        if (n == 0) {
            return new int[] {0,1,0};
        } else {
            int[] previousRow = pascalRow(n - 1);
            int[] nextRow = new int[n + 3];
            for (int i = 1; i < nextRow.length - 1; i++) {
                nextRow[i] = previousRow[i - 1] + previousRow[i];
            }
            return nextRow;
        }
    }
}
