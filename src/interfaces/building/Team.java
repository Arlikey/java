package interfaces.building;

import java.util.Arrays;
import java.util.Objects;

public class Team {
    private final IWorker[] workers;
    private final TeamLeader leader;

    public Team(IWorker[] workers, TeamLeader leader) {
        this.workers = workers;
        this.leader = leader;
    }

    public void buildHouse(House house) {
        while (house.isCompleted()) {
            for (IWorker worker : workers) {
                if (house.isCompleted())
                    worker.work(house);
            }
            leader.work(house);
            System.out.println();
        }

        System.out.println("Building completed!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Team team)) return false;
        return Objects.deepEquals(workers, team.workers) && Objects.equals(leader, team.leader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(workers), leader);
    }

    @Override
    public String toString() {
        return "Team{" +
                "workers=" + Arrays.toString(workers) +
                ", leader=" + leader +
                '}';
    }
}
