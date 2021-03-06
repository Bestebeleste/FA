package com.example.kr_by_belek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    TextView status;
    ImageView emoji;
    ProgressBar stressLvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        emoji = (ImageView) findViewById(R.id.resultImage);
        status = (TextView) findViewById(R.id.resultTxt);
        stressLvl = (ProgressBar) findViewById(R.id.progressBar);

            int indicator = getIntent().getIntExtra("indicator",0);

        Toast toast =  Toast.makeText(MainActivity2.this,
                indicator, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
            status.setText("Введенные значения соответствуют отсутствию переутомления.");
            emoji.setImageResource(R.drawable.ok);
            stressLvl.setProgress(indicator);

        }

    }