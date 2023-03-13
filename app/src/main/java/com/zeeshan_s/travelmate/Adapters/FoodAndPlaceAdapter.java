package com.zeeshan_s.travelmate.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.zeeshan_s.travelmate.Fragment.FoodListFragment;
import com.zeeshan_s.travelmate.Fragment.PlaceListFragment;

public class FoodAndPlaceAdapter extends FragmentPagerAdapter {
    String [] name={"Places","Foods"};

    public FoodAndPlaceAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PlaceListFragment();
            case 1:
                return new FoodListFragment();
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
