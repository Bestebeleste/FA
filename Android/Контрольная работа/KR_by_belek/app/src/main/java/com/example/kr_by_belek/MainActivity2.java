package com.example.kr_by_belek;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    TextView status;
    ImageView emoji;
    ProgressBar stressLvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle b = this.getIntent().getExtras();
        String[] getVal = b.getStringArray("values");

        emoji = (ImageView) findViewById(R.id.resultImage);
        status = (TextView) findViewById(R.id.resultTxt);
        stressLvl = (ProgressBar) findViewById(R.id.progressBar);

        int result = Math.abs(Integer.parseInt(getVal[0])-Integer.parseInt(getVal[1]));
        int indicator = (int) (100-(double) result/25*100);

        if (result<12 && result>=0){
            status.setText("Введенные значения соответствуют отсутствию переутомления.");
            emoji.setImageResource(R.drawable.ok);
            stressLvl.setProgress(100);
        }
        else  if (result<18 && result>13){
            status.setText("Введенные значения соответствуют небольшому переутомления. Рекомендуется снижение нагрузки.");
            emoji.setImageResource(R.drawable.not_bad);
            stressLvl.setProgress(75);
        }
        else  if (result<25 && result>18){
            status.setText("Введенные значения соответствуют высокому уровню переутомления. Рекомендуется снижение нагрузки или отпуск.");
            emoji.setImageResource(R.drawable.not_good);
            stressLvl.setProgress(indicator);
        }
        else {
            status.setText("Можно говорить либо о переутомлении, либо о заболевании сердечно-сосудистой системы или других проблемах со здоровьем.");
            emoji.setImageResource(R.drawable.sick);
            stressLvl.setProgress(0);
        }

    }
}