package com.example.kr_by_belek;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.DataOutputStream;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Spinner date, month, year, sex;
    Button btnDone;
    EditText etDown, etUp;


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

        etDown = findViewById(R.id.pulse_1);
        etUp = findViewById(R.id.pulse_2);

        date = findViewById(R.id.spinnerDay);
        month = findViewById(R.id.spinnerMonth);
        year = findViewById(R.id.spinnerYear);
        sex = findViewById(R.id.spinnerSex);
        btnDone = findViewById(R.id.mainButton);
        btnDone.setOnClickListener(this);

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

        date.setAdapter(adapter_day);
        month.setAdapter(adapter_month);
        year.setAdapter(adapter_year);
        sex.setAdapter(adapter_pol);



}
    private int sendPost(String[] params) throws Exception {

        String url = "http://abashin.ru/cgi-bin/ru/tests/burnout";
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

        String urlParameters = "day="+params[0]+"&month="+params[1]+"&year="+params[2] +
                "&sex="+params[3]+"&m1="+params[4]+"&m2="+params[5];
//        urlParameters="day=15&month=12&year=1990&sex=1&m1=55&m2=77";

//        System.out.println(urlParameters);

        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(urlParameters);
        wr.flush();
        wr.close();


        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        String strResponse = response.toString();
        // Распечатываем результат
        int retValue = -1;
        if (strResponse.contains("отсутствию переутомления")) {
            retValue = (int) Math.random() * (101-66) +67;
        } else if (strResponse.contains("небольшому переутомлению")) {
            retValue = (int) Math.random() * (67-33) +34;
        } else if (strResponse.contains("высокому уровню переутомления")) {
            retValue = (int) Math.random() * 34;
        } else {}
        System.out.println(response.toString());
        return retValue;

    }





    @Override
    public void onClick(View view) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int fatigue = -1;
                String dayy = date.getSelectedItem().toString();
                String mon = month.getSelectedItem().toString();
                String yearr = year.getSelectedItem().toString();
                String sexx = sex.getSelectedItem().toString();
                if (sexx == "М"){
                    sexx = "1";
                } else {
                    sexx = "2";
                }
                String m1 = etDown.getText().toString();
                String m2 = etUp.getText().toString();
                String[] params = new String[] {dayy, mon, yearr, sexx, m1, m2};
                try  {
                    fatigue = sendPost(params);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                Intent results = new Intent("com.example.kr_by_belek.action.MainActivity2");
                results.putExtra("indicator", fatigue);
                startActivity(results);

            }
        });
        thread.start();
    }
}