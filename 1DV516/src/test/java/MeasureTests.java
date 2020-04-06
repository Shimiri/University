import assignment2.exercise3.A2Measure;
import assignment2.exercise3.Measure;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MeasureTests {
    @Test
    public void sameCollectionTests() {
        // Arrange
        int[] array1 = new int[] { 10, 1, 7, 10 };
        int[] array2 = new int[] { 1, 10, 7, 10 };
        A2Measure measure = new Measure();

        // Act
        boolean isSame = measure.isSameCollection(array1, array2);

        // Assert
        Assertions.assertTrue(isSame);
    }

    @Test
    public void notSameCollectionTests() {
        // Arrange
        int[] array1 = new int[] { 10, 1, 7, 10 };
        int[] array2 = new int[] { 1, 10, 7, 9 };
        A2Measure measure = new Measure();

        // Act
        boolean isSame = measure.isSameCollection(array1, array2);

        // Assert
        Assertions.assertFalse(isSame);
    }

    @Test
    public void differentSizeCollectionTests() {
        // Arrange
        int[] array1 = new int[] { 10, 1, 7, 10 };
        int[] array2 = new int[] { 1, 10, 7 };
        A2Measure measure = new Measure();

        // Act
        boolean isSame = measure.isSameCollection(array1, array2);

        // Assert
        Assertions.assertFalse(isSame);
    }

    @Test
    public void minDiffTest() {
        // Arrange
        int[] array1 = new int[] { 2, 5, 3, 9 };
        int[] array2 = new int[] { 15, 12, 1, 3 };
        A2Measure measure = new Measure();

        // Act
        int actual = measure.minDifferences(array1, array2);
        int expected = 86;

        // Assert
        Assertions.assertEquals(actual, expected);
    }

    @Test
    public void percentileRangeTest() {
        int[] list = new int[] { 20, 16, 2, 4, 10, 6, 12, 18, 14, 8 };
        A2Measure measure = new Measure();

        int[] result1 = measure.getPercentileRange(list, 0, 10);
        int[] result2 = measure.getPercentileRange(list, 10, 20);
        int[] result3 = measure.getPercentileRange(list, 10, 50);
        int[] result4 = measure.getPercentileRange(list, 60, 70);
        int[] result5 = measure.getPercentileRange(list, 0, 100);

        System.out.println();
    }
}
