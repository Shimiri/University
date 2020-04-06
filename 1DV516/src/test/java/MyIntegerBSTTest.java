import assignment1.MyIntegerBST;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MyIntegerBSTTest {
    @Test
    public void itemShouldBeInsertedToTheRight() {
        // Arrange
        MyIntegerBST bst = new MyIntegerBST(5);

        // Act
        bst.insert(7);

        // Assert
        Integer actual = bst.getRoot().rightChild.item;
        Integer expected = 7;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void itemShouldBeInsertedToTheLeft() {
        // Arrange
        MyIntegerBST bst = new MyIntegerBST(5);

        // Act
        bst.insert(3);

        // Assert
        Integer actual = bst.getRoot().leftChild.item;
        Integer expected = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void itemShouldExist() {
        // Arrange
        MyIntegerBST bst = new MyIntegerBST(5);
        bst.insert(10);
        bst.insert(8);

        // Act
        boolean actual = bst.contains(8);

        // Assert
        Assertions.assertTrue(actual);
    }

    @Test
    public void itemShouldNotExist() {
        // Arrange
        MyIntegerBST bst = new MyIntegerBST(5);
        bst.insert(10);
        bst.insert(8);

        // Act
        boolean actual = bst.contains(12);

        // Assert
        Assertions.assertFalse(actual);
    }

    @Test
    public void rootItemShouldExist() {
        // Arrange
        MyIntegerBST bst = new MyIntegerBST(5);
        bst.insert(10);
        bst.insert(8);

        // Act
        boolean actual = bst.contains(5);

        // Assert
        Assertions.assertTrue(actual);
    }

    @Test
    public void mostSimilarValueTests() {
        // Arrange
        MyIntegerBST bst = new MyIntegerBST(10);
        Integer[] values = new Integer[] { 4, 7, 9, 8, 20, 25, 24, 26 };
        for (Integer value : values)
            bst.insert(value);

        // Act
        Integer actual = bst.mostSimilarValue(22);

        // Assert
        Integer expected = 20;
        Assertions.assertEquals(expected, actual);
    }
}
