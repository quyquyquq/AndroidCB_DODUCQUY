package com.example.caculatorprogram;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView tvMath;
    private TextView tvResult;
    private StringBuilder input = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMath = findViewById(R.id.tvMath);
        tvResult = findViewById(R.id.tvResult);

        setButtonListeners();
    }

    private void setButtonListeners() {
        int[] buttonIds = {
                R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3, R.id.btn4,
                R.id.btn5, R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnOpen, R.id.btnClose, R.id.btnDot, R.id.btnDiv,
                R.id.btnMul, R.id.btnSub, R.id.btnPlus, R.id.btnC, R.id.btnResult
        };

        for (int id : buttonIds) {
            findViewById(id).setOnClickListener(this::onButtonClick);
        }
    }

    private void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (buttonText.equals("C")) {
            input.setLength(0);
            tvMath.setText("0");
            tvResult.setText("0");
        } else if (buttonText.equals("=")) {
            String result = calculate(input.toString());
            tvResult.setText(result);
        } else {
            // Thêm ký tự trực tiếp vào input
            input.append(buttonText);
            tvMath.setText(input.toString());
        }
    }


    private String calculate(String input) {
        double result = 0;
        String currentNumber = "";
        String operator = "+";
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch) || ch == '.') {
                currentNumber += ch; // Xây dựng số hiện tại
            } else {
                if (!currentNumber.isEmpty()) {
                    double number = Double.parseDouble(currentNumber);
                    switch (operator) {
                        case "+":
                            result += number;
                            break;
                        case "-":
                            result -= number;
                            break;
                        case "*":
                            result *= number;
                            break;
                        case "/":
                            if (number != 0) {
                                result /= number;
                            } else {
                                return "Lỗi: Chia cho 0";
                            }
                            break;
                    }
                    currentNumber = "";
                }
                operator = String.valueOf(ch);
            }
        }

        if (!currentNumber.isEmpty()) {
            double number = Double.parseDouble(currentNumber);
            switch (operator) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    if (number != 0) {
                        result /= number;
                    } else {
                        return "Lỗi: Chia cho 0";
                    }
                    break;
            }
        }

        return String.valueOf(result);
    }

}


