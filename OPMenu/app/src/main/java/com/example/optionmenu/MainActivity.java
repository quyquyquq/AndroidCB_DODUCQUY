package com.example.optionmenu;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvContact;
    ArrayAdapter<String> adapter;
    final static String[] contactList={" Mai 099999999","Linh 099999999","Tuan 099999999"};
    Button btnShowMenu;
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
        bindData();
        registerForContextMenu(lvContact);
        //xu lu click vao btn show hien thi popupmenu
        btnShowMenu=findViewById(R.id.btnshowmenu);
        btnShowMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //khai bao va goi popupmenu o day
                PopupMenu popupMenu =new PopupMenu(MainActivity.this,view);
                MenuInflater inflater =popupMenu.getMenuInflater();
                inflater.inflate(R.menu.popup_menu,popupMenu.getMenu());
                popupMenu.show();
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        //xu ly su kien tai day
                        if(menuItem.getItemId()==R.id.menu_play){
                            Toast.makeText(MainActivity.this,"Play !!!", Toast.LENGTH_LONG).show();
                        } else if (menuItem.getItemId()==R.id.menu_pause) {
                            Toast.makeText(MainActivity.this,"Pause !!!", Toast.LENGTH_LONG).show();
                        } else if (menuItem.getItemId()==R.id.menu_stop) {
                            Toast.makeText(MainActivity.this,"Stop !!!", Toast.LENGTH_LONG).show();
                        }
                        return false;
                    }
                });
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        //hien thi option menu su dung qua phuong thuc getMenuInflater().inflater de load option menu hien thi len activity
        getMenuInflater().inflate(R.menu.checked_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // lay ra item menu su dung getItemid()
//        if(item.getItemId()==R.id.new_game){
//            //todo
//            Toast.makeText(MainActivity.this,"This is new game", Toast.LENGTH_LONG).show();
//            return true;
//        }else if(item.getItemId()==R.id.help){
//            //todo
//            Toast.makeText(MainActivity.this,"This is help", Toast.LENGTH_LONG).show();
//
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.menu_send) {
            Toast.makeText(MainActivity.this,"Check mail", Toast.LENGTH_LONG).show();
            if(item.isChecked())
                item.setChecked(false);
            else item.setChecked(true);
        } else if (item.getItemId() == R.id.menu_Notification) {
            //todo
            Toast.makeText(MainActivity.this,"Check notification", Toast.LENGTH_LONG).show();
            if(item.isChecked())
                item.setChecked(false);
            else item.setChecked(true);
        }
            return true;
    }
    //xuly su kien khi chọn contxtmenu item



    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_add){
            Toast.makeText(MainActivity.this,"Add new contact", Toast.LENGTH_LONG).show();
        }else if(item.getItemId()==R.id.menu_detail){
            Toast.makeText(MainActivity.this,"Detail contact", Toast.LENGTH_LONG).show();
        }else if(item.getItemId()==R.id.menu_xoa){
            Toast.makeText(MainActivity.this,"Delete contact", Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override//load contact gọi method onCreateContextmenu
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        //sd menuinflater load menu
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.contact_menu,menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private void bindData(){
        lvContact=findViewById(R.id.lvContact);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, contactList);
        lvContact.setAdapter(adapter);
    }
}