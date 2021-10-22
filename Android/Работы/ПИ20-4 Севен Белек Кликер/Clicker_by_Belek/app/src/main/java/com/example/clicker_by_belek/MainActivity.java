package com.example.clicker_by_belek;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mainText;
    ImageButton plusButton;
    ImageButton minusButton;
    Button resetButton;
    String text;
    private long score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainText = (TextView) findViewById(R.id.mainTxt);
        plusButton = (ImageButton) findViewById(R.id.plusBtn);
        minusButton = (ImageButton) findViewById(R.id.minusBtn);
        resetButton = (Button) findViewById(R.id.resetBtn);
        OnClick();
    }
    void translate() {
        if (score % 10 == 2 || score % 10 == 3 || score % 10 == 4) {
            if (score % 100 < 10 || score % 100 > 20) {
                text = " раза";
            }
        } else {
            text = " раз";
        }
    }
    @SuppressLint("SetTextI18n")
    void OnClick(){
        plusButton.setOnClickListener(view -> {
            score++;
            translate();
            mainText.setText(score+text);
        });
        minusButton.setOnClickListener((view -> {
            if(score>0){
                score--;
                translate();
                mainText.setText(score+text);
            }
        }));
        resetButton.setOnClickListener((view -> {
            score=0;
            translate();
            mainText.setText(score+text);
        }));
    }


}