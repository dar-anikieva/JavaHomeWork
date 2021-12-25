package com.pb.anikieva.hw13;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String args[]) {

        Stack<Integer> stack = new Stack<>();

        Producer producer = new Producer(stack);// p
        Consumer consumer = new Consumer(stack);// c
        Thread producerTread = new Thread(producer);
        Thread consumerTread = new Thread(consumer);

        producerTread.start();
        consumerTread.start();
    }
}
