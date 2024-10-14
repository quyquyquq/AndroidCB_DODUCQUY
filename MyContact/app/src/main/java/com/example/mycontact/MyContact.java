package com.example.mycontact;

import java.io.Serializable;

public class MyContact implements Serializable {
    int imageID;
    String name, phone;

    public MyContact(){

    }

    public MyContact(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public MyContact(int imageID, String name, String phone) {
        this.imageID = imageID;
        this.name = name;
        this.phone = phone;
    }

    public int getImageID() {
        return imageID;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
