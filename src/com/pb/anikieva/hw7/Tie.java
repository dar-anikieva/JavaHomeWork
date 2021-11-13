package com.pb.anikieva.hw7;

public class Tie extends Clothes implements ManClothes {

    private String name;

    public Tie(Size size, String colour, int price, String name) {
        super(size, colour, price);
        this.name = name;
    }
    @Override
    public void dressMan() {
        System.out.println("название: " + name +
                " размер: " + this.getSize() +
                " цена: " + this.getPrice() +
                " цвет: " + this.getColour());
    }
}