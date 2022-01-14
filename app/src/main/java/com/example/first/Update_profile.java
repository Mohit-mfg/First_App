package com.example.first;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first.databinding.ActivityUpdateProfileBinding;
import com.example.first.utility.Constants;

public class Update_profile extends AppCompatActivity {
private ActivityUpdateProfileBinding binding;
SharedPreferences preferences;
SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences= getSharedPreferences("Profile Details", MODE_PRIVATE);


        binding.etNameId.setText(preferences.getString(Constants.NAME,null));
        binding.etEmaiId.setText(preferences.getString(Constants.Email,null));
        binding.etMobNumber.setText(preferences.getString(Constants.PHONE_NO,null));

    }
}