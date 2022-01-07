package com.example.ActivePlus.FragmentsForMainAplicationPage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.ActivePlus.MainAplicationPage;
import com.example.ActivePlus.R;
import com.example.ActivePlus.Task1;
import com.example.ActivePlus.Task2;
import com.example.ActivePlus.Task3;
import com.example.ActivePlus.Task4;
import com.example.ActivePlus.Task5;
import com.example.ActivePlus.TaskFormActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Task#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Task extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ListView listView;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Task() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static Task newInstance(String param1, String param2) {
        Task fragment = new Task();
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


    CardView TaskCard1;
    CardView TaskCard2;
    CardView TaskCard3;
    CardView TaskCard4;
    CardView TaskCard5;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentview=inflater.inflate(R.layout.fragemnt_task, container, false);
        TaskCard1=(CardView) fragmentview.findViewById(R.id.TaskCard1);
        TaskCard2=(CardView) fragmentview.findViewById(R.id.TaskCard2);
        TaskCard3=(CardView) fragmentview.findViewById(R.id.TaskCard3);
        TaskCard4=(CardView) fragmentview.findViewById(R.id.TaskCard4);
        TaskCard5=(CardView) fragmentview.findViewById(R.id.TaskCard5);

        TaskCard1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Task1.class));
            }
        });
        TaskCard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Task2.class));
            }
        });
        TaskCard3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Task3.class));
            }
        });
        TaskCard4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Task4.class));
            }
        });
        TaskCard5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Task5.class));
            }
        });


        return fragmentview;
    }


}
