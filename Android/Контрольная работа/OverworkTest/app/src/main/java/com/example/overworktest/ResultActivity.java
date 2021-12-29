package com.example.overworktest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView resultTextView;
    ProgressBar progressBar;
    ImageView resultImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        resultImg = findViewById(R.id.resultImage);
        resultTextView = findViewById(R.id.resultTxt);
        progressBar = findViewById(R.id.progressBar);

        Intent intent = getIntent();
        int result = intent.getIntExtra("result", MainActivity.ERROR);
        if (result == MainActivity.GOOD) {
            resultTextView.setText("Введенные значения соответствуют отсутствию переутомления.");
            progressBar.setProgress(90);
            resultImg.setImageResource(R.drawable.goo);

        } else if (result == MainActivity.MEDIUM) {
            resultTextView.setText("Введенные значения соответствуют небольшому переутомлению. Рекомендуется снижение нагрузки.");
            progressBar.setProgress(60);
            resultImg.setImageResource(R.drawable.okey);
        } else if (result == MainActivity.BAD){
            resultTextView.setText("Введенные значения соответствуют высокому уровню переутомления. Рекомендуется снижение нагрузки или отпуск.");
            progressBar.setProgress(30);
            resultImg.setImageResource(R.drawable.bad);
        } else {
            resultTextView.setText("Произошла ошибка. Вероятно, Вы ввели некорректные значения.");
        }
    }
}