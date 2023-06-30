package model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import controller.IO;
import controller.LevelManager;
import controller.TileManager;
import model.boss.OgreMagi;
import model.enemies.*;
import model.items.Coin;
import model.items.Item;
import model.items.Mushroom;
import model.items.Star;
import model.others.Throwable;
import model.others.*;
import view.GraphicalModel.*;
import view.GraphicalModel.GraphicalEnemies.GraphicalGoompa;
import view.GraphicalModel.GraphicalEnemies.GraphicalKoopa;
import view.GraphicalModel.GraphicalEnemies.GraphicalNukeBird;
import view.GraphicalModel.GraphicalEnemies.GraphicalSpiny;
import view.GraphicalModel.GraphicalItems.GraphicalCoin;
import view.GraphicalModel.GraphicalItems.GraphicalMushroom;
import view.GraphicalModel.GraphicalItems.GraphicalStar;
import view.frames.GameFrame;
import view.frames.MainFrame;
import view.panels.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static config.Constants.*;


@JsonIncludeProperties(value = {"player", "levelManager", "time"})
public class Game implements Runnable {

    public static boolean isInLevelOne = false;
    public static boolean isInLevelTwo = true;
    public static boolean isInLevelThree = false;

    public static boolean isInSectionOne = true;
    public static boolean isInSectionTwo = false;
    public static boolean isInBossFight = false;

    public static boolean isInFirstHiddenPart = false;
    public static boolean isInSecondHiddenPart = false;

    public final int BOUND_TO_NEXT_SECTION = (5 * GAME_WIDTH) - 100;

    public boolean isGameEnded;
    public boolean isCalculatedScoreInSectionOne;
    public boolean isCalculatedScoreInSectionTwo;
    public TileManager tileManager;
    public LevelManager levelManager;
    public Mushroom mushroom;
    public Mushroom mushroom1;
    public Mushroom mushroom2;
    public Mushroom mushroom3;
    public Star star;
    public Star star1;
    public Star star2;
    public Star star3;
    public Coin coin;
    public Pipe pipe;
    public Checkpoint checkpoint;
    public Enemy enemy;
    public Goompa goompa;
    public Goompa goompa1;
    public Goompa goompa2;
    public Goompa goompa3;
    public Koopa koopa;
    public Koopa koopa1;
    public Koopa koopa2;
    public Koopa koopa3;
    public Spiny spiny;
    public Spiny spiny1;
    public Spiny spiny2;
    public Spiny spiny3;
    public NukeBird nukeBird;
    public Bomb bomb;
    public Fireball fireball;
    public OgreMagi ogreMagi;
    public Plant plant;
    public int coins;
    public int lives = 3;
    public int score = 0;
    public int progressRate;
    public int progressRisk;
    public int distanceWithOgre;
    public int distanceWithSpiny;
    public ArrayList<Enemy> enemies;
    public ArrayList<Item> items;
    public ArrayList<Coin> coinArrayList;
    int dyingCoins;
    int checkpointsSaved;
    Weapon weapon;
    GraphicalMario graphicalMario;
    GraphicalWeapon graphicalWeapon;
    GraphicalOgreMagi graphicalOgreMagi;
    GraphicalCoin graphicalCoin;
    GraphicalPlant graphicalPlant;
    GraphicalPipe graphicalPipe;
    GraphicalCheckpoint graphicalCheckpoint;
    GraphicalSpiny graphicalSpiny;
    GraphicalSpiny graphicalSpiny1;
    GraphicalSpiny graphicalSpiny2;
    GraphicalSpiny graphicalSpiny3;
    GraphicalStar graphicalStar;
    GraphicalGoompa graphicalGoompa;
    GraphicalGoompa graphicalGoompa1;
    GraphicalGoompa graphicalGoompa2;
    GraphicalGoompa graphicalGoompa3;
    GraphicalKoopa graphicalKoopa;
    GraphicalKoopa graphicalKoopa1;
    GraphicalKoopa graphicalKoopa2;
    GraphicalKoopa graphicalKoopa3;
    GraphicalNukeBird graphicalNukeBird;
    GraphicalBomb graphicalBomb;
    GraphicalFireball graphicalFireball;
    GraphicalMushroom graphicalMushroom;
    GraphicalMushroom graphicalMushroom1;
    GraphicalMushroom graphicalMushroom2;
    GraphicalMushroom graphicalMushroom3;
    ArrayList<JFrame> frames;
    Timer timer;
    int time = 100;
    ArrayList<GraphicalGoompa> graphicalGoompas;
    ArrayList<Throwable> throwables;
    private GameFrame gameFrame;
    private GamePanel gamePanel;
    private Thread gameThread;
    private Player player;

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

