package com.kmm.slidingdatalist;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private final int totalSurah;

    public ViewPagerAdapter(int totalSurah) {
        this.totalSurah = totalSurah;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        List<String> stringList = new ArrayList<>();

        for (int i = 1; i < 1000; i++) {
            stringList.add("Item " + (position + 1) + ": " + i);
        }

        RecyclerViewFragment pagerView = new RecyclerViewFragment(container.getContext());
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(stringList);

        pagerView.setAdapter(adapter);
        pagerView.setRotation(180);
        container.addView(pagerView);
        return pagerView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((RecyclerViewFragment) object);
    }

    @Override
    public int getCount() {
        return totalSurah;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}