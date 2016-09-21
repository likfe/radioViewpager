package com.likfe.demo.module2radioviewpager;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mainViewpager;
    private RadioGroup mRadioGroup;
    private RadioButton radioButtonA, radioButtonB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
    }

    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.main_top_rg);
        radioButtonA= (RadioButton) findViewById(R.id.top_rg_a);
        radioButtonB= (RadioButton) findViewById(R.id.top_rg_b);
        mainViewpager= (ViewPager) findViewById(R.id.main_viewpager);
    }

    private void initEvent() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentA());
        fragments.add(new FragmentB());

        NotePagerAdapter pagerAdapter = new NotePagerAdapter(getSupportFragmentManager(), fragments);
        mainViewpager.setAdapter(pagerAdapter);
        mainViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) radioButtonA.setChecked(true);
                else radioButtonB.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == radioButtonA.getId()) mainViewpager.setCurrentItem(0);
                else if (checkedId == radioButtonB.getId()) mainViewpager.setCurrentItem(1);
            }
        });

        //设置默认页
        mainViewpager.setCurrentItem(0);
    }
}
