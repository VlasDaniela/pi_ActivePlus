package com.example.ActivePlus;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.ActivePlus.FragmentsForMainAplicationPage.FragmentAdapter;
import com.google.android.material.tabs.TabLayout;

public class MainAplicationPage extends AppCompatActivity {
    TabLayout tablelayout;
    ViewPager2 pager2;
    FragmentAdapter adapter;
    CardView card3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_aplication_page);
        pager2=findViewById(R.id.pager2);
        card3=findViewById(R.id.card3);
        tablelayout=findViewById(R.id.tab_layout);
        FragmentManager fm=getSupportFragmentManager();
        adapter=new FragmentAdapter(fm,getLifecycle());
        pager2.setAdapter(adapter);
        tablelayout.addTab(tablelayout.newTab().setIcon(R.drawable.ic_baseline_home_24));
        tablelayout.addTab(tablelayout.newTab().setIcon(R.drawable.ic_baseline_book_24));
        tablelayout.addTab(tablelayout.newTab().setIcon(R.drawable.ic_baseline_equalizer_24));
        tablelayout.addTab(tablelayout.newTab().setIcon(R.drawable.ic_baseline_account_circle_24));


        tablelayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tablelayout.selectTab(tablelayout.getTabAt(position));
            }
        });
    }
}