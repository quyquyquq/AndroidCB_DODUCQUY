package com.example.lab1_bai2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button rollDiceButton;
    private ImageView diceImageView;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollDiceButton = findViewById(R.id.rollDiceButton);
        diceImageView = findViewById(R.id.diceImageView);
        random = new Random();
        rollDiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }
    private void rollDice() {
        int diceRoll = random.nextInt(6) + 1;
        int drawableResource;
        switch (diceRoll) {
            case 1:
                drawableResource = R.drawable.dice_1;
                break;
            case 2:
                drawableResource = R.drawable.dice_2;
                break;
            case 3:
                drawableResource = R.drawable.dice_3;
                break;
            case 4:
                drawableResource = R.drawable.dice_4;
                break;
            case 5:
                drawableResource = R.drawable.dice_5;
                break;
            case 6:
                drawableResource = R.drawable.dice_6;
                break;
            default:
                drawableResource = R.drawable.dice_1;
        }
        diceImageView.setImageResource(drawableResource);

    }
}
