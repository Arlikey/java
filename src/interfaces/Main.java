package interfaces;

import interfaces.building.House;
import interfaces.building.Team;
import interfaces.building.TeamLeader;
import interfaces.building.Worker;
import interfaces.cipher.ACipher;
import interfaces.cipher.BCipher;
import interfaces.cipher.ICipher;
import interfaces.music.MusicalInstrument;
import interfaces.music.MusicalInstrumentFactory;

public class Main {
    public static void main(String[] args) {
        //music();

        //cipher();

        building();
    }

    public static void music() {
        MusicalInstrument[] instruments = MusicalInstrumentFactory.createInstuments();

        for (var instrument : instruments) {
            System.out.println("\nInstrument: " + instrument.show());
            System.out.print("\tSound: ");
            instrument.sound();
            System.out.println("\tDescription: " + instrument.desc());
            System.out.println("\tHistory: " + instrument.history());
            System.out.println("\tDate of Origin: " + instrument.getDateOfOrigin());
            System.out.println("\tInventor: " + instrument.getInventor());
        }
    }

    public static void cipher() {
        ICipher cipher = new ACipher("Hello World!");
        cipher.encode();
        System.out.println(cipher);
        cipher.decode();
        System.out.println(cipher);

        cipher = new BCipher("Hello World", 5);
        cipher.encode();
        System.out.println(cipher);
        cipher.decode();
        System.out.println(cipher);
    }

    private static void building() {
        House house = new House();
        Worker[] builders = {
                new Worker("Bob"),
                new Worker("Alice"),
                new Worker("John")
        };
        TeamLeader leader = new TeamLeader("Foreman Alex");
        Team team = new Team(builders, leader);
        team.buildHouse(house);
    }
}
