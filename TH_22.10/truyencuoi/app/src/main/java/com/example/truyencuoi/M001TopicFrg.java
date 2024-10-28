package com.example.truyencuoi;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;

public class M001TopicFrg extends Fragment implements View.OnClickListener {
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.m001_frg_topic, container, false);
        initViews(rootView); // Khởi tạo các view
        return rootView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context; // Lưu Context
    }

    private void initViews(View v) {
        LinearLayout lnMain = v.findViewById(R.id.ln_topic);
        lnMain.removeAllViews(); // Xóa tất cả các view trước đó

        try {
            // Lấy danh sách tệp hình ảnh từ thư mục assets/photo
            String[] listItem = mContext.getAssets().list("photo");
            for (String fileName : listItem) {
                String name = fileName.substring(0, fileName.indexOf(".")); // Lấy tên mà không có đuôi mở rộng
                View vTopic = LayoutInflater.from(mContext).inflate(R.layout.item_topic, null);

                ImageView ivTopic = vTopic.findViewById(R.id.iv_topic);
                TextView tvTopic = vTopic.findViewById(R.id.tv_topic);

                // Đọc hình ảnh từ assets và thiết lập vào ImageView
                ivTopic.setImageBitmap(BitmapFactory.decodeStream(mContext.getAssets().open("photo/" + fileName)));
                tvTopic.setText(name); // Thiết lập tên vào TextView

                lnMain.addView(vTopic); // Thêm view topic vào LinearLayout

                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) vTopic.getLayoutParams();
                params.bottomMargin = 40; // Thiết lập khoảng cách dưới cho mỗi item
                vTopic.setLayoutParams(params);
                vTopic.setTag(name); // Gán tag cho view
                vTopic.setOnClickListener(this); // Thiết lập listener cho sự kiện click
            }
        } catch (Exception e) {
            e.printStackTrace(); // Xử lý lỗi
        }
    }

    @Override
    public void onClick(View v) {
        // Truyền tag (tên topic) khi chuyển đến M002StoryFrg
        ((MainActivity) getActivity()).gotoM002Screen((String) v.getTag());
    }
}
