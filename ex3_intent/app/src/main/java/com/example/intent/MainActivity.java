package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = findViewById(R.id.edittext1);
        e2 = findViewById(R.id.edittext2);
        b1 = findViewById(R.id.btn1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = e1.getText().toString().trim();
                String pass = e2.getText().toString();

                if(username.equals("user")&& pass.equals("admin123")){
                    Toast.makeText(MainActivity.this, "Login Succesfull", Toast.LENGTH_SHORT).show();
                    Intent intent =
                            new Intent(MainActivity.this, Homepage.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this,"login failed",Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
