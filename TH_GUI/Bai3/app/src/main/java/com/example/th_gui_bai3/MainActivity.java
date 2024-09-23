package com.example.th_gui_bai3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btntinhBMI(View arg0) {
        EditText editchieucao = findViewById(R.id.editchieucao);
        EditText editcannang = findViewById(R.id.editcannang);
        EditText editBMI = findViewById(R.id.editBMI);
        EditText editchandoan = findViewById(R.id.editChanDoan);

        String strHeight = editchieucao.getText().toString();
        String strWeight = editcannang.getText().toString();

        if (!strHeight.isEmpty() && !strWeight.isEmpty()) {
            double H = Double.parseDouble(strHeight);
            double W = Double.parseDouble(strWeight);
            double BMI = W / Math.pow(H, 2);

            String chandoan;
            if (BMI < 18) {
                chandoan = "Bạn gầy";
            } else if (BMI <= 24.9) {
                chandoan = "Bạn bình thường";
            } else if (BMI <= 29.9) {
                chandoan = "Bạn béo phì độ 1";
            } else if (BMI <= 34.9) {
                chandoan = "Bạn béo phì độ 2";
            } else {
                chandoan = "Bạn béo phì độ 3";
            }

            DecimalFormat dcf = new DecimalFormat("#.0");
            editBMI.setText(dcf.format(BMI));
            editchandoan.setText(chandoan);
        } else {
            editchandoan.setText("Vui lòng nhập đầy đủ thông tin.");
        }
    }

}
