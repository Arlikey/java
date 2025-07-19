package interfaces.music;

public class MusicalInstrumentFactory {
    public static MusicalInstrument[] createInstuments() {
        return new MusicalInstrument[]{
                createCello(),
                createViolin(),
                createUkulele(),
                createTrombone()
        };
    }

    public static Cello createCello() {
        return new Cello(
                "Cello",
                "A large bowed string instrument with a rich, deep tone.",
                "The cello originated in Italy around 1535, likely by Andrea Amati. It became a staple in orchestras in the 17th century.",
                1535,
                "Andrea Amati",
                true,
                75.0f
        );
    }

    public static Violin createViolin() {
        return new Violin(
                "Violin",
                "A small, bright-sounding string instrument often used in classical music.",
                "The violin appeared in Italy around 1550. It was developed from older instruments like the rebec and refined by Andrea Amati.",
                1550,
                "Andrea Amati",
                true,
                true
        );
    }

    public static Trombone createTrombone() {
        return new Trombone(
                "Trombone",
                "A brass instrument with a sliding mechanism and bold sound.",
                "Originated around 1450 in Burgundy. Evolved from the sackbut and became key in Renaissance and jazz music.",
                1450,
                "Unknown",
                false,
                true
        );
    }

    public static Ukulele createUkulele() {
        return new Ukulele(
                "Ukulele",
                "A small, cheerful four-string instrument associated with Hawaiian music.",
                "Developed in the late 1800s in Hawaii, inspired by the Portuguese machete. Name means 'jumping flea' in Hawaiian.",
                1879,
                "João Fernandes, Augusto Dias, Manuel Nunes",
                true,
                4
        );
    }
}
