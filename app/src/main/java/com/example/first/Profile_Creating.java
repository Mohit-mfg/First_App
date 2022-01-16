package com.example.first;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.first.databinding.ActivityProfileCreatingBinding;
import com.example.first.utility.Constants;



public class Profile_Creating extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener{


private ActivityProfileCreatingBinding binding;
public SharedPreferences sharedPreferences;
public SharedPreferences.Editor editor;

    Context context=Profile_Creating.this;
    int create_check;
    Boolean detail_check;
    RadioGroup radioGroup;
    int s_check;
    int gender_check=0;
    String gender;


    String unit[]=new String[]{"Metric Units","US Units"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfileCreatingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        radioGroup=findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(this);

        sharedPreferences= getSharedPreferences("Profile Details", MODE_PRIVATE);
        editor=sharedPreferences.edit();

        create_check=sharedPreferences.getInt(Constants.CHECK,0);

//        Toast.makeText(context,String.valueOf(create_check), Toast.LENGTH_SHORT).show();


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


        binding.relativeLayoutId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard(view);
            }
        });

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

        binding.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString(Constants.NAME,null);
                editor.putString(Constants.Email,null);
                editor.putString(Constants.PHONE_NO,null);
                editor.putInt(Constants.CHECK,0);
                detail_check=editor.commit();

                if(detail_check){

                    binding.llUpdateId.setVisibility(View.GONE);
                    binding.llCreateId.setVisibility(View.VISIBLE);

                    Toast.makeText(context, "Profile Delete Sucessful", Toast.LENGTH_SHORT).show();}
                else {

                    Toast.makeText(context, "Profile Delete Fail", Toast.LENGTH_SHORT).show();}
            }
        });

        binding.continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Skip_Continue();

            }
        });

        binding.skipBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Skip_Continue();

            }
        });



    }
    public void Skip_Continue(){
        if(gender_check==0){

                    Toast.makeText(context, "please check Gender", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent=new Intent(context,MainActivity.class);
            intent.putExtra("s_check",String.valueOf(s_check));
            intent.putExtra("gender_check",gender_check);
            intent.putExtra("gender",gender);



            startActivity(intent);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int id=radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton=findViewById(id);
        if(radioButton.getText().toString().isEmpty()){
            gender_check=0;
        }
        else {
            gender_check=1;
        }

        hideSoftKeyboard(this.getCurrentFocus());

        gender=radioButton.getText().toString();
//        Toast.makeText(context, radioButton.getText().toString(), Toast.LENGTH_SHORT).show();

    }
    public void hideSoftKeyboard(View view) {
        if (view == null) {
            view = this.getCurrentFocus();
        }
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (inputMethodManager != null) {
            if (view != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }

    public void onBackPressed() {


        // super.onBackPressed();
        AlertDialog.Builder builder=new AlertDialog.Builder(context);
        builder.setTitle("Alert Dialog Box");
        builder.setMessage("Do You want to Exit");
        builder.setCancelable(false);

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {




            }
        });
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                cancel();

            }
        });

        builder.show();
    }

    private void cancel() {
        super.onBackPressed();
    }
}