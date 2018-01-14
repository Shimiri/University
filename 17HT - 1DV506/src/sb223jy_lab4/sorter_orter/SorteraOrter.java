package sb223jy_lab4.sorter_orter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SorteraOrter {
    public static void main(String[] args) {
        File txtFile = new File(args[0]);
        ArrayList<Ort> orter = new ArrayList<Ort>();
        try {
            Scanner scanner = new Scanner(txtFile);
            while (scanner.hasNextLine()) {
                String str = new String(scanner.nextLine());
                String[] ortArgs = str.split(";");
                orter.add(new Ort(Integer.parseInt(ortArgs[0]), ortArgs[1]));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        orter.sort(null);

        for (Ort o : orter)
            System.out.println(o);
    }
}
