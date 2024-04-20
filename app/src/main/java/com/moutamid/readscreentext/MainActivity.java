package com.moutamid.readscreentext;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.moutamid.readscreentext.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Constants.checkApp(this);

        binding.btn.setOnClickListener(v -> {
            if (!Constants.isAccessibilityServiceEnabled(this, getPackageName() + "/.ReadService")) {
                Constants.openAccessibilitySettings(this);
            }
        });

    }
}