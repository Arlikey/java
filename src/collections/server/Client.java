package collections.server;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Client implements Comparable<Client> {
    private String name;
    private int priority;
    private Request request;


    public Client(String name, int priority, Request request) {
        this.name = name;
        this.priority = priority;
        this.request = request;
    }

    public String getName() { return name; }

    public int getPriority() { return priority; }

    public Request getRequest() { return request; }

    public String getFullInfo(){
        return "Client: " + name + " | Priority = " + priority + request.getRequestInfo();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Client client)) return false;
        return priority == client.priority
                && Objects.equals(name, client.name)
                && Objects.equals(request, client.request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, priority, request);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                ", request=" + request +
                '}';
    }

    @Override
    public int compareTo(Client o) {
        return Integer.compare(this.priority, o.priority);
    }
}
