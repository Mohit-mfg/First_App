package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.first.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
private ActivityMain2Binding binding;
Context context=MainActivity2.this;
String height,weight,gender,result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent=getIntent();
        binding.heightId.setText((intent.getStringExtra("height"))+" cm");
        binding.weightId.setText((intent.getStringExtra("weight"))+" kg");
        binding.bmiResult.setText(intent.getStringExtra("str_result"));
        binding.genderId.setText(intent.getStringExtra("gender"));




    }
}