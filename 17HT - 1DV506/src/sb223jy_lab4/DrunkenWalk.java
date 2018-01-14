package sb223jy_lab4;

import java.util.Scanner;

public class DrunkenWalk {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ange storlek: ");
        int size = scanner.nextInt();
        System.out.println("Ange max antal steg: ");
        int steps = scanner.nextInt();
        System.out.println("Ange antal slumvandringar: ");
        int numOfWalks = scanner.nextInt();

        RandomWalk drunk = new RandomWalk(steps, size);
        for (int i = 0; i < numOfWalks; i++) {
            drunk.reset();
            drunk.walk();
        }

        System.out.println("Av " + numOfWalks + " onyktra personer, föll " + drunk.getNumOfDrunksWhoFellInWater()
                            + " (" + (((double)drunk.getNumOfDrunksWhoFellInWater() / (double)numOfWalks) * 100) + "%) i vattnet.");
    }
}
