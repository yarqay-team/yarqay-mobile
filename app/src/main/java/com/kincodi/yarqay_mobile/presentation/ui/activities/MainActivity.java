package com.kincodi.yarqay_mobile.presentation.ui.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.kincodi.yarqay_mobile.R;
import com.kincodi.yarqay_mobile.presentation.ui.adapter.SlideViewPageAdapter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.btn_next) Button btnNext;
    @BindView(R.id.view_pager) ViewPager vp;
    @BindView(R.id.btn_skip) Button btnSkip;
    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        SlideViewPageAdapter adapter = new SlideViewPageAdapter(this);
        vp.setAdapter(adapter);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vp.setCurrentItem(getItem(+1), true);
            }
        });
        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextActivity();
            }
        });
    }
    public int getItem(int i) {
        return vp.getCurrentItem() + i;
    }
    public void nextActivity() {
        Intent i = new Intent(this, MapActivity2.class);
        startActivity(i);
    }
}

