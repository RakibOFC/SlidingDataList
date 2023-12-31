package com.kmm.slidingdatalist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewLayout extends FrameLayout {
    private RecyclerView recyclerView;

    public RecyclerViewLayout(@NonNull Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {

        View rootView = LayoutInflater.from(context).inflate(R.layout.fragment_recycler_view, this, true);
        recyclerView = rootView.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    public void setAdapter(RecyclerViewAdapter adapter) {
        recyclerView.setAdapter(adapter);
    }
}
