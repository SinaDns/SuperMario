import controller.IO;
import model.User;
import view.frames.GameSlotFrame;

public class Main {

    public static void main(String[] args) {


        // 5 default users
        User user1 = new User("anis", "1383");
        User user2 = new User("amir", "321");
        User user3 = new User("pasha", "185");
        User user4 = new User("sina", "daneshgar");
        User user5 = new User("mamad", "666");

//         for not being null exception
        User.loggedInUser.add(0, user1);


//        new FirstFrame();
        new GameSlotFrame();

        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                IO.getInstance().save();
            }
        }));
    }
}