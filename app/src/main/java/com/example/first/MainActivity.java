package com.example.first;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.first.databinding.ActivityMainBinding;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity  {

    ActivityMainBinding binding;

    EditText et_weight,et_height;
    Button btn_Submit;
    TextView tv_Result,tv_show_details;
    String str,str_result,gender;
   Context context=MainActivity.this;

   int s_check;


    float weight ,height,result;
    double feet,inches,pound,rslt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        Intent intent=getIntent();
         s_check=Integer.valueOf(intent.getStringExtra("s_check"));
         gender=intent.getStringExtra("gender");


//        Toast.makeText(context,String.valueOf(s_check), Toast.LENGTH_SHORT).show();

//        ArrayAdapter<String> adapter=new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,unit);
//        binding.spinerId.setAdapter(adapter);
//
//        binding.spinerId.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//
//                s_check=Integer.valueOf(String.valueOf(adapterView.getItemIdAtPosition(i)));
//                Toast.makeText(context,String.valueOf(s_check), Toast.LENGTH_SHORT).show();
//                changeunit();
//
//
//            }
//
//
//
//
//            @Override
//            public void onNothingSelected(AdapterView<?> adapterView) {
//
//            }
//        });


        DecimalFormat decimalFormat = new DecimalFormat("0.0");

        et_weight=findViewById(R.id.et_weight);
        et_height=findViewById(R.id.et_height);
        btn_Submit=findViewById(R.id.btn_submit);
        tv_Result=findViewById(R.id.tv_result);
        tv_show_details=findViewById(R.id.tv_detail);

//        radioGroup=findViewById(R.id.radio_group);
//
//        radioGroup.setOnCheckedChangeListener(this);


        registerForContextMenu(btn_Submit);

        changeunit();


        binding.relativeLayoutId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideSoftKeyboard(view);
            }
        });


        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                hideSoftKeyboard(view);

                if(s_check==0){


                if(et_height.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "please check height", Toast.LENGTH_SHORT).show();
                }
                else if(et_weight.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "please check weight", Toast.LENGTH_SHORT).show();
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
                else if(s_check==1){
                    if(binding.etFeetId.getText().toString().isEmpty()||binding.etInchId.getText().toString().isEmpty()){
                        Toast.makeText(MainActivity.this, "please check height", Toast.LENGTH_SHORT).show();
                    }
                    else if(binding.etPoundId.getText().toString().isEmpty()){
                        Toast.makeText(MainActivity.this, "please check weight", Toast.LENGTH_SHORT).show();
                    }

                    else {
                        pound=Float.parseFloat(binding.etPoundId.getText().toString());
                        feet=Float.parseFloat(binding.etFeetId.getText().toString());
                        inches=((Float.parseFloat(binding.etInchId.getText().toString()))/12);
                        feet=feet+inches;
                        Toast.makeText(context, String.valueOf(feet), Toast.LENGTH_LONG).show();

                            pound=pound*0.453592;
                            feet=feet/3.281;
                            rslt=pound/(feet*feet);
                            result= (float) rslt;




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


            }
        });


        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(context,Profile_Creating.class));
                finish();
            }
        });

        tv_show_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent= new Intent(context, ShowDeatail.class);
                intent.putExtra("height",et_height.getText().toString());
                intent.putExtra("weight",et_weight.getText().toString());
                intent.putExtra("str_result",str_result);
                intent.putExtra("gender",gender);
                intent.putExtra("feet",binding.etFeetId.getText().toString()+"."+binding.etInchId.getText());
                intent.putExtra("pound",binding.etPoundId.getText().toString());
                intent.putExtra("s_check",String.valueOf(s_check));
                startActivity(intent);

            }
        });



    }

    private void changeunit() {

        if(s_check==0){
            binding.metricUinitLl.setVisibility(View.VISIBLE);
            binding.usUinitLl.setVisibility(View.GONE);

        }

        else if(s_check==1) {
            binding.metricUinitLl.setVisibility(View.GONE);
            binding.usUinitLl.setVisibility(View.VISIBLE);

        }

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
                Intent intent_3=new Intent(context,Help.class);
                startActivity(intent_3);
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

}