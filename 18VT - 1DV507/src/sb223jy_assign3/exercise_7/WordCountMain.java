package sb223jy_assign3.exercise_7;

import sb223jy_assign3.exercise_4.Word;
import sb223jy_assign3.exercise_6.HashWordSet;
import sb223jy_assign3.exercise_6.TreeWordSet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class WordCountMain {
    public static void main(String[] args) {
        HashWordSet hashSet = new HashWordSet();
        TreeWordSet treeSet = new TreeWordSet();

        try {
            Scanner sc = new Scanner(new File("res/words.txt"));
            while (sc.hasNext()) {
                String s = sc.next();
                hashSet.add(new Word(s));
                treeSet.add(new Word(s));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}

