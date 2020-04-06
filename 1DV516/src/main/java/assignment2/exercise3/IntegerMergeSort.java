package assignment2.exercise3;

public class IntegerMergeSort {
    public static void sortIntegers(int[] list) {
        sort(list, 0, list.length - 1);
    }

    private static void sort(int[] list, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            sort(list, left, middle);
            sort(list, middle + 1, right);

            merge(list, left, middle, right);
        }
    }

    @SuppressWarnings("ManualArrayCopy")
    private static void merge(int[] list, int left, int middle, int right) {
        int leftListSize = middle - left + 1;
        int rightListSize = right - middle;

        int[] leftSubList = new int[leftListSize];
        int[] rightSubList = new int[rightListSize];

        for (int i = 0; i < leftListSize; i++)
            leftSubList[i] = list[left + i];
        for (int i = 0; i < rightListSize; i++)
            rightSubList[i] = list[middle + 1 + i];

        int leftIndex = 0, rightIndex = 0;
        int index = left;
        while (leftIndex < leftListSize && rightIndex < rightListSize) {
            if (leftSubList[leftIndex] < rightSubList[rightIndex])
                list[index] = leftSubList[leftIndex++];
            else
                list[index] = rightSubList[rightIndex++];
            index++;
        }

        while (leftIndex < leftListSize) {
            list[index] = leftSubList[leftIndex];
            index++; leftIndex++;
        }


        while (rightIndex < rightListSize) {
            list[index] = rightSubList[rightIndex];
            index++; rightIndex++;
        }
    }
}
