package com.pb.anikieva.hw6;
import java.util.Objects;

public class Horse extends Animal{
    private static final String kind = "Конь";
    private String suit;

    public Horse() {
        super(kind);
    }

    public Horse(String food, String location) {
        super(food, location, kind);
    }

    public Horse(String food, String location, String suit) {
        super(food, location, kind);
        this.suit = suit;
    }

    @Override
    public void makeNoise(){
        StringBuilder text = new StringBuilder(kind);
        if (suit != null) text.append(" " + suit + " масти");
        text.append(" скачет ");
        System.out.println(text);
    }

    public String getSuit() {
        return suit;
    }

    @Override
    public void eat() {
        StringBuilder text = new StringBuilder(kind);
        if (suit != null) text.append(" " + suit + " масти");
        text.append(" ест " + super.getFood());
        System.out.println(text);
    }

    public void run() {
        StringBuilder text = new StringBuilder(kind);
        if (suit != null) text.append(" " + suit + " масти");
        text.append(" щиплет травку ");
        System.out.println(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return suit.equals(horse.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "suit='" + suit + '\'' +
                '}';
    }
}