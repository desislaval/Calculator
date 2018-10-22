package com.example.android.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText percentageTxt = findViewById(R.id.percentage_textview);
                EditText numberTxt = findViewById(R.id.number_textview);
                TextView resultTxt = findViewById(R.id.total_textview);
                RadioButton subtract = findViewById(R.id.subtract_radiobutton);
                RadioButton add = findViewById(R.id.add_radiobutton);
                RadioButton show = findViewById(R.id.show_percent_radiobutton);

                if (percentageTxt.getText().toString().length() > 0 && resultTxt.getText().toString().length() > 0){
                    float percentage = Float.parseFloat(percentageTxt.getText().toString());
                    float number = Float.parseFloat(numberTxt.getText().toString());
                    float result = (percentage * number) / 100;

                    if (show.isChecked()) {
                        resultTxt.setText(String.valueOf(result));
                    } else if (add.isChecked()) {
                        result += number;
                        resultTxt.setText(String.valueOf(result));
                    } else if (subtract.isChecked()) {
                        result = number - result;
                        resultTxt.setText(String.valueOf(result));
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Enter two valid numbers", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
