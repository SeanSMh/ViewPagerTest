package com.example.sean.viewpagertest;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import javax.crypto.spec.PSource;

public class MainActivity extends AppCompatActivity {

    private View view_1, view_2, view_3;
    private ViewPager viewPager;
    private List<View> viewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        PagerAdapter pagerAdapter = new PagerAdapter() {
            @Override
            public int getCount() {
                return viewList.size();
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
                return view == object;
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                container.addView(viewList.get(position));

                return viewList.get(position);
            }
        };

        viewPager.setAdapter(pagerAdapter);
    }

    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        LayoutInflater inflater = getLayoutInflater();
        view_1 = inflater.inflate(R.layout.layout_1, null);
        view_2 = inflater.inflate(R.layout.layout_2, null);
        view_3 = inflater.inflate(R.layout.layout_3, null);
        viewList = new ArrayList<View>();  //降要分页显示的view装入viewlist
        viewList.add(view_1);
        viewList.add(view_2);
        viewList.add(view_3);
    }
}
