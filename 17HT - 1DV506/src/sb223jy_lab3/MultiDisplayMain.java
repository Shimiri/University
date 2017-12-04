package sb223jy_lab3;

public class MultiDisplayMain {
    public static void main(String[] args) {
        MultiDisplay md = new MultiDisplay();

        md.setDisplayCount(3);
        md.setDisplayMessage("Hello World");
        md.display();

        MultiDisplay md_2 = new MultiDisplay(5, "Goodbye World");
        System.out.println(md_2.getMessage());
        md_2.display();
    }
}
