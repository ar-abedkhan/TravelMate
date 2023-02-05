package com.zeeshan_s.travelmate.Viewholders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zeeshan_s.travelmate.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class JelaViewholder extends RecyclerView.ViewHolder {
    public TextView jelaName;
    public CircleImageView jelaImg;


    public JelaViewholder(@NonNull View itemView) {
        super(itemView);



        jelaImg=itemView.findViewById(R.id.jelaImg);
        jelaName=itemView.findViewById(R.id.jelaName);




    }
}
