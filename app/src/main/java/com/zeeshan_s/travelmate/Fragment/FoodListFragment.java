package com.zeeshan_s.travelmate.Fragment;

import android.hardware.lights.LightsManager;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeeshan_s.travelmate.Adapters.FamousFoodAdapter;
import com.zeeshan_s.travelmate.Models.JelaModel;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentFoodListBinding;

import java.util.ArrayList;
import java.util.List;

public class FoodListFragment extends Fragment {
    public FoodListFragment() {
    }

    FragmentFoodListBinding binding;
List<JelaModel>foodlist;





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       binding=FragmentFoodListBinding.inflate(getLayoutInflater(),container,false);


foodlist=new ArrayList<>();



        foodlist.add(new JelaModel("Dhaka",R.drawable.flower_garden_img,"All Types of food","Chittagong","4.0",R.drawable.food1));
        foodlist.add(new JelaModel("Chittangong",R.drawable.travel1,"Burger","Dhaka","3.6",R.drawable.food2));
        foodlist.add(new JelaModel("Shylet",R.drawable.travel2jpg,"Burger ","Shylet","2.9",R.drawable.food3));
        foodlist.add(new JelaModel("Narayangang",R.drawable.travel3,"Chesse roll","Rajshahi","5.0",R.drawable.food4));
        foodlist.add(new JelaModel("Noyakhali",R.drawable.travel4,"Burger","Rangpur","4.5",R.drawable.food2));
        foodlist.add(new JelaModel("Comilla",R.drawable.mars_human_colony_img,"Potenga sea betch","Chittagong","4.0",R.drawable.food4));
        foodlist.add(new JelaModel("Rangamati",R.drawable.tree_and_light_img,"Hill","conx bajar","4.7",R.drawable.food1));
        foodlist.add(new JelaModel("Rangpur",R.drawable.five_star_icon,"Tea forest","Shylet","2.9",R.drawable.food3));
        foodlist.add(new JelaModel("Rajshgahi",R.drawable.travel1,"Dhanmondi Leak ","Dhaka","3.6",R.drawable.food1));
        foodlist.add(new JelaModel("Bandarban",R.drawable.flower_garden_img,"Ki ase jani na","Rangpur","4.5",R.drawable.food4));
        foodlist.add(new JelaModel("Khagrachori",R.drawable.travel3,"Mango forest","Rajshahi","5.0",R.drawable.travel2jpg));
        foodlist.add(new JelaModel("Borisal",R.drawable.travel4,"Tea forest","Shylet","2.9",R.drawable.travel1));
        foodlist.add(new JelaModel("Bogura",R.drawable.travel2jpg,"Dhanmondi Leak ","Dhaka","3.6",R.drawable.tree_and_light_img));
        foodlist.add(new JelaModel("Gopalgong",R.drawable.flower_garden_img,"Potenga sea betch","Chittagong","4.0",R.drawable.flower_garden_img));
        foodlist.add(new JelaModel("Gopalgong",R.drawable.flower_garden_img,"Potenga sea betch","Chittagong","4.0",R.drawable.flower_garden_img));





        FamousFoodAdapter foodAdapter=new FamousFoodAdapter(foodlist,requireContext());
        binding.foodrecycler.setAdapter(foodAdapter);










        return binding.getRoot();
    }
}