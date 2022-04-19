import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UserInterface {

    private static UserInterface instance;

    private UserInterface() {
    }

    public static synchronized UserInterface getInstance() {
        if (instance == null) {
            instance = new UserInterface();
        }
        return instance;
    }

    public void printAllBirds(Set<Bird> list) {
//        for (int i = 0; i < list.size(); i++)
//            System.out.println(list.get(i));
        list.stream().forEach(System.out::println);
    }

    public int showMainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an option:\n 1. Add Bird\n 2. Remove Bird\n 3. Update\n 4. Print all Brid\n 5. Print Swimmable Birds\n 6. Print flyable birds\n 7. Print Eating Behaviour birds\n " + Controller.EXIT_VALUE + ". Exit");
        return (sc.nextInt());
    }

    public void printSwimmableBirds(Set<Bird> list) {
        list.stream().filter(bird -> bird.isSwimmable).forEach(System.out::println);
        //list.stream().filter(bird -> bird instanceof Swimmable).forEach(bird -> ((Swimmable) bird).swim());
    }

    public void printFlyableBirds(Set<Bird> birdList) {
        birdList.stream().filter(bird -> bird.isFlyable).forEach(System.out::println);
    }

    public void printEatingBehaviourBirds(Set<Bird> birdList) {
        birdList.forEach(Bird::eat);
    }
}

