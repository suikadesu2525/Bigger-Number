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
    private int userPoints = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button userButton = findViewById(R.id.userSelect);
        final Button userButton2 = findViewById(R.id.userSelect2);
        final TextView userOption = findViewById(R.id.randomNumber);
        final TextView userOption2 = findViewById(R.id.randomNumber2);
        final TextView selectResult = findViewById(R.id.selectResult);
        final TextView userScore = findViewById(R.id.userScore);

        generateRandom();
        userOption.setText(String.valueOf(userNumber1));
        userOption2.setText(String.valueOf(userNumber2));

        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkOption(userNumber1, userNumber2) == true) {
                    selectResult.setText("Congratulations!");
                    userPoints++;
                }
                else {
                    selectResult.setText("Too bad, try again!");
                }
                generateRandom();
                userOption.setText(String.valueOf(userNumber1));
                userOption2.setText(String.valueOf(userNumber2));
                userScore.setText(String.valueOf(userPoints));
            }
        });

        userButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkOption(userNumber2, userNumber1) == true) {
                    selectResult.setText("Congratulations!");
                    userPoints++;
                }
                else {
                    selectResult.setText("Too bad, try again!");
                }
                generateRandom();
                userOption.setText(String.valueOf(userNumber1));
                userOption2.setText(String.valueOf(userNumber2));
                userScore.setText(String.valueOf(userPoints));
            }
        });
    }

    private void generateRandom() {
        Random randomNum = new Random();

            userNumber1 = randomNum.nextInt(100);
            userNumber2 = randomNum.nextInt(100);
                while (userNumber1 == userNumber2) {
                    userNumber1 = randomNum.nextInt(100);
                    userNumber2 = randomNum.nextInt(100);
                    break;
                }
    }
    private boolean checkOption(int userOption, int otherOption) {
        if (userOption > otherOption) {
            return true;
    }
        else {
            return false;
        }
    }

}
