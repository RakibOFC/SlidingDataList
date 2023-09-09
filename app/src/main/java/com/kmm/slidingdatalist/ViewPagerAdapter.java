package com.kmm.slidingdatalist;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends PagerAdapter {

    private final int noOfList;
    private RecyclerViewAdapter adapter;

    public ViewPagerAdapter(int noOfList) {
        this.noOfList = noOfList;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setTextSizes(float textSize) {

        try {
            adapter.setTextSizes(textSize);
            this.notifyDataSetChanged();

        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        List<String> stringList = new ArrayList<>();

        for (int i = 1; i < 1000; i++) {
            stringList.add("Item " + (position + 1) + ": " + i);
        }

        RecyclerViewFragment pagerView = new RecyclerViewFragment(container.getContext());
        adapter = new RecyclerViewAdapter(stringList);

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
        return noOfList;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}