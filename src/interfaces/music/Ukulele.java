package interfaces.music;

import java.util.Objects;

public class Ukulele extends MusicalInstrument {
    private int numberOfStrings;

    public Ukulele() {
    }

    public Ukulele(String name, String description, String history, int dateOfOrigin, String inventor, boolean isString, int numberOfStrings) {
        super(name, description, history, dateOfOrigin, inventor, isString);
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void sound() {
        System.out.println("plinka-plinka");
    }

    @Override
    public String show() {
        return this.getName();
    }

    @Override
    public String desc() {
        return this.getDescription();
    }

    @Override
    public String history() {
        return this.getHistory();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ukulele ukulele)) return false;
        if (!super.equals(o)) return false;
        return numberOfStrings == ukulele.numberOfStrings;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numberOfStrings);
    }

    @Override
    public String toString() {
        return "Ukulele{" +
                super.toString() +
                ", numberOfStrings=" + numberOfStrings +
                '}';
    }
}
