package com.zeeshan_s.travelmate.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.zeeshan_s.travelmate.Adapters.AddFragmentAdapter;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentAddBinding;

public class AddFragment extends Fragment {
    public AddFragment() {
    }

    FragmentAddBinding binding;
FragmentManager fragmentManager;
AddFragmentAdapter adapter;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentAddBinding.inflate(getLayoutInflater(),container,false);





        fragmentManager=getChildFragmentManager();
        adapter= new AddFragmentAdapter(fragmentManager,100);
        binding.addViewpager.setAdapter(adapter);
        binding.addTabLayout.setupWithViewPager(binding.addViewpager);




        return binding.getRoot();
    }
}