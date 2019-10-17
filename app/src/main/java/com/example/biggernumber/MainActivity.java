package com.example.biggernumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int userNumber1;
    private int userNumber2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button userButton = findViewById(R.id.userSelect);
        final Button userButton2 = findViewById(R.id.userSelect2);
        final TextView userOption = findViewById(R.id.displayNumber);
        final TextView userOption2 = findViewById(R.id.displayNumber2);
        generateRandom();
        userOption.setText(String.valueOf(userNumber1));
        userOption2.setText(String.valueOf(userNumber2));
        userButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                generateRandom();
                userOption.setText(String.valueOf(userNumber1));
                userOption2.setText(String.valueOf(userNumber2));
            }
        });
    }

    private void generateRandom() {
        Random randomNum = new Random();
        while (userNumber1 == userNumber2) {
            userNumber1 = randomNum.nextInt(100);
            userNumber2 = randomNum.nextInt(100);
        }
    }
}
