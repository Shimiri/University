package sb223jy_assign3.exercise_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class IdentifyWordsMain {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<String>();
        try {
            Scanner sc = new Scanner(new File("res/HistoryOfProgramming.txt"));
            while (sc.hasNext()) {
                strings.add(sc.next());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<String> words = Arrays.stream(strings.toArray(new String[0]))
                .map(s -> s.replaceAll("[^a-zA-Z-\']", ""))
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toCollection(ArrayList::new));

        try {
            Files.write(Paths.get("res/words    .txt"), words, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
