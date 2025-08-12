package collections;

import collections.db.Fine;
import collections.db.FineDatabase;
import collections.db.FineType;
import collections.db.PersonRecord;
import collections.server.Client;
import collections.server.Request;
import collections.server.Server;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        //server();

        fineDb();
    }

    private static void server(){
        Server server = new Server();

        server.addClient(new Client("Mr. Joke", 2, new Request("Get data")));
        server.addClient(new Client("Kira", 1, new Request("SQL-Injection")));
        server.addClient(new Client("AE-132S", 3, new Request("Download image")));
        server.addClient(new Client("eYeLeSS", 2, new Request("Send message")));


        System.out.println("=== Working with queue by priority ===");
        try {
            server.processQueue();
        }
        catch (InterruptedException ex){
            System.out.println(ex.getMessage());
        }

        server.printStatistics();
    }

    private static void fineDb(){
        FineDatabase db = new FineDatabase();

        PersonRecord p1 = new PersonRecord("1234567890", "Ivan Petrov", "Kyiv");
        PersonRecord p2 = new PersonRecord("9876543210", "Maria Ivanova", "Lviv");
        db.addPerson(p1);
        db.addPerson(p2);

        Fine f1 = new Fine(FineType.TRAFFIC, 150.0, "Speeding", null);
        Fine f2 = new Fine(FineType.TAX, 1000.0, "Late tax filing",
                LocalDateTime.of(2024, 12, 1, 21, 42, 10));
        Fine f3 = new Fine(FineType.TRAFFIC, 200.0, "Red light",
                LocalDateTime.of(2025, 3, 5, 12, 32, 1));

        db.addFineToPerson("1234567890", f1);
        db.addFineToPerson("1234567890", f2);
        db.addFineToPerson("9876543210", f3);

        db.printAll();

        System.out.println();

        db.printByPin("1234567890");

        System.out.println();

        db.printByFineType(FineType.TRAFFIC);

        System.out.println();

        db.printByCity("Lviv");

        System.out.println("\nRemoving fine " + f2.getFineId() + " from PID 1234567890");
        db.removeFine("1234567890", f2.getFineId());

        System.out.println();
        db.printByPin("1234567890");

        PersonRecord p1Replacement = new PersonRecord(null, "Ivan Petrov", "Odesa");
        p1Replacement.addFine(new Fine(FineType.OTHER, 300.0, "Administrative", LocalDateTime.now()));
        db.replacePerson("1234567890", p1Replacement);
        db.printByPin("1234567890");
    }
}