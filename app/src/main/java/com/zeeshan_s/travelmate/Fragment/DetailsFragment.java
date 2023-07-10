package com.zeeshan_s.travelmate.Fragment;
import static com.zeeshan_s.travelmate.Adapters.PlaceAdapter.PLACE_ID;

import android.os.Bundle;

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
import com.bumptech.glide.Glide;
import com.zeeshan_s.travelmate.Adapters.FamousPlaceAdapter;
import com.zeeshan_s.travelmate.Models.JelaModel;
import com.zeeshan_s.travelmate.Models.PlaceModel;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentDetailsBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DetailsFragment extends Fragment {

    public DetailsFragment() {
    }
FragmentDetailsBinding binding;
    List<JelaModel> jelaModelList;
    List<PlaceModel> nearPlaceModel;
    RequestQueue requestQueue;
    String url = "https://codecorral.000webhostapp.com/travel-app/getPlaceDataToDevice.php";
    String place_district="";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
binding=FragmentDetailsBinding.inflate(getLayoutInflater(),container,false);

        String imgUrl = "https://codecorral.000webhostapp.com/travel-app/images/";

        jelaModelList=new ArrayList<>();
        nearPlaceModel = new ArrayList<>();


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


//            FamousPlaceAdapter adapter=new FamousPlaceAdapter(jelaModelList,requireContext());
//            binding.famBdRecycler.setAdapter(adapter);

//            ------------------------------------------------------------------------------------------------
        JsonArrayRequest arrayRequest  = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Log.i("TAG", "Response from server: "+ response.getString());

                        if (response.length()>0){
                            for (int i = 0; i< response.length(); i++){
                                try {
                                    JSONObject jsonObject = response.getJSONObject(i);

                                    int placeId = jsonObject.getInt("p_id");
                                    String district = jsonObject.getString("place_district");

//                                    @ get the specific place data
                                    if (placeId == PLACE_ID) {
//                                        String district = jsonObject.getString("place_district");
                                        place_district = district;
                                        int rate = jsonObject.getInt("rate");
                                        String name = jsonObject.getString("name");
                                        String desc = jsonObject.getString("description");
                                        String full_location = jsonObject.getString("full_location");
                                        String category = jsonObject.getString("category");
                                        String img = jsonObject.getString("place_img");

//                                        @ setting up data to the layouts
                                        try {
//                                            TODO: Category onujayi place holder e image set korbo
                                            Glide.with(getContext()).load(imgUrl+img).placeholder(R.drawable.tree_and_light_img).into(binding.placeImg);
                                        }catch (Exception e){
                                            Log.i("TAG", "Place adapter image setting error: "+e.getLocalizedMessage());
                                        }

                                        binding.placeName.setText(name);
                                        binding.ratings.setText(""+rate);
                                        binding.fullLocation.setText(full_location);
                                        binding.mainDescription.setText(desc);

//                                        ---------------------------------------------------------------------------------------------------------

//                                        PlaceModel model = new PlaceModel(p_id, rate, name, desc, full_location, img, district, category);
//                                        placeModels.add(model);
                                    }

//                                    ----------@ Get data for Near places
                                    if (district.equals(place_district)){
                                        int rate = jsonObject.getInt("rate");
                                        int p_id = jsonObject.getInt("p_id");
                                        String name = jsonObject.getString("name");
                                        String desc = jsonObject.getString("description");
                                        String full_location = jsonObject.getString("full_location");
                                        String category = jsonObject.getString("category");
                                        String img = jsonObject.getString("place_img");

                                        PlaceModel model = new PlaceModel(p_id, rate, name, desc, full_location, img, district, category);
                                        nearPlaceModel.add(model);
                                    }

                                }catch (Exception e){
                                    Log.i("TAG", "Works till (1) "+ e.getLocalizedMessage());
                                    Toast.makeText(getContext(), "Error!!\n"+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                                }
                            }
                        }


//        @ Sending data to adapter
                        FamousPlaceAdapter adapter=new FamousPlaceAdapter(nearPlaceModel,requireContext());
                        binding.famBdRecycler.setAdapter(adapter);
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




        return binding.getRoot();
    }
}