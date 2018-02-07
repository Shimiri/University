package sb223jy_assign1.exercise_4;

import java.io.File;

public class PrintJavaMain {
    private static int depth = 0;

    public static void main(String[] args) {
        File startDir = new File("C:\\Users\\Samuel Bäckström\\Repositories\\University\\17HT - 1DV506");
        printAllJavaFiles(startDir);
    }

    private static void printAllJavaFiles(File directory) {
        String name = directory.getName();
        String subName = "";
        if (!directory.isDirectory() && name.length() > 5)
            subName = name.substring(name.length() - 5, name.length());

        StringBuilder whiteSpace = new StringBuilder();
        for (int i = 0; i < depth; i++)
            whiteSpace.append(" ");

        if (directory.isDirectory()) {
            depth++;

            System.out.println(whiteSpace + directory.getName());

            File[] files = directory.listFiles();
            for (File f : files) {
                printAllJavaFiles(f);
            }

            depth--;
        } else if (subName.equals(".java")) {
            System.out.println(whiteSpace + name);
        }
    }
}
