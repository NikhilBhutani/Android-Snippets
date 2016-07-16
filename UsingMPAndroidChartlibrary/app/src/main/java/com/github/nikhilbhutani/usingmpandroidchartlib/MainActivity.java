package com.github.nikhilbhutani.usingmpandroidchartlib;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    BarChart barChart;
    BarData data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        barChart = (BarChart)findViewById(R.id.chart);

        ArrayList<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(4f, 0));
        entries.add(new BarEntry(8f, 1));
        entries.add(new BarEntry(6f, 2));
        entries.add(new BarEntry(12f, 3));
        entries.add(new BarEntry(18f, 4));
        entries.add(new BarEntry(9f, 5));

        BarDataSet dataset = new BarDataSet(entries, "# of Calls");


        //Add this to set the color
      //  dataset.setColors(ColorTemplate.COLORFUL_COLORS);

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
        labels.add("May");
        labels.add("June");

        data = new BarData(labels,dataset);
        barChart.setData(data);

        barChart.setDescription("Bar Chart Desc");

    }


}
