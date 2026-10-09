package com.example.salaryapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText employeeName, employeeId;
    EditText basicSalary, allowances;
    Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        employeeName = findViewById(R.id.employeeName);
        employeeId = findViewById(R.id.employeeId);
        basicSalary = findViewById(R.id.basicSalary);
        allowances = findViewById(R.id.allowances);
        nextButton = findViewById(R.id.nextButton);

        nextButton.setOnClickListener(v -> {

            String name = employeeName.getText().toString();
            String id = employeeId.getText().toString();
            String basic = basicSalary.getText().toString();
            String allowance = allowances.getText().toString();

            if (name.isEmpty() || id.isEmpty()
                    || basic.isEmpty() || allowance.isEmpty()) {

                Toast.makeText(
                        MainActivity.this,
                        "Please enter all details",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            Intent intent =
                    new Intent(MainActivity.this,
                            SalaryCalculationActivity.class);

            intent.putExtra("name", name);
            intent.putExtra("id", id);
            intent.putExtra("basic", Double.parseDouble(basic));
            intent.putExtra("allowance", Double.parseDouble(allowance));

            startActivity(intent);
        });
    }
}