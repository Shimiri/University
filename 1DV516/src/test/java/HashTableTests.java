import assignment2.exercise1.HashTable;
import org.junit.jupiter.api.*;

public class HashTableTests {
    private int[] testData = new int[] { 4, 3, 10, 5, 16, 7, 9, 8 };
    private HashTable<Integer> table;

    @BeforeEach
    public void initHashTable() {
        table = new HashTable<>();
        for (int n : testData)
            table.insert(n);
    }

    @Test
    public void testDeleteAndContainsFunc() {
        // Arrange
        int n = 100;
        table.insert(n);

        // Act
        table.printTable();
        table.delete(n);
        table.printTable();

        // Assert
        Assertions.assertFalse(table.contains(n));
    }

    @Test
    public void testProbeFunction() {
        // Arrange
        int[] elementsToBeInserted = new int[] { 99, 128, 71, -1, 20, 81, 47, -3 };

        // Act
        table.printTable();
        for (int n : elementsToBeInserted)
            table.insert(n);
        table.printTable();

        // Assert
        int expected = 16;
        int actual = table.getNumberOfElements();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testTableWithStrings() {
        // Arrange
        HashTable<String> table = new HashTable<>();
        String[] strings = new String[] {
                "apple",
                "apple",
                "orange",
                "kiwi",
                "watermelon",
                "strawberry",
                "blueberry",
                "tomato" };
        for (String s : strings)
            table.insert(s);

        // Act
        table.printTable();
        table.insert("carrot");
        table.delete("kiwi");
        table.printTable();

        // Assert
        Assertions.assertTrue(table.contains("carrot"));
    }
}
