package com.example.salaryapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SalarySummaryActivity extends AppCompatActivity {

    TextView summaryText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_summary);

        summaryText = findViewById(R.id.summaryText);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String id = intent.getStringExtra("id");

        double basic = intent.getDoubleExtra("basic", 0);
        double allowance = intent.getDoubleExtra("allowance", 0);
        double gross = intent.getDoubleExtra("gross", 0);
        double deduction = intent.getDoubleExtra("deduction", 0);
        double net = intent.getDoubleExtra("net", 0);

        String summary =
                "Employee Name: " + name +
                        "\n\nEmployee ID: " + id +
                        "\n\nBasic Salary: ₹" + String.format("%.2f", basic) +
                        "\n\nAllowances: ₹" + String.format("%.2f", allowance) +
                        "\n\nGross Salary: ₹" + String.format("%.2f", gross) +
                        "\n\nDeductions: ₹" + String.format("%.2f", deduction) +
                        "\n\nNet Salary: ₹" + String.format("%.2f", net);

        summaryText.setText(summary);
    }
}