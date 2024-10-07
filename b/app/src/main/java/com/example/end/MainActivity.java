package com.example.end;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CategoryAdapter.OnCategoryClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<String> categories = Arrays.asList("Công sở", "Cười 18", "Cực hài", "Dân gian", "Gia đình", "Giao thông", "Học sinh");

        CategoryAdapter adapter = new CategoryAdapter(categories, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onCategoryClick(String category) {
        Intent intent = new Intent(MainActivity.this, JokeListActivity.class);
        intent.putExtra("category", category);
        startActivity(intent);
    }
}
