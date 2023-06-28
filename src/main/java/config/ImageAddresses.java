package config;

import javax.imageio.ImageIO;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageAddresses {

//   public static final String ICON_GAME = "src/MarioPhotos/images.png";

    // Items
    public static final String COIN = "spr_coin_0.png";
    public static final String MUSHROOM = "Mushroom.png";
    public static final String PIPE = "pipe.png";
    public static final String FLOWER = "flower.png";
    public static final String PASHA = "PashaHead.png";
    public static final String STAR = "Star.png";
    public static final String HEALTH_BAR = "health-bar.png";
    public static final String HEALTH_BAR_2 = "HealthBar.png";

    public static final String RED_MARIO = "RedMario.png";
    public static final String BLACK_MARIO = "BlackMario.png";
    public static final String YELLOW_MARIO = "YellowMario.png";
    public static final String PINK_MARIO = "PinkMario.png";
    public static final String GREEN_MARIO = "GreenMario.png";
    public static final String ICY_MARIO = "IcyMario.png";

    public static final String STORE_RED = "StoreRed.png";
    public static final String STORE_BLACK = "StoreBlack.png";
    public static final String STORE_GREEN = "StoreGreen.png";
    public static final String STORE_YELLOW = "StoreYellow.png";
    public static final String STORE_PINK = "StorePink.png";

    public static final String CHECKPOINT_FLAG = "Checkpoint-Flag.png";
    public static final String SWORD = "PipeSword.png";

    // Boss
    public static final String BOSS = "ogre_magi.png";
    public static final String INVERTED_BOSS = "ogre_magi_inverted.png";
    public static final String TRIGGERED_BOSS = "ogre_magi_arcana.png";

    // Enemies
    public static final String SPINY = "Spiny.png";
    public static final String GOOMPA = "Goompa.png";
    public static final String KOOPA = "Turtle.png";
    public static final String NUKEBIRD = "NukeBird.png";
    public static final String BOMB = "Bomb.png";



    public static BufferedImage getSprite (String fileName) {
        File imageFile = new File("D:\\Coding Tutorial\\spam tamrin code\\SuperSuperSuperSuperMariooo\\src\\" + fileName);
        BufferedImage image = null;

        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


//        BufferedImage image = null;
        //InputStream inputStream = config.ImageAddresses.class.getResourceAsStream("/" + fileName);
//        try {
//            assert inputStream != null;
//            image = ImageIO.read(inputStream);
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                assert inputStream != null;
//                inputStream.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
        return image;
    }


}