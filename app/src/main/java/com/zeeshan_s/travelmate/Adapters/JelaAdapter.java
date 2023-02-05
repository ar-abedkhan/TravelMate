package com.zeeshan_s.travelmate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zeeshan_s.travelmate.Models.JelaModel;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.Viewholders.JelaViewholder;

import java.util.List;

public class JelaAdapter extends RecyclerView.Adapter<JelaViewholder> {
    List<JelaModel> jelaModelList;
    Context context;

    public JelaAdapter(List<JelaModel> jelaModelList, Context context) {
        this.jelaModelList = jelaModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public JelaViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.jeladesign,parent,false);
        return new JelaViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JelaViewholder holder, int position) {
JelaModel jelaModel=jelaModelList.get(position);

holder.jelaName.setText(jelaModel.getJelaName());

        Glide.with(context).load(jelaModel.getJelaImg()).into(holder.jelaImg);
    }

    @Override
    public int getItemCount() {
        return jelaModelList.size();
    }
}