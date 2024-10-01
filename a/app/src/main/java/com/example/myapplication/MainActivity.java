package com.example.myapplication;


import android.content.DialogInterface;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void open(View view){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Bạn có chắc chắn muốn ẩn ứng dụng không?");
        //Tạo nút Không
        alertDialogBuilder.setPositiveButton("Không", new DialogInterface.OnClickListener() {
            //Khi nhấn sẽ tạo thông báo
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Toast.makeText(MainActivity.this,"Bạn đã nhấn nút Không",Toast.LENGTH_LONG).show();
            }
        });
        //Tạo nút Có
        alertDialogBuilder.setNegativeButton("Có",new DialogInterface.OnClickListener() {
            //Khi nhấn sẽ đóng hộp thoại
            @Override
            public void onClick(DialogInterface dialog, int which) {

                finish(); //Rời khỏi ứng dụng
            }
        });

        alertDialogBuilder.create().show();
        //alertDialog.show();
    }
}
