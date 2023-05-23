import java.io.*;
import java.util.ArrayList;

public class LoadSave {

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
//            // read the data storage
//            DataStorage ds = (DataStorage) ois.readObject();
//
//            game.coins = ds.coins;
//
//        } catch (Exception e) {
//            System.out.println("exception thrown");
//        }
//    }