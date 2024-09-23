package com.example.th_gui_1;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText txtA, txtB;
    TextView txtResult;
    Button tong, hieu, tich, thuong, ucln, thoat;

    private boolean validateInput() {
        if (txtA.getText().toString().isEmpty() || txtB.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ số A và số B", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void initSumControl() {
        tong = findViewById(R.id.tong);
        tong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    int x = Integer.parseInt(txtA.getText().toString());
                    int y = Integer.parseInt(txtB.getText().toString());
                    int result = x + y;
                    txtResult.setText("Tổng: " + result);
                }
            }
        });
    }

    private void initSubtractionControl() {
        hieu = findViewById(R.id.hieu);
        hieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    int x = Integer.parseInt(txtA.getText().toString());
                    int y = Integer.parseInt(txtB.getText().toString());
                    int result = x - y;
                    txtResult.setText("Hiệu: " + result);
                }
            }
        });
    }

    private void initMultiplicationControl() {
        tich = findViewById(R.id.tich);
        tich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    int x = Integer.parseInt(txtA.getText().toString());
                    int y = Integer.parseInt(txtB.getText().toString());
                    int result = x * y;
                    txtResult.setText("Tích: " + result);
                }
            }
        });
    }

    private void initDivisionControl() {
        thuong = findViewById(R.id.thuong);
        thuong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInput()) {
                    float x = Float.parseFloat(txtA.getText().toString());
                    float y = Float.parseFloat(txtB.getText().toString());
                    if (y == 0) {
                        Toast.makeText(MainActivity.this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    float result = x / y;
                    txtResult.setText("Thương: " + result);
                }
            }
        });
    }
    private void uclnControl() {
        ucln = findViewById(R.id.ucln);
        ucln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(txtA.getText().toString());
                int y = Integer.parseInt(txtB.getText().toString());
                int result = ucln(x, y);
                txtResult.setText(String.valueOf(result));
            }
        });
    }

    // Hàm tính UCLN sử dụng thuật toán Euclid
    private int ucln(int a, int b) {
        if (b == 0) {
            return a;
        }
        return ucln(b, a % b);
    }

    private void initExitControl() {
        thoat = findViewById(R.id.thoat);
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtA = findViewById(R.id.txtA);
        txtB = findViewById(R.id.txtB);
        txtResult = findViewById(R.id.txtResult);

        initSumControl();
        initSubtractionControl();
        initMultiplicationControl();
        initDivisionControl();
        initExitControl();
        uclnControl();
    }
}
