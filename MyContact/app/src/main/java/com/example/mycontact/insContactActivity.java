package com.example.mycontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class insContactActivity extends AppCompatActivity {
    EditText etPhone, etName;
    Button btnSave, btnClose;
    MyContact currentContact;
    String action; // để xác định hành động là thêm hay sửa

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ins_contact);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getViews();

        // Nhận Intent để kiểm tra hành động
        Intent intent = getIntent();
        action = intent.getStringExtra("action");

        // Nếu là hành động sửa, thì lấy thông tin liên hệ và hiển thị lên các EditText
        if (action.equals("edit")) {
            currentContact = (MyContact) intent.getSerializableExtra("listcontact");
            etName.setText(currentContact.getName());
            etPhone.setText(currentContact.getPhone());
            setTitle("Edit Contact");
        } else {
            setTitle("Add New Contact");
        }

        // Xử lý sự kiện khi nhấn nút "Lưu"
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Tạo Intent để trả về kết quả
                Intent iResult = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("contact", getContact());
                iResult.putExtras(bundle);
                setResult(RESULT_OK, iResult);
                finish(); // Đóng activity
            }
        });

        // Xử lý khi nhấn nút "Đóng" (quay lại màn hình chính mà không lưu)
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED); // Không gửi dữ liệu về MainActivity
                finish();
            }
        });
    }

    // Hàm lấy các View
    private void getViews() {
        etName = findViewById(R.id.edtName);
        etPhone = findViewById(R.id.edtPhoneNumber);
        btnClose = findViewById(R.id.btnClose);
        btnSave = findViewById(R.id.btnSave);
    }

    // Hàm lấy thông tin liên hệ hiện tại để trả về MainActivity
    private MyContact getContact() {
        if (currentContact != null) {
            currentContact.setName(etName.getText().toString());
            currentContact.setPhone(etPhone.getText().toString());
            return currentContact; // Trả về đối tượng đã được sửa
        }
        // Nếu là thêm mới
        return new MyContact(R.drawable.img2, etName.getText().toString(), etPhone.getText().toString());
    }
}
