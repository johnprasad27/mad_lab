package com.example.studentregistration;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.content.Intent;
import android.view.View;
import android.widget.*;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText name,roll;
        Spinner course;
        Button register;

        name = findViewById(R.id.name);
        roll = findViewById(R.id.roll);
        course = findViewById(R.id.course);
        register = findViewById(R.id.register);

        String courses[] ={"Select Course", "MCA", "MBA", "BCA", "BSc"};
        ArrayAdapter<String>adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item,
                courses
        );
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}