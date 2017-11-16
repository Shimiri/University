package sb223jy_lab2;

public class BytaPlats {
    public static void main(String[] args) {
        char[] text = { 't', 't', 'ä', 'l', ' ', 'r', 'a', 'v', ' ', 'a',
                't', 't', 'e', 'D' };

        for (int i = 0; i < text.length / 2; i++) {
            char temp = text[i];
            text[i] = text[(text.length - 1) - i];
            text[(text.length - 1) - i] = temp;
        }

        for (char c : text)
            System.out.print(c);
    }
}
