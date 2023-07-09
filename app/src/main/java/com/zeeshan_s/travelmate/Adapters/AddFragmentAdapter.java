package com.zeeshan_s.travelmate.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zeeshan_s.travelmate.Fragment.AddFoodFragment;
import com.zeeshan_s.travelmate.Fragment.AddPlaceFragment;

public class AddFragmentAdapter extends FragmentPagerAdapter {
   public String [] name ={"Add Place","Add Food"};

    public AddFragmentAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new AddPlaceFragment();
            case 1:
                return new AddFoodFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return name.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return name[position];
    }
}
