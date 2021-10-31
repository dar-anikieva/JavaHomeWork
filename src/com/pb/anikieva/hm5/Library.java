package com.pb.anikieva.hm5;

public class Library {
    public static void main(String[] args) {
        Reader reader1 = new Reader("Петров В.В.", 1, "ИФ", "21.10.1999", "+3806311111");
        Reader reader2 = new Reader("Иванов И.И.", 2, "ИФ", "11.11.1997", "+3806322222");
        Reader reader3 = new Reader("Сидоров А.А.", 3, "ИФ", "05.04.2005", "+3806333333");
        Reader[] readers = {reader1, reader2, reader3};

        Book book1 = new Book("Задача трех тел", "Лю Цысинь");
        Book book2 = new Book("Дюна", "Фрэнк Герберт");
        Book book3 = new Book("Пикник на обочине", "Стругацкие");
        Book[] books = {book1, book2, book3};

        printReaders(readers);
        printBooks(books);

        reader1.takeBook(5);
        reader2.takeBook("Космобиолухи, Громыко", "Java программирование, Шилдт");
        reader3.takeBook(book1, book2,book3);

        reader1.returnBook(1);
        reader2.returnBook("Java программирование, Шилдт");
        reader3.returnBook(book3);
    }

    private static void printBooks(Book[] books) {
        System.out.println("Список книг:");
        for (Book book : books) {
            System.out.println(book.getInfo());
        }
        System.out.println();
    }

    private static void printReaders(Reader[] readers) {
        System.out.println("Список читателей:");
        for (Reader reader : readers) {
            System.out.println( reader.getInfo());
        }
        System.out.println();
    }

}
