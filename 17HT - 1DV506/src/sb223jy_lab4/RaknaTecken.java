package sb223jy_lab4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RaknaTecken {
    public static void main(String[] args) {
        int numOfWhiteSpaces = 0;
        int numOfLowerCase = 0;
        int numOfUpperCase = 0;
        int numOfDigits = 0;
        int numOfOthers = 0;

        File textFile = new File(args[0]);
        StringBuilder sb = new StringBuilder();

        try {
            Scanner scanner = new Scanner(textFile);
            while (scanner.hasNextLine())
                sb.append(scanner.nextLine());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String str = new String(sb.toString());
        for (char c : str.toCharArray()) {
            if (c == ' ' || c == '\t' || c == '\r' || c == '\n')
                numOfWhiteSpaces++;
            else if (c >= 'a' && c <= 'z')
                numOfLowerCase++;
            else if (c >= 'A' && c <= 'Z')
                numOfUpperCase++;
            else if (c >= '0' && c <= '9')
                numOfDigits++;
            else
                numOfOthers++;
        }

        System.out.println("\nAntal stora bokstäver: " + numOfUpperCase + "\nAntal små bokstäver: " + numOfLowerCase
                            + "\nAntal siffror: " + numOfDigits + "\nAntal \"whitespaces\": " + numOfWhiteSpaces
                            + "\nAntal övriga: " + numOfOthers);
    }
}
