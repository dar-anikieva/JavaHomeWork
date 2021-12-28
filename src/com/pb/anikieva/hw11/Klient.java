package com.pb.anikieva.hw11;

import java.time.LocalDateTime;
import java.util.Date;

public class Klient {
    // private static int count;
    private int id;
    private String fullName;
    private String date;
    private String phone;
    private  String address;
    private LocalDateTime localDateTime;

    public Klient(int id, String fullName, String date, String phone, String address, LocalDateTime localDateTime) {
        this.id = ++id;
        this.fullName = fullName;
        this.date = date;
        this.phone = phone;
        this.address = address;
        this.localDateTime = localDateTime;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String  date) {
        this.date = date;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "Klient{" + "id: " + id + ", имя: " + fullName + ", дата рождения: " + date +
                ", телефон: " + phone + ", адрес: " + address + ", дата и время редактирования: " + localDateTime +'}';
    }
}
