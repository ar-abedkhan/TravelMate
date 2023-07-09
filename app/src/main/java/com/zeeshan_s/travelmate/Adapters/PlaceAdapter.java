package com.zeeshan_s.travelmate.Adapters;

import android.content.Context;
import android.util.Log;
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

        View view= LayoutInflater.from(context).inflate(R.layout.place_list_recycler_design,parent,false);
        return new PlaceViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewholder holder, int position) {
      PlaceModel placeModel=placeModelList.get(position);

        //    TODO: After getting our own hosting we have to change the link
        String url = "https://codecorral.000webhostapp.com/travel-app/images/";

      holder.placelocation.setText(placeModel.getFull_location());
        holder.placename.setText(placeModel.getName());
          holder.placeRatings.setText(placeModel.getRate()+"");


          try {
              Glide.with(context).load(url+placeModel.getPlace_img()).into(holder.placeImg);
          }catch (Exception e){
              Log.i("TAG", "Place adapter image setting error: "+e.getLocalizedMessage());
          }


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
