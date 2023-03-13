package com.zeeshan_s.travelmate.Fragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeeshan_s.travelmate.Adapters.PlaceAdapter;
import com.zeeshan_s.travelmate.Models.PlaceModel;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentPlaceListBinding;

import java.util.ArrayList;
import java.util.List;

public class PlaceListFragment extends Fragment {
    public PlaceListFragment() {

    }
    FragmentPlaceListBinding binding;
    List<PlaceModel> placeModelList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentPlaceListBinding.inflate(getLayoutInflater(),container,false);

placeModelList=new ArrayList<>();







            placeModelList.add(new PlaceModel("Cox Bazar sea betch","cox bajar","4.6",R.drawable.travel4));
            placeModelList.add(new PlaceModel("Potenga sea betch","Chittagong","4.0",R.drawable.flower_garden_img));
            placeModelList.add(new PlaceModel("Dhanmondi Leak ","Dhaka","3.6",R.drawable.tree_and_light_img));
            placeModelList.add(new PlaceModel("Tea forest","Shylet","2.9",R.drawable.travel1));
            placeModelList.add(new PlaceModel("Mango forest","Rajshahi","5.0",R.drawable.travel2jpg));
            placeModelList.add(new PlaceModel("Ki ase jani na","Rangpur","4.5",R.drawable.travel3));
            placeModelList.add(new PlaceModel("Hill","conx bajar","4.7",R.drawable.mars_human_colony_img));
            placeModelList.add(new PlaceModel("Cox Bazar sea betch","cox bajar","3.6",R.drawable.mars_human_colony_img));
            placeModelList.add(new PlaceModel("Dhanmondi Leak ","Dhaka","3.6",R.drawable.tree_and_light_img));
            placeModelList.add(new PlaceModel("Tea forest","Shylet","2.9",R.drawable.travel1));
            placeModelList.add(new PlaceModel("Mango forest","Rajshahi","5.0",R.drawable.travel2jpg));
            placeModelList.add(new PlaceModel("Ki ase jani na","Rangpur","4.5",R.drawable.travel3));
            placeModelList.add(new PlaceModel("Hill","conx bajar","4.7",R.drawable.mars_human_colony_img));
            placeModelList.add(new PlaceModel("Cox Bazar sea betch","cox bajar","3.6",R.drawable.mars_human_colony_img));
            placeModelList.add(new PlaceModel("Dhanmondi Leak ","Dhaka","3.6",R.drawable.tree_and_light_img));
            placeModelList.add(new PlaceModel("Tea forest","Shylet","2.9",R.drawable.travel1));
            placeModelList.add(new PlaceModel("Mango forest","Rajshahi","5.0",R.drawable.travel2jpg));
            placeModelList.add(new PlaceModel("Ki ase jani na","Rangpur","4.5",R.drawable.travel3));
            placeModelList.add(new PlaceModel("Hill","conx bajar","4.7",R.drawable.mars_human_colony_img));
            placeModelList.add(new PlaceModel("Cox Bazar sea betch","cox bajar","3.6",R.drawable.mars_human_colony_img));


            PlaceAdapter adapter=new PlaceAdapter(placeModelList,requireContext());
            binding.allPlacesRecycler.setAdapter(adapter);











        return binding.getRoot();
    }
}