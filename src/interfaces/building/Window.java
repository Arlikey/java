package interfaces.building;

import java.util.Objects;

public class Window implements IPart {
    private boolean built = false;

    public String getName() {
        return "Window";
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
        if (!(o instanceof Window window)) return false;
        return built == window.built;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(built);
    }

    @Override
    public String toString() {
        return "Window{" +
                "built=" + built +
                '}';
    }
}
