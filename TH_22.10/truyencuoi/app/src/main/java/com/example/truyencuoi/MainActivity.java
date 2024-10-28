package com.example.truyencuoi;

import android.content.res.AssetManager;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String topicName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showFrg(new M000SplashFrg()); // Hiển thị fragment splash
    }

    private void showFrg(Fragment frg) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.ln_main, frg, null)
                .addToBackStack(null) // Thêm vào back stack
                .commit();
    }

    public void gotoM001Screen() {
        showFrg(new M001TopicFrg());
    }

    public void gotoM002Screen(String topicName) {
        this.topicName = topicName;
        M002StoryFrg frg = new M002StoryFrg();
        Bundle args = new Bundle();
        args.putString("topicName", topicName); // Truyền tên topic
        frg.setArguments(args);
        showFrg(frg);
    }

    public void backToM001Screen() {
        getSupportFragmentManager().popBackStack(); // Quay lại fragment trước
    }

    public void gotoM003Screen(ArrayList<StoryEntity> listStory, StoryEntity story) {
        M003DetailStoryFrg frg = new M003DetailStoryFrg();
        frg.setData(topicName, listStory, story);
        showFrg(frg);
    }

    // Phương thức để đọc nội dung từ tệp assets
    public String readAssetFile(String fileName) {
        AssetManager assetManager = getAssets();
        StringBuilder content = new StringBuilder();

        try {
            InputStream inputStream = assetManager.open(fileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
            return "Error loading file.";
        }

        return content.toString();
    }
}
