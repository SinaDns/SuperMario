package config;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageAddresses {

//   public static final String ICON_GAME = "src/MarioPhotos/images.png";


    public static final String COIN = "spr_coin_0.png";
    public static final String PIPE = "pipe.png";
    public static final String FLOWER = "flower.png";
    public static final String PASHA = "PashaHead.png";

    public static final String section1 = "IMG_1871.JPG";
    public static final String section2 = "Level1-Section2.jpg";

    public static final String RED_MARIO = "RedMario.png";
    public static final String BLACK_MARIO = "BlackMario.png";
    public static final String YELLOW_MARIO = "YellowMario.png";
    public static final String PINK_MARIO = "PinkMario.png";
    public static final String GREEN_MARIO = "GreenMario.png";

    public static final String STORE_RED = "StoreRed.png";
    public static final String STORE_BLACK = "StoreBlack.png";
    public static final String STORE_GREEN = "StoreGreen.png";
    public static final String STORE_YELLOW = "StoreYellow.png";
    public static final String STORE_PINK = "StorePink.png";

    public static final String CHECKPOINT_FLAG = "Checkpoint-Flag.png";


    public static final String SPINY = "Spiny.png";
    public static final String GOOMPA = "Goompa.png";


    public static BufferedImage getPlayerSprite(String fileName) {
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