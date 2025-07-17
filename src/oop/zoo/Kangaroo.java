package oop.zoo;

import java.util.Objects;

public class Kangaroo extends Animal {
    public Kangaroo(String name, int foodAmountPerDay) {
        super(name, foodAmountPerDay);
    }

    @Override
    public String makeSound() {
        return "Chortle!";
    }

    @Override
    public boolean isPredator() {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Kangaroo kangaroo)) return false;
        return foodAmountPerDay == kangaroo.foodAmountPerDay && Objects.equals(name, kangaroo.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Kangaroo{" +
                super.toString() +
                '}';
    }
}