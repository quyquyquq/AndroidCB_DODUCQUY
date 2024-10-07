package com.example.project_truyencuoi; // Thay đổi tên package theo ứng dụng của bạn

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start); // Thay đổi tên layout nếu cần

        ImageButton imageButton = findViewById(R.id.startButton); // Thay đổi ID nếu cần

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Khi nhấn vào ImageButton, chuyển sang list_truyencuoi
                Intent intent = new Intent(MainActivity.this, list_truyencuoi.class);
                startActivity(intent);
            }
        });
    }
}