        player = new Player(50, 100, 50, 80, levelManager);
        graphicalMario = new GraphicalMario(levelManager, player);

        time = 100;
        levelManager = new LevelManager(player);

        enemies = new ArrayList<>();
        items = new ArrayList<>();
        throwables = new ArrayList<>();
        coinArrayList = new ArrayList<>();
        graphicalGoompas = new ArrayList<>();

        if (isInSectionOne && isInLevelOne) {
            levelManager = new LevelManager(this, 1, 1);
        } else if (isInSectionTwo && isInLevelOne) {
            levelManager = new LevelManager(this, 1, 2);
        } else if (isInSectionOne && isInLevelTwo) {
            levelManager = new LevelManager(this, 2, 1);
        } else if (isInSectionTwo && isInLevelTwo) {
            levelManager = new LevelManager(this, 2, 2);
        } else if (isInSectionOne && isInLevelThree) {
            levelManager = new LevelManager(this, 3, 1);
        } else if (isInSectionTwo && isInLevelThree) {
            levelManager = new LevelManager(this, 3, 2);
        } else if (isInBossFight) {
            levelManager = new LevelManager(this, 4, 1);
        }


        // Making Boss
        ogreMagi = new OgreMagi(1000, 330, 200, 200, levelManager, distanceWithOgre, player);
        graphicalOgreMagi = new GraphicalOgreMagi(levelManager, ogreMagi);

        // Making Enemies
        spiny = new Spiny(2600, 450, 50, 50, levelManager, distanceWithSpiny, player);
        spiny1 = new Spiny(3600, 450, 50, 50, levelManager, distanceWithSpiny, player);
        spiny2 = new Spiny(4600, 450, 50, 50, levelManager, distanceWithSpiny, player);
        spiny3 = new Spiny(5600, 450, 50, 50, levelManager, distanceWithSpiny, player);
        graphicalSpiny = new GraphicalSpiny(levelManager, spiny);
        graphicalSpiny1 = new GraphicalSpiny(levelManager, spiny1);
        graphicalSpiny2 = new GraphicalSpiny(levelManager, spiny2);
        graphicalSpiny3 = new GraphicalSpiny(levelManager, spiny3);

        enemies.add(spiny);

        koopa = new Koopa(1800, 450, 50, 50, levelManager);
        koopa1 = new Koopa(2800, 450, 50, 50, levelManager);
        koopa2 = new Koopa(3800, 450, 50, 50, levelManager);
        koopa3 = new Koopa(5800, 450, 50, 50, levelManager);
        graphicalKoopa = new GraphicalKoopa(levelManager, koopa);
        graphicalKoopa1 = new GraphicalKoopa(levelManager, koopa1);
        graphicalKoopa2 = new GraphicalKoopa(levelManager, koopa2);
        graphicalKoopa3 = new GraphicalKoopa(levelManager, koopa3);

        enemies.add(koopa);


//        for (int i = 0; i < 4; i++) {
//            enemies.add(new Goompa(1300 + (200 * i), 450, 50, 50, levelManager));
//            graphicalGoompas.add(new GraphicalGoompa(levelManager, (Goompa) enemies.get(i)));
//        }


        goompa = new Goompa(1300, 450, 50, 50, levelManager);
        goompa1 = new Goompa(1500, 450, 50, 50, levelManager);
        goompa2 = new Goompa(1700, 450, 50, 50, levelManager);
        goompa3 = new Goompa(1900, 450, 50, 50, levelManager);
        graphicalGoompa = new GraphicalGoompa(levelManager, goompa);
        graphicalGoompa1 = new GraphicalGoompa(levelManager, goompa1);
        graphicalGoompa2 = new GraphicalGoompa(levelManager, goompa2);
        graphicalGoompa3 = new GraphicalGoompa(levelManager, goompa3);

        enemies.add(goompa);
        enemies.add(goompa1);
        enemies.add(goompa2);
        enemies.add(goompa3);

