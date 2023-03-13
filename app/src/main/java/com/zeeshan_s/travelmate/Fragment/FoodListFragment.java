package com.zeeshan_s.travelmate.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentFoodListBinding;

public class FoodListFragment extends Fragment {
    public FoodListFragment() {
    }

    FragmentFoodListBinding binding;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentFoodListBinding.inflate(getLayoutInflater(),container,false);



















        return binding.getRoot();
    }
}