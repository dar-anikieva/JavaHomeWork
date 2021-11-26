package com.pb.anikieva.hw10;

public class Main {
    public static void main(String[] args) {

        NumBox<Integer> objInt = new NumBox<Integer>(10);

        try {
            objInt.add(15);
            objInt.add(45);
            objInt.add(30);
            objInt.add(35);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Число по индексу [3] - " + objInt.get(2));
        System.out.println("Текущее количество элементов " + objInt.length());
        System.out.println("Cреднее арифметического среди элементов массива " + objInt.average());
        System.out.println("Сумма всех элементов массива " + objInt.sum());
        System.out.println("Максимальный элемент массива " + objInt.max());

    }
}
