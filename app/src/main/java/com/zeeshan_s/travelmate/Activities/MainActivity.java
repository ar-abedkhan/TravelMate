package com.zeeshan_s.travelmate.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.denzcoskun.imageslider.models.SlideModel;
import com.zeeshan_s.travelmate.Fragment.HomeFragment;
import com.zeeshan_s.travelmate.Models.JelaModel;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<SlideModel> imageList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        replace(new HomeFragment());


    }

    private void replace(Fragment fragment) {

        getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment).commit();
    }
}