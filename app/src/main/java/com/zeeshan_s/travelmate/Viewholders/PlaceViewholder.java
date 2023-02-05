package com.zeeshan_s.travelmate.Viewholders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeeshan_s.travelmate.R;

public class PlaceViewholder extends RecyclerView.ViewHolder {
    public TextView placename,placelocation,placeRatings;
    public ImageView placeImg;

    public PlaceViewholder(@NonNull View itemView) {
        super(itemView);

        placename=itemView.findViewById(R.id.placeName);
        placeImg=itemView.findViewById(R.id.placeImg);
        placelocation=itemView.findViewById(R.id.location);
        placeRatings=itemView.findViewById(R.id.ratings);


    }
}
