package com.example.mycontact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ContactAdapter extends ArrayAdapter<MyContact> {
    Context context;
    int layout;
    ArrayList<MyContact> myListContact;

    public ContactAdapter(@NonNull Context context, int resource, ArrayList<MyContact> lstContact) {
        super(context, resource, lstContact);
        this.context = context;
        this.layout = resource;
        this.myListContact = lstContact;
    }

    @Nullable
    @Override
    public MyContact getItem(int position) {
        return myListContact.get(position);
    }

    @Override
    public int getCount() {
        return myListContact.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View currentView = convertView;
        if (currentView == null) {
            currentView = LayoutInflater.from(context).inflate(layout, parent, false);
        }

        // Lấy đối tượng MyContact tại vị trí 'position'
        MyContact contact = getItem(position);

        // Liên kết các View trong layout item_contact với dữ liệu
        ImageView imgContact = currentView.findViewById(R.id.imgContact);
        TextView tvName = currentView.findViewById(R.id.tvName);
        TextView tvPhone = currentView.findViewById(R.id.tvPhoneNumber);
        ImageButton btnCall = currentView.findViewById(R.id.btnCall);
        ImageButton btnSend = currentView.findViewById(R.id.btnSend);

        // Set dữ liệu cho các TextView
        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhone());

        // Xử lý sự kiện cho nút gọi
        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iCall = new Intent(Intent.ACTION_DIAL);
                iCall.setData(Uri.parse("tel:" + contact.getPhone()));
                context.startActivity(iCall);
            }
        });

        // Xử lý sự kiện cho nút nhắn tin
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri smsUri = Uri.parse("smsto:" + contact.getPhone());
                Intent iSMS = new Intent(Intent.ACTION_SENDTO, smsUri);
                iSMS.putExtra("sms_body", "input sms message");
                context.startActivity(iSMS);
            }
        });

        // Xử lý sự kiện khi người dùng nhấn vào mục trong ListView
        currentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popupMenu = new PopupMenu(context, view);
                MenuInflater inflater = popupMenu.getMenuInflater();
                inflater.inflate(R.menu.listcontact, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if (menuItem.getItemId() == R.id.menu_edit) {
                            Intent intent = new Intent(context, insContactActivity.class);
                            intent.putExtra("action", "edit");
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("listcontact", getItem(position));
                            intent.putExtras(bundle);
                            ((MainActivity) context).startActivityForResult(intent, MainActivity.REQUEST_CODE_EDIT);
                        } else if (menuItem.getItemId() == R.id.menu_del) {
                            myListContact.remove(position);
                            notifyDataSetChanged();
                        }
                        return true;
                    }
                });
                popupMenu.show();
            }
        });

        // Bind hình ảnh cho ImageView
        imgContact.setImageResource(contact.getImageID());

        return currentView;
    }
}
