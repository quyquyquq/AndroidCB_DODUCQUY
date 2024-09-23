package com.example.th_gui_bai2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edtCelsius, edtFahrenheit;
    private Button btnConvertToF, btnConvertToC, btnClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtCelsius = findViewById(R.id.edtCelsius);
        edtFahrenheit = findViewById(R.id.edtFahrenheit);
        btnConvertToF = findViewById(R.id.btnConvertToF);
        btnConvertToC = findViewById(R.id.btnConvertToC);
        btnClear = findViewById(R.id.btnClear);

        btnConvertToF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String celsiusStr = edtCelsius.getText().toString();
                if (!celsiusStr.isEmpty()) {
                    double celsius = Double.parseDouble(celsiusStr);
                    double fahrenheit = celsius * 9 / 5 + 32;
                    edtFahrenheit.setText(String.valueOf(fahrenheit));
                } else {
                    Toast.makeText(MainActivity.this, "Moi nhap do C de chuyen doi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnConvertToC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fahrenheitStr = edtFahrenheit.getText().toString();
                if (!fahrenheitStr.isEmpty()) {
                    double fahrenheit = Double.parseDouble(fahrenheitStr);
                    double celsius = (fahrenheit - 32) * 5 / 9;
                    edtCelsius.setText(String.valueOf(celsius));
                } else {
                    Toast.makeText(MainActivity.this, " Moi nhap do F de chuyen doi", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCelsius.setText("");
                edtFahrenheit.setText("");
            }
        });
    }
}
