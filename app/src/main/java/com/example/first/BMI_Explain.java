package com.example.first;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

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
                binding.tvTextId1.setVisibility(View.GONE);
                binding.tvTextId2.setText("Normal weight is the desired or optimal weight of a person. It depends on age and gender. You have reason to rejoice when your body mass index as a woman is between 19 and 24 and between 20 and 25 for a man, respectively. This means that your weight and your height are in harmony. In terms of your diet and health, you have largely made the right decisions. A balanced diet and enough exercise will help you maintain your ideal weight.\n" +
                        "If you already do a lot of sports, are in shape, and have a high percentage of muscle mass, it is possible that your calculated BMI falls into the group of overweight. In this case, it is better to focus on the percentage of body fat. Targeting your body fat percentage is also helpful at a normal weight. Overweight women and men can lose weight relatively quickly in the form of water excreted from the body with express diets. But weight loss can also occur with muscle loss. This can have negative consequences when too little body fat is broken down at the same time When you lose weight, you should first of all be careful to maintain or increase your muscle mass and, at best, to break down fat.");
                binding.ll3.setBackgroundColor(Color.parseColor("#7E85C36F"));
//
//                Intent intent= new Intent(context,Normal.class);
//                        startActivity(intent);
            }
        });
        binding.btnObese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvTextId1.setVisibility(View.GONE);
                binding.tvTextId2.setText("Overweight is divided into three stages: overweight (BMI in women is between 24 and 30, and in men - between 25 and 30), obesity (BMI in men and women is between 30 and 40), and severe obesity (BMI). in men and women it is over 40). To get a better idea of the type of your overweight, you should consult your doctor. Along with it, analyze the composition of your body by the percentage of fat, muscle and water.\n" +
                        "Overweight calculated by BMI does not necessarily mean that it is unhealthy or that the body is out of shape. Both men and women who train strength sports and have a high percentage of muscle mass can, as we have already explained in the section on normal weight, fall into the group of overweight.");
                binding.ll3.setBackgroundColor(Color.parseColor("#D2E85F5F"));
//                Intent intent= new Intent(context,Obese.class);
//                startActivity(intent);
            }
        });
        binding.btnOverWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvTextId1.setVisibility(View.GONE);
                binding.tvTextId2.setText("Overweight is divided into three stages: overweight (BMI in women is between 24 and 30, and in men - between 25 and 30), obesity (BMI in men and women is between 30 and 40), and severe obesity (BMI). in men and women it is over 40). To get a better idea of the type of your overweight, you should consult your doctor. Along with it, analyze the composition of your body by the percentage of fat, muscle and water.\n" +
                        "Overweight calculated by BMI does not necessarily mean that it is unhealthy or that the body is out of shape. Both men and women who train strength sports and have a high percentage of muscle mass can, as we have already explained in the section on normal weight, fall into the group of overweight.");
                binding.ll3.setBackgroundColor(Color.parseColor("#BADFD364"));

//                Intent intent= new Intent(context,Over_weight.class);
//                startActivity(intent);
            }
        });
        binding.btnUnderWeight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.tvTextId1.setVisibility(View.GONE);
                binding.tvTextId2.setText("Being underweight is just as unhealthy for the human body as being overweight. Women are underweight if their BMI is below 19, and men are under 20. The reasons for being underweight can be different. If it is caused by voluntary deprivation of food (anorexia) or forced vomiting (bulimia), you may need to consult a doctor. These eating disorders affect both men and women of all ages. In many cases, help from the social environment and professionals is needed to change eating habits and perceptions.\n" +
                        "Other causes of underweight include metabolic diseases, such as hyperthyroidism or diabetes, inflammatory bowel disease, such as Crohn's disease, food intolerances, or liver disease. Mental factors, such as stress, can also lead to decreased appetite and subsequently underweight.");
                binding.ll3.setBackgroundColor(Color.parseColor("#CBAAD4F4"));

//                Intent intent= new Intent(context,Under_weight.class);
//                startActivity(intent);
            }
        });
    }
}