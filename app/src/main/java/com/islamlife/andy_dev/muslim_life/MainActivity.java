package com.islamlife.andy_dev.muslim_life;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public MainActivity() throws Exception {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context c= this;
        try {
            SalahData obj= new SalahData(c);
        } catch (Exception e) {
            e.printStackTrace();
        }
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate= df.format(cal.getTime());
            TextView txtView = (TextView) findViewById(R.id.textView2);
            txtView.setText(formattedDate);
    }
    }
