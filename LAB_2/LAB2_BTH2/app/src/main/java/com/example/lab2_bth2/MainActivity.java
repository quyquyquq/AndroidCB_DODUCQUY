package com.example.lab2_bth2;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private LinearLayout loadingLayout;
    private LinearLayout actiMain;
    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Khởi tạo các thành phần giao diện
        loadingLayout = findViewById(R.id.loadingLayout);
        actiMain = findViewById(R.id.actiMain);
        // Hiển thị ProgressBar và lam mo main content
        showLoading();
        //an ProcessBar hien lại sau 3s
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                hideLoading();
            }
        }, 3000);
    }
    private void showLoading() {
        loadingLayout.setVisibility(View.VISIBLE);
        actiMain.setAlpha(0.5f); // Lam mo noi dung
    }

    private void hideLoading() {
        loadingLayout.setVisibility(View.GONE);
        actiMain.setAlpha(1f)   ;
    }
}
