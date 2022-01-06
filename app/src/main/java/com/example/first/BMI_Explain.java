package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.first.databinding.ActivityBmiExplainBinding;

public class BMI_Explain extends AppCompatActivity {
private ActivityBmiExplainBinding binding;
Context context = BMI_Explain.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       binding= ActivityBmiExplainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,Normal.class);
                        startActivity(intent);
            }
        });
        binding.btnObese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,Obese.class);
                startActivity(intent);
            }
        });
        binding.btnOverWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,Over_weight.class);
                startActivity(intent);
            }
        });
        binding.btnUnderWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(context,Under_weight.class);
                startActivity(intent);
            }
        });
    }
}