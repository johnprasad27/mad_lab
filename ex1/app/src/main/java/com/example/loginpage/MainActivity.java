package com.example.loginpage;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText username,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextTextPassword);
        login = findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
            String user = username.getText().toString();
            String pass = password.getText().toString();
            if (user.equals("usr")&&pass.equals("123")){
                Toast.makeText(MainActivity.this, "login succesfull", Toast.LENGTH_SHORT).show();
            }
            else{
               Toast.makeText(MainActivity.this,"Invalid credentials",Toast.LENGTH_SHORT).show();
            }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}