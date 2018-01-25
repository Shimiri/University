package sb223jy_assign1.exercise_9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class WarAndPeace {

    /**
     *  Your task is to write a single-class program WarAndPeace.java that,
     *  once you have split the text into separate words,
     *  use a single Java 1.8 stream to compute the number of unique words used in the text.
     *  Words are substrings made of ordinary letters and the characters ' (as in don't) and - (as in well-known).
     *  Other type of characters (e.g. digits) should be removed from each word as well as entire words only containing such characters.
     *  Also, we do not care about upper and lower case when looking for unique words. Hence, HELLO and Hello are considered to be the same word.
     * @param args
     */

    public static void main(String[] args) {
        File txtFile = new File("C:\\Users\\Samuel Bäckström\\Repositories\\University\\18VT - 1DV507\\res\\WarAndPeace.txt");
        List<String> words = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(txtFile);
            while (fileScanner.hasNext()) {
                words.add(fileScanner.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> data = new ArrayList<>();
        Predicate<String> unique = (s) -> {
            String strLowerCase = s.toLowerCase();
            if (data.contains(strLowerCase))
                return false;
            else {
                data.add(strLowerCase);
                return true;
            }
        };
        Function<String, String> replaceInvalidChars = (s) -> s.replaceAll("\\W", "");
        Function<String, String> toLowerCase = String::toLowerCase;
        Predicate<String> removeNumbers = (s) -> !s.matches("\\d*");

        List<String> uniqueWords = words.stream()
                .map(toLowerCase)
                .map(replaceInvalidChars)
                .filter(removeNumbers)
                .filter(unique)
                .collect(Collectors.toList());

        System.out.println(uniqueWords.size());
    }
}
