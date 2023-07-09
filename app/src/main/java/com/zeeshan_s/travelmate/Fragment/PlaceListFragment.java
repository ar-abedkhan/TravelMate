package com.zeeshan_s.travelmate.Fragment;
import static com.zeeshan_s.travelmate.Adapters.JelaAdapter.DISTRICT_NAME;

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
import com.zeeshan_s.travelmate.Adapters.JelaAdapter;
import com.zeeshan_s.travelmate.Adapters.PlaceAdapter;
import com.zeeshan_s.travelmate.Models.DistrictModel;
import com.zeeshan_s.travelmate.Models.JelaModel;
import com.zeeshan_s.travelmate.Models.PlaceModel;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentPlaceListBinding;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PlaceListFragment extends Fragment {
    public PlaceListFragment() {

    }
    FragmentPlaceListBinding binding;
    List<JelaModel> jelaModelList;
    List<PlaceModel> placeModels;
    RequestQueue requestQueue;
    String url = "https://codecorral.000webhostapp.com/travel-app/getPlaceDataToDevice.php";
    String districtName = "Dhaka";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentPlaceListBinding.inflate(getLayoutInflater(),container,false);

jelaModelList=new ArrayList<>();
    placeModels = new ArrayList<>();

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


//            PlaceAdapter adapter=new PlaceAdapter(jelaModelList,requireContext());
//            binding.allPlacesRecycler.setAdapter(adapter);

        //        ----------------------------------------------------------------------------------------------------------------------------------------
//        @ IN this section we will get Place data from the districts database
//                $ If this works we will delete the jela database

        Bundle args = getArguments();
//        districtName = getArguments().getString("DistrictName");
        if (args != null) {
            districtName  = args.getString("DistrictName");
            Log.i("TAG", "---District Name: "+ districtName);
            binding.jelaName.setText(districtName);
        }else {
            Log.i("TAG", "!!!District Bundle Doesn't works___ ");
            districtName = DISTRICT_NAME;
            binding.jelaName.setText(districtName);
        }

        JsonArrayRequest arrayRequest  = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
//                        Log.i("TAG", "Response from server: "+ response.getString());

                        if (response.length()>0){
                            for (int i = 0; i< response.length(); i++){
                                try {
                                    JSONObject jsonObject = response.getJSONObject(i);

                                    String district = jsonObject.getString("place_district");

                                    if (districtName.equals(district)) {
                                        int p_id = jsonObject.getInt("p_id");
                                        int rate = jsonObject.getInt("rate");
                                        String name = jsonObject.getString("name");
                                        String desc = jsonObject.getString("description");
                                        String full_location = jsonObject.getString("full_location");
                                        String category = jsonObject.getString("category");
                                        String img = jsonObject.getString("place_img");
                                        Log.i("TAG", "Works till (1) ");

                                        PlaceModel model = new PlaceModel(p_id, rate, name, desc, full_location, img, district, category);
                                        placeModels.add(model);
                                    }

                                }catch (Exception e){
                                    Log.i("TAG", "Works till (1) "+ e.getLocalizedMessage());
                                    Toast.makeText(getContext(), "Error!!\n"+e.getLocalizedMessage(), Toast.LENGTH_LONG).show();

                                }
                            }
                        }


//        @ Sending data to adapter
            PlaceAdapter adapter=new PlaceAdapter(placeModels,requireContext());
            binding.allPlacesRecycler.setAdapter(adapter);
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