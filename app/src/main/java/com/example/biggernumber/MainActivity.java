package com.example.biggernumber;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private int userNumber1;
    private int userNumber2;
    private int userPoints = 0;
    private int userLives = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button userButton = findViewById(R.id.userSelect);
        final Button userButton2 = findViewById(R.id.userSelect2);
        final Button resetButton = findViewById(R.id.resetGame);
        final TextView userOption = findViewById(R.id.randomNumber);
        final TextView userOption2 = findViewById(R.id.randomNumber2);
        final TextView selectResult = findViewById(R.id.selectResult);
        final TextView userScore = findViewById(R.id.userScore);
        final TextView userLivesDisplay = findViewById(R.id.userLives);
        generateRandom();
        userOption.setText(String.valueOf(userNumber1));
        userOption2.setText(String.valueOf(userNumber2));
        userLivesDisplay.setText(String.valueOf(userLives));
        userScore.setText(String.valueOf(userPoints));


        userButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkOption(userNumber1, userNumber2) == true) {
                    selectResult.setText("Congratulations!");
                    userPoints++;
                }
                else {
                    selectResult.setText("Too bad, try again!");
                    userLives--;
                    userLivesDisplay.setText(String.valueOf(userLives));
                }
                generateRandom();
                gameOver();
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
                    userLives--;
                    userLivesDisplay.setText(String.valueOf(userLives));
                }
                generateRandom();
                gameOver();
                userOption.setText(String.valueOf(userNumber1));
                userOption2.setText(String.valueOf(userNumber2));
                userScore.setText(String.valueOf(userPoints));
            }
        });
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
                userOption.setText(String.valueOf(userNumber1));
                userOption2.setText(String.valueOf(userNumber2));
                userLivesDisplay.setText(String.valueOf(userLives));
                userScore.setText(String.valueOf(userPoints));
                selectResult.setText("");
            }
        });
    }


    private void generateRandom() {
        Random randomNum = new Random();
            userNumber1 = randomNum.nextInt(1000);
            userNumber2 = randomNum.nextInt(1000);
                while (userNumber1 == userNumber2) {
                    userNumber1 = randomNum.nextInt(1000);
                    userNumber2 = randomNum.nextInt(1000);
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
    private void gameOver() {
        if (userLives == 0) {
            Toast.makeText(getApplicationContext(), "Game over.", Toast.LENGTH_SHORT).show();
        }
    }

    private void resetGame() {
        generateRandom();
        userPoints = 0;
        userLives = 3;
    }
}
