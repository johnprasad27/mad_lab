package com.example.oino;

import android.os.Bundle;
import android.content.Intent;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class SummaryActivity extends AppCompatActivity {

    TextView customer, movie, seat, tickets, addons, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        customer = findViewById(R.id.summaryCustomer);
        movie = findViewById(R.id.summaryMovie);
        seat = findViewById(R.id.summarySeat);
        tickets = findViewById(R.id.summaryTickets);
        addons = findViewById(R.id.summaryAddons);
        total = findViewById(R.id.summaryTotal);

        Intent i = getIntent();

        String name = i.getStringExtra("name");
        String movieName = i.getStringExtra("movie");
        String time = i.getStringExtra("time");
        String seatType = i.getStringExtra("seat");

        int n = i.getIntExtra("tickets", 0);
        int addonTotal = i.getIntExtra("addons", 0);
        int ticketTotal = i.getIntExtra("ticketTotal", 0);

        double gst = i.getDoubleExtra("gst", 0);
        double grandTotal = i.getDoubleExtra("grandTotal", 0);

        customer.setText("Customer: " + name);
        movie.setText("Movie: " + movieName + "\nShow Time: " + time);
        seat.setText("Seat: " + seatType);
        tickets.setText("Number of Tickets: " + n +
                "\nTicket Total: ₹" + ticketTotal);
        addons.setText("Add-ons Total: ₹" + addonTotal);
        total.setText("GST: ₹" + gst +
                "\nGrand Total: ₹" + grandTotal);
    }
}