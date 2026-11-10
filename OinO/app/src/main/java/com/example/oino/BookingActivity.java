package com.example.oino;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.sql.Array;

public class BookingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking);

        TextView customer, movie;
        Spinner seat;
        EditText tickets;
        CheckBox popcorn,drink,glasses;
        Button book;

        customer = findViewById(R.id.textView);
        movie = findViewById(R.id.textView2);

        seat = findViewById(R.id.spinner2);
        tickets =  findViewById(R.id.editTextText2);

        popcorn = findViewById(R.id.checkBox);
        drink = findViewById(R.id.checkBox2);
        glasses = findViewById(R.id.checkBox3);

        book = findViewById(R.id.button2);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        String movieName = intent.getStringExtra("movie");
        String time = intent.getStringExtra("time");

        customer.setText("Customer: " + name);
        movie.setText("Movie: " + movieName);

        String[] seats = {
                "Selected Seat",
                "Silver - 150",
                "gold - 250",
                "Platinum -400",
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                seats
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        seat.setAdapter(adapter);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String count = tickets.getText().toString();

                if(count.isEmpty()){
                    Toast.makeText(BookingActivity.this,
                            "Enter number of tickets",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                int n =Integer.parseInt(count);

                if(n < 1 || n>10){
                    Toast.makeText(BookingActivity.this,
                            "Enter ticket between 1 and 10",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                if (seat.getSelectedItemPosition()==0){
                    Toast.makeText(BookingActivity.this,
                            "Select seat type",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                int price = 0;

                if (seat.getSelectedItemPosition()==1)
                    price = 150;
                else if (seat.getSelectedItemPosition()==2)
                    price = 250;
                else if (seat.getSelectedItemPosition()==3)
                    price=400;

                int ticketTotal = price*n;

                int addon = 0;

                if(popcorn.isChecked())
                    addon +=120;
                if(drink.isChecked())
                    addon +=80;
                if(glasses.isChecked())
                    addon +=50;

                int addonTotal = addon * n;

                double gst = (ticketTotal + addonTotal)* 0.18;
                double grandTotal = ticketTotal +addonTotal + gst;
                Intent i = new Intent(BookingActivity.this, SummaryActivity.class);

                i.putExtra("name", name);
                i.putExtra("movie", movieName);
                i.putExtra("time", time);
                i.putExtra("seat", seat.getSelectedItem().toString());
                i.putExtra("tickets", n);
                i.putExtra("addons", addonTotal);
                i.putExtra("ticketTotal", ticketTotal);
                i.putExtra("gst", gst);
                i.putExtra("grandTotal", grandTotal);

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