        graphicalGoompas.add(graphicalGoompa);
        graphicalGoompas.add(graphicalGoompa1);
        graphicalGoompas.add(graphicalGoompa2);
        graphicalGoompas.add(graphicalGoompa3);


        nukeBird = new NukeBird(2500, 70, 57, 100, levelManager);
        graphicalNukeBird = new GraphicalNukeBird(levelManager, nukeBird);
        enemies.add(nukeBird);

        plant = new Plant(levelManager);
        graphicalPlant = new GraphicalPlant(levelManager, plant);

        // Making Items
        coin = new Coin(0, 0, 35, 35, levelManager);
        graphicalCoin = new GraphicalCoin(levelManager, coin);

        for (int i = 0; i < 7; i++) {
            coinArrayList.add(new Coin(500 + (300 * i), 300, 35, 35, levelManager));
        }


//        mushroom = new Mushroom(700, 450, 50, 50, levelManager);
//        mushroom1 = new Mushroom(1700, 450, 50, 50, levelManager);
//        mushroom2 = new Mushroom(2700, 450, 50, 50, levelManager);
//        mushroom3 = new Mushroom(4600, 450, 50, 50, levelManager);
//        graphicalMushroom = new GraphicalMushroom(levelManager, mushroom);
//        graphicalMushroom1 = new GraphicalMushroom(levelManager, mushroom1);
//        graphicalMushroom2 = new GraphicalMushroom(levelManager, mushroom2);
//        graphicalMushroom3 = new GraphicalMushroom(levelManager, mushroom3);
//        items.add(mushroom);

        for (int i = 0; i < 4; i++) {
            items.add(new Mushroom(700 + 1000 * i, 450, 50, 50, levelManager));
            graphicalMushroom = new GraphicalMushroom(levelManager, (Mushroom) items.get(i));
            graphicalMushroom1 = new GraphicalMushroom(levelManager, (Mushroom) items.get(i));
            graphicalMushroom2 = new GraphicalMushroom(levelManager, (Mushroom) items.get(i));
            graphicalMushroom3 = new GraphicalMushroom(levelManager, (Mushroom) items.get(i));
        }


        pipe = new Pipe(levelManager);
        graphicalPipe = new GraphicalPipe(levelManager);

        star = new Star(640, 500, 50, 50, levelManager);
        graphicalStar = new GraphicalStar(levelManager, star);
        items.add(star);

        checkpoint = new Checkpoint(levelManager);
        graphicalCheckpoint = new GraphicalCheckpoint(levelManager, checkpoint);

        bomb = new Bomb(0, 0, 25, 50, levelManager);
        graphicalBomb = new GraphicalBomb(levelManager, bomb);

        weapon = new Weapon(0, 0, 40, 80, levelManager, player);
        graphicalWeapon = new GraphicalWeapon(levelManager, player, weapon);

        fireball = new Fireball(0, 0, 50, 50, levelManager, player);
        graphicalFireball = new GraphicalFireball(levelManager, player, fireball);

        throwables.add(fireball);
        throwables.add(weapon);
        throwables.add(bomb);

