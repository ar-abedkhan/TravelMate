package com.zeeshan_s.travelmate.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentAddFoodBinding;

public class AddFoodFragment extends Fragment {

    public AddFoodFragment() {
        // Required empty public constructor
    }
FragmentAddFoodBinding binding;









    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentAddFoodBinding.inflate(getLayoutInflater(),container,false);














        return binding.getRoot();
    }
}