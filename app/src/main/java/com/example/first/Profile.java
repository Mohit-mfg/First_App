package com.example.first;

import android.content.Context;
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
    int p_check;

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

                editor.putString(Constants.NAME,name);
                editor.putString(Constants.Email,email);
                editor.putString(Constants.PHONE_NO,mob_number);
                editor.putInt(Constants.CHECK,1);
                detail_check=editor.commit();
                if(detail_check){
                    p_check=1;
                Toast.makeText(context, "Profile Create Sucessful", Toast.LENGTH_SHORT).show();}
                else {
                    p_check=0;
                    Toast.makeText(context, "Profile Create Fail", Toast.LENGTH_SHORT).show();
                }


            }
        });




    }
}