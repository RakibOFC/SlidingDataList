package com.kmm.slidingdatalist;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private final List<String> data;
    private float textSize;

    public RecyclerViewAdapter(List<String> data) {
        this.data = data;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setTextSizes(float textSize) {

        this.textSize = textSize;
        try {
            this.notifyDataSetChanged();

        } catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(textSize, data.get(position), position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);

        }

        public void bind(float textSize, String string, int position) {

            textView.setTextSize(textSize < 14 ? 14 : textSize);

            textView.setText(string);

            itemView.setOnClickListener(v -> {
                Log.e("Position", position + ", Data: " + string);
            });
        }
    }
}