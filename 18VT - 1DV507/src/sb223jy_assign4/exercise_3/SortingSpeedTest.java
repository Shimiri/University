package sb223jy_assign4.exercise_3;

import java.util.Comparator;

import static sb223jy_assign3.exercise_2.SortingAlgorithms.*;

public class SortingSpeedTest {
    public static void main(String[] args) {
        stringInsertionSortTest();
    }

    public static void intInsertionSortTest() {
        long timeStart = 0;
        long endTime = 0;

        int elementsSorted = 0;

        int[] sorted = generateArray(100000000);
        int length = sorted.length;

        System.out.println("Time Start!");
        boolean flag = true;
        timeStart = System.nanoTime();
        for (int i = 1; (1000 > ((endTime - timeStart) / 1000000)) && i < length; i++) {
            for (int j = (i - 1), k = i; j >= 0 && sorted[k] < sorted[j]; j--, k--) {
                int tmp = sorted[j];
                sorted[j] = sorted[k];
                sorted[k] = tmp;

                if (flag) {
                    elementsSorted++;
                    flag = false;
                }
                endTime = System.nanoTime();
            }
            flag = true;
        }
        System.out.println("Time End!");
        System.out.println("IntInsertionsSortTest:\n\tNumber of elements sorted: " + elementsSorted + "\n\tTime: " + ((endTime - timeStart) / 1000000) + " MS");
    }

    public static void stringInsertionSortTest() {
        long timeStart = 0;
        long endTime = 0;

        int elementsSorted = 0;

        String[] sorted = generateStringArray(1000000);
        int length = sorted.length;
        Comparator<String> c = String::compareTo;

        boolean flag = true;
        System.out.println("Time Start!");
        timeStart = System.nanoTime();
        for (int i = 1; i < length; i++) {
            for (int j = (i - 1), k = i; (1000 > ((endTime - timeStart) / 1000000)) &&  j >= 0 && c.compare(sorted[k], sorted[j]) < 0; j--, k--) {
                String tmp = sorted[j];
                sorted[j] = sorted[k];
                sorted[k] = tmp;

                if (flag) {
                    elementsSorted++;
                    flag = false;
                }
                endTime = System.nanoTime();
            }
            flag = true;
        }

        System.out.println("Time End!");
        System.out.println("StringInsertionsSortTest:\n\tNumber of elements sorted: " + elementsSorted + "\n\tTime: " + ((endTime - timeStart) / 1000000) + " MS");
    }
}
