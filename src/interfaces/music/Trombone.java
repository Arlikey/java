package interfaces.music;

import java.util.Objects;

public class Trombone extends MusicalInstrument {
    private boolean isHasSlideMechanism;

    public Trombone() {
    }

    public Trombone(String name, String description, String history, int dateOfOrigin, String inventor, boolean isString, boolean isHasSlideMechanism) {
        super(name, description, history, dateOfOrigin, inventor, isString);
        this.isHasSlideMechanism = isHasSlideMechanism;
    }

    @Override
    public void sound() {
        System.out.println("waaaaAAAAHHHH");
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
        if (!(o instanceof Trombone trombone)) return false;
        if (!super.equals(o)) return false;
        return isHasSlideMechanism == trombone.isHasSlideMechanism;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isHasSlideMechanism);
    }

    @Override
    public String toString() {
        return "Trombone{" +
                super.toString() +
                ", isHasSlideMechanism=" + isHasSlideMechanism +
                '}';
    }
}
