package com.example.first;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    EditText et_weight,et_height;
    Button btn_Submit;
    TextView tv_Result,tv_show_details;
    String str,str_result,gender;
   Context context=MainActivity.this;
   int check=0;

   RadioGroup radioGroup;

    float weight ,height,result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DecimalFormat decimalFormat = new DecimalFormat("0.0");

        et_weight=findViewById(R.id.et_weight);
        et_height=findViewById(R.id.et_height);
        btn_Submit=findViewById(R.id.btn_submit);
        tv_Result=findViewById(R.id.tv_result);
        tv_show_details=findViewById(R.id.tv_detail);

        radioGroup=findViewById(R.id.radio_group);

        radioGroup.setOnCheckedChangeListener(this);


        registerForContextMenu(btn_Submit);



        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                if(et_height.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "please check height", Toast.LENGTH_SHORT).show();
                }
                else if(et_weight.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "please check weight", Toast.LENGTH_SHORT).show();
                }
                else if(check==0){

                    Toast.makeText(context, "please check Gender", Toast.LENGTH_SHORT).show();



                }
                else {
                    height= Float.parseFloat(et_height.getText().toString());
                    weight= Float.parseFloat(et_weight.getText().toString());
                    height = height / 100;

                    result = weight / (height * height);

                    if (result <18.5){
                        str="Under Weight";
                    }
                    else if(result >= 18.5 && result <=25 ){
                        str="Normal";
                    }
                    else if(result >= 25 && result <=30 ){
                        str="Over Weight";
                    }
                    else {
                        str="Obese";
                    }

                    tv_Result.setText(String.valueOf(decimalFormat.format(result))+"   "+str);
                      str_result=(String.valueOf(decimalFormat.format(result))+"   "+str);
                    tv_Result.setVisibility(View.VISIBLE);

                    tv_show_details.setVisibility(View.VISIBLE);
                }
            }
        });



        tv_show_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(context,MainActivity2.class);
                intent.putExtra("height",et_height.getText().toString());
                intent.putExtra("weight",et_weight.getText().toString());
                intent.putExtra("str_result",str_result);
                intent.putExtra("gender",gender);
                startActivity(intent);

            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.menu_items,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bmi_explain_id:
//                Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,BMI_Explain.class);
                startActivity(intent);
                break;
            case R.id.bmi_chart_id:
                Intent intent_2=new Intent(context,BMI_Chart.class);
                startActivity(intent_2);
//                Toast.makeText(MainActivity.this, "Graph", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help_id:
                Toast.makeText(MainActivity.this, "Help", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_items,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.bmi_explain_id:
                Toast.makeText(MainActivity.this, "About", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(context,BMI_Explain.class);
                startActivity(intent);
                break;
            case R.id.bmi_chart_id:
                Intent intent_2=new Intent(context,BMI_Chart.class);
                startActivity(intent_2);
                Toast.makeText(MainActivity.this, "Graph", Toast.LENGTH_SHORT).show();
                break;
            case R.id.help_id:
                Toast.makeText(MainActivity.this, "Help", Toast.LENGTH_SHORT).show();
                break;
        }

        return super.onContextItemSelected(item);
    }



    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        int id=radioGroup.getCheckedRadioButtonId();
        RadioButton radioButton=findViewById(id);
        if(radioButton.getText().toString().isEmpty()){
            check=0;
        }
        else {
            check=1;
        }

        gender=radioButton.getText().toString();
        Toast.makeText(context, radioButton.getText().toString(), Toast.LENGTH_SHORT).show();


    }
}