package com.zeeshan_s.travelmate.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.zeeshan_s.travelmate.R;
import com.zeeshan_s.travelmate.databinding.ActivityFragmentViewerBinding;

public class FragmentViewerActivity extends AppCompatActivity {
ActivityFragmentViewerBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fragment_viewer);
    }
}