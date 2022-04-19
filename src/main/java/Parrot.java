public class Parrot extends Bird implements Flyable{
    public Parrot() {
        this.name="Parrot";
        colour = Colour.GREEN;

    }

    @Override
    public void fly() {
        System.out.println("Parrot can fly");
    }
}
