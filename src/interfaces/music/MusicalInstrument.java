package interfaces.music;

import java.util.Objects;

public abstract class MusicalInstrument implements IInfo {
    protected String name;
    protected String description;
    protected String history;
    protected int dateOfOrigin;
    protected String inventor;
    protected boolean isString;

    public MusicalInstrument() {

    }

    public MusicalInstrument(String name, String description, String history, int dateOfOrigin, String inventor, boolean isString) {
        this.name = name;
        this.description = description;
        this.history = history;
        this.dateOfOrigin = dateOfOrigin;
        this.inventor = inventor;
        this.isString = isString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public int getDateOfOrigin() {
        return dateOfOrigin;
    }

    public void setDateOfOrigin(int dateOfOrigin) {
        this.dateOfOrigin = dateOfOrigin;
    }

    public String getInventor() {
        return inventor;
    }

    public void setInventor(String inventor) {
        this.inventor = inventor;
    }

    public boolean isString() {
        return isString;
    }

    public void setString(boolean string) {
        isString = string;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MusicalInstrument that)) return false;
        return dateOfOrigin == that.dateOfOrigin
                && isString == that.isString
                && Objects.equals(name, that.name)
                && Objects.equals(description, that.description)
                && Objects.equals(history, that.history)
                && Objects.equals(inventor, that.inventor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, history, dateOfOrigin, inventor, isString);
    }

    @Override
    public String toString() {
        return "MusicalInstrument{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", history='" + history + '\'' +
                ", dateOfOrigin=" + dateOfOrigin +
                ", inventor='" + inventor + '\'' +
                ", isString=" + isString +
                '}';
    }
}
