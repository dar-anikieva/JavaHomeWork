package com.pb.anikieva.hw13;
import java.util.Queue;
import java.util.Stack;


public class Consumer implements Runnable {
    Stack<Integer> A;

    public Consumer(Stack<Integer> A) {
        this.A = A;
    }

    public void consume() {
        synchronized (A) {
            while (A.isEmpty()) {
                System.err.println("Список пустой" + A + A.size());
                try {
                    System.err.println("Потребитель wait");
                    A.wait();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.err.println(A.pop() + " Consumed " + A);
            A.notifyAll();
        }
    }

    @Override
    public void run() {
        System.out.println("Начало работы нового потребителя");
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (true) {
            consume();
        }
    }
}