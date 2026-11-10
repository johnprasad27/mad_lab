package com.example.oino;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.*;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText name = findViewById(R.id.editTextText);
        Spinner movie = findViewById(R.id.spinner);
        RadioGroup timings = findViewById(R.id.radioGroup);
        Button next = findViewById(R.id.button);

        String movies[] = {
                "Select a movie",
                "Leo",
                "Vikram",
                "Jailer",
                "premalu",
                "manjumel boys"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                movies
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        movie.setAdapter(adapter);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();

                if(n.isEmpty()){
                    Toast.makeText(MainActivity.this,
                            "Enter your name ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (movie.getSelectedItemPosition()==0){
                    Toast.makeText(MainActivity.this,
                            "Select a movie", Toast.LENGTH_SHORT).show();
                    return;
                }

                int selectId = timings.getCheckedRadioButtonId();

                if (selectId == -1){
                    Toast.makeText(MainActivity.this, "Show timing", Toast.LENGTH_SHORT).show();
                    return;
                }
                RadioButton rb = findViewById(selectId);
                String time = rb.getText().toString();
                String m = movie.getSelectedItem().toString();

                Intent i  = new Intent(MainActivity.this, BookingActivity.class);

                i.putExtra("name", n);
                i.putExtra("movie",m);
                i.putExtra("time",time);
                startActivity(i);
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}