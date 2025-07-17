package oop.zoo;

import java.util.Objects;

public class Wolf extends Animal {
    public Wolf(String name, int foodAmountPerDay) {
        super(name, foodAmountPerDay);
    }

    @Override
    public String makeSound() {
        return "Howl!";
    }

    @Override
    public boolean isPredator() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Wolf wolf)) return false;
        return foodAmountPerDay == wolf.foodAmountPerDay && Objects.equals(name, wolf.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Wolf{" +
                super.toString() +
                '}';
    }
}