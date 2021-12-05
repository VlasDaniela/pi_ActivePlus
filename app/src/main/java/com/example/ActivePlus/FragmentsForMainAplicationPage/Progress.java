package com.example.ActivePlus.FragmentsForMainAplicationPage;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ActivePlus.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Progress#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Progress extends Fragment {
    public  void Data(BarChart tabel){
        ArrayList<BarEntry>  progress=new ArrayList<>();
        progress.add(new BarEntry(2014,200));
        progress.add(new BarEntry(2015,400));
        progress.add(new BarEntry(2016,600));
        progress.add(new BarEntry(2017,700));
        progress.add(new BarEntry(2018,800));
        progress.add(new BarEntry(2019,900));

        BarDataSet bardatSet= new BarDataSet(progress,"progress");
        bardatSet.setColors(ColorTemplate.MATERIAL_COLORS);
        bardatSet.setValueTextColor(Color.CYAN);
        bardatSet.setValueTextSize(20f);

        BarData bardata= new BarData(bardatSet);

        tabel.setFitBars(true);
        tabel.setData(bardata);
        tabel.getDescription().setText("Progress Chart");
        tabel.animateY(2000);
    }
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Progress() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Progress.
     */
    // TODO: Rename and change types and number of parameters
    public static Progress newInstance(String param1, String param2) {
        Progress fragment = new Progress();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    BarChart table;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentview=inflater.inflate(R.layout.fragment_progress,container,false);
        table=(BarChart) fragmentview.findViewById(R.id.barchart);
        Data(table);
        return fragmentview;
    }
}