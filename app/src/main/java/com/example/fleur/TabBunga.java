package com.example.fleur;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class TabBunga extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabBungaAdapter tabBungaAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_bunga);

        tabLayout = (TabLayout) findViewById(R.id.tl_bunga);
        viewPager = (ViewPager) findViewById(R.id.vp_bunga);
        tabBungaAdapter = new TabBungaAdapter(getSupportFragmentManager());

        tabBungaAdapter.AddFragment(new ListFragment(),"List");
        tabBungaAdapter.AddFragment(new StaggeredFragment(),"Staggered");

        viewPager.setAdapter(tabBungaAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}