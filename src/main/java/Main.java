import model.IO;
import model.User;
import view.FirstFrame;

public class Main {

    public static void main(String[] args) {


        // 5 default users
        User user1 = new User("anis", "snd");
        User user2 = new User("amir", "321");
        User user3 = new User("pasha", "185");
        User user4 = new User("sina", "daneshgar");
        User user5 = new User("mamad", "666");

//         for not being null
        User.loggedInUser.add(0, user1);


        new FirstFrame();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                IO.getInstance().save();
            }
        }));
    }
}



//    model.Game game;
//
//    LoadSave(model.Game game) {
//        this.game = game;
//
//    }
//
//
//    public void save() {
//
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("save.dat")));
//
//            DataStorage ds = new DataStorage();
//
//            ds.highScore = game.coins;
//
//
//            // Write the data storage object
//            oos.writeObject(ds);
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//
//    public void load() {
//
//
//        try {
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("save.dat")));
//
//
//            // read the data storage
//            DataStorage ds = (DataStorage) ois.readObject();
//
//            game.coins = ds.coins;
//
//        } catch (Exception e) {
//            System.out.println("exception thrown");
//        }
//    }