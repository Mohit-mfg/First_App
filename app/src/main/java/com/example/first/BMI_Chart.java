package com.example.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.example.first.databinding.ActivityBmiChartBinding;

public class BMI_Chart extends AppCompatActivity {

    private ActivityBmiChartBinding binding;
    Context context=BMI_Chart.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityBmiChartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}