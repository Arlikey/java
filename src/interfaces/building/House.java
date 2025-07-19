package interfaces.building;

import java.util.Arrays;
import java.util.Objects;

public class House {
    private final Basement basement = new Basement();
    private final Wall[] walls = {new Wall(), new Wall(), new Wall(), new Wall()};
    private final Window[] windows = {new Window(), new Window(), new Window(), new Window()};
    private final Door door = new Door();
    private final Roof roof = new Roof();

    public IPart[] getAllParts() {
        IPart[] parts = new IPart[11];
        int index = 0;

        parts[index++] = basement;

        for (Wall wall : walls)
            parts[index++] = wall;

        parts[index++] = door;

        for (Window window : windows)
            parts[index++] = window;

        parts[index++] = roof;

        return parts;
    }

    public boolean isCompleted() {
        IPart[] parts = getAllParts();

        for (IPart part : parts)
            if (!part.isBuilt()) return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House house)) return false;
        return Objects.equals(basement, house.basement) && Objects.deepEquals(walls, house.walls) && Objects.deepEquals(windows, house.windows) && Objects.equals(door, house.door) && Objects.equals(roof, house.roof);
    }

    @Override
    public int hashCode() {
        return Objects.hash(basement, Arrays.hashCode(walls), Arrays.hashCode(windows), door, roof);
    }

    @Override
    public String toString() {
        return "House{" +
                "basement=" + basement +
                ", walls=" + Arrays.toString(walls) +
                ", windows=" + Arrays.toString(windows) +
                ", door=" + door +
                ", roof=" + roof +
                '}';
    }
}
