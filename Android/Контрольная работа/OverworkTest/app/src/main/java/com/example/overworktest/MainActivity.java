package com.example.overworktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static final int ERROR = -1;
    public static final int GOOD = 2;
    public static final int MEDIUM = 1;
    public static final int BAD = 0;

    EditText m1EditText, m2EditText;
    Spinner daySpinner, monthSpinner, yearSpinner, maleSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m1EditText = findViewById(R.id.pulse_1);
        m2EditText = findViewById(R.id.pulse_2);
        daySpinner = findViewById(R.id.SpinnerDay);
        monthSpinner = findViewById(R.id.spinnerMonth);
        yearSpinner = findViewById(R.id.spinnerYear);
        maleSpinner = findViewById(R.id.spinnerSex);

        ArrayList<String> days = new ArrayList<>();
        for (int day = 1; day <= 31; day++) {
            days.add(String.valueOf(day));
        }
        ArrayAdapter<String> dayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, days);
        daySpinner.setAdapter(dayAdapter);

        ArrayList<String> years = new ArrayList<>();
        for (int year = 2020; year >= 1910; year--) {
            years.add(String.valueOf(year));
        }
        ArrayAdapter<String> yearAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, years);
        yearSpinner.setAdapter(yearAdapter);
    }

    public void onClick(View view) {
        String m1 = m1EditText.getText().toString();
        String m2 = m2EditText.getText().toString();
        if (!m1.equals("") && !m2.equals("")) {
            String day = String.valueOf(daySpinner.getSelectedItem());
            String month = String.valueOf((monthSpinner.getSelectedItemPosition() + 1));
            String year = String.valueOf(yearSpinner.getSelectedItem());
            String male;
            if (maleSpinner.getSelectedItem().equals("М")) {
                male = "1";
            } else {
                male = "2";
            }

            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        String response = request(new String[] {day, month, year, male, m1, m2});
                        int result = ERROR;
                        if (response.contains("отсутствию")) {
                            result = GOOD;
                        } else if (response.contains("небольшому")) {
                            result = MEDIUM;
                        } else if (response.contains("высокому")) {
                            result = BAD;
                        }
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("result", result);
                        startActivity(intent);
                    } catch (Exception ignored) {
                    }
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
    }

    private String request(String[] postParameters) throws Exception {
        URL url = new URL("http://abashin.ru/cgi-bin/ru/tests/burnout");
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
        String body = String.format("day=%s&month=%s&year=%s&sex=%s&m1=%s&m2=%s", postParameters);
        urlConnection.setDoOutput(true);
        urlConnection.getOutputStream().write(body.getBytes());
        BufferedReader in = new BufferedReader(
                new InputStreamReader(urlConnection.getInputStream()));
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = in.readLine()) != null) {
            response.append(line);
        }
        urlConnection.disconnect();
        return response.toString();
    }

}