package interfaces.building;

import java.util.Objects;

public class Basement implements IPart {
    private boolean built = false;

    public String getName() {
        return "Basement";
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
        if (!(o instanceof Basement basement)) return false;
        return built == basement.built;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(built);
    }

    @Override
    public String toString() {
        return "Basement{" +
                "built=" + built +
                '}';
    }
}
