package interfaces.music;

import java.util.Objects;

public class Violin extends MusicalInstrument {
    private boolean isBowRequired;

    public Violin() {
    }

    public Violin(String name, String description, String history, int dateOfOrigin, String inventor, boolean isString, boolean isBowRequired) {
        super(name, description, history, dateOfOrigin, inventor, isString);
        this.isBowRequired = isBowRequired;
    }

    @Override
    public void sound() {
        System.out.println("eeeeeeEEEeeee");
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
        if (!(o instanceof Violin violin)) return false;
        if (!super.equals(o)) return false;
        return isBowRequired == violin.isBowRequired;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), isBowRequired);
    }

    @Override
    public String toString() {
        return "Violin{" +
                super.toString() +
                ", isBowRequired=" + isBowRequired +
                '}';
    }
}
