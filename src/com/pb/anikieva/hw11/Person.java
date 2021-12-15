package com.pb.anikieva.hw11;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Person implements Serializable {

    private final static long serialVersionUID = 42;

    private  String name;
    private  String phone;
    private  String address;
    private transient LocalDate dateOfBirth;
    private transient LocalDateTime dateOfEdit;

    public String getName() {return name; }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public LocalDateTime getDateOfEdit() {
        return dateOfEdit;
    }

    public Person(String name, String phone) {
        this.name = name;
        this.phone = phone;
    }

    public Person(String name, String phone, String address, LocalDate dateOfBirth, LocalDateTime dateOfEdit) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEdit = dateOfEdit;
    }
    public String toString() {
        return "Имя " + getName() + ", телефон " + getPhone() + ", адрес " + getAddress() +
                ", дата рождения " + getDateOfBirth() + ", дата редактирования " + getDateOfEdit();
    }
}