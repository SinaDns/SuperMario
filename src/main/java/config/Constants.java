package config;

public class Constants {

    public static final int MENU_WIDTH = 1000;
    public static final int MENU_HEIGHT = 900;

    public final static int GAME_WIDTH = 1280;
    public final static int GAME_HEIGHT = 720;

    public final static int leftBorder = (int) (0.5 * Constants.GAME_WIDTH);
    public final static int rightBorder = (int) (0.5 * Constants.GAME_WIDTH);

//    public final int BOUND_TO_NEXT_SECTION = (5 * GAME_WIDTH) - 100;

    public static final int FPS = 120;
    public static final int UPS = 120;

    public final static float SCALE = 1.5f;
    public final static int TILES_DEFAULT_SIZE = 32;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);


    public static class Directions {
        public static final int LEFT = 0;
        public static final int UP = 1;
        public static final int RIGHT = 2;
        public static final int DOWN = 3;
    }

    public static class PlayerConstants {

        public static final int IDLE = 0;
        public static final int RUNNING = 1;
        public static final int JUMPING = 2;
        public static final int FALLING = 3;
        public static final int GROUND = 4;
        public static final int HIT = 5;
//        public static final int ATTACK_1 = 6;
//        public static final int ATTACK_JUMP_1 = 7;
//        public static final int ATTACK_JUMP_2 = 8;


        // how many sprites, are in the action? (for not going out of bounds)
        public static int getSpriteAmounts(int playerAction) {

            return switch (playerAction) {
                case RUNNING -> 2;
                case JUMPING, HIT, FALLING, GROUND -> 1;
                default -> 1;
            };
        }
    }


}