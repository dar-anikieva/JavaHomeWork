package com.pb.anikieva.hw11;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    public static void main(String[] args)  throws Exception {

        File file = Paths.get("person.data").toFile();
        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        Person person1 = new Person("Ivan", "0636970616", "str.Brooks 12",
                LocalDate.of(1998, 11, 15), LocalDateTime.now());
        Person person2 = new Person("Sima", "0654876536", "str.Second 10",
                LocalDate.of(2004, 5, 8), LocalDateTime.now());
        Person person3 = new Person("Boris", "0957685398", "str.While 71",
                LocalDate.of(1995, 3, 21), LocalDateTime.now() );

        List<Person> list = new ArrayList<>();

        list.add(new Person("Jenny", "0508973612", "str.Whole 34",
                LocalDate.of(1993, 11, 23), LocalDateTime.now()));
        list.add(person1);
        list.add(person2);
        list.add(person3);

        objectOutputStream.writeObject(list);
        System.out.println("File has been written!");
        objectOutputStream.close();

        System.out.println(new String(Files.readAllBytes(Paths.get("person.data"))));


        ArrayList<Person> newList = new ArrayList<>();

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("person.data"));
        newList = (ArrayList<Person>)objectInputStream.readObject();

        // System.out.printf("Name: %s \t Age: %d \n", p.getName(), p.getAge());;
        for(Person p : newList) {
            System.out.println(p.getName());
            System.out.println(p.toString());
        }

    }
}
