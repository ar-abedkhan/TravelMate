package com.zeeshan_s.travelmate.Fragment;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.FragmentAddBinding;

public class AddFragment extends Fragment {
    public AddFragment() {
    }

    FragmentAddBinding binding;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding=FragmentAddBinding.inflate(getLayoutInflater(),container,false);



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
        binding.subjectName.setAdapter(jelaNameAdapter);























        binding.backBtn.setOnClickListener(view -> {

            AppCompatActivity appCompatActivity= (AppCompatActivity) view.getContext();
            HomeFragment homeFragment=new HomeFragment();
            Bundle bundle=new Bundle();
            homeFragment.setArguments(bundle);

            appCompatActivity.getSupportFragmentManager().beginTransaction().replace(R.id.mainFrame,homeFragment).addToBackStack(null).commit();

        });

        return binding.getRoot();
    }
}