package oop.zoo;

import java.util.Objects;

public class Rabbit extends Animal {
    public Rabbit(String name, int foodAmountPerDay) {
        super(name, foodAmountPerDay);
    }

    @Override
    public String makeSound() {
        return "Squeak!";
    }

    @Override
    public boolean isPredator() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Rabbit rabbit)) return false;
        return foodAmountPerDay == rabbit.foodAmountPerDay && Objects.equals(name, rabbit.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Rabbit{" +
                super.toString() +
                '}';
    }
}