package sb223jy_assign3.exercise_2;

import java.util.Comparator;

public class SortingAlgorithms {
    public static void main(String[] args) {
        System.out.println("InsertionSort: " + intArrayToString(insertionSort(generateArray(9))));
        System.out.println("MergeSort: " + intArrayToString(mergeSort(generateArray(9))));

        String[] strings = new String[] {"Adam", "Samuel", "Bob", "David", "Bop"};
        System.out.println("InsertionSort: " + stringArrayToString(insertionSort(strings, String::compareTo)));
        System.out.println("MergeSort: " + stringArrayToString(mergeSort(strings, String::compareTo)));

    }

    public static int[] generateArray(int n) {
        int[] randomArr = new int[n];
        for (int i = 0; i < n; i++)
            randomArr[i] = (int) (Math.random() * 100);
        return randomArr;
    }

    public static String intArrayToString(int[] in) {
        StringBuilder sb = new StringBuilder("[ ");
        for (int n : in)
            sb.append(n).append(" ");
        sb.append("]");
        return sb.toString();
    }

    public static String stringArrayToString(String[] in) {
        StringBuilder sb = new StringBuilder("[ ");
        for (String s : in)
            sb.append(s).append(" ");
        sb.append("]");
        return sb.toString();
    }

    public static int[] insertionSort(int[] in) {
        int length = in.length;
        int[] sorted = new int[length];

        System.arraycopy(in, 0, sorted, 0, length);

        for (int i = 1; i < length; i++) {
            for (int j = (i - 1), k = i; j >= 0 && sorted[k] < sorted[j]; j--, k--) {
                int tmp = sorted[j];
                sorted[j] = sorted[k];
                sorted[k] = tmp;
            }
        }
        return sorted;
    }

    public static int[] mergeSort(int[] in) {
        if (in.length == 1)
            return in;

        int[] left;
        int[] right;
        if (in.length % 2 == 1) {
            left = new int[in.length / 2];
            right = new int[in.length / 2 + 1];
        } else {
            left = new int[in.length / 2];
            right = new int[in.length / 2];
        }

        for (int i = 0; i < in.length; i++) {
            if (i < left.length)
                left[i] = in[i];
            else
                right[(i - (in.length / 2))] = in[i];
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] sorted = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j])
                sorted[k++] = left[i++];
            else
                sorted[k++] = right[j++];
        }

        while (i < left.length)
            sorted[k++] = left[i++];

        while (j < right.length)
            sorted[k++] = right[j++];

        return sorted;
    }

    public static String[] insertionSort(String[] in, Comparator<String> c) {
        int length = in.length;
        String[] sorted = new String[in.length];

        System.arraycopy(in, 0, sorted, 0, length);

        for (int i = 1; i < length; i++) {
            for (int j = (i - 1), k = i; j >= 0 && c.compare(sorted[k], sorted[j]) < 0; j--, k--) {
                String tmp = sorted[j];
                sorted[j] = sorted[k];
                sorted[k] = tmp;
            }
        }
        return sorted;
    }

    public static String[] mergeSort(String[] in, Comparator<String> c) {
        String[] sorted = new String[in.length];
        if (in.length == 1)
            return in;

        String[] left;
        String[] right;
        if (in.length % 2 == 1) {
            left = new String[in.length / 2];
            right = new String[in.length / 2 + 1];
        } else {
            left = new String[in.length / 2];
            right = new String[in.length / 2];
        }

        for (int i = 0; i < in.length; i++) {
            if (i < left.length)
                left[i] = in[i];
            else
                right[(i - (in.length / 2))] = in[i];
        }

        left = mergeSort(left, c);
        right = mergeSort(right, c);

        return merge(left, right, c);
    }

    private static String[] merge(String[] left, String[] right, Comparator<String> c) {
        String[] sorted = new String[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (c.compare(left[i], right[j]) < 0)
                sorted[k++] = left[i++];
            else
                sorted[k++] = right[j++];
        }

        while (i < left.length)
            sorted[k++] = left[i++];

        while (j < right.length)
            sorted[k++] = right[j++];

        return sorted;
    }
}
