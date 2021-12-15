package com.pb.anikieva.hw12;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Contact implements Serializable {

    private final static long serialVersionUID = 42;

    private String name;
    private String phone1;
    private String phone2;
    private String address;
    private LocalDate dateOfBirth;
    private LocalDateTime dateOfEdit;

    public void setName(String name, LocalDateTime dateOfEdit) {
        this.name = name; this.dateOfEdit = LocalDateTime.now();
    }
    public void setPhone1(String phone1, LocalDateTime dateOfEdit) {
        this.phone1 = phone1; this.dateOfEdit = LocalDateTime.now();
    }

    public void setPhone2(String phone2, LocalDateTime dateOfEdit) {
        this.phone2 = phone2; this.dateOfEdit = LocalDateTime.now();
    }

    public void setAddress(String address, LocalDateTime dateOfEdit) {
        this.address = address; this.dateOfEdit = LocalDateTime.now();
    }

    public void setDateOfBirth(LocalDate dateOfBirth, LocalDateTime dateOfEdit) {
        this.dateOfBirth = dateOfBirth; this.dateOfEdit = LocalDateTime.now();
    }

    public String getName() {return name;  }

    public String getPhone1() {return phone1; }

    public String getPhone2() {return phone2; }

    public String getAddress() { return address; }

    public LocalDate getDateOfBirth() {return dateOfBirth;  }

    public LocalDateTime getDateOfEdit() { return dateOfEdit; }

    public Contact(String name, String phone1, String phone2, String address, LocalDate dateOfBirth, LocalDateTime dateOfEdit) {
        this.name = name;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.dateOfEdit = dateOfEdit;
    }
    public Contact(String name, String phone, LocalDateTime dateOfEdit) {
        this.name = name;
        this.phone1 = phone;
        this.dateOfEdit = LocalDateTime.now();
    }

    public String toString() {
        return "Имя: " + getName() + " Телефон: " + getPhone1() + ", " + getPhone2() + " Адрес: " + getAddress() +
                " Дата рождения: " + getDateOfBirth() + " Дата редактирования: " + getDateOfEdit();
    }
    public String getInfo() {
        return "Имя: " + getName() + " Телефон: " + getPhone1() + ", " + " Дата редактирования: " + getDateOfEdit();
    }
}
