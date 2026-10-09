package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    Button bw, br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.text_status);
        bw = findViewById(R.id.btn_write);
        br = findViewById(R.id.btn_read);

        String usernamedemo = "demo1po";
        String emaildemo = "demo1@gmail.ou";

        SharedPreferences sp =
                getSharedPreferences("sp_abc", MODE_PRIVATE);

        // Write Data
        bw.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                SharedPreferences.Editor se = sp.edit();

                se.putString("username", usernamedemo);
                se.putString("email", emaildemo);

                se.apply();

                txt.setText("Written Data");
            }
        });

        // Read Data
        br.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String u, e;

                u = sp.getString("username", "");
                e = sp.getString("email", "");

                txt.setText(
                        "Username: " + u +
                                "\nEmail: " + e
                );
            }
        });
    }
}