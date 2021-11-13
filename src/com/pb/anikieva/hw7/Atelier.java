package com.pb.anikieva.hw7;

public class Atelier {
    public static void main(String[] args) {

        Tshirt tshirt = new Tshirt(Size.S, "красный", 100, "футболка");
        Pants pants = new Pants(Size.M, "черный", 250, "штаны");
        Skirt skirt = new Skirt(Size.XS, "голубой", 200, "юбка");
        Tie tie = new Tie(Size.L, "коричневый", 150, "галстук");

        Clothes[] clothes = new Clothes[]{tshirt, pants, skirt, tie};
        dressWooMan(clothes);
        dressMan(clothes);
    }
    public static void dressWooMan(Clothes[] clothes) {
        System.out.println("Женская одежда: ");
        for (Clothes c : clothes) {
            if (c instanceof WomanClothes) {
                ((WomanClothes) c).dressWooMan();
            }
        }
    }
    public static void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда: ");
        for (Clothes c : clothes) {
            if (c instanceof ManClothes) {
                ((ManClothes) c).dressMan();
            }
        }
    }
}