package sb223jy_lab1;

public class Telefonnummer {
    public static void main(String[] args) {
        System.out.println("0" + Math.round(100 + (Math.random() * 899)) + "-" + Math.round(1 + (Math.random() * 8)) +
            Math.round(10000 + Math.random() * 89999));
    }
}
