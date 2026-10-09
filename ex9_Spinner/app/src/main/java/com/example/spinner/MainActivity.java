package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Spinner s;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        s = findViewById(R.id.sp);
        t1 = findViewById(R.id.t1);

        ArrayList<String> al = new ArrayList<String>();

        al.add("mango");
        al.add("apple");
        al.add("pineapple");
        al.add("banana");

        ArrayAdapter<String> ad =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        al
                );

        s.setAdapter(ad);

        s.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        t1.setText(
                                "Selected Fruit: " + al.get(position)
                        );
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {

                        t1.setText("Select a Fruit !!!!");
                    }
                }
        );
    }
}