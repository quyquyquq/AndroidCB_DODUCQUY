package com.example.truyencuoi;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class M002StoryFrg extends Fragment {
    private Context mContext;
    private ArrayList<StoryEntity> listStory;
    private String topicName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Nhận tên chủ đề từ arguments
        if (getArguments() != null) {
            topicName = getArguments().getString("topicName");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m002_frg_story, container, false);
        initViews(rootView);
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    private void initViews(View v) {
        v.findViewById(R.id.iv_back).setVisibility(View.VISIBLE);
        v.findViewById(R.id.iv_back).setOnClickListener(v1 -> backToM001Screen());
        ((TextView) v.findViewById(R.id.tv_name)).setText(topicName);
        RecyclerView rv = v.findViewById(R.id.rv_story);
        listStory = readStory(); // Sử dụng biến khai báo ở lớp
        StoryAdapter adapter = new StoryAdapter(listStory, mContext);
        rv.setAdapter(adapter);
        rv.setLayoutManager(new LinearLayoutManager(mContext));
    }

    private ArrayList<StoryEntity> readStory() {
        ArrayList<StoryEntity> listStory = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(mContext.getAssets().open("story/" + topicName + ".txt"), "UTF-8"));
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                String title = mLine; // Lấy tiêu đề từ dòng đầu tiên
                StringBuilder contentBuilder = new StringBuilder();
                while ((mLine = reader.readLine()) != null && !mLine.contains("','0');")) {
                    contentBuilder.append(mLine).append("\n");
                }
                String content = contentBuilder.toString().replace("','0');", "");
                StoryEntity storyEntity = new StoryEntity(topicName, title, content);
                listStory.add(storyEntity);
            }
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(mContext, "Lỗi khi đọc file: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return listStory;
    }

    private void backToM001Screen() {
        ((MainActivity) getActivity()).backToM001Screen();
    }
}
