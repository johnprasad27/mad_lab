package com.example.scrollview;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        LinearLayout linearLayout =
                findViewById(R.id.linearLayoutContainer);

        for (int i = 1; i <= 20; i++) {

            TextView textView = new TextView(this);

            textView.setText("TextView " + i);

            textView.setTextSize(45);

            textView.setPadding(16, 16, 16, 16);

            linearLayout.addView(textView);
        }
    }
}