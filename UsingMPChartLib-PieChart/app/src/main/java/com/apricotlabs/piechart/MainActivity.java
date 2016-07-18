package com.apricotlabs.piechart;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import static com.github.mikephil.charting.utils.ColorTemplate.*;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    PieChart pieChart = (PieChart)findViewById(R.id.chart);


        ArrayList<Entry> entries = new ArrayList<>();

        entries.add(new Entry(4f,0));
        entries.add(new Entry(8f,1));
        entries.add(new Entry(6f,2));
        entries.add(new Entry(12f,3));
       // entries.add(new Entry(18f,4));
     //   entries.add(new Entry(9f,0));

        PieDataSet dataset = new PieDataSet(entries, "# of calls");

        ArrayList<String> labels = new ArrayList<String>();
        labels.add("January");
        labels.add("February");
        labels.add("March");
        labels.add("April");
     //   labels.add("May");
       // labels.add("June");

        PieData data = new PieData(labels, dataset); // initialize Piedata
        pieChart.setData(data);

        pieChart.setDescription("Description");
         dataset.setColors(ColorTemplate.COLORFUL_COLORS);
        pieChart.animateY(2000);


    }
}
