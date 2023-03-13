package com.zeeshan_s.travelmate.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zeeshan_s.travelmate.Fragment.DetailsFragment;
import com.zeeshan_s.travelmate.Fragment.PlaceListFragment;
import com.zeeshan_s.travelmate.Models.PlaceModel;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.Viewholders.PlaceViewholder;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceViewholder> {
    List<PlaceModel> placeModelList;
    Context context;

    public PlaceAdapter(List<PlaceModel> placeModelList, Context context) {
        this.placeModelList = placeModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public PlaceViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.famous_bd_recycler,parent,false);
        return new PlaceViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewholder holder, int position) {
PlaceModel placeModel=placeModelList.get(position);

holder.placelocation.setText(placeModel.getPlaceLocation());
holder.placename.setText(placeModel.getPlaceName());
holder.placeRatings.setText(placeModel.getPlaceRatings());


        Glide.with(context).load(placeModel.getPlaceImg()).into(holder.placeImg);
holder.itemView.setOnClickListener(view -> {
    AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
    DetailsFragment detailsFragment=new DetailsFragment();
    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,detailsFragment).addToBackStack(null).commit();

});



    }

    @Override
    public int getItemCount() {
        return placeModelList.size();
    }
}
