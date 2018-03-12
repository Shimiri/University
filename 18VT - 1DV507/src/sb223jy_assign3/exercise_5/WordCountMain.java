package sb223jy_assign3.exercise_5;

import sb223jy_assign3.exercise_4.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCountMain {
    public static void main(String[] args) {
        HashSet<Word> wordHashSet = new HashSet<>();
        TreeSet<Word> wordTreeSet = new TreeSet<>();

        try {
            Scanner sc = new Scanner(new File("res/words.txt"));
            while (sc.hasNext()) {
                String s = sc.next();
                wordHashSet.add(new Word(s));
                wordTreeSet.add(new Word(s));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("HashSet number of words: " + wordHashSet.size() +
              "\nTreeSet number of words: " + wordTreeSet.size());

        int i = 0;
        for (Word w : wordTreeSet) {
            if (i++ % 20 == 19)
                System.out.println();
            System.out.print(i + ": " + w + " ");
        }
    }
}
