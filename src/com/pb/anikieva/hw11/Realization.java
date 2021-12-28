package com.pb.anikieva.hw11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;

public class Realization {
    Scanner scanner = new Scanner(System.in);
    List<Klient> list = new ArrayList<>();
    Path path = Paths.get("klientsList.txt");


    public void start() {
        Work menu;
        do {
            menu = menu();
            switch (menu) {
                case ADD:
                    add();
                    break;
                case DELETE:
                    delete();
                    break;
                case SEARCH:
                    search();
                    break;
                case OUTPUT:
                    sortByName();
                    break;
                case OUTPUT2:
                    sortByAddress();
                    break;
                case EDITING:
                    editin();
                    break;
                case WRITING:
                    writeToFile();
                    break;
                case LOADING:
                    readToFile();
                    break;
            }
        } while (menu != Work.WorkintoMenu(9));
        System.out.println("Работа программы завершена!");
    }

    public void add() {
        int id = list.size();
        System.out.print("Укажите имя клиента: ");
        String name = scanner.next();
        System.out.print("Укажите дату рождения: ");
        String date = scanner.next();
        System.out.print("Укажите номер телефона: ");
        String phone = scanner.next();
        System.out.print("Укажите адрес: ");
        String address = scanner.next();
        LocalDateTime localDateTime = LocalDateTime.now();

        list.add(new Klient(id, name, date, phone, address, localDateTime));
        for (Klient klient : list) {
            System.out.println(klient);
        }
        System.out.println();
    }

    public void delete() {
        int id;
        for (Klient klient : list) {
            System.out.println(klient);
        }
        System.out.println();
        System.out.print("Укажите ID клиента который хотите удалить: ");
        id = scanner.nextInt();
        for (Klient klient1 : list) {
            if (klient1 == null) {
                return;
            }
            if (klient1.getId() == id) {
                list.remove(klient1);
                break;
            }
        }
        for (Klient klient1 : list) {
            System.out.println(klient1);
        }
        System.out.println();
    }

    public void search() {
        System.out.println("Имя клиента: ");
        String name = scanner.next();
        for (Klient klient1 : list) {
            if (klient1 == null) {
                return;
            }
            if (klient1.getFullName().equals(name)) {
                System.out.println(klient1 + "\n");
            }
        }
    }

    public void sortByName() {
        Comparator<Klient> comparator = Comparator.comparing(Klient::getFullName);
        list.sort(comparator);
        for (Klient klient : list) {
            System.out.println(klient);
        }
        System.out.println();
    }

    public void sortByAddress() {
        Comparator<Klient> comparator = Comparator.comparing(Klient::getAddress);
        list.sort(comparator);
        for (Klient klient : list) {
            System.out.println(klient);
        }
        System.out.println();
    }

    public void editin() {
        System.out.print("Укажите ID клиента данные которого хотите отредактировать: ");
        int n = scanner.nextInt();
        for (Klient klient : list) {
            if (klient == null) {
                return;
            }
            if (klient.getId() == n) {
                System.out.print("Укажите новое имя: ");
                String name = scanner.next();
                System.out.print("Укажите новую дату рождения: ");
                String date = scanner.next();
                System.out.print("Укажите новый телефон: ");
                String phone = scanner.next();
                System.out.print("Укажите новый адрес: ");
                String address = scanner.next();
                klient.setFullName(name);
                klient.setDate(date);
                klient.setPhone(phone);
                klient.setAddress(address);
                klient.setLocalDateTime(LocalDateTime.now());
            }
        }
        for (Klient klient : list) {
            System.out.println(klient);
        }
        System.out.println();
    }

    public void writeToFile() {

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            for (Klient klient : list) {
                writer.write(String.valueOf(klient));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readToFile() {
        String line;
        try (BufferedReader reader = Files.newBufferedReader(path)) {
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Work menu() {
        int menu = 0;
        for (Work works : Work.values()) {
            System.out.println(works);
        }
        menu = getIntRange(1, 9);
        return Work.WorkintoMenu(menu);
    }

    private int getIntRange(int from, int to) {
        int menu = 0;
        do {
            System.out.print(">>> ");
            String input = scanner.next();
            menu = Integer.parseInt(input);
            try {
            } catch (Throwable ex) {
                System.out.println("Введите число от " + from + " до " + to);
            }
        } while (menu < from || menu > to);

        return menu;
    }
}