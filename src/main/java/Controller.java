import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Controller {
    //    BirdRepository birdRepository = BirdRepository.getInstance();
//    UserInterface ui = UserInterface.getInstance();
    Scanner sc = new Scanner(System.in);
    static final int EXIT_VALUE = 8;

    public static void main(String[] args) {

        Controller controller = new Controller();
        int option = 0;
        do {
            option = UserInterface.getInstance().showMainMenu();
            controller.handleUserSelection(option);
        } while (option != EXIT_VALUE);
    }

    public void handleUserSelection(int option) {
        BirdRepository birdRepository = BirdRepository.getInstance();
        UserInterface userInterface = UserInterface.getInstance();
        switch (option) {
            case 1:
                addBird();
                break;
            case 2:
                System.out.println("Enter a Bird");
                String birdName = sc.next();
                Bird bird = birdRepository.getBird(birdName);
                birdRepository.remove(bird);
                break;
            case 3:
                System.out.println("Enter the Bird name to update");
                String birdName1 = sc.next();
                Bird bird1 = birdRepository.getBird(birdName1);
                updateBird(bird1);
                break;
            case 4:
                Set<Bird> birdList = birdRepository.getBirdList();
                userInterface.printAllBirds(birdList);
                break;
            case 5:
                userInterface.printSwimmableBirds(birdRepository.getBirdList());
                break;
            case 6:
                userInterface.printFlyableBirds(birdRepository.getBirdList());
                break;
            case 7:
                userInterface.printEatingBehaviourBirds(birdRepository.getBirdList());
                break;
            case 8:
                System.out.println("Exiting from menu");
                break;
            default:
                System.out.println("Invaild Option selected.");
        }
    }

    private void addBird() {
        BirdRepository birdRepository = BirdRepository.getInstance();
        Bird bird = new Bird();
        System.out.println("Enter Bird id ");
        bird.id = sc.next();
        System.out.println("Enter the name of new bird");
        bird.name = sc.next();
        System.out.println("Choose Colour");
        setBirdColour(bird);
        System.out.println("Choose Gender");
        setBirdGender(bird);
        System.out.println("Enter is bird flyable ?");
        bird.isFlyable = sc.nextBoolean();
        System.out.println("Enter is bird swimmable ?");
        bird.isSwimmable = sc.nextBoolean();

        birdRepository.add(bird);
    }

    public void updateBird(Bird bird) {
        System.out.println("Choose anyone to Update:\n 1. Name\n 2. Colour \n 3. Gender \n 4. Fly \n 5. Swim \n 6.Id");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter the name");
                bird.name = sc.next();
                break;
            case 2:
                setBirdColour(bird);
                break;
            case 3:
                setBirdGender(bird);
                break;
            case 4:
                System.out.println("Enter bird is Flyable");
                bird.isSwimmable = sc.nextBoolean();
                break;
            case 5:
                System.out.println("Enter bird is Swimmable");
                bird.isSwimmable = sc.nextBoolean();
                break;
            case 6:
                System.out.println("Enter the new Id");
                bird.id = sc.next();
            default:
                System.out.println("Invalid choice");
        }
    }

    private void setBirdGender(Bird bird) {
        System.out.println("Enter the choice \n 1. MALE \n 2. FEMALE \n 3. OTHER");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                bird.gender = Bird.Gender.MALE;
                break;
            case 2:
                bird.gender = Bird.Gender.FEMALE;
                break;
            case 3:
                bird.gender = Bird.Gender.OTHER;
                break;
            default:
                System.out.println("Invalid option");
        }
    }

    private void setBirdColour(Bird bird) {
        System.out.println("Enter the choice \n 1. GREEN \n 2. RED \n 3. BLACK \n 4. YELLOW \n 5. BLACK_WHITE \n 6. WHITE ");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                bird.colour = Bird.Colour.GREEN;
                break;
            case 2:
                bird.colour = Bird.Colour.RED;
                break;
            case 3:
                bird.colour = Bird.Colour.BLACK;
                break;
            case 4:
                bird.colour = Bird.Colour.YELLOW;
                break;
            case 5:
                bird.colour = Bird.Colour.BLACK_WHITE;
                break;
            case 6:
                bird.colour = Bird.Colour.WHITE;
                break;
            default:
                System.out.println("Invalid option");
        }
    }

}
