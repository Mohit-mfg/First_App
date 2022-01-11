package com.example.first;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.first.databinding.ActivityHelpBinding;

public class Help extends AppCompatActivity {
    ActivityHelpBinding binding;
    Context context=Help.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHelpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.dialId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.ll2.setVisibility(View.VISIBLE);
                binding.ll3.setVisibility(View.GONE);




            }
        });

        binding.emaiId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.ll2.setVisibility(View.GONE);
                binding.ll3.setVisibility(View.VISIBLE);

//                Intent email = new Intent(Intent.ACTION_SEND);
//                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ binding.etEmailId.getText().toString()});
//                email.putExtra(Intent.EXTRA_SUBJECT, binding.etSubjectId.getText().toString());
//                email.putExtra(Intent.EXTRA_TEXT, binding.etMessageId.getText().toString());
//
//                startActivity(Intent.createChooser(email, "Choose an Email client :"));

//                Intent email = new Intent(Intent.ACTION_SEND);
//                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
//                email.putExtra(Intent.EXTRA_SUBJECT, subject);
//                email.putExtra(Intent.EXTRA_TEXT, message);
//
//                //need this to prompts email client only
//                email.setType("message/rfc822");
//
//                startActivity(Intent.createChooser(email, "Choose an Email client :"));

            }
        });

        binding.aboutId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.ll2.setVisibility(View.GONE);
                binding.ll3.setVisibility(View.GONE);

                Intent intent= new Intent(context, WebView.class);
                startActivity(intent);

//                Intent intent=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.calculator.net/bmi-calculator.html"));
//                startActivity(intent);
                Toast.makeText(context, "help", Toast.LENGTH_SHORT).show();

            }
        });


        binding.callId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String s=binding.etDialId.getText().toString();

                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle("Alert Dialog box Call");
                builder.setMessage("Please choose Call or Dial");
                builder.setPositiveButton("Call", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+binding.etDialId.getText().toString()));
                        startActivity(intent);

                        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                            startActivity(intent);
                        }else {
                            ActivityCompat.requestPermissions(Help.this, new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                        }
                    }
                });

                builder.setNegativeButton("Dial", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {


                        Intent intent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+binding.etDialId.getText().toString()));
                        startActivity(intent);

                        if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                            startActivity(intent);
                        }else {
                            ActivityCompat.requestPermissions(Help.this, new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                        }
                    }
                });
                builder.show();


//                Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+binding.etDialId.getText().toString()));
//                startActivity(intent);


//                if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
//                    startActivity(intent);
//                }else {
//                    ActivityCompat.requestPermissions(Help.this, new String[]{Manifest.permission.CALL_PHONE, Manifest.permission.ACCESS_FINE_LOCATION}, 1);
//                }



            }
        });


        binding.sendId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                Intent email = new Intent(Intent.ACTION_SEND);
//                email.putExtra(Intent.EXTRA_EMAIL, new String[]{ binding.etEmailId.getText().toString()});
//                email.putExtra(Intent.EXTRA_SUBJECT, binding.etSubjectId.getText().toString());
//                email.putExtra(Intent.EXTRA_TEXT, binding.etMessageId.getText().toString());
//
//                startActivity(Intent.createChooser(email, "Choose an Email client :"));

//
//                Intent email = new Intent(Intent.ACTION_SENDTO,Uri.parse("mailto:"+binding.etEmailId.getText().toString()));
//                email.putExtra(Intent.EXTRA_SUBJECT, binding.etSubjectId.getText().toString());
//                email.putExtra(Intent.EXTRA_TEXT, binding.etMessageId.getText().toString());
//                startActivity(email);


//                public void composeEmail(String[] addresses, String subject) {
                    Intent intent = new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    intent.putExtra(Intent.EXTRA_EMAIL, binding.etEmailId.getText().toString());
                    intent.putExtra(Intent.EXTRA_SUBJECT, binding.etSubjectId.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, binding.etMessageId.getText().toString());
                    if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
//                }


            }
        });


    }
}