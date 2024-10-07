package com.example.end;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class JokeListActivity extends AppCompatActivity implements JokeAdapter.OnJokeClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_list);

        String category = getIntent().getStringExtra("category");

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> jokes = Arrays.asList("Truyện 1", "Truyện 2", "Truyện 3", "Truyện 4"); // Lấy danh sách truyện theo category

        JokeAdapter adapter = new JokeAdapter(jokes, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onJokeClick(String joke) {
        Intent intent = new Intent(JokeListActivity.this, JokeDetailActivity.class);
        intent.putExtra("joke", joke);
        startActivity(intent);
    }
}
