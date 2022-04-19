public class Bird {

    enum Colour {
        GREEN, RED, BLACK, YELLOW, BLACK_WHITE, WHITE;
    }

    enum Gender {
        MALE, FEMALE, OTHER;
    }

    String id;
    String name;
    Colour colour;
    Gender gender;
    Boolean isFlyable;
    Boolean isSwimmable;

    void eat() {
        System.out.println(name + " can eat");
    }

    boolean doesMakesNest(boolean value) {
        return false;
    }

    @Override
    public String toString() {
        return "Bird{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", colour=" + colour +
                ", gender=" + gender +
                ", isFlyable=" + isFlyable +
                ", isSwimmable=" + isSwimmable +
                '}';
    }
}
