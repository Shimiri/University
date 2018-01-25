package sb223jy_lab4;

import org.knowm.xchart.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        int[] data = new int[10];

        File textFile = new File(args[0]);
        System.out.println("Läser text från filen: " + args[0]);
        ArrayList<Integer> numbers = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(textFile);
            while (scanner.hasNext()) {
                numbers.add(Integer.parseInt(scanner.nextLine()));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        int validNumCounter = 0;
        for (Integer number : numbers) {
            if (number >= 1 && number <= 100) {
                validNumCounter++;
            }
        }

        System.out.println("Antal i intervallet [1, 100]: " + validNumCounter
                            + "\nÖvriga: " + (numbers.size() - validNumCounter));

        System.out.print("Histogram: ");
        System.out.print("\n  1 - 10 | ");
        int i = 0;
        for (int n : numbers) {
            if (n >= 1 && n <= 10) {
                System.out.print("*");
                i++;
            }
        }
        data[0] = i;

        i = 0;
        System.out.print("\n  11 - 20 | ");
        for (int n : numbers) {
            if (n >= 11 && n <= 20) {
                System.out.print("*");
                i++;
            }
        }
        data[1] = i;

        i = 0;
        System.out.print("\n  21 - 30 | ");
        for (int n : numbers) {
            if (n >= 21 && n <= 30) {
                System.out.print("*");
                i++;
            }
        }
        data[2] = i;

        i = 0;
        System.out.print("\n  31 - 40 | ");
        for (int n : numbers) {
            if (n >= 31 && n <= 40) {
                System.out.print("*");
                i++;
            }
        }
        data[3] = i;

        i = 0;
        System.out.print("\n  41 - 50 | ");
        for (int n : numbers) {
            if (n >= 41 && n <= 50) {
                System.out.print("*");
                i++;
            }
        }
        data[4] = i;

        i = 0;
        System.out.print("\n  51 - 60 | ");
        for (int n : numbers) {
            if (n >= 51 && n <= 60) {
                System.out.print("*");
                i++;
            }
        }
        data[5] = i;

        i = 0;
        System.out.print("\n  61 - 70 | ");
        for (int n : numbers) {
            if (n >= 61 && n <= 70) {
                System.out.print("*");
                i++;
            }
        }
        data[6] = i;

        i = 0;
        System.out.print("\n  71 - 80 | ");
        for (int n : numbers) {
            if (n >= 71 && n <= 80) {
                System.out.print("*");
                i++;
            }
        }
        data[7] = i;

        i = 0;
        System.out.print("\n  81 - 90 | ");
        for (int n : numbers) {
            if (n >= 81 && n <= 90) {
                System.out.print("*");
                i++;
            }
        }
        data[8] = i;

        i = 0;
        System.out.print("\n  91 - 100 | ");
        for (int n : numbers) {
            if (n >= 91 && n <= 100) {
                System.out.print("*");
                i++;
            }
        }
        data[9] = i;

        generateChart(data);
    }

    private static void generateChart(int[] data) {
        PieChart chart = new PieChartBuilder().width(800).height(600).title("").build();

        // Customize Chart
        Color[] sliceColors = new Color[] { Color.blue,
                                            Color.black,
                                            Color.red,
                                            Color.pink,
                                            Color.gray,
                                            Color.cyan,
                                            Color.green,
                                            Color.orange,
                                            Color.magenta,
                                            Color.yellow };
        chart.getStyler().setSeriesColors(sliceColors);

        // Series
        chart.addSeries("1 - 10", data[0]);
        chart.addSeries("11 - 20", data[1]);
        chart.addSeries("21 - 30", data[2]);
        chart.addSeries("31 - 40", data[3]);
        chart.addSeries("41 - 50", data[4]);
        chart.addSeries("51 - 60", data[5]);
        chart.addSeries("61 - 70", data[6]);
        chart.addSeries("71 - 80", data[7]);
        chart.addSeries("81 - 90", data[8]);
        chart.addSeries("91 - 100", data[9]);

        new SwingWrapper<>(chart).displayChart();

        CategoryChart bar = new CategoryChartBuilder().width(800).height(600).title("").xAxisTitle("").yAxisTitle("").build();

        Integer[] numbers = new Integer[] { data[0],
                                            data[1],
                                            data[2],
                                            data[3],
                                            data[4],
                                            data[5],
                                            data[6],
                                            data[7],
                                            data[8],
                                            data[9] };

        // Series
        bar.addSeries("test", Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), Arrays.asList(numbers));

        new SwingWrapper<>(bar).displayChart();
    }
}
