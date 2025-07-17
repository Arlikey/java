package oop.zoo;

import java.util.Objects;

public class Tiger extends Animal {
    public Tiger(String name, int foodAmountPerDay) {
        super(name, foodAmountPerDay);
    }

    @Override
    public String makeSound() {
        return "Roar!";
    }

    @Override
    public boolean isPredator() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Tiger tiger)) return false;
        return foodAmountPerDay == tiger.foodAmountPerDay && Objects.equals(name, tiger.name);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Tiger{" +
                super.toString() +
                '}';
    }
}