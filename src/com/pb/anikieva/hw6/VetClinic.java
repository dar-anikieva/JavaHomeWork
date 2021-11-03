package com.pb.anikieva.hw6;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

class VetСlinic {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        Class сlazz = Class.forName("com.pb.anikieva.hw6.Veterinarian");
        Veterinarian veterinarian = null;
        Constructor constr = сlazz.getConstructor(new Class[] {});
        Object obj = constr.newInstance();
        if (obj instanceof Veterinarian) veterinarian = (Veterinarian) obj;

        Dog dog1 = new Dog("чем угостит сторож", "на улице");
        Dog dog2 = new Dog("чем угостит сторож", "на улице", "дворняжка");
        Dog dog3 = new Dog("чем угостит сторож", "на улице", "дворняжка", "Рэмка");

        Cat cat1 = new Cat("сметана", "дача");
        Cat cat2 = new Cat("рыбу", "на рынке ", "Муся");

        Horse horse1 = new Horse("сено", "ферма");
        Horse horse2 = new Horse("трава", "поле", "гнедой");
        Horse horse3 = new Horse("сахарок", "заповедник", "белой");

        Animal[] animals = new Animal[] {dog1, dog2, dog3, cat1, cat2, horse1, horse2, horse3};

        for (Animal animal: animals) {
            if (veterinarian != null) {
                veterinarian.treatAnimal(animal);
            }
            animal.makeNoise();
            animal.eat();
            animal.sleep();
            if (animal instanceof Cat) ((Cat) animal).doHobby();
            if (animal instanceof Horse) ((Horse) animal).run();
        }
    }
}