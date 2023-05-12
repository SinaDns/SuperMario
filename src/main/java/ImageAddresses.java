import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.Buffer;

public class ImageAddresses {

//    static final String ICON_GAME = "src/MarioPhotos/images.png";


    static final String COIN = "spr_coin_0.png";
    static final String PIPE = "pipe.png";
    static final String FLOWER = "flower.png";
    static final String PASHA = "PashaHead.png";

    static final String section1 = "IMG_1871.JPG";
    static final String section2 = "Level1-Section2.jpg";

    static final String RED_MARIO = "RedMario.png";
    static final String BLACK_MARIO = "BlackMario.png";
    static final String YELLOW_MARIO = "YellowMario.png";
    static final String PINK_MARIO = "PinkMario.png";
    static final String GREEN_MARIO = "GreenMario.png";

    static final String STORE_RED = "StoreRed.png";
    static final String STORE_BLACK = "StoreBlack.png";
    static final String STORE_GREEN = "StoreGreen.png";
    static final String STORE_YELLOW = "StoreYellow.png";
    static final String STORE_PINK = "StorePink.png";


    public static BufferedImage getPlayerSprite(String fileName) {
        File imageFile = new File("D:\\Coding Tutorial\\spam tamrin code\\SuperSuperSuperSuperMariooo\\src\\" + fileName);
        BufferedImage image = null;

        try {
            image = ImageIO.read(imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        BufferedImage image = null;
        //InputStream inputStream = ImageAddresses.class.getResourceAsStream("/" + fileName);
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