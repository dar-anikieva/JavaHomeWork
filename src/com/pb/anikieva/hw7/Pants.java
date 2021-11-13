package com.pb.anikieva.hw7;

public class Pants extends Clothes implements ManClothes, WomanClothes {

    private String name;

    public Pants(Size size, String colour, int price, String name) {
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
    @Override
    public void dressWooMan() {
        System.out.println("название: " + name +
                " размер: " + this.getSize() +
                " цена: " + this.getPrice() +
                " цвет: " + this.getColour());
    }
}
