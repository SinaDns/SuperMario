package config;

public class Constants {

    public static final int MENUS_WIDTH = 1000;
    public static final int MENUS_HEIGHT = 900;


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

            switch (playerAction) {
                case RUNNING:
                    return 2;

                case JUMPING:
                case HIT:
                case FALLING:
                case GROUND:
                    return 1;

                default:
                    return 1;
            }
        }
    }



}
