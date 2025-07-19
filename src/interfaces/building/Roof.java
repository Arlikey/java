package interfaces.building;

import java.util.Objects;

public class Roof implements IPart {
    private boolean built = false;

    public String getName() {
        return "Roof";
    }

    public boolean isBuilt() {
        return built;
    }

    public void build() {
        built = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Roof roof)) return false;
        return built == roof.built;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(built);
    }

    @Override
    public String toString() {
        return "Roof{" +
                "built=" + built +
                '}';
    }
}