        tileManager = new TileManager(gamePanel);
    }

    public void update() {

        player.x = player.hitBox.x;
        player.y = player.hitBox.y;
        player.width = player.hitBox.width;
        player.height = player.hitBox.height + 40;

        progressRate = (player.x / (5 * GAME_WIDTH));
        progressRisk = coins * progressRate;
        dyingCoins = ((checkpointsSaved + 1) * coins + progressRisk) / (checkpointsSaved + 4);


        for (Throwable throwable : throwables) {
            for (Enemy enemy : enemies) {

                if (throwable.intersects(enemy))
                    enemy.isAlive = false;
            }

        }

        for (Enemy enemy : enemies) {

            if (enemy instanceof Koopa) {
                enemy.isAlive = false;
            }

            if (enemy instanceof Goompa)
                if (player.hitBox.intersects(enemy))
                    enemy.isAlive = false;

            if (enemy instanceof NukeBird || enemy instanceof Spiny)
                if (player.hitBox.intersects(enemy)) {
                    initClasses();
                    lives--;
                }

        }

        for (Item item : items) {

            if (player.hitBox.intersects(item)) {

                System.out.println("oomad too if");

                if (item instanceof Mushroom) {
//                    mushroom.isUsed = true;
                    ((Mushroom) item).isUsed = true;
                    System.out.println(((Mushroom) item).isUsed);
                }

                if (item instanceof Star) {
                    star.setUsed(true);
                    player.activeShield = true;
                }

            }

        }
//        System.out.println(star.x + " - " + star.y + " - " + star.width + " - " + star.height);


        /* ---------------------------------------------- Death Mechanism ------------------------------------------- */

        // ********* LEVEL 1
        if (isInLevelOne) {
            // SECTION 1
            if (isInSectionOne) {
                // hole
                if (player.hitBox.x + player.width >= 1950 && player.hitBox.x + player.width <= 2040
                        && player.hitBox.y + player.height >= 500) {
                    initClasses();
                    if (score >= 30)
                        score -= 30;
                    lives--;
                }
                // pipe
                if (player.hitBox.x + player.width >= 3400 && player.hitBox.x + player.width <= 3470
                        && player.hitBox.y + player.height >= 345 && player.hitBox.y + player.height <= 390) {
                    initClasses();
                    lives--;
                }

//                // star logic
//                if (player.hitBox.x + player.width >= 620 && player.hitBox.x + player.width <= 680
//                        && player.hitBox.y + player.height >= 250 && player.hitBox.y + player.height <= 310) {
//                    star.setUsed(true);
//                    player.activeShield = true;
//                }

            }
            // in section two
            if (isInSectionTwo) {
                // hole
                if (player.hitBox.x + player.width >= 1685 && player.hitBox.x + player.width <= 1800
                        && player.hitBox.y + player.height >= 500) {
                    initClasses();
                    if (score >= 30)
                        score -= 30;
                    lives--;
                }
                // pipe (pasha)
                if (player.hitBox.x + player.width >= 3050 && player.hitBox.x + player.width <= 3150
                        && player.hitBox.y + player.height >= 345 && player.hitBox.y + player.height <= 390) {
                    initClasses();
                    lives--;
                }
            }
        }

        // ********* LEVEL 2

        if (isInLevelTwo) {

            if (isInSectionOne) {

            }


            if (isInSectionTwo) {

            }

        }

        /* ---------------------------------------------------------------------------------------------------------- */

        /* ------------------------------------------------ ENDING -------------------------------------------------- */
        if (isGameEnded) {
            stopTimer();
            IO.getInstance().save();
            gameFrame.dispose();
            new MainFrame();
            isInSectionOne = true;
            isInSectionTwo = false;
            isInLevelOne = true;
            isInLevelTwo = false;
            isGameEnded = false;
        }
        /* ---------------------------------------------------------------------------------------------------------- */

        /* ----------------------------------------- MOVING TO NEXT PART -------------------------------------------- */

        // Level 1 ... Section 1 going to 2
        if (player.hitBox.x >= BOUND_TO_NEXT_SECTION && levelManager.levelNumber == 1 && levelManager.sectionNumber == 1) {
            levelManager.sectionNumber = 2;
            isInSectionOne = false;
            isInSectionTwo = true;
            initClasses();
        }

        // Level 1 ... Section 2 Ending
        if (player.hitBox.x >= BOUND_TO_NEXT_SECTION && levelManager.levelNumber == 1 && levelManager.sectionNumber == 2) {
            levelManager.levelNumber = 2;
            levelManager.sectionNumber = 1;
            isInSectionOne = true;
            isInSectionTwo = false;
            isInLevelOne = false;
            isInLevelTwo = true;
            initClasses();
        }

        // Level 2 ... Section 1 going to 2
        if (player.hitBox.x >= BOUND_TO_NEXT_SECTION && levelManager.levelNumber == 2 && levelManager.sectionNumber == 1) {
            levelManager.sectionNumber = 2;
            isInSectionOne = false;
            isInSectionTwo = true;
            initClasses();
        }

        // Level 2 ... Section 2 Ending
        if (player.hitBox.x >= BOUND_TO_NEXT_SECTION && levelManager.levelNumber == 2 && levelManager.sectionNumber == 2) {
            levelManager.levelNumber = 3;
            levelManager.sectionNumber = 1;
            isInSectionOne = true;
            isInSectionTwo = false;
            isInLevelTwo = false;
            isInLevelThree = true;
            initClasses();
        }

        // Level 3 ... Section 1 going to 2
        if (player.hitBox.x >= BOUND_TO_NEXT_SECTION && levelManager.levelNumber == 3 && levelManager.sectionNumber == 1) {
            levelManager.sectionNumber = 2;
            isInSectionOne = false;
            isInSectionTwo = true;
            initClasses();
        }

        // Level 3 ... Section 2 Ending
        if (player.hitBox.x >= BOUND_TO_NEXT_SECTION && levelManager.levelNumber == 3 && levelManager.sectionNumber == 2) {
            levelManager.levelNumber = 4;
            isInSectionOne = true;
            isInSectionTwo = false;
            isInLevelThree = false;
            isInBossFight = true;
            initClasses();
        }

        if (levelManager.levelNumber == 5) {
            System.out.println("az 1-2 raftam hidden");
            isInSectionOne = false;
            isInSectionTwo = false;
            isInLevelOne = false;
            initClasses();
        }

        /* ---------------------------------------------------------------------------------------------------------- */


        player.update();
        if (!isInBossFight)
            player.checkCloseToBorder();
    }

    public void render(Graphics g) {

        // ------------------------------------------- MOVING OBJECTS ----------------------------------------------- //

        for (Enemy e : enemies) {

            if (e instanceof Goompa)
                ((Goompa) e).move();

        }

        for (Item item : items) {

            if (item instanceof Mushroom)
                ((Mushroom) item).move();


            if (item instanceof Star)
                ((Star) item).move();

        }

//        for (GraphicalGoompa gg : graphicalGoompas) {
//            gg.draw(g, player.xLvlOffset);
//        }


        /* ------------------------------------------------- LEVEL 1 --------------------------------------------- */
        // LEVEL ONE DESIGNS
        if (levelManager.levelNumber == 1) {
            // SECTION ONE
            if (levelManager.sectionNumber == 1) {

                levelManager.draw(g, player.xLvlOffset, lives, coins, score);

                tileManager.draw(g, player.xLvlOffset);

                // Hole
                g.setColor(new Color(75, 145, 233, 255));
                g.fillRect(1860 - player.xLvlOffset, 500, 130, 300);

                // eating coins
                if ((player.hitBox.x <= 485 && player.hitBox.x >= 450)
                        && (player.hitBox.y + player.height <= 380 && player.hitBox.y + player.height >= 260))
                    coin.drawingCoinsAtLevelOneSectionOne[0] = true;
                if ((player.hitBox.x <= 735 && player.hitBox.x >= 700)
                        && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
                    coin.drawingCoinsAtLevelOneSectionOne[1] = true;
                if ((player.hitBox.x <= 835 && player.hitBox.x >= 800)
                        && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
                    coin.drawingCoinsAtLevelOneSectionOne[2] = true;
                if ((player.hitBox.x <= 1435 && player.hitBox.x >= 1400)
                        && (player.hitBox.y + player.height <= 380 && player.hitBox.y + player.height >= 290))
                    coin.drawingCoinsAtLevelOneSectionOne[3] = true;
                if ((player.hitBox.x <= 1785 && player.hitBox.x >= 1750)
                        && (player.hitBox.y + player.height <= 440 && player.hitBox.y + player.height >= 350))
                    coin.drawingCoinsAtLevelOneSectionOne[4] = true;
                if ((player.hitBox.x <= 2035 && player.hitBox.x >= 2000)
                        && (player.hitBox.y + player.height <= 350 && player.hitBox.y + player.height >= 300))
                    coin.drawingCoinsAtLevelOneSectionOne[5] = true;
                if ((player.hitBox.x <= 2535 && player.hitBox.x >= 2500)
                        && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
                    coin.drawingCoinsAtLevelOneSectionOne[6] = true;


                graphicalCoin.draw(g, player.xLvlOffset);

                graphicalMushroom.draw(g, player.xLvlOffset);
//                mushroom.move();

                graphicalSpiny.draw(g, player.xLvlOffset);
                spiny.move();

                graphicalGoompa.draw(g, player.xLvlOffset);
//                goompa.move();

                graphicalKoopa.draw(g, player.xLvlOffset);
                koopa.move();

                if (!star.isUsed())
                    graphicalStar.draw(g, player.xLvlOffset);

//                star.move();

                if (plant.x1Flower - player.xLvlOffset <= 1000)
                    plant.draw(g, player.xLvlOffset);
            }

            // SECTION TWO
            if (levelManager.sectionNumber == 2) {

                levelManager.draw(g, player.xLvlOffset, lives, coins, score);
                tileManager.draw(g, player.xLvlOffset);

                // Hole
                g.setColor(new Color(75, 145, 233, 255));
                g.fillRect(1685 - player.xLvlOffset, 500, 115, 300);

                // eating the coins
                if ((player.hitBox.x <= 635 && player.hitBox.x >= 600)
                        && (player.hitBox.y + player.height <= 380 && player.hitBox.y + player.height >= 260))
                    coin.drawingCoinsAtLevelOneSectionTwo[0] = true;
                if ((player.hitBox.x <= 885 && player.hitBox.x >= 850)
                        && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
                    coin.drawingCoinsAtLevelOneSectionTwo[1] = true;
                if ((player.hitBox.x <= 1135 && player.hitBox.x >= 1100)
                        && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
                    coin.drawingCoinsAtLevelOneSectionTwo[2] = true;
                if ((player.hitBox.x <= 1585 && player.hitBox.x >= 1550)
                        && (player.hitBox.y + player.height <= 380 && player.hitBox.y + player.height >= 290))
                    coin.drawingCoinsAtLevelOneSectionTwo[3] = true;
                if ((player.hitBox.x <= 1785 && player.hitBox.x >= 1750)
                        && (player.hitBox.y + player.height <= 440 && player.hitBox.y + player.height >= 350))
                    coin.drawingCoinsAtLevelOneSectionTwo[4] = true;
                if ((player.hitBox.x <= 2035 && player.hitBox.x >= 2000)
                        && (player.hitBox.y + player.height <= 335 && player.hitBox.y + player.height >= 300))
                    coin.drawingCoinsAtLevelOneSectionTwo[5] = true;
                if ((player.hitBox.x <= 3535 && player.hitBox.x >= 3500)
                        && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
                    coin.drawingCoinsAtLevelOneSectionTwo[6] = true;

                graphicalCoin.draw(g, player.xLvlOffset);

                graphicalMushroom1.draw(g, player.xLvlOffset);
//                mushroom1.move();

                graphicalSpiny1.draw(g, player.xLvlOffset);
                spiny1.move();

                graphicalGoompa1.draw(g, player.xLvlOffset);
//                goompa1.move();

                graphicalKoopa1.draw(g, player.xLvlOffset);
                koopa1.move();

                if (plant.x2Flower - player.xLvlOffset <= 1000)
                    plant.draw(g, player.xLvlOffset);

            }
        }
        /* -------------------------------------------------------------------------------------------------------- */

        /* ------------------------------------------------- LEVEL 2 --------------------------------------------- */

        // LEVEL TWO DESIGNS
        if (levelManager.levelNumber == 2) {
            // SECTION ONE
            if (levelManager.sectionNumber == 1) {
                levelManager.draw(g, player.xLvlOffset, lives, coins, score);
                tileManager.draw(g, player.xLvlOffset);


                for (Coin coin : coinArrayList) {

                    if (player.hitBox.intersects(coin)) {
                        coin.eat = true;
                    }

                }

//                if ((player.hitBox.x <= 485 && player.hitBox.x >= 450)
//                        && (player.hitBox.y + player.height <= 380 && player.hitBox.y + player.height >= 260))
//                    coin.drawingCoinsAtLevelTwoSectionOne[0] = true;
//                if ((player.hitBox.x <= 735 && player.hitBox.x >= 700)
//                        && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
//                    coin.drawingCoinsAtLevelTwoSectionOne[1] = true;
//                if ((player.hitBox.x <= 835 && player.hitBox.x >= 800)
//                        && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
//                    coin.drawingCoinsAtLevelTwoSectionOne[2] = true;
//                if ((player.hitBox.x <= 1435 && player.hitBox.x >= 1400)
//                        && (player.hitBox.y + player.height <= 380 && player.hitBox.y + player.height >= 290))
//                    coin.drawingCoinsAtLevelTwoSectionOne[3] = true;
//                if ((player.hitBox.x <= 1785 && player.hitBox.x >= 1750)
//                        && (player.hitBox.y + player.height <= 440 && player.hitBox.y + player.height >= 350))
//                    coin.drawingCoinsAtLevelTwoSectionOne[4] = true;
//                if ((player.hitBox.x <= 2035 && player.hitBox.x >= 2000)
//                        && (player.hitBox.y + player.height <= 350 && player.hitBox.y + player.height >= 300))
//                    coin.drawingCoinsAtLevelTwoSectionOne[5] = true;
//                if ((player.hitBox.x <= 2535 && player.hitBox.x >= 2500)
//                        && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
//                    coin.drawingCoinsAtLevelTwoSectionOne[6] = true;

                graphicalCoin.draw(g, player.xLvlOffset);

                graphicalMushroom2.draw(g, player.xLvlOffset);
//                mushroom2.move();

                graphicalSpiny2.draw(g, player.xLvlOffset);
                spiny2.move();

                graphicalGoompa2.draw(g, player.xLvlOffset);
                goompa2.move();

                graphicalKoopa2.draw(g, player.xLvlOffset);
                koopa2.move();
            }


            // SECTION TWO
            if (levelManager.sectionNumber == 2) {
                levelManager.draw(g, player.xLvlOffset, lives, coins, score);
                tileManager.draw(g, player.xLvlOffset);

//               if ((player.hitBox.x <= 485 && player.hitBox.x >= 450)
//                        && (player.hitBox.y + player.height <= 380 && player.hitBox.y + player.height >= 260))
//                    coin.drawingCoinsAtLevelTwoSectionTwo[0] = true;
//                if ((player.hitBox.x <= 735 && player.hitBox.x >= 700)
//                        && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
//                    coin.drawingCoinsAtLevelTwoSectionTwo[1] = true;
//                if ((player.hitBox.x <= 835 && player.hitBox.x >= 800)
//                        && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
//                    coin.drawingCoinsAtLevelTwoSectionTwo[2] = true;
//                if ((player.hitBox.x <= 1435 && player.hitBox.x >= 1400)
//                        && (player.hitBox.y + player.height <= 380 && player.hitBox.y + player.height >= 290))
//                    coin.drawingCoinsAtLevelTwoSectionTwo[3] = true;
//                if ((player.hitBox.x <= 1785 && player.hitBox.x >= 1750)
//                        && (player.hitBox.y + player.height <= 440 && player.hitBox.y + player.height >= 350))
//                    coin.drawingCoinsAtLevelTwoSectionTwo[4] = true;
//                if ((player.hitBox.x <= 2035 && player.hitBox.x >= 2000)
//                        && (player.hitBox.y + player.height <= 350 && player.hitBox.y + player.height >= 300))
//                    coin.drawingCoinsAtLevelTwoSectionTwo[5] = true;
//                if ((player.hitBox.x <= 2535 && player.hitBox.x >= 2500)
//                        && (player.hitBox.y + player.height <= 550 && player.hitBox.y + player.height >= 460))
//                    coin.drawingCoinsAtLevelTwoSectionTwo[6] = true;

                graphicalCoin.draw(g, player.xLvlOffset);

                graphicalMushroom3.draw(g, player.xLvlOffset);
//                mushroom3.move();

                graphicalSpiny3.draw(g, player.xLvlOffset);
                spiny3.move();

                graphicalGoompa3.draw(g, player.xLvlOffset);
                goompa3.move();

                graphicalKoopa3.draw(g, player.xLvlOffset);
                koopa3.move();
            }
        }
        /* -------------------------------------------------------------------------------------------------------- */

        /* ---------------------------------------------- LEVEL 3 ------------------------------------------------- */
        // LEVEL THREE DESIGNS
        if (levelManager.levelNumber == 3) {
            // SECTION ONE
            if (levelManager.sectionNumber == 1) {
                levelManager.draw(g, player.xLvlOffset, lives, coins, score);
                tileManager.draw(g, player.xLvlOffset);

                graphicalCoin.draw(g, player.xLvlOffset);
            }


            // SECTION TWO
            if (levelManager.sectionNumber == 2) {
                levelManager.draw(g, player.xLvlOffset, lives, coins, score);
                tileManager.draw(g, player.xLvlOffset);

                graphicalCoin.draw(g, player.xLvlOffset);
            }
        }
        /* -------------------------------------------------------------------------------------------------------- */

        /* ------------------------------------------------- BOSS_FIGHT --------------------------------------------- */
        // LEVEL 4 (BOSS FIGHT) DESIGNS
        if (levelManager.levelNumber == 4) {
            levelManager.draw(g, player.xLvlOffset, lives, coins, score);
            graphicalOgreMagi.draw(g, player.xLvlOffset);
            ogreMagi.move();
        }
        /* ---------------------------------------------------------------------------------------------------------- */

        /* ------------------------------------------------ Hidden Parts -------------------------------------------- */

        if (levelManager.levelNumber == 5) {
            // HIDDEN IN LEVEL 1
            if (levelManager.sectionNumber == 1) {
                levelManager.draw(g, player.xLvlOffset, lives, coins, score);
            }

            // HIDDEN IN LEVEL 2
            if (levelManager.sectionNumber == 2) {
                levelManager.draw(g, player.xLvlOffset, lives, coins, score);
            }

        }



        /* ---------------------------------------------------------------------------------------------------------- */

        /* ------------------------------------------------- TIME MECHANISM ----------------------------------------- */
        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.BOLD, 40));
        g.drawString("Time: " + time, 745, 40);


        if (time == -1) {
            lives--;
            isInSectionTwo = false;
            isInSectionOne = true;
            initClasses();
        }
        /* -------------------------------------------------------------------------------------------------------- */

        /* -------------------------------------------------- LIFE ------------------------------------------------- */

        if (lives == 0) {
            isGameEnded = true;
            IO.getInstance().save();
            stopTimer();
            gameFrame.dispose();
            new MainFrame();
        }

        /* -------------------------------------------------------------------------------------------------------- */

        /* ----------------------------------------- CALCULATE MECHANISM ------------------------------------- */

        // Updating the Score
        if (player.hitBox.x >= BOUND_TO_NEXT_SECTION - 100 && !isCalculatedScoreInSectionOne) {
            calculatingScore();
            isCalculatedScoreInSectionOne = true;
            isInSectionOne = false;
            isInSectionTwo = true;
        }

        if (player.hitBox.x >= BOUND_TO_NEXT_SECTION - 100 && levelManager.sectionNumber == 2 && !isCalculatedScoreInSectionTwo) {
            calculatingScore();
            isCalculatedScoreInSectionTwo = true;
            isInSectionOne = true;
            isInSectionTwo = false;
            isInLevelOne = false;
            isInLevelTwo = true;
        }

        /* ---------------------------------------------- HUI ------------------------------------------------------- */
        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.BOLD, 36));
        g.drawString("Lives: " + lives, 20, 40);

        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.BOLD, 36));
        g.drawString("Coins: " + coins, 250, 40);

        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.BOLD, 36));
        g.drawString("Score: " + score, 490, 40);

        g.setColor(Color.black);
        g.setFont(new Font("Courier", Font.BOLD, 36));
        g.drawString("World: " + levelManager.levelNumber + " - " + levelManager.sectionNumber, 1000, 40);
        /* ---------------------------------------------------------------------------------------------------------- */

        graphicalCheckpoint.draw(g, player.xLvlOffset);

        graphicalNukeBird.draw(g, player.xLvlOffset);
        nukeBird.move();

        graphicalBomb.draw(g, player.xLvlOffset);
        bomb.move();

        graphicalPipe.draw(g, player.xLvlOffset);

        // important
        player.render(g, player.xLvlOffset);

        graphicalWeapon.draw(g, player.xLvlOffset);
        weapon.move();

        graphicalFireball.draw(g, player.xLvlOffset);
        fireball.move();

        graphicalMario.draw(g, player.xLvlOffset);
    }

    public void calculatingScore() {
        if (isInLevelOne && isInSectionOne) {
            for (boolean e : coin.drawingCoinsAtLevelOneSectionOne) {
                if (e) {
                    coins++;
                }
            }
            score += (10 * coins) + (20 * lives) + (time);
        }

        if (isInLevelOne && isInSectionTwo && player.hitBox.x >= 5000) {
            for (int i = 0; i < 7; i++) {
                if (coin.drawingCoinsAtLevelOneSectionTwo[i]) {
                    coins++;
                }
            }
            score += (10 * coins) + (20 * lives) + (time);
        }

        if (isInLevelTwo && isInSectionOne) {

            for (Coin coin : coinArrayList) {
                if (coin.eat) coins++;
            }


            score += (10 * coins) + (20 * lives) + (time);

        }

        if (isInLevelTwo && isInSectionTwo) {

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
//                time--;
                System.out.println("createTime: " + time);
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
                time--;

                frames = 0;
                updates = 0;
            }

        }
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
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