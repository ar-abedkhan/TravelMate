package com.zeeshan_s.travelmate.Fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeeshan_s.travelmate.Activities.MainActivity;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentFoodSearchBinding;

public class FoodSearchFragment extends Fragment {
    public FoodSearchFragment() {
    }
 FragmentFoodSearchBinding binding;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentFoodSearchBinding.inflate(getLayoutInflater(),container,false);





        binding.backBtn.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), MainActivity.class));
            getActivity().finish();
        });


        return binding.getRoot();
    }
}