package com.example.calculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText t1;
    Button bac;

    String firstNumber = "";
    String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = findViewById(R.id.t1);
        bac = findViewById(R.id.bac);

        int b[] = new int[17];

        for (int i = 0; i <= 16; i++) {
            String s = "b" + i;
            int rid = getResources().getIdentifier(
                    s,
                    "id",
                    getPackageName()
            );
            b[i] = rid;
        }

        for (int id : b) {

            Button button = findViewById(id);

            if (button != null) {

                button.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        handleButtonClick(view.getId());
                    }

                });
            }
        }

        bac.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                t1.setText("");
            }

        });
    }

    private void handleButtonClick(int id) {

        String txt = t1.getText().toString();

        // Equal
        if (id == R.id.b16) {

            if (!firstNumber.isEmpty() && !operator.isEmpty()) {

                String secondNumber = txt;

                double num1 = Double.parseDouble(firstNumber);
                double num2 = Double.parseDouble(secondNumber);

                double result = 0;

                switch (operator) {

                    case "+":
                        result = num1 + num2;
                        break;

                    case "-":
                        result = num1 - num2;
                        break;

                    case "x":
                        result = num1 * num2;
                        break;

                    case "/":
                        result = num1 / num2;
                        break;
                }

                t1.setText(String.valueOf(result));

                firstNumber = "";
                operator = "";
            }
        }

        // Decimal
        else if (id == R.id.b10) {

            if (!txt.contains(".")) {
                t1.setText(txt + ".");
            }
        }

        // Operators
        else if (id == R.id.b12 ||
                id == R.id.b13 ||
                id == R.id.b14 ||
                id == R.id.b15) {

            if (!txt.isEmpty()) {

                firstNumber = txt;

                operator = ((Button) findViewById(id))
                        .getText()
                        .toString();

                t1.setText("");
            }
        }

        // Backspace
        else if (id == R.id.b11) {

            if (txt.length() > 0) {

                t1.setText(
                        txt.substring(0, txt.length() - 1)
                );
            }
        }

        // Numbers
        else {

            t1.setText(
                    txt + ((Button) findViewById(id)).getText()
            );
        }
    }
}