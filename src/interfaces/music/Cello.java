package interfaces.music;

import java.util.Objects;

public class Cello extends MusicalInstrument {
    private float bodyLength;

    public Cello() {
    }

    public Cello(String name, String description, String history, int dateOfOrigin, String inventor, boolean isString, float bodyLength) {
        super(name, description, history, dateOfOrigin, inventor, isString);
        this.bodyLength = bodyLength;
    }

    @Override
    public void sound() {
        System.out.println("vooooom");
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
        if (!(o instanceof Cello cello)) return false;
        if (!super.equals(o)) return false;
        return Float.compare(bodyLength, cello.bodyLength) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bodyLength);
    }

    @Override
    public String toString() {
        return "Cello{" +
                super.toString() +
                ", bodyLength=" + bodyLength +
                '}';
    }
}
