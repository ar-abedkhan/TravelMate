package com.zeeshan_s.travelmate.Fragment;

import static android.app.Activity.RESULT_OK;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentAddPlaceBinding;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class AddPlaceFragment extends Fragment {
    public AddPlaceFragment() {
        // Required empty public constructor
    }
    FragmentAddPlaceBinding binding;
    private static final int STORAGE_PERMISSION_CODE = 4655;
    private final int PICK_IMAGE_REQUEST = 1;
    private Uri filepath;
    private Bitmap bitmap;
    String encodeImageString;
    RequestQueue requestQueue;
    ProgressDialog dialog;
    public static final String UPLOAD_URL = "https://zirwabd.000webhostapp.com/tavel/placeupload.php";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddPlaceBinding.inflate(getLayoutInflater(), container, false);

        //allSpeener();
        requestStoragePermission();
        setupdialog();
        binding.ImgBtnCon.setOnClickListener(v -> {
            ShowFileChooser();
        });

        binding.submitBtn.setOnClickListener(v -> {
            uploadImage();
        });

//        setting image button click
//        binding.ImgBtnCon.setOnClickListener(view -> {
//            binding.placeImgCon.setVisibility(View.VISIBLE);
//            binding.ImgBtnCon.setVisibility(View.GONE);
//        });

        binding.backBtn.setOnClickListener(view -> {

            AppCompatActivity appCompatActivity = (AppCompatActivity) view.getContext();
            HomeFragment homeFragment = new HomeFragment();
            Bundle bundle = new Bundle();
            homeFragment.setArguments(bundle);
            appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame, homeFragment).addToBackStack(null).commit();
        });





        return binding.getRoot();
    }

    private void requestStoragePermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
            return;

        if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }
        ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == STORAGE_PERMISSION_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getActivity(), "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();

            } else {
                Toast.makeText(getActivity(), "Oops you just denied the permission", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void ShowFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && data != null && data.getData() != null) {
            filepath = data.getData();
            try
            {
                InputStream inputStream=getActivity().getApplicationContext().getContentResolver().openInputStream(filepath);
                bitmap= BitmapFactory.decodeStream(inputStream);
                binding.placeImg.setImageBitmap(bitmap);
                encodeBitmapImage(bitmap);
            }catch (Exception ex)
            {

            }

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


    private void setupdialog() {
        dialog = new ProgressDialog(getActivity());
        dialog.setTitle("Uploading Data");
        dialog.setMessage("Please Wait...!");
        dialog.setCancelable(false);
    }


    private void uploadImage() {

        String placeName = binding.placeName.getText().toString().trim();
        String fullLocation = binding.fullLocation.getText().toString();
        String placeDescription = binding.placeDescription.getText().toString();
        String jelaId = binding.jelaId.getText().toString();
        String ratings = binding.ratings.getText().toString();


         if (placeDescription.length()>1309) {
            binding.placeDescription.setError("Description is to Long");
        }
        else {
            dialog.show();
            StringRequest stringRequest = new StringRequest(Request.Method.POST, UPLOAD_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            binding.placeName.setText("");
                            binding.fullLocation.setText("");
                            binding.placeDescription.setText("");
                            binding.jelaId.setText("");
                            binding.ratings.setText("");
                            binding.placeImg.setImageResource(R.drawable.img_icon);
                            dialog.dismiss();
                            Toast.makeText(getActivity(), response.toString(), Toast.LENGTH_SHORT).show();
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getActivity(), "Fail to Upload Data", Toast.LENGTH_SHORT).show();
                }

            })
//            Post Main Part
            {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();
                    params.put("dis_id", String.valueOf(Integer.parseInt(jelaId)));
                    params.put("pname", placeName);
                    params.put("ploca", fullLocation);
                    params.put("pimage ", encodeImageString);
                    params.put("rateing", String.valueOf(Integer.parseInt(ratings)));
                    params.put("description", placeDescription);
                    return params;
                }
            };
            requestQueue = Volley.newRequestQueue(getActivity());
            requestQueue.add(stringRequest);

        }





    }





//    private void allSpeener() {
//
//
//
//
//        String[] allJelaName = {
//                "কুমিল্লা",
//                "ফেনী",
//                "ব্রাহ্মণবাড়িয়া",
//                "রাঙ্গামাটি",
//                "নোয়াখালী",
//                "চাঁদপুর",
//                "লক্ষ্মীপুর",
//                "চট্টগ্রাম",
//                "কক্সবাজার",
//                "খাগড়াছড়ি",
//                "বান্দরবান",
//                "সিরাজগঞ্জ",
//                "পাবনা",
//                "বগুড়া",
//                "রাজশাহী",
//                "নাটোর", "জয়পুরহাট", "চাঁপাইনবাবগঞ্জ","নওগাঁ", "যশোর", "সাতক্ষীরা","মেহেরপুর", "নড়াইল", "চুয়াডাঙ্গা","কুষ্টিয়া", "মাগুরা", "খুলনা",
//                "বাগেরহাট", "ঝিনাইদহ", "ঝালকাঠি","পটুয়াখালী", "বরিশাল", "ভোলা","বরগুনা", "সিলেট", "মৌলভীবাজার","হবিগঞ্জ", "সুনামগঞ্জ", "নরসিংদী",
//                "গাজীপুর", "শরীয়তপুর", "নারায়ণগঞ্জ","টাঙ্গাইল", "কিশোরগঞ্জ", "মানিকগঞ্জ","ঢাকা", "মুন্সিগঞ্জ", "রাজবাড়ী","মাদারীপুর", "গোপালগঞ্জ", "ফরিদপুর",
//                "পঞ্চগড়", "দিনাজপুর", "লালমনিরহাট","নীলফামারী", "গাইবান্ধা", "ঠাকুরগাঁও","রংপুর", "কুড়িগ্রাম", "শেরপুর","ময়মনসিংহ", "জামালপুর", "নেত্রকোণা",
//        };
//
//        ArrayAdapter<String> jelaNameAdapter = new ArrayAdapter<>(getContext(),
//                android.R.layout.simple_dropdown_item_1line,
//                allJelaName);
//        binding.jelaName.setAdapter(jelaNameAdapter);


//
//
//        String[] ispopular={
//                "Popular","NonPopular"
//        };
//        ArrayAdapter<String> ispopularAdapter = new ArrayAdapter<>(getContext(),
//                android.R.layout.simple_dropdown_item_1line,
//                ispopular);
//        binding.isPopular.setAdapter(ispopularAdapter);
//
//
//
//
//
//        String[] cetagory={
//                "Hill","Sea","Forest","Historic"
//        };
//        ArrayAdapter<String> cetagoryAdapter = new ArrayAdapter<>(getContext(),
//                android.R.layout.simple_dropdown_item_1line,
//                cetagory);
//        binding.cetagory.setAdapter(cetagoryAdapter);


    private void encodeBitmapImage(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG,100,byteArrayOutputStream);
        byte[] bytesofimage=byteArrayOutputStream.toByteArray();
        encodeImageString=android.util.Base64.encodeToString(bytesofimage, Base64.DEFAULT);
    }
    }