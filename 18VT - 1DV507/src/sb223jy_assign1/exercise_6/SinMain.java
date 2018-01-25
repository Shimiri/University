package sb223jy_assign1.exercise_6;

import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;
import org.knowm.xchart.style.Styler;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.cos;

public class SinMain {
    public static void main(String[] args) {
        XYChart chart = new XYChartBuilder().width(800).height(600).build();
        chart.getStyler().setDefaultSeriesRenderStyle(XYSeries.XYSeriesRenderStyle.Line);
        chart.getStyler().setChartTitleVisible(false);
        chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideSW);
        chart.getStyler().setMarkerSize(5);

        // Generate data
        List xData = new ArrayList();
        List yData = new ArrayList();

        for (int x = -180; x < 180; x++) {
            yData.add(100 - (int) (50 * cos((x / 100.0) * 2 * Math.PI)));
        }
        for (int i = 0; i < 360; i++) {
            xData.add(i);
        }

        chart.addSeries("SinMain", xData, yData);
        new SwingWrapper(chart).displayChart();
    }
}
