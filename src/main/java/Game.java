import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


@JsonIncludeProperties (value = {"player", "levelManager", "time"})
public class Game implements Runnable {

    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS = 120;
    private final int UPS = 200;


    private Player player;
    private LevelManager levelManager;
    public TileManager tileManager;
    public Coin coin;
    public Pipe pipe;
    public Plant plant;


    ArrayList<JFrame> frames;

    Timer timer;
    int time = 100;
    public int coins = 0;
    public int lives = 3;
    public int score = 0;

    public static boolean isInSectionOne = true;
    public static boolean isInSectionTwo = false;
    public boolean isGameEnded;

    public boolean isCalculatedScoreInSectionOne;
    public boolean isCalculatedScoreInSectionTwo;

    public final static float SCALE = 1.5f;
    public final static int TILES_DEFAULT_SIZE = 32;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = 1280;
    public final static int GAME_HEIGHT = 720;

//    LoadSave loadSave = new LoadSave(this);

    public Game() {
        // this should be the first thing in constructor
        initClasses();

        createTime();

        showPanel();

        // this should be the latest thing in constructor
        startGameLoop();
    }

    public void showPanel() {
        gamePanel = new GamePanel(this);
        gameFrame = new GameFrame(gamePanel);

        frames = new ArrayList<>();
        frames.add(0, gameFrame);

        gamePanel.requestFocus();
        startTimer();
    }

    private void initClasses() {
        player = new Player(40, 300, 50, 80);
        time = 100;

        if (isInSectionOne)
            levelManager = new LevelManager(this, 1);

        else if (isInSectionTwo)
            levelManager = new LevelManager(this, 2);


        // creating new coins
        coin = new Coin(levelManager);

        pipe = new Pipe(levelManager);
        plant = new Plant(levelManager);

        if (isInSectionTwo)
            tileManager = new TileManager(gamePanel);
    }

    public void update() {
        // Death
        // in section one
        if (isInSectionOne) {
            // hole
            if (player.hitBox.x + player.width >= 1950 && player.hitBox.x + player.width <= 2040
                    && player.hitBox.y + player.height >= 500) {
                initClasses();
                lives--;
            }
            // pipe
            if (player.hitBox.x + player.width >= 3400 && player.hitBox.x + player.width <= 3470
                    && player.hitBox.y + player.height >= 345 && player.hitBox.y + player.height <= 390) {
                initClasses();
                lives--;
            }
        }
        // in section two
        if (isInSectionTwo) {
            // hole
            if (player.hitBox.x + player.width >= 1685 && player.hitBox.x + player.width <= 1800
                    && player.hitBox.y + player.height >= 500) {
                initClasses();
                lives--;
            }
            // pipe (pasha)
            if (player.hitBox.x + player.width >= 3050 && player.hitBox.x + player.width <= 3150
                    && player.hitBox.y + player.height >= 345 && player.hitBox.y + player.height <= 390) {
                initClasses();
                lives--;
            }
        }

        if (isGameEnded) {
            stopTimer();
            IO.getInstance().save();
            gameFrame.dispose();
            new MainFrame();
            isInSectionOne = true;
            isInSectionTwo = false;
            isGameEnded = false;
        }

        player.update();
        player.checkCloseToBorder();
    }


    public void render(Graphics g) {

        if (player.hitBox.x >= 5000 && levelManager.sectionNumber == 1) {
            levelManager.sectionNumber = 2;
            isInSectionOne = false;
            isInSectionTwo = true;
            initClasses();
        }


        // SECTION ONE
        if (levelManager.sectionNumber == 1) {
            levelManager.draw(g, player.xLvlOffset, lives, coins, score);

            // eating the coins
            if ((player.hitBox.x <= 485 && player.hitBox.x >= 450)
                    && (player.hitBox.y + player.height <= 380 && player.hitBox.y + player.height >= 260))
                coin.drawingCoinsAtSectionOne[0] = true;
            if ((player.hitBox.x <= 735 && player.hitBox.x >= 700)
                    && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
                coin.drawingCoinsAtSectionOne[1] = true;
            if ((player.hitBox.x <= 835 && player.hitBox.x >= 800)
                    && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
                coin.drawingCoinsAtSectionOne[2] = true;
            if ((player.hitBox.x <= 1435 && player.hitBox.x >= 1400)
                    && (player.hitBox.y + player.height <= 380 && player.hitBox.y + player.height >= 290))
                coin.drawingCoinsAtSectionOne[3] = true;
            if ((player.hitBox.x <= 1785 && player.hitBox.x >= 1750)
                    && (player.hitBox.y + player.height <= 440 && player.hitBox.y + player.height >= 350))
                coin.drawingCoinsAtSectionOne[4] = true;
            if ((player.hitBox.x <= 2035 && player.hitBox.x >= 2000)
                    && (player.hitBox.y + player.height <= 350 && player.hitBox.y + player.height >= 300))
                coin.drawingCoinsAtSectionOne[5] = true;
            if ((player.hitBox.x <= 2535 && player.hitBox.x >= 2500)
                    && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
                coin.drawingCoinsAtSectionOne[6] = true;


            coin.draw(g, player.xLvlOffset);

            if (plant.x1Flower - player.xLvlOffset <= 1000)
                plant.draw(g, player.xLvlOffset);
        }


        // SECTION TWO
        if (levelManager.sectionNumber == 2) {
            levelManager.draw(g, player.xLvlOffset, lives, coins, score);

            // eating the coins
            if ((player.hitBox.x <= 635 && player.hitBox.x >= 600)
                    && (player.hitBox.y + player.height <= 380 && player.hitBox.y + player.height >= 260))
                coin.drawingCoinsAtSectionTwo[0] = true;
            if ((player.hitBox.x <= 885 && player.hitBox.x >= 850)
                    && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
                coin.drawingCoinsAtSectionTwo[1] = true;
            if ((player.hitBox.x <= 1135 && player.hitBox.x >= 1100)
                    && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
                coin.drawingCoinsAtSectionTwo[2] = true;
            if ((player.hitBox.x <= 1585 && player.hitBox.x >= 1550)
                    && (player.hitBox.y + player.height <= 380 && player.hitBox.y + player.height >= 290))
                coin.drawingCoinsAtSectionTwo[3] = true;
            if ((player.hitBox.x <= 1785 && player.hitBox.x >= 1750)
                    && (player.hitBox.y + player.height <= 440 && player.hitBox.y + player.height >= 350))
                coin.drawingCoinsAtSectionTwo[4] = true;
            if ((player.hitBox.x <= 2035 && player.hitBox.x >= 2000)
                    && (player.hitBox.y + player.height <= 335 && player.hitBox.y + player.height >= 300))
                coin.drawingCoinsAtSectionTwo[5] = true;
            if ((player.hitBox.x <= 3535 && player.hitBox.x >= 3500)
                    && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
                coin.drawingCoinsAtSectionTwo[6] = true;

            coin.draw(g, player.xLvlOffset);

            if (plant.x2Flower - player.xLvlOffset <= 1000) {
                plant.draw(g, player.xLvlOffset);
            }

        }


        // TIME
        g.setFont(new Font("Courier", Font.BOLD, 40));
        g.drawString("Time: " + time, 800, 40);

        if (time == -1) {
            lives--;
            isInSectionTwo = false;
            isInSectionOne = true;
            initClasses();
        }

        if (lives == 0) {
            isGameEnded = true;
            IO.getInstance().save();
            stopTimer();
            gameFrame.dispose();
            new MainFrame();
        }

        // Updating the Score
        if (player.hitBox.x >= 4950 && !isCalculatedScoreInSectionOne) {
            calculatingScore();
            isCalculatedScoreInSectionOne = true;
            isInSectionOne = false;
            isInSectionTwo = true;
        }

        if (player.hitBox.x >= 4950 && !isCalculatedScoreInSectionTwo) {
            calculatingScore();
        }


        pipe.draw(g, player.xLvlOffset);
        player.render(g, player.xLvlOffset);
    }

    public void calculatingScore() {
        if (isInSectionOne) {
            for (boolean e : coin.drawingCoinsAtSectionOne) {
                if (e) {
                    coins++;
                }
            }
            score += (10 * coins) + (20 * lives) + (time);
        }

        if (isInSectionTwo && player.hitBox.x >= 5000) {
            for (int i = 0; i < 7; i++) {
                if (coin.drawingCoinsAtSectionTwo[i]) {
                    coins++;
                }
            }
            score += (10 * coins) + (20 * lives) + (time);
            isCalculatedScoreInSectionTwo = true;
            isGameEnded = true;
        }

        if (User.loggedInUser.get(0).allScores.get(0) <= score)
            User.loggedInUser.get(0).allScores.set(0, score);

        if (User.loggedInUser.get(0).userCoins.get(0) <= coins)
            User.loggedInUser.get(0).userCoins.set(0, coins);
    }

    void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void createTime() {
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time--;
                System.out.println("createTime" + time);
            }
        });
    }

    public void startTimer() {
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }


    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS;
        double timePerUpdate = 1000000000.0 / UPS;

        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        long lastCheck = System.currentTimeMillis();

        double deltaUpdate = 0;
        double deltaFrame = 0;


        while (true) {
            long currentTime = System.nanoTime();

            deltaUpdate += (currentTime - previousTime) / timePerUpdate;
            deltaFrame += (currentTime - previousTime) / timePerFrame;

            previousTime = currentTime;


            if (deltaUpdate >= 1) {
                update();
                updates++;
                deltaUpdate--;
            }

            if (deltaFrame >= 1) {
                gamePanel.repaint();
                frames++;
                deltaFrame--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);

                // handling times
//                time--;

                frames = 0;
                updates = 0;
            }

        }
    }


    public Player getPlayer() {
        return player;
    }

    public GameFrame getGameFrame() {
        return gameFrame;
    }

    public void setGameFrame(GameFrame gameFrame) {
        this.gameFrame = gameFrame;
    }

    public GamePanel getGamePanel() {
        return gamePanel;
    }

    public void setGamePanel(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public Thread getGameThread() {
        return gameThread;
    }

    public void setGameThread(Thread gameThread) {
        this.gameThread = gameThread;
    }

    public int getFPS() {
        return FPS;
    }

    public int getUPS() {
        return UPS;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public LevelManager getLevelManager() {
        return levelManager;
    }

    public void setLevelManager(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    public TileManager getTileManager() {
        return tileManager;
    }

    public void setTileManager(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    public Coin getCoin() {
        return coin;
    }

    public void setCoin(Coin coin) {
        this.coin = coin;
    }

    public Pipe getPipe() {
        return pipe;
    }

    public void setPipe(Pipe pipe) {
        this.pipe = pipe;
    }

    public Plant getPlant() {
        return plant;
    }

    public void setPlant(Plant plant) {
        this.plant = plant;
    }

    public ArrayList<JFrame> getFrames() {
        return frames;
    }

    public void setFrames(ArrayList<JFrame> frames) {
        this.frames = frames;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static boolean isIsInSectionOne() {
        return isInSectionOne;
    }

    public static void setIsInSectionOne(boolean isInSectionOne) {
        Game.isInSectionOne = isInSectionOne;
    }

    public static boolean isIsInSectionTwo() {
        return isInSectionTwo;
    }

    public static void setIsInSectionTwo(boolean isInSectionTwo) {
        Game.isInSectionTwo = isInSectionTwo;
    }

    public boolean isGameEnded() {
        return isGameEnded;
    }

    public void setGameEnded(boolean gameEnded) {
        isGameEnded = gameEnded;
    }

    public boolean isCalculatedScoreInSectionOne() {
        return isCalculatedScoreInSectionOne;
    }

    public void setCalculatedScoreInSectionOne(boolean calculatedScoreInSectionOne) {
        isCalculatedScoreInSectionOne = calculatedScoreInSectionOne;
    }

    public boolean isCalculatedScoreInSectionTwo() {
        return isCalculatedScoreInSectionTwo;
    }

    public void setCalculatedScoreInSectionTwo(boolean calculatedScoreInSectionTwo) {
        isCalculatedScoreInSectionTwo = calculatedScoreInSectionTwo;
    }
}