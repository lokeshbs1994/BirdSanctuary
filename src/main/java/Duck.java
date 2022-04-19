public class Duck extends Bird implements Swimmable, Flyable {
    public Duck() {
        name = "Duck";
        colour = Colour.WHITE;
    }

    @Override
    public void fly() {
        System.out.println("Duck can fly");
    }

    @Override
    public void swim() {
        System.out.println("Duck can swim");
    }

}
