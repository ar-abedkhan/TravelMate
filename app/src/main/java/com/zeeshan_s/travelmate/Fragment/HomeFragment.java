package com.zeeshan_s.travelmate.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.zeeshan_s.travelmate.Adapters.FamousFoodAdapter;
import com.zeeshan_s.travelmate.Adapters.FamousPlaceAdapter;
import com.zeeshan_s.travelmate.Adapters.JelaAdapter;
import com.zeeshan_s.travelmate.Models.DistrictModel;
import com.zeeshan_s.travelmate.Models.JelaModel;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentHomeBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    ArrayList<SlideModel> imageList;
    List<JelaModel>jelaModelList;
    List<JelaModel>foodlist;
    List<DistrictModel> districtModels;
    RequestQueue requestQueue;

//    TODO: After getting our own hosting we have to change the link
    String url = "https://codecorral.000webhostapp.com/travel-app/getDistrictDataToDevice.php";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding= FragmentHomeBinding.inflate(inflater,  container, false);

        jelaModelList=new ArrayList<>();
        foodlist=new ArrayList<>();
        districtModels = new ArrayList<>();

//        ---------------------------- Image Slider ------------------------
//        Image Slider data entry example___________
//        imageList.add(SlideModel("String Url" or R.drawable, ScaleTypes.FIT) // for one image
//        imageList.add(SlideModel("String Url" or R.drawable, "Title", ScaleTypes.FIT) // you can with title
//        imageSlider.setImageList(imageList, ScaleTypes.FIT) // for all images

        imageList = new ArrayList<>();
        imageList.add(new SlideModel(R.drawable.flower_garden_img,"Garden", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.food1,"All Food", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.tree_and_light_img,"Night", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.food2,"Burger", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.mars_human_colony_img,"Mars", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.food3,"Roll", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.travel3,"Sean", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.food4,"Burger", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.travel2jpg,"Beauty", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.travel1,"Nature", ScaleTypes.CENTER_CROP));

        binding.imageSlider.setImageList(imageList);



        binding.foodSearch.setOnClickListener(view -> {
//            Log.i("TAG", "onCreate:-----------------Main search ");

            AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
            FoodSearchFragment fragment=new FoodSearchFragment();
            Bundle bundle=new Bundle();
            fragment.setArguments(bundle);

            appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,fragment).addToBackStack(null).commit();
        });



        binding.placeSearch.setOnClickListener(view -> {
//            Log.i("TAG", "onCreate:-----------------Main search ");
            AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
            PlaceSearchFragment placeSearchFragment=new PlaceSearchFragment();
            Bundle bundle=new Bundle();
            placeSearchFragment.setArguments(bundle);
            appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,placeSearchFragment).addToBackStack(null).commit();
        });



        binding.myProfile.setOnClickListener(view -> {
            AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
            AddFragment addFragment=new AddFragment();
            Bundle bundle=new Bundle();
            addFragment.setArguments(bundle);
            appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,addFragment).addToBackStack(null).commit();
        });


//        $ this one is for going to the web from activity
//        binding.myProfile.setOnClickListener(view -> {
//            Intent intent = new Intent(getActivity(), AddPlaceByWebActivity.class);
//
//            Log.i("TAG", "This is from home fragment --1 ");
////            ------------------------------------Here is the problem
//            startActivity(intent);
//        });

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

//        JelaAdapter jelaAdapter=new JelaAdapter(jelaModelList,requireContext());
//        binding.allPlacesRecycler.setAdapter(jelaAdapter);

//        ----------------------------------------------------------------------------------------------------------------------------------------
//        @ IN this section we will get District data from the districts database
//                $ If this works we will delete the jela database
        JsonArrayRequest arrayRequest  = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Log.i("TAG", "Response from server: "+ response.getString());

                        if (response.length()>0){
                            for (int i = 0; i< response.length(); i++){
                                try {
                                    JSONObject jsonObject = response.getJSONObject(i);

                                    int d_id = jsonObject.getInt("d_id");
                                    String name = jsonObject.getString("name");
                                    String img = jsonObject.getString("img");
                                    Log.i("TAG", "Works till (1) ");

                                    DistrictModel model = new DistrictModel(d_id, name, img);
                                    districtModels.add(model);

                                }catch (Exception e){
                                    Log.i("TAG", "Works till (1) "+ e.getLocalizedMessage());
                                    Toast.makeText(getContext(), "Error!!\n"+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                                }
                            }
                        }


//        @ Sending data to adapter
                        JelaAdapter jelaAdapter=new JelaAdapter(districtModels,requireContext());
                        binding.allPlacesRecycler.setAdapter(jelaAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Error!!\n"+error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                        Log.i("TAG", "Error-> "+error.getLocalizedMessage());
                    }
                });


        requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(arrayRequest);

//        ---------------------------------------------------------------------------------------------------------------------------------------------


        FamousPlaceAdapter adapter=new FamousPlaceAdapter(jelaModelList,requireContext());
        binding.famBdRecycler.setAdapter(adapter);


        foodlist.add(new JelaModel("Dhaka",R.drawable.flower_garden_img,"Potenga sea betch","Chittagong","4.0",R.drawable.food1));
        foodlist.add(new JelaModel("Chittangong",R.drawable.travel1,"Dhanmondi Leak ","Dhaka","3.6",R.drawable.food2));
        foodlist.add(new JelaModel("Shylet",R.drawable.travel2jpg,"Tea forest","Shylet","2.9",R.drawable.food3));
        foodlist.add(new JelaModel("Narayangang",R.drawable.travel3,"Mango forest","Rajshahi","5.0",R.drawable.food4));
        foodlist.add(new JelaModel("Noyakhali",R.drawable.travel4,"Ki ase jani na","Rangpur","4.5",R.drawable.food2));
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
        binding.famFoodRecycler.setAdapter(foodAdapter);








        return binding.getRoot();
    }








}