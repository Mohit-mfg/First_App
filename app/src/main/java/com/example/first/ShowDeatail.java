package com.example.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first.databinding.ActivityShowDeatailBinding;
import com.example.first.utility.Constants;

public class ShowDeatail extends AppCompatActivity {
private ActivityShowDeatailBinding binding;
Context context= ShowDeatail.this;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;



//String height,weight,gender,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityShowDeatailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        preferences= getSharedPreferences("Profile Details", MODE_PRIVATE);
        editor = preferences.edit();

        Intent intent=getIntent();

        Toast.makeText(context, intent.getStringExtra(Constants.NAME)+"name", Toast.LENGTH_SHORT).show();
        int s_check=Integer.valueOf(intent.getStringExtra("s_check"));
        if(s_check==0){

        binding.heightId.setText((intent.getStringExtra("height"))+" cm");
        binding.weightId.setText((intent.getStringExtra("weight"))+" kg");
        detail(intent);

        }
        else if(s_check==1){

            binding.heightId.setText((intent.getStringExtra("feet"))+" feet");
            binding.weightId.setText((intent.getStringExtra("pound"))+" pound");
            detail(intent);

        }




    }
    public void detail(Intent intent){

        if(preferences.getString(Constants.NAME,null)==null){

            binding.tvNameId.setText("null");
            binding.tvEmailId.setText("null");
            binding.tvPhoneNo.setText("null");

        }
        else {

            binding.tvNameId.setText(preferences.getString(Constants.NAME,null));
            binding.tvEmailId.setText(preferences.getString(Constants.Email,null));
            binding.tvPhoneNo.setText(preferences.getString(Constants.PHONE_NO,null));

             }
            binding.bmiResult.setText(intent.getStringExtra("str_result"));
            binding.genderId.setText(intent.getStringExtra("gender"));

    }
}