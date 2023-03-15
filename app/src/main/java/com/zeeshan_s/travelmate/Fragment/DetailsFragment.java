package com.zeeshan_s.travelmate.Fragment;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeeshan_s.travelmate.Adapters.FamousPlaceAdapter;
import com.zeeshan_s.travelmate.Adapters.PlaceAdapter;
import com.zeeshan_s.travelmate.Models.JelaModel;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentDetailsBinding;

import java.util.ArrayList;
import java.util.List;

public class DetailsFragment extends Fragment {

    public DetailsFragment() {
    }
FragmentDetailsBinding binding;
    List<JelaModel> jelaModelList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
binding=FragmentDetailsBinding.inflate(getLayoutInflater(),container,false);



jelaModelList=new ArrayList<>();



        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img,"Potenga sea betch","Chittagong","4.0",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Chittangong",R.drawable.travel1,"Dhanmondi Leak ","Dhaka","3.6",R.drawable.tree_and_light_img));
        jelaModelList.add(new JelaModel("Shylet",R.drawable.travel2jpg,"Tea forest","Shylet","2.9",R.drawable.travel1));
        jelaModelList.add(new JelaModel("Narayangang",R.drawable.travel3,"Mango forest","Rajshahi","5.0",R.drawable.travel2jpg));
        jelaModelList.add(new JelaModel("Noyakhali",R.drawable.travel4,"Ki ase jani na","Rangpur","4.5",R.drawable.travel3));
        jelaModelList.add(new JelaModel("Comilla",R.drawable.mars_human_colony_img,"Potenga sea betch","Chittagong","4.0",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Rangamati",R.drawable.tree_and_light_img,"Hill","conx bajar","4.7",R.drawable.mars_human_colony_img));
        jelaModelList.add(new JelaModel("Rangpur",R.drawable.five_star_icon,"Tea forest","Shylet","2.9",R.drawable.travel1));
        jelaModelList.add(new JelaModel("Rajshgahi",R.drawable.travel1,"Dhanmondi Leak ","Dhaka","3.6",R.drawable.tree_and_light_img));
        jelaModelList.add(new JelaModel("Bandarban",R.drawable.flower_garden_img,"Ki ase jani na","Rangpur","4.5",R.drawable.travel3));
        jelaModelList.add(new JelaModel("Khagrachori",R.drawable.travel3,"Mango forest","Rajshahi","5.0",R.drawable.travel2jpg));
        jelaModelList.add(new JelaModel("Borisal",R.drawable.travel4,"Tea forest","Shylet","2.9",R.drawable.travel1));
        jelaModelList.add(new JelaModel("Bogura",R.drawable.travel2jpg,"Dhanmondi Leak ","Dhaka","3.6",R.drawable.tree_and_light_img));
        jelaModelList.add(new JelaModel("Gopalgong",R.drawable.flower_garden_img,"Potenga sea betch","Chittagong","4.0",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Gopalgong",R.drawable.flower_garden_img,"Potenga sea betch","Chittagong","4.0",R.drawable.flower_garden_img));


            FamousPlaceAdapter adapter=new FamousPlaceAdapter(jelaModelList,requireContext());
            binding.famBdRecycler.setAdapter(adapter);






        return binding.getRoot();
    }
}