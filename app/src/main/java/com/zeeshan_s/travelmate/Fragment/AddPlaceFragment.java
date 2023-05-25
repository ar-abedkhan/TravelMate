package com.zeeshan_s.travelmate.Fragment;

import static android.app.Activity.RESULT_OK;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentAddPlaceBinding;

public class AddPlaceFragment extends Fragment {
    public AddPlaceFragment() {
        // Required empty public constructor
    }
    FragmentAddPlaceBinding binding;
    Uri postImgUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentAddPlaceBinding.inflate(getLayoutInflater(),container,false);

        allSpeener();

//        setting image button click
        binding.ImgBtnCon.setOnClickListener(view -> {
            binding.placeImgCon.setVisibility(View.VISIBLE);
            binding.ImgBtnCon.setVisibility(View.GONE);
        });

//        setting place image

        binding.placeImgCon.setOnClickListener(view -> {
            //            !getting image from the device
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, 102);
        });

        binding.backBtn.setOnClickListener(view -> {

            AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
            HomeFragment homeFragment=new HomeFragment();
            Bundle bundle=new Bundle();
            homeFragment.setArguments(bundle);

            appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,homeFragment).addToBackStack(null).commit();

        });

        return binding.getRoot();
    }


//    Adding image setting
    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 102 && resultCode == RESULT_OK && data != null){
            postImgUri = data.getData();

//            if the process is successful than add img button will hide
            binding.addImgBtnCon.setVisibility(View.GONE);
            binding.postImgCon.setVisibility(View.VISIBLE);
            binding.postImg.setImageURI(postImgUri);
        }

    }

    private void allSpeener() {




        String[] allJelaName = {
                "কুমিল্লা",
                "ফেনী",
                "ব্রাহ্মণবাড়িয়া",
                "রাঙ্গামাটি",
                "নোয়াখালী",
                "চাঁদপুর",
                "লক্ষ্মীপুর",
                "চট্টগ্রাম",
                "কক্সবাজার",
                "খাগড়াছড়ি",
                "বান্দরবান",
                "সিরাজগঞ্জ",
                "পাবনা",
                "বগুড়া",
                "রাজশাহী",
                "নাটোর", "জয়পুরহাট", "চাঁপাইনবাবগঞ্জ","নওগাঁ", "যশোর", "সাতক্ষীরা","মেহেরপুর", "নড়াইল", "চুয়াডাঙ্গা","কুষ্টিয়া", "মাগুরা", "খুলনা",
                "বাগেরহাট", "ঝিনাইদহ", "ঝালকাঠি","পটুয়াখালী", "বরিশাল", "ভোলা","বরগুনা", "সিলেট", "মৌলভীবাজার","হবিগঞ্জ", "সুনামগঞ্জ", "নরসিংদী",
                "গাজীপুর", "শরীয়তপুর", "নারায়ণগঞ্জ","টাঙ্গাইল", "কিশোরগঞ্জ", "মানিকগঞ্জ","ঢাকা", "মুন্সিগঞ্জ", "রাজবাড়ী","মাদারীপুর", "গোপালগঞ্জ", "ফরিদপুর",
                "পঞ্চগড়", "দিনাজপুর", "লালমনিরহাট","নীলফামারী", "গাইবান্ধা", "ঠাকুরগাঁও","রংপুর", "কুড়িগ্রাম", "শেরপুর","ময়মনসিংহ", "জামালপুর", "নেত্রকোণা",
        };

        ArrayAdapter<String> jelaNameAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_dropdown_item_1line,
                allJelaName);
        binding.jelaName.setAdapter(jelaNameAdapter);




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




    }
}