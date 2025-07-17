package oop.zoo;

import java.util.Objects;

public abstract class Animal {
    protected String name;
    protected int foodAmountPerDay;

    public Animal(String name, int foodAmountPerDay) {
        this.name = name;
        this.foodAmountPerDay = foodAmountPerDay;
    }

    public abstract String makeSound();

    public abstract boolean isPredator();

    public int getFoodAmountPerDay() {
        return foodAmountPerDay;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Animal animal)) return false;
        return foodAmountPerDay == animal.foodAmountPerDay && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, foodAmountPerDay);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", foodAmountPerDay=" + foodAmountPerDay +
                '}';
    }
}
