package collections.server;

import java.time.LocalDateTime;
import java.util.*;

public class Server {
    private PriorityQueue<Client> queue;
    private List<Client> statistics;

    private Random random = new Random();

    public Server() {
        queue = new PriorityQueue<>();
        statistics = new ArrayList<>();
    }

    public void addClient(Client client) {
        queue.add(client);
        statistics.add(client);
    }

    public void processQueue() throws InterruptedException {
        while (!queue.isEmpty()) {
            Client client = queue.poll();
            client.getRequest().setStartTime(LocalDateTime.now());
            System.out.println("Processing... : " + client.getFullInfo());
            int delay = 500 + random.nextInt(1000);
            Thread.sleep(delay);
            client.getRequest().setFinishTime(LocalDateTime.now());
        }
    }

    public void printStatistics() {
        System.out.println("\n=== Request statistics ===");
        for (Client client : statistics) {
            System.out.println(client.getFullInfo());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Server server)) return false;
        return Objects.equals(queue, server.queue) && Objects.equals(statistics, server.statistics) && Objects.equals(random, server.random);
    }

    @Override
    public int hashCode() {
        return Objects.hash(queue, statistics, random);
    }

    @Override
    public String toString() {
        return "Server{" +
                "queue=" + queue +
                ", statistics=" + statistics +
                ", random=" + random +
                '}';
    }
}
