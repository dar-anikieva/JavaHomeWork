package com.pb.anikieva.hw13;

import java.util.Random;
import java.util.Stack;

public class Producer implements Runnable {

    int result;
    Random rand = new Random();
    Stack<Integer> A;

    public Producer(Stack<Integer> A) {
        this.A = A;
    }

    public void produce() {
        synchronized (A) {
            while (A.size() >= 5) {
                System.out.println("Список заполнен");
                try {
                    A.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            result = rand.nextInt(10);

            System.out.println(result + " Производитель ");
            A.push(result);
            System.out.println("stack ---"+A);

            A.notifyAll();
        }
    }

    @Override
    public void run() {
        System.out.println("Производитель начинает работу");

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            produce();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
