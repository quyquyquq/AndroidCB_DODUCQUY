package com.example.lab1_bai1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText txtX,txtY; //nh ap X,Y
    TextView txtResult; //hienthiketqua
    Button btnPlus; //nut +
    Button btnTru; //nut -
    Button btnNhan;//nut *
    Button btnChia;//nut /
    Button btnTram;//nut %

    private void innitControl(){
        txtX=findViewById(R.id.txtX);
        txtY=findViewById(R.id.txtY);
        txtResult=findViewById(R.id.txtResult);
        btnPlus=findViewById(R.id.btnPlus);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                int result = x + y;
                txtResult.setText(String.valueOf(result));
            }
        });
    }
    private void intiControl(){
        txtX=findViewById(R.id.txtX);
        txtY=findViewById(R.id.txtY);
        txtResult=findViewById(R.id.txtResult);
        btnTru=findViewById(R.id.btnTru);
        btnTru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vi) {
                int x = Integer.parseInt(txtX.getText().toString());
                int y = Integer.parseInt(txtY.getText().toString());
                int result = x - y;
                txtResult.setText(String.valueOf(result));
            }
        });
    }
    private void intiiControl(){
        txtX=findViewById(R.id.txtX);
        txtY=findViewById(R.id.txtY);
        txtResult=findViewById(R.id.txtResult);
        btnNhan=findViewById(R.id.btnNhan);
        btnNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vie) {
                int x= Integer.parseInt(txtX.getText().toString());
                int y=Integer.parseInt(txtY.getText().toString());
                int result = x*y;
                txtResult.setText(String.valueOf(result));
            }
        });

    }
    private void  intiiiControl(){
        txtX=findViewById(R.id.txtX);
        txtY=findViewById(R.id.txtY);
        txtResult=findViewById(R.id.txtResult);
        btnChia=findViewById(R.id.btnChia);
        btnChia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float x= Integer.parseInt(txtX.getText().toString());
                float y=Integer.parseInt(txtY.getText().toString());
                float result = x/y;
                txtResult.setText(String.valueOf(result));
            }
        });
    }
    private void intiiiiControl(){
        txtX=findViewById(R.id.txtX);
        txtY=findViewById(R.id.txtY);
        txtResult=findViewById(R.id.txtResult);
        btnTram=findViewById(R.id.btnTram);
        btnTram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vieww) {
                float x= Integer.parseInt(txtX.getText().toString());
                float y=Integer.parseInt(txtY.getText().toString());
                float result = x/y*100;
                txtResult.setText(String.valueOf(result));
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        innitControl();
        intiControl();
        intiiControl();
        intiiiControl();
        intiiiiControl();
    }
}