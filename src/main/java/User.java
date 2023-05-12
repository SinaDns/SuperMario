import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;


@JsonPropertyOrder(value = {"users", "loggedInUser"})
public class User {

    public static ArrayList<User> loggedInUser;
    static ArrayList<User> users = new ArrayList<>();
    String username;
    String password;

    @JsonIgnore
    ArrayList<Game> games;
    ArrayList<Integer> allScores;
    ArrayList<Integer> userCoins;

    boolean redBought = true;
    boolean pinkBought;
    boolean greenBought;
    boolean blackBought;
    boolean yellowBought;

    boolean redChoose;
    boolean pinkChoose;
    boolean greenChoose;
    boolean blackChoose;
    boolean yellowChoose;


    public User(String name, String password) {
        this.username = name;
        this.password = password;
        addName(this);

        loggedInUser = new ArrayList<>();
        if (loggedInUser.size() == 0) {
            loggedInUser.add(null);
        }

        allScores = new ArrayList<>();
        allScores.add(0, 0);

        userCoins = new ArrayList<>();
        userCoins.add(0, 0);

        games = new ArrayList<>();
        games.add(0, null);
        games.add(1, null);
        games.add(2, null);
    }

    public User() {

    }


    void addName(User user) {
//        for (User esm : users) {
//            if (esm.username.equals(user.username)) {
//                return;
//            }
//        }
        users.add(user);
    }

    static void login(String username, String password) {
        User user = getUser(username);
        if (user == null) {
            return;
        }
        getAndCheckPassword(user, password);
    }

    static User getUser(String username) {
        User user = null;

        while (user == null) {
            user = User.getUserByUsername(username);

            if (user == null)
                System.out.println("Username Yaft Nashod! Lotfan Dobare Talash Konid.");
        }

        return user;
    }

    static User getUserByUsername(String Username) {

        for (User u : users) {
            if (u.username.equals(Username))
                return u;
        }
        return null;
    }


    public static void getAndCheckPassword(User user, String password) {
        boolean success = false;

        while (!success) {
            if (user.password.equals(password)) {
                System.out.println("Ba Movafaghiyat Login shodid!");
                success = true;
                loggedInUser.set(0, user);
                // IO.getInstance().loadGame();
                System.out.println(loggedInUser.get(0).username);
            } else System.out.println("Password Eshtebah Ast. Dobare talash konid");
        }

    }


    static boolean checkUsername(String username) {

        for (User esm : users) {
            if (esm.username.equals(username))
                return false;
        }

        return true;
    }

    static String getValidUsername() {
        String username = null;
//        while (username == null) {
//            System.out.println("Username ra Vared Konid: ");
//            username;
//            if (!User.checkUsername(username)) {
//                System.out.println("Username Tekrari Bood. Talashe Mojadad Lotfan");
//            }
//        }
        return username;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Game> getGames() {
        return games;
    }

    public void setGames(ArrayList<Game> games) {
        this.games = games;
    }

    public ArrayList<Integer> getAllScores() {
        return allScores;
    }

    public void setAllScores(ArrayList<Integer> allScores) {
        this.allScores = allScores;
    }

    public ArrayList<Integer> getUserCoins() {
        return userCoins;
    }

    public void setUserCoins(ArrayList<Integer> userCoins) {
        this.userCoins = userCoins;
    }

    public boolean isRedBought() {
        return redBought;
    }

    public void setRedBought(boolean redBought) {
        this.redBought = redBought;
    }

    public boolean isPinkBought() {
        return pinkBought;
    }

    public void setPinkBought(boolean pinkBought) {
        this.pinkBought = pinkBought;
    }

    public boolean isGreenBought() {
        return greenBought;
    }

    public void setGreenBought(boolean greenBought) {
        this.greenBought = greenBought;
    }

    public boolean isBlackBought() {
        return blackBought;
    }

    public void setBlackBought(boolean blackBought) {
        this.blackBought = blackBought;
    }

    public boolean isYellowBought() {
        return yellowBought;
    }

    public void setYellowBought(boolean yellowBought) {
        this.yellowBought = yellowBought;
    }

    public boolean isRedChoose() {
        return redChoose;
    }

    public void setRedChoose(boolean redChoose) {
        this.redChoose = redChoose;
    }

    public boolean isPinkChoose() {
        return pinkChoose;
    }

    public void setPinkChoose(boolean pinkChoose) {
        this.pinkChoose = pinkChoose;
    }

    public boolean isGreenChoose() {
        return greenChoose;
    }

    public void setGreenChoose(boolean greenChoose) {
        this.greenChoose = greenChoose;
    }

    public boolean isBlackChoose() {
        return blackChoose;
    }

    public void setBlackChoose(boolean blackChoose) {
        this.blackChoose = blackChoose;
    }

    public boolean isYellowChoose() {
        return yellowChoose;
    }

    public void setYellowChoose(boolean yellowChoose) {
        this.yellowChoose = yellowChoose;
    }
}