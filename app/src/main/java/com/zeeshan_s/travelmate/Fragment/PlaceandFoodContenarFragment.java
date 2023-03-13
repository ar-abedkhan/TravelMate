package com.zeeshan_s.travelmate.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeeshan_s.travelmate.Adapters.FoodAndPlaceAdapter;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentPlaceandFoodContenarBinding;

public class PlaceandFoodContenarFragment extends Fragment {
    public PlaceandFoodContenarFragment() {
    }
FragmentPlaceandFoodContenarBinding binding;
    FragmentManager fragmentManager;
    FoodAndPlaceAdapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
binding=FragmentPlaceandFoodContenarBinding.inflate(getLayoutInflater(),container,false);





        fragmentManager=getChildFragmentManager();
        adapter=new FoodAndPlaceAdapter(fragmentManager,101);
        binding.placeAndFoodViewpager.setAdapter(adapter);
        binding.tabLayout.setupWithViewPager(binding.placeAndFoodViewpager);








        return binding.getRoot();
    }
}