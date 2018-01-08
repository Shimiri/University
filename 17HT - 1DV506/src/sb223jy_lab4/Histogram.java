package sb223jy_lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        File textFile = new File(args[0]);
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(textFile);
            while (scanner.hasNext()) {
                numbers.add(Integer.parseInt(scanner.nextLine()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
