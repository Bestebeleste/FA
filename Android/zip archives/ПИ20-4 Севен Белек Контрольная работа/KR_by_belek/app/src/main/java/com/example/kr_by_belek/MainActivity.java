package com.example.kr_by_belek;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Spinner day, month, year, sex;
    EditText pulse_1, pulse_2;
    Button mainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> days = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            days.add(Integer.toString(i));
        }

        ArrayList<String> years = new ArrayList<String>();
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1900; i <= thisYear; i++) {
            years.add(Integer.toString(i));
        }

        String[] months = new String[] { "Январь", "Февраль",
                "Март", "Апрель", "Май", "Июнь", "Июль", "Август", "Сентябрь",
                "Октябрь", "Ноябрь", "Декабрь" };

        String[] sexes = new String[] { "М", "Ж" };

        day = (Spinner) findViewById(R.id.spinnerDay);
        month = (Spinner) findViewById(R.id.spinnerMonth);
        year = (Spinner) findViewById(R.id.spinnerYear);
        sex = (Spinner) findViewById(R.id.spinnerSex);

        pulse_1 = (EditText) findViewById(R.id.pulse_1);
        pulse_1.setTransformationMethod(null);
        pulse_2 = (EditText) findViewById(R.id.pulse_2);
        pulse_2.setTransformationMethod(null);

        mainBtn = (Button) findViewById(R.id.mainButton);
        mainBtn.setOnClickListener(this::OnClick);

        ArrayAdapter<String> adapter_day = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, days);
        adapter_day.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter_month = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, months);
        adapter_month.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter_year = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, years);
        adapter_year.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        ArrayAdapter<String> adapter_pol = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, sexes);
        adapter_pol.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        day.setAdapter(adapter_day);
        month.setAdapter(adapter_month);
        year.setAdapter(adapter_year);
        sex.setAdapter(adapter_pol);

        day.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        month.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });

        sex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            public void onNothingSelected(AdapterView<?> adapterView) {
                return;
            }
        });
    }

    public void OnClick(View v){
        Intent intent = new Intent(this, MainActivity2.class);

        if( pulse_1.getText().toString().equals("") || pulse_2.getText().toString().equals("")){
            Toast toast =  Toast.makeText(MainActivity.this,
                    "Заполните пустые поля!", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();
        }
        else{
            startActivity(intent);}
    }


}