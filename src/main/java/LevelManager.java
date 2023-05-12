import com.fasterxml.jackson.annotation.JsonIgnore;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.logging.Level;

public class LevelManager {

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(int sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public BufferedImage getSection1Sprite() {
        return section1Sprite;
    }

    public void setSection1Sprite(BufferedImage section1Sprite) {
        this.section1Sprite = section1Sprite;
    }

    public BufferedImage getSection2Sprite() {
        return section2Sprite;
    }

    public void setSection2Sprite(BufferedImage section2Sprite) {
        this.section2Sprite = section2Sprite;
    }

    private Game game;
    public int sectionNumber;

    @JsonIgnore
    private BufferedImage section1Sprite;
    @JsonIgnore
    private BufferedImage section2Sprite;


    public LevelManager(Game game, int sectionNumber) {
        this.game = game;
        this.sectionNumber = sectionNumber;
        section1Sprite = ImageAddresses.getPlayerSprite(ImageAddresses.section1);
        section2Sprite = ImageAddresses.getPlayerSprite(ImageAddresses.section2);
    }

    public LevelManager() {

    }


    public void draw(Graphics g, int xlvloffset, int lives, int coins, int score) {

        switch (sectionNumber) {
            case 1:
                g.drawImage(section1Sprite, -xlvloffset, 0, 5120, 720, null);
                break;

            case 2:
                g.drawImage(section2Sprite, -xlvloffset, 0, 5120, 720, null);

                // DRAWING TILES (COMPLICATED ONE)
                g.drawImage(TileManager.tile[0].image, 631 -xlvloffset, 311, 48, 48, null);
                g.drawImage(TileManager.tile[0].image, 681 -xlvloffset, 311, 48, 48, null);
                g.drawImage(TileManager.tile[0].image, 731 -xlvloffset, 311, 48, 48, null);
                g.drawImage(TileManager.tile[0].image, 781 -xlvloffset, 311, 48, 48, null);
                g.drawImage(TileManager.tile[0].image, 831 -xlvloffset, 311, 48, 48, null);
                break;
        }


        g.setFont(new Font("Consolas", Font.BOLD, 60));
        g.drawString("Ghoole Marhale Akhar :D", 4300 - xlvloffset, 350);

        g.setFont(new Font("Courier", Font.BOLD, 40));
        g.drawString("Lives: " + lives, 20, 40);

        g.setFont(new Font("Courier", Font.BOLD, 40));
        g.drawString("Coins: " + coins, 250, 40);

        g.setFont(new Font("Courier", Font.BOLD, 40));
        g.drawString("Score: " + score, 500, 40);


        g.setFont(new Font("Courier", Font.BOLD, 40));
        if ((-xlvloffset <= 0) && (-xlvloffset >= -1280))
            g.drawString("World: " + sectionNumber + " -1", 1050, 40);
        else if ((-xlvloffset <= -1280) && (-xlvloffset >= -2560))
            g.drawString("World: " + sectionNumber + " -2", 1050, 40);
        else if ((-xlvloffset <= -2560) && (-xlvloffset >= -3840))
            g.drawString("World: " + sectionNumber + " -3", 1050, 40);
        else if ((-xlvloffset <= 0))
            g.drawString("World: " + sectionNumber + " -4", 1050, 40);



    }


}
