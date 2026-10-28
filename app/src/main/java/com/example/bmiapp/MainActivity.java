
package com.example.bmiapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView result;
        EditText weight, height;
        Button button;

        result = findViewById(R.id.result);
        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String wtText = weight.getText().toString().trim();
                String htText = height.getText().toString().trim();

                if (wtText.isEmpty() || htText.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Please enter weight and height",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                double wt = Double.parseDouble(wtText);
                double ht = Double.parseDouble(htText);

                if (wt <= 0 || ht <= 0) {
                    result.setText("Enter valid values");
                    return;
                }

                // Height is entered in centimeters
                double heightM = ht / 100.0;

                double bmi = wt / (heightM * heightM);

                String category;

                if (bmi < 18.5) {
                    category = "Underweight";
                } else if (bmi < 25) {
                    category = "Normal weight";
                } else if (bmi < 30) {
                    category = "Overweight";
                } else {
                    category = "Obese";
                }

                result.setText(
                        String.format(java.util.Locale.US,
                                "Your BMI: %.2f\nCategory: %s",
                                bmi, category)
                );
            }
        });
    }
}
