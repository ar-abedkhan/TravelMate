package com.zeeshan_s.travelmate.Adapters;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.zeeshan_s.travelmate.Fragment.PlaceandFoodContenarFragment;
import com.zeeshan_s.travelmate.Models.DistrictModel;
import com.zeeshan_s.travelmate.Models.JelaModel;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.Viewholders.JelaViewholder;

import java.util.List;

public class JelaAdapter extends RecyclerView.Adapter<JelaViewholder> {
    List<DistrictModel> jelaModelList;
    Context context;
    public static String DISTRICT_NAME=""; // ***This is a Global Variable***

    public JelaAdapter(List<DistrictModel> jelaModelList, Context context) {
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
DistrictModel jelaModel=jelaModelList.get(position);

//    TODO: After getting our own hosting we have to change the link
String url = "https://codecorral.000webhostapp.com/travel-app/images/";

holder.jelaName.setText(jelaModel.getName());

        try {
            Glide.with(context).load(url+jelaModel.getImg()).into(holder.jelaImg);
        }catch (Exception e){
            Glide.with(context).load(url+jelaModel.getImg()).placeholder(R.drawable.tree_and_light_img).into(holder.jelaImg);
            Log.i("TAG", "Jela adapter[img loading problem]: "+ e.getLocalizedMessage());
        }

//        holder.cardView.setAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(),R.anim.animation));

        holder.itemView.setOnClickListener(view -> {

            AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
//            PlaceListFragment placeListFragment=new PlaceListFragment();

//            PlaceandFoodContenarFragment placeandFoodContenarFragment=new PlaceandFoodContenarFragment();
            Fragment placeandFoodContenarFragment = new PlaceandFoodContenarFragment();

            Bundle bundle = new Bundle();

            Log.i("TAG", "District Name (Adapter): "+ jelaModel.getName());
            DISTRICT_NAME = jelaModel.getName();
            bundle.putString("DistrictName", jelaModel.getName()); // Set your argument key-value pair

            placeandFoodContenarFragment.setArguments(bundle);

           appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,placeandFoodContenarFragment).addToBackStack(null).commit();
//            context.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, placeandFoodContenarFragment).commit();

        });
    }

    @Override
    public int getItemCount() {
        return jelaModelList.size();
    }
}
