package sb223jy_assign3.exercise_2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SortTest {
    private int[] intArray;
    private String[] stringArray;

    @Before
    public void setup() {
        intArray = SortingAlgorithms.generateArray(100);
        System.out.println(SortingAlgorithms.intArrayToString(intArray));
        stringArray = SortingAlgorithms.generateStringArray(100);
        System.out.println(SortingAlgorithms.stringArrayToString(stringArray));
    }

    @Test
    public void testIntInsertionSort() {
        int[] arr = SortingAlgorithms.insertionSort(intArray);
        boolean sorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                sorted = false; break;
            }
        }
        assertTrue(sorted);
    }

    @Test
    public void testStringInsertionSort() {
        String[] arr = SortingAlgorithms.insertionSort(stringArray, String::compareTo);
        boolean sorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                sorted = false; break;
            }
        }
        assertTrue(sorted);
    }

    @Test
    public void testIntMergeSort() {
        int[] arr = SortingAlgorithms.mergeSort(intArray);
        boolean sorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                sorted = false; break;
            }
        }
        assertTrue(sorted);
    }

    @Test
    public void testStringMergeSort() {
        String[] arr = SortingAlgorithms.mergeSort(stringArray, String::compareTo);
        boolean sorted = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                sorted = false; break;
            }
        }
        assertTrue(sorted);
    }
}
