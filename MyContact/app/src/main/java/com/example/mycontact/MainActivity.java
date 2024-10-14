package com.example.mycontact;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Currency;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_EDIT = 1;
    ListView lvContact;
    ArrayList<MyContact> listContacts = new ArrayList<>();
    ContactAdapter contactAdapter;
    FloatingActionButton btnAdd;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        setTitle("List Contact");
        initData();
        lvContact = findViewById(R.id.lvContact);

        //khoi tao contactAdapter
        contactAdapter = new ContactAdapter(MainActivity.this, R.layout.layout_item_contact, listContacts);
        lvContact.setAdapter(contactAdapter);

        //xu ly sk cho nut floatting Button
        btnAdd = findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //goi InsContact de them moi contact
                Intent iIns = new Intent(MainActivity.this, insContactActivity.class);
                insertContactResult.launch(iIns);
            }
        });

    }

    ActivityResultLauncher<Intent> insertContactResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult o) {
            //xu ly kq tra ve o day
            if(o.getResultCode()==RESULT_OK){
                Intent intent = o.getData();
                MyContact contact = (MyContact) intent.getExtras().getSerializable("contact");
                //add vao list contact
                listContacts.add(contact);
                //refresh adapter
                contactAdapter.notifyDataSetChanged();
            }
        }
    });

    private void initData() {

        listContacts.add(new MyContact(R.drawable.img2, "Xuân", "099999999"));
        listContacts.add(new MyContact(R.drawable.img2, "Hạ ", "099999999"));
        listContacts.add(new MyContact(R.drawable.img2, "Thu", "099999999"));
        listContacts.add(new MyContact(R.drawable.img2, "Đông", "099999999"));
        listContacts.add(new MyContact(R.drawable.img2, "Mai", "099999999"));

    }
    public boolean onCreateOptionsMenu(Menu menu) {
        //hien thi option menu su dung qua phuong thuc getMenuInflater().inflater de load option menu hien thi len activity
        getMenuInflater().inflate(R.menu.contact_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //  lay ra item menu su dung getItemid()
        if (item.getItemId() == R.id.menu_them) {
            //todo
            Intent intent = new Intent(MainActivity.this, insContactActivity.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Thêm mới", Toast.LENGTH_LONG).show();
            return true;
        } else if (item.getItemId() == R.id.menu_thongtin) {
            //todo
            Intent intent = new Intent(MainActivity.this, infoAPP.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Thông tin ứng dụng", Toast.LENGTH_LONG).show();
            return true;
        }else if (item.getItemId() == R.id.menu_setting) {
            //todo
            Intent intent = new Intent(MainActivity.this, Setting.class);
            startActivity(intent);
            Toast.makeText(MainActivity.this, "Cài đặt", Toast.LENGTH_LONG).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }



}