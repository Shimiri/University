package sb223jy_lab3;

public class Arrays {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        System.out.println(hasSubsequence(arr, new int[]{2, 3, 4}));
    }

    private static int sum(int[] arr) {
        int sum = 0;
        for (int n : arr)
            sum += n;
        return sum;
    }

    private static String toString(int[] arr) {
        String str = new String();
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1)
                str += arr[i];
            else
                str += arr[i] + ", ";
        }
        return str;
    }

    private static int[] addN(int[] arr, int n) {
        int[] secondArr = new int[arr.length];
        for (int i = 0; i < secondArr.length; i++) {
            secondArr[i] = arr[i] + n;
        }
        return secondArr;
    }

    private static int[] reverse(int[] arr) {
        int[] secondArr = new int[arr.length];
        for (int i = 0; i < secondArr.length; i++) {
            secondArr[i] = arr[(arr.length - 1) - i];
        }
        return secondArr;
    }

    private static boolean hasN(int[] arr, int n) {
        for (int k : arr) {
            if (k == n)
                return true;
        }
        return false;
    }

    private static void replaceAll(int[] arr, int old, int nw) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == old) {
                arr[i] = nw;
            }
        }
    }

    private static int[] sort(int[] arr) {
        int[] sortedArr = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            sortedArr[i] = arr[i];

        int j, min, temp;
        for (int i = 0; i < arr.length - 1; i++) {
            min = i;
            for (j = min + 1; j < arr.length; j++) {
                if (sortedArr[j] < sortedArr[min]) {
                    min = j;
                }
            }
            temp = sortedArr[min];
            sortedArr[min] = sortedArr[i];
            sortedArr[i] = temp;
        }

        return sortedArr;
    }

    private static boolean hasSubsequence(int[] arr, int[] sub) {
        int numOfSameItem = 0;
        for (int i = 0; i <= (arr.length - sub.length); i++) {
            int k = i;
            numOfSameItem = 0;
            for (int j = 0; j < sub.length; j++, k++) {
                if (arr[k] == sub[j]) {
                    numOfSameItem++;
                }
                if (numOfSameItem == sub.length)
                    return true;
            }
        }
        return false;
    }
}
