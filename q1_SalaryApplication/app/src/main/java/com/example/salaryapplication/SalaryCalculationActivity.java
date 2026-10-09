package com.example.salaryapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SalaryCalculationActivity extends AppCompatActivity {

    TextView grossText, deductionText, netText;
    Button summaryButton;

    String name, id;
    double basic, allowance;
    double gross, deduction, net;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_calculation);

        grossText = findViewById(R.id.grossText);
        deductionText = findViewById(R.id.deductionText);
        netText = findViewById(R.id.netText);
        summaryButton = findViewById(R.id.summaryButton);

        Intent intent = getIntent();

        name = intent.getStringExtra("name");
        id = intent.getStringExtra("id");

        basic = intent.getDoubleExtra("basic", 0);
        allowance = intent.getDoubleExtra("allowance", 0);

        // Calculate gross salary
        gross = basic + allowance;

        // 10% deduction
        deduction = gross * 0.10;

        // Calculate net salary
        net = gross - deduction;

        grossText.setText(
                "Gross Salary: ₹" + String.format("%.2f", gross)
        );

        deductionText.setText(
                "Deduction: ₹" + String.format("%.2f", deduction)
        );

        netText.setText(
                "Net Salary: ₹" + String.format("%.2f", net)
        );

        summaryButton.setOnClickListener(v -> {

            Intent summaryIntent =
                    new Intent(
                            SalaryCalculationActivity.this,
                            SalarySummaryActivity.class
                    );

            summaryIntent.putExtra("name", name);
            summaryIntent.putExtra("id", id);
            summaryIntent.putExtra("basic", basic);
            summaryIntent.putExtra("allowance", allowance);
            summaryIntent.putExtra("gross", gross);
            summaryIntent.putExtra("deduction", deduction);
            summaryIntent.putExtra("net", net);

            startActivity(summaryIntent);
        });
    }
}