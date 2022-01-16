package com.example.first;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.first.databinding.ActivityProfileBinding;
import com.example.first.utility.Constants;

public class Profile extends AppCompatActivity {

    private ActivityProfileBinding binding;
    Context context=Profile.this;
    String name,email,mob_number;
    Boolean detail_check;


    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        preferences = getSharedPreferences("Profile Details", MODE_PRIVATE);
        editor = preferences.edit();

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=binding.etNameId.getEditableText().toString();
                email=binding.etEmaiId.getEditableText().toString();
                mob_number=binding.etMobNumber.getEditableText().toString();

                if(name.isEmpty()){
                    Toast.makeText(context, "Please check name", Toast.LENGTH_SHORT).show();
                }
                else if(email.isEmpty()){
                    Toast.makeText(context, "Please check email", Toast.LENGTH_SHORT).show();

                }
                else if(mob_number.isEmpty()){
                    Toast.makeText(context, "Please check Number", Toast.LENGTH_SHORT).show();

                }
            else {
                    editor.putString(Constants.NAME, name);
                    editor.putString(Constants.Email, email);
                    editor.putString(Constants.PHONE_NO, mob_number);
                    editor.putInt(Constants.CHECK, 1);
                    detail_check = editor.commit();
                    if (detail_check) {

                        Toast.makeText(context, "Profile Create Sucessful", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(context, Profile_Creating.class));
                        finish();
                    } else {

                        Toast.makeText(context, "Profile Create Fail", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });




    }
}