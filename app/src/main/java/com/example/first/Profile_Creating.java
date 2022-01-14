package com.example.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first.databinding.ActivityProfileCreatingBinding;
import com.example.first.utility.Constants;

public class Profile_Creating extends AppCompatActivity {
private ActivityProfileCreatingBinding binding;
public SharedPreferences sharedPreferences;
public SharedPreferences.Editor editor;

Context context=Profile_Creating.this;
int create_check;




    int s_check;

    String unit[]=new String[]{"Metric Units","US Units"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfileCreatingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        sharedPreferences= getSharedPreferences("Profile Details", MODE_PRIVATE);

        create_check=sharedPreferences.getInt(Constants.CHECK,0);

        Toast.makeText(context,String.valueOf(create_check), Toast.LENGTH_SHORT).show();


        ArrayAdapter<String> adapter=new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,unit);
        binding.spinerId.setAdapter(adapter);

        binding.spinerId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                s_check=Integer.valueOf(String.valueOf(adapterView.getItemIdAtPosition(i)));
//                Toast.makeText(context,String.valueOf(s_check), Toast.LENGTH_SHORT).show();



            }




            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        if(create_check==1){
            binding.llCreateId.setVisibility(View.GONE);
            binding.llUpdateId.setVisibility(View.VISIBLE);


        }else {
            binding.llUpdateId.setVisibility(View.GONE);
            binding.llCreateId.setVisibility(View.VISIBLE);

        }


        binding.createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,Profile.class));

            }
        });

        binding.updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,Update_profile.class));

            }
        });
    }
}