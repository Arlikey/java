package interfaces.building;

import java.util.Objects;

public class TeamLeader implements IWorker {
    private final String name;

    public TeamLeader(String name) {
        this.name = name;
    }

    public void work(House house) {
        IPart[] parts = house.getAllParts();

        int builtCount = 0;
        for (IPart iPart : parts) if (iPart.isBuilt()) builtCount++;

        System.out.println("REPORT:" + "\n\tfrom: " + name + "\n\tparts: " + builtCount + "/" + parts.length + " are built." + "\n\tprogress:");

        int index = 0;
        for (IPart part : parts) {
            System.out.println("\t\t" + ++index + ". " + part.getName() + ": " + (part.isBuilt() ? "done" : "in progress"));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeamLeader that)) return false;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "TeamLeader{" +
                "name='" + name + '\'' +
                '}';
    }
}
