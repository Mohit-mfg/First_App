package com.example.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first.databinding.ActivityUpdateProfileBinding;
import com.example.first.utility.Constants;

public class Update_profile extends AppCompatActivity {
private ActivityUpdateProfileBinding binding;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    Context context =Update_profile.this;
    Boolean detail_check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityUpdateProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences= getSharedPreferences("Profile Details", MODE_PRIVATE);
        editor = preferences.edit();


        binding.etNameId.setText(preferences.getString(Constants.NAME,null));
        binding.etEmaiId.setText(preferences.getString(Constants.Email,null));
        binding.etMobNumber.setText(preferences.getString(Constants.PHONE_NO,null));

//        name=binding.etNameId.getEditableText().toString();
//        email=binding.etEmaiId.getEditableText().toString();
//        mob_number=binding.etMobNumber.getEditableText().toString();


        binding.btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(binding.etNameId.getEditableText().toString().isEmpty()||binding.etNameId.getEditableText().toString().equals(null)){

                    Toast.makeText(context, "Please check name", Toast.LENGTH_SHORT).show();

                }
                else if(binding.etEmaiId.getEditableText().toString().isEmpty()||binding.etEmaiId.getEditableText().toString().equals(null)){
                    Toast.makeText(context, "Please check email", Toast.LENGTH_SHORT).show();

                }
                else if(binding.etMobNumber.getEditableText().toString().isEmpty()||binding.etMobNumber.getEditableText().toString().equals(null)){
                    Toast.makeText(context, "Please check Number", Toast.LENGTH_SHORT).show();

                }
                else {

                editor.putString(Constants.NAME,binding.etNameId.getEditableText().toString());
                editor.putString(Constants.Email,binding.etEmaiId.getEditableText().toString());
                editor.putString(Constants.PHONE_NO,binding.etMobNumber.getEditableText().toString());
                editor.putInt(Constants.CHECK,1);
                detail_check=editor.commit();

                if(detail_check){

                    Toast.makeText(context, "Profile Update Sucessful", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(context,Profile_Creating.class));
                    finish();

                }
                else {

                    Toast.makeText(context, "Profile Update Fail", Toast.LENGTH_SHORT).show();
                }
            }
            }
        });


    }
}