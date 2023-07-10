package com.zeeshan_s.travelmate.Adapters;

import static com.zeeshan_s.travelmate.Adapters.PlaceAdapter.PLACE_ID;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zeeshan_s.travelmate.Fragment.DetailsFragment;
import com.zeeshan_s.travelmate.Models.JelaModel;
import com.zeeshan_s.travelmate.Models.PlaceModel;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.Viewholders.PlaceViewholder;

import java.util.List;

public class FamousPlaceAdapter extends RecyclerView.Adapter<PlaceViewholder> {
    List<PlaceModel> placeModelList;
    Context context;

    public FamousPlaceAdapter(List<PlaceModel> placeModelList, Context context) {
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

holder.placelocation.setText(placeModel.getFull_location());
holder.placename.setText(placeModel.getName());
holder.placeRatings.setText(placeModel.getRate()+"");


        Glide.with(context).load(placeModel.getPlace_img()).into(holder.placeImg);



holder.itemView.setOnClickListener(view -> {
    AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
    DetailsFragment detailsFragment=new DetailsFragment();
    PLACE_ID = placeModel.getP_id();
    appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,detailsFragment).addToBackStack(null).commit();

});



    }

    @Override
    public int getItemCount() {
        return placeModelList.size();
    }
}
