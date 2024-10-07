package com.example.end;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class JokeDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_detail);

        // Kích hoạt nút quay về
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish(); // Đóng activity và quay lại activity trước đó
        return true;
    }
}
