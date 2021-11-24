package com.example.mainmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    CheckBox chb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.textView);
        chb = (CheckBox) findViewById(R.id.chbExtMenu);
    }

    public boolean onCreateOptionsMenu(Menu menu){
     menu.add(0, 1, 0, "add");
     menu.add(0, 2, 0, "edit");
     menu.add(0, 3, 3, "delete");
     menu.add(1, 4, 1, "copy");
     menu.add(1, 5, 2, "paste");
     menu.add(1, 6, 5, "exit");
     menu.add(1, 7, 4, "screenshot");

     return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        menu.setGroupVisible(1, chb.isChecked());
        return super.onPrepareOptionsMenu(menu);
    }

    public void onClickExit(){
        finish();
        System.exit(0);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        StringBuilder sb = new StringBuilder();

        if (item.getItemId()==6){
            onClickExit();
        }

        sb.append("item menu");
        sb.append("\r\n groupId " + String.valueOf(item.getGroupId()));
        sb.append("\r\n itemId " + String.valueOf(item.getItemId()));
        sb.append("\r\n order " + String.valueOf(item.getOrder()));
        sb.append("\r\n title " + String.valueOf(item.getTitle()));
        tv.setText(sb.toString());

        return super.onOptionsItemSelected(item);
    }

}