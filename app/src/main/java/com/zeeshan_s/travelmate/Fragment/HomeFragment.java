package com.zeeshan_s.travelmate.Fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.zeeshan_s.travelmate.Adapters.JelaAdapter;
import com.zeeshan_s.travelmate.Adapters.PlaceAdapter;
import com.zeeshan_s.travelmate.Models.JelaModel;
import com.zeeshan_s.travelmate.Models.PlaceModel;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    public HomeFragment() {
    }

    FragmentHomeBinding binding;
    ArrayList<SlideModel> imageList;
    List<PlaceModel> placeModelList;
    List<JelaModel>jelaModelList;








    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentHomeBinding.inflate(getLayoutInflater(),container,false);






        placeModelList=new ArrayList<>();
        jelaModelList=new ArrayList<>();





//        ---------------------------- Image Slider ------------------------
//        Image Slider data entry example___________
//        imageList.add(SlideModel("String Url" or R.drawable, ScaleTypes.FIT) // for one image
//        imageList.add(SlideModel("String Url" or R.drawable, "Title", ScaleTypes.FIT) // you can with title
//        imageSlider.setImageList(imageList, ScaleTypes.FIT) // for all images

        imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.flower_garden_img,"Garden", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.tree_and_light_img,"Night", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.mars_human_colony_img,"Mars", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.travel3,"Sean", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.travel2jpg,"Beauty", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.travel1,"Nature", ScaleTypes.CENTER_CROP));

        binding.imageSlider.setImageList(imageList);

        placedata();
        jeladata();

        binding.foodSearch.setOnClickListener(view -> {
//            Log.i("TAG", "onCreate:-----------------Main search ");
//
//            Intent intent  = new Intent(MainActivity.this, Search_Item_BucketActivity.class);
//            startActivity(intent);
            getChildFragmentManager().beginTransaction().replace(R.id.mainFrame, new FoodSearchFragment()).commit();




//            startActivity(new Intent(requireContext(), Search_Item_BucketActivity.class));
        });



        binding.placeSearch.setOnClickListener(view -> {
//            Log.i("TAG", "onCreate:-----------------Main search ");
//
//            Intent intent  = new Intent(requireContext(), Search_Item_BucketActivity.class);
//            startActivity(intent);

            PlaceSearchFragment placeSearchFragment=new PlaceSearchFragment();
            getChildFragmentManager().beginTransaction().add(R.id.mainFrame, placeSearchFragment).addToBackStack(null).commit();

//            startActivity(new Intent(requireContext(), Search_Item_BucketActivity.class));
        });















        return binding.getRoot();
    }





    private void jeladata() {


        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Chittangong",R.drawable.travel1));
        jelaModelList.add(new JelaModel("Shylet",R.drawable.travel2jpg));
        jelaModelList.add(new JelaModel("Narayangang",R.drawable.travel3));
        jelaModelList.add(new JelaModel("Noyakhali",R.drawable.travel4));
        jelaModelList.add(new JelaModel("Comilla",R.drawable.mars_human_colony_img));
        jelaModelList.add(new JelaModel("Rangamati",R.drawable.tree_and_light_img));
        jelaModelList.add(new JelaModel("Rangpur",R.drawable.five_star_icon));
        jelaModelList.add(new JelaModel("Rajshgahi",R.drawable.travel1));
        jelaModelList.add(new JelaModel("Bandarban",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Khagrachori",R.drawable.travel3));
        jelaModelList.add(new JelaModel("Borisal",R.drawable.travel4));
        jelaModelList.add(new JelaModel("Bogura",R.drawable.travel2jpg));
        jelaModelList.add(new JelaModel("Gopalgong",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));
        jelaModelList.add(new JelaModel("Dhaka",R.drawable.flower_garden_img));

        JelaAdapter adapter=new JelaAdapter(jelaModelList,requireContext());
        binding.allPlacesRecycler.setAdapter(adapter);

    }

    private void placedata() {




        placeModelList.add(new PlaceModel("Cox Bazar sea betch","cox bajar","4.6",R.drawable.travel4));
        placeModelList.add(new PlaceModel("Potenga sea betch","Chittagong","4.0",R.drawable.flower_garden_img));
        placeModelList.add(new PlaceModel("Dhanmondi Leak ","Dhaka","3.6",R.drawable.tree_and_light_img));
        placeModelList.add(new PlaceModel("Tea forest","Shylet","2.9",R.drawable.travel1));
        placeModelList.add(new PlaceModel("Mango forest","Rajshahi","5.0",R.drawable.travel2jpg));
        placeModelList.add(new PlaceModel("Ki ase jani na","Rangpur","4.5",R.drawable.travel3));
        placeModelList.add(new PlaceModel("Hill","conx bajar","4.7",R.drawable.mars_human_colony_img));
        placeModelList.add(new PlaceModel("Cox Bazar sea betch","cox bajar","3.6",R.drawable.mars_human_colony_img));


        PlaceAdapter adapter=new PlaceAdapter(placeModelList,requireContext());
        binding.famBdRecycler.setAdapter(adapter);

    }





}