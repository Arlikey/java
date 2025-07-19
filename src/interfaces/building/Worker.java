package interfaces.building;

import java.util.Objects;

public class Worker implements IWorker {
    private final String name;

    public Worker(String name) {
        this.name = name;
    }

    public void work(House house) {
        IPart[] parts = house.getAllParts();

        for (IPart part : parts) {
            if (!part.isBuilt()) {
                part.build();
                System.out.println(name + " built: " + part.getName());
                break;
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Worker worker)) return false;
        return Objects.equals(name, worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                '}';
    }
}
