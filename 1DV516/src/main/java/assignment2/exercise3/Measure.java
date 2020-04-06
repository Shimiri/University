package assignment2.exercise3;

import assignment2.exercise1.HashTable;

public class Measure implements A2Measure {
    @Override
    public boolean isSameCollection(int[] array1, int[] array2) {
        if (array1.length != array2.length)
            return false;

        HashTable<Integer> array1hashTable = new HashTable<>();
        for (int n : array1)
            array1hashTable.insert(n);

        for (int n : array2) {
            if (!array1hashTable.contains(n))
                return false;
            array1hashTable.delete(n);
        }
        return true;
    }

    @Override
    public int minDifferences(int[] array1, int[] array2) {
        if (array1.length != array2.length)
            return Integer.MIN_VALUE;

        IntegerMergeSort.sortIntegers(array1);
        IntegerMergeSort.sortIntegers(array2);

        int[][] listOfMinPairs = new int[array1.length][2];

        for (int i = 0; i < array1.length; i++) {
            listOfMinPairs[i][0] = array1[i];
            listOfMinPairs[i][1] = array2[i];
        }

        int sum = 0;
        for (int[] pair : listOfMinPairs)
            sum += (int) Math.pow((pair[1] - pair[0]), 2);
        return sum;
    }

    @Override
    public int[] getPercentileRange(int[] arr, int lower, int upper) {
        IntegerMergeSort.sortIntegers(arr);

        int max = arr[arr.length - 1];
        int lowerInt = (int) (max * (lower / 100.0));
        int upperInt = (int) (max * (upper / 100.0));

        int lowerIndex, upperIndex, i = 0;
        while (arr[i] <= lowerInt)
            i++;
        lowerIndex = i;

        while (arr[i] < upperInt)
            i++;
        upperIndex = ++i;

        int size = upperIndex - lowerIndex;
        int[] range = new int[size];
        for (int index = 0; lowerIndex < upperIndex; lowerIndex++, index++)
            range[index] = arr[lowerIndex];

        return range;
    }
}
