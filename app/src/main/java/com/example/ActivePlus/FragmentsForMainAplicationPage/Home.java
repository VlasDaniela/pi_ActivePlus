package com.example.ActivePlus.FragmentsForMainAplicationPage;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.ActivePlus.R;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Home.
     */
    // TODO: Rename and change types and number of parameters
    public static Home newInstance(String param1, String param2) {
        Home fragment = new Home();
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

    private Button challenge;
    private ImageView wheel;
    private static final  String [] sectors={"10","10","10","10","15","15","15","20","20"};
    private  static final int [] sectorDegrees= new int[ sectors.length];
    private static final Random random=new Random();
    private int  degree=0;
    private boolean isSpinning=false;
    int x=0;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentview=inflater.inflate(R.layout.fragment_home, container, false);

        challenge=fragmentview.findViewById(R.id.ChallengeButton);
        wheel=fragmentview.findViewById(R.id.wheel);
        getDegreeForSectors();
        challenge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 if(x==0) {
                     spin();
                     isSpinning = true;
                     x++;
                 }


            }
        });



        return fragmentview;
    }
    private void spin(){
        degree=random.nextInt(sectors.length-1);

        RotateAnimation rotateAnimation=new RotateAnimation(0,(360* sectors.length)+sectorDegrees[degree],RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(3600);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setInterpolator(new DecelerateInterpolator());
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {


                isSpinning=false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        wheel.startAnimation(rotateAnimation);

    }
    private  void getDegreeForSectors(){
        int sectordegree=360/ sectors.length;
        for(int i=0;i< sectors.length;i++){
            sectorDegrees[i]=(i+1)*sectordegree;

        }
    }

}