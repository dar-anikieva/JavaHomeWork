package com.pb.anikieva.hw12;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static ArrayList<Contact> contacts = new ArrayList<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        boolean exit = false;

        do {
            System.out.println("1.Добавить контакт\n" +
                    "2.Удалить контакт\n" +
                    "3.Вывести на экран все записи\n" +
                    "4.Поиск по номеру\n" +
                    "5.Поиск по имени\n" +
                    "6.Редактировать\n" +
                    "7.Запись в файл всех данных\n" +
                    "8.Загрузка из файла всех данных\n" +
                    "9.Выход?");

            int com = in.nextInt();

            switch (com) {
                case 1:
                    contactNew();
                    break;
                case 2:
                    contactDelete();
                    break;
                case 3:
                    contactView();
                    break;
                case 4:
                    contactSearchPhone();
                    break;
                case 5:
                    contactSearchName();
                    break;
                case 6:
                    contactEdit();
                    break;
                case 7:
                    contactWrite();
                    break;
                case 8:
                    contactRead();
                    break;
                case 9:
                    exit = true;
                    break;
                default:
                    System.out.println("Неверная команда. Попробуйте еще раз. \n");

            }
        }  while (!exit);
    }

    private static void contactNew() {
        System.out.println("Введите имя ");
        String name = in.next();
        System.out.println("Введите номер телефона: ");
        String phone1 = in.next();
        System.out.println("Введите дополнительный номер телефона: ");
        String phone2 = in.next();
        System.out.println("Введите адрес: ");
        String address = in.next();
        System.out.println("Введите дату рождения через в формате XXXX XX XX через пробел: ");
        LocalDate dateOfBirth = LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt());

        try {
            contacts.add( new Contact(name, phone1, phone2, address, dateOfBirth, LocalDateTime.now()));
            System.out.println("Контакт сохранен! ");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("String: " + e);
        }
        System.out.println();
    }


    private static void contactDelete() {
        System.out.println("Введите имя абонента для удаления ");
        contacts.removeIf(c -> c.getName().equals(in.next()));
        System.out.println("Контакт удален! ");
    }
    private static void contactView() {
        contacts.stream().forEach(System.out :: println);
    }

    private static void contactSearchPhone() {
        System.out.println("Введите номер абонента для поиска: ");
        contacts.stream().filter(c -> c.getPhone1().equals(in.next())).forEach(System.out :: println);
        contacts.stream().filter(c -> c.getPhone2().equals(in.next())).forEach(System.out :: println);
    }
    private static void contactSearchName() {
        System.out.println("Введите имя абонента для поиска: ");
        contacts.stream().filter(c -> c.getName().equals(in.next())).forEach(System.out :: println);
    }
    private static void contactEdit() {
        if (contacts.isEmpty()) {
            System.out.println("Список пуст! ");
        } else {
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println("#" + (i + 1) + " " + contacts.get(i));
            }
            System.out.println();
        }
        System.out.println("Введите номер редактируемого контакта: ");
        int index = in.nextInt();

        try {
            boolean exit = false;

            do {
                System.out.println("Введите 1, если хотите отредактировать имя\n" +
                        "Введите 2, если хотите отредактировать первый номер\n" +
                        "Введите 3, если хотите отредактировать второй номер\n" +
                        "Введите 4, если хотите отредактировать адрес\n" +
                        "Введите 5, если хотите отредактировать дату\n" +
                        "Введите 6, если хотите выйти\n");

                int com = in.nextInt();

                switch (com) {
                    case 1:
                        System.out.println("Старое имя " + contacts.get(index-1).getName());
                        System.out.println("Введите новое имя: ");
                        contacts.set(index-1, contacts.get(index-1)).setName(in.next(), LocalDateTime.now());
                        System.out.println("Новое имя: " + contacts.get(index-1).getName());

                        //contacts.set(index-1, contacts.get(index-1));
                        System.out.println("Контакт сохранен! ");
                        break;
                    case 2:
                        System.out.println("Старый телефон: " + contacts.get(index-1).getPhone1());
                        System.out.println("Введите новый номер телефона: ");
                        contacts.set(index-1, contacts.get(index-1)).setPhone1(in.next(), LocalDateTime.now());
                        System.out.println("Новый телефон: " + contacts.get(index-1).getPhone1());

                        System.out.println("Контакт сохранен! ");
                        break;
                    case 3:
                        System.out.println("Старый телефон: " + contacts.get(index-1).getPhone2());
                        System.out.println("Введите новый номер телефона: ");
                        contacts.set(index-1, contacts.get(index-1)).setPhone2(in.next(), LocalDateTime.now());
                        System.out.println("Новый телефон: " + contacts.get(index-1).getPhone1());

                        System.out.println("Контакт сохранен! ");
                        break;
                    case 4:
                        System.out.println("Старый адрес: " + contacts.get(index-1).getAddress());
                        System.out.println("Введите новый адрес: ");
                        contacts.set(index-1, contacts.get(index-1)).setAddress(in.next(), LocalDateTime.now());
                        System.out.println("Новый адрес: " + contacts.get(index-1).getAddress());

                        System.out.println("Контакт сохранен! ");
                        break;
                    case 5:
                        System.out.println("Старая дата рождения: " + contacts.get(index-1).getDateOfBirth());
                        System.out.println("Введите новую дату рождения через в формате XXXX XX XX через пробел: ");
                        contacts.set(index-1, contacts.get(index-1)).setDateOfBirth(LocalDate.of(in.nextInt(), in.nextInt(), in.nextInt()),
                                LocalDateTime.now());
                        System.out.println("Новая дата рождения: " + contacts.get(index-1).getDateOfBirth());

                        System.out.println("Контакт сохранен! ");
                        break;
                    case 6:
                        exit = true;
                        break;
                    default:
                        System.out.println("Неверная команда. Попробуйте еще раз. \n");
                }
            }  while (!exit);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("String: " + e);
        }
        System.out.println();
    }
    private static void contactWrite() throws IOException {
        File file = Paths.get("contacts.data").toFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(contacts);
        System.out.println("Файл записан! ");
        objectOutputStream.close();
        System.out.println(new String(Files.readAllBytes(Paths.get("contacts.data"))));
    }
    private static void contactRead() throws IOException, ClassNotFoundException {
        ArrayList<Contact> newContacts;
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("contacts.data"));
        newContacts = (ArrayList<Contact>) objectInputStream.readObject();
        for (Contact c : newContacts) {
            System.out.println(c.toString());
        }
    }

}
