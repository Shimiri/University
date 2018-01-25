package sb223jy_assign1.exercise_6;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ScatterPlot { // Create and Customize Chart
    public static void main(String[] args) {
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(5);

        // Generate data
        List xData = new ArrayList();
        List yData = new ArrayList();
        Random random = new Random();
        int size = 1000;
        for (int i = 0; i < size; i++) {
            xData.add(random.nextGaussian());
            yData.add(random.nextGaussian());
        }

        // Display scatter plot
        chart.addSeries("Gaussian Blob", xData, yData);
        new SwingWrapper(chart).displayChart();
    }
}
