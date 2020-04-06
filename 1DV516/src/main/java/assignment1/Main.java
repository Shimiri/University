package assignment1;

public class Main {
    public static void main(String[] args) {
        MyIntegerBST bst = new MyIntegerBST(10);
        Integer[] values = new Integer[] { 4, 7, 9, 8, 20, 25 };
        for (Integer value : values)
            bst.insert(value);

        int similar = bst.mostSimilarValue(22);
        System.out.println(similar);
        bst.printByLevels();

        SequenceWithMinimum seq = new SequenceWithMinimum(10);
        seq.insertRight(20);
        seq.insertRight(2);
        seq.insertLeft(32);
        seq.insertRight(53);
        seq.insertLeft(5);
        int min = seq.findMinimum();
        System.out.println(min);

        seq.removeRight();
        seq.removeRight();
        seq.removeLeft();

        min = seq.findMinimum();
        System.out.println(min);
    }
}
