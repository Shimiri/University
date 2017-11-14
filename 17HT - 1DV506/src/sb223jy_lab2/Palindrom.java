package sb223jy_lab2;

import java.util.Scanner;

public class Palindrom {
    public static void main(String[] args) {
        boolean isPalindrome = false;
        Scanner scanner = new Scanner(System.in);

        System.out.print("Skriv in en rad text: ");
        String text = scanner.nextLine();

        int length = text.length();
        int i = 0;
        int j = 0;
        while (i < length || j < length) {

            while (!Character.isLetter(text.charAt(i))) {
                i++;
            }

            int lastCharIndex = (text.length() - 1) - j;
            while (!Character.isLetter(text.charAt(lastCharIndex))) {
                lastCharIndex--; j++;
            }

            if (Character.toLowerCase(text.charAt(i)) == Character.toLowerCase(text.charAt(lastCharIndex))) {
                isPalindrome = true;
            } else {
                isPalindrome = false;
                break;
            }

            i++; j++;
        }

        System.out.println("\"" + text + "\" is palindrome: " + isPalindrome);
    }
}
