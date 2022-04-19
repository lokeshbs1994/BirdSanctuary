import java.util.*;

public class BirdRepository {
    //private List<Bird> birdList = new ArrayList();
    Set<Bird> birdList = new HashSet<>();

    static BirdRepository instance;

    private BirdRepository(){
    }

    public static synchronized BirdRepository getInstance(){
        if (instance == null){
            instance = new BirdRepository();
        }
        return instance;
    }

    public void add(Bird bird) {
        birdList.add(bird);
    }

    public Set<Bird> getBirdList() {
        return birdList;
    }

    public void remove(Bird bird) {
        birdList.remove(bird);
    }

    public Bird getBird(String name) {
//        for (int i = 0; i <= birdList.size(); i++) {
//            if (name.equalsIgnoreCase(birdList.get(i).name)) {
//                return birdList.get(i);
//            }
//        }
//        return null;
        return birdList.stream().filter(bird -> bird.name.equals(name)).findFirst().orElse(null);
    }
}
