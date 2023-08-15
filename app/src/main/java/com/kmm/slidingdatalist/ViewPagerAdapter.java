package com.kmm.slidingdatalist;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private String[][] data = {
            {"Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1", "Item 2", "Item 3"},
            {"Apple", "Banana", "Orange", "Mango", "Apple", "Banana", "Orange", "Mango", "Apple", "Banana", "Orange", "Mango", "Apple", "Banana", "Orange", "Mango"},
            {"Red", "Green", "Blue"}
    };

    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return RecyclerViewFragment.newInstance(data[position]);
    }

    @Override
    public int getCount() {
        return data.length;
    }
}
