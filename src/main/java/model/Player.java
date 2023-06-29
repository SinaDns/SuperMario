package model;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import config.Constants;
import config.ImageAddresses;
import controller.LevelManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import static config.Constants.PlayerConstants.IDLE;
import static config.Constants.PlayerConstants.RUNNING;
import static config.Constants.leftBorder;
import static config.Constants.rightBorder;

public class Player extends Entity {

    LevelManager levelManager;

    public boolean weapon = false;
    public boolean isOnSlimeBlock = false;
    public boolean isOnMiniMode = false;
    public boolean isOnMegaMode = false;
    public boolean isOnIcyMode = true;
    public int marioSelectionNumber = 4;
    public int xLvlOffset;
    public boolean activeShield = false;
    Timer timer;
    private boolean fire;
    //    @JsonIgnore
    private BufferedImage[] afkAni;
    private int aniTick, aniIndex, aniSpeed = 15;
    private int playerAction = IDLE;
    private boolean moving;
    private boolean left, right, jump;

    Rectangle2D.Double marioRectangle;

    // pixels that we wouldn't see
    private int maxOffsetX = (5 * Constants.GAME_WIDTH) - Constants.GAME_WIDTH;
    private float xDrawOffset = 21 * Constants.SCALE;
    private float yDrawOffset = 4 * Constants.SCALE;

    // Jumping + Gravity
    private float airSpeed = 0f;
    private float gravity = 0.04f * Constants.SCALE;
    private float jumpSpeed = -3f * Constants.SCALE;
    private float fallSpeedAfterCollision = 0.5f * Constants.SCALE;
    private boolean inAir = false;

    public Player(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);
        loadAnimations();
        initHitBox(x, y, 20 * Constants.SCALE, 27 * Constants.SCALE);
        marioRectangle = new Rectangle2D.Double(x, y, hitBox.width, hitBox.height);
    }

//    public Player() {
//    }

    public void update() {
        updatePosition();
        updateAnimationTick();

        if (!Game.isInBossFight)
            checkCloseToBorder();

        setAnimation();
    }

    public void checkCloseToBorder() {
        int playerX = this.getHitBox().x;
        int diff = playerX - xLvlOffset;

        if (diff > rightBorder)
            xLvlOffset += diff - rightBorder;
        else if (diff < leftBorder)
            xLvlOffset += diff - leftBorder;

        if (xLvlOffset > maxOffsetX)
            xLvlOffset = maxOffsetX;
        else if (xLvlOffset < 0)
            xLvlOffset = 0;
    }

    public void render(Graphics g, int xLvlOffset) {

        if (isOnMiniMode) {
            if (activeShield) {
                g.setColor(Color.PINK);
                g.fillOval((int) (hitBox.x - xDrawOffset) - xLvlOffset - 25, (int) (hitBox.y - yDrawOffset), 65, 65);
                g.drawImage(afkAni[aniIndex], (int) (hitBox.x - xDrawOffset) - xLvlOffset, (int) (hitBox.y - yDrawOffset), 50, 40, null);
            } else
                g.drawImage(afkAni[aniIndex], (int) (hitBox.x - xDrawOffset) - xLvlOffset, (int) (hitBox.y - yDrawOffset), 50, 40, null);
        } else {
            if (activeShield) {
                g.setColor(Color.PINK);
                g.fillOval((int) (hitBox.x - xDrawOffset) - xLvlOffset - 20, (int) (hitBox.y - yDrawOffset), 85, 85);
                g.drawImage(afkAni[aniIndex], (int) (hitBox.x - xDrawOffset) - xLvlOffset, (int) (hitBox.y - yDrawOffset), 50, 80, null);
            } else
                g.drawImage(afkAni[aniIndex], (int) (hitBox.x - xDrawOffset) - xLvlOffset, (int) (hitBox.y - yDrawOffset), 50, 80, null);
        }

    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= 2) {
                aniIndex = 0;
            }
        }
    }

    private void setAnimation() {
        if (moving)
            playerAction = RUNNING;
        else playerAction = IDLE;
    }

    private void updatePosition() {
        moving = false;


        // Mario Weapon
        if (isOnMiniMode && jump) {
            System.out.println("tooye in if");
            timer = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("kar kard.");
                    weapon = true;
                }
            });
            timer.start();
            timer.setRepeats(false);
        } else {
            if (jump)
                jump();

            if (!left && !right && !inAir)
                return;

            float xSpeed = 0;
            float playerSpeed = 5;
            if (left)
                xSpeed -= playerSpeed;
            if (right)
                xSpeed += playerSpeed;

            if (!inAir)
                if (!IsEntityOnFloor(hitBox))
                    inAir = true;

            if (inAir) {
                if (canMoveHere(hitBox.x, hitBox.y + airSpeed, hitBox.width, hitBox.height)) {
                    hitBox.y += airSpeed;
                    airSpeed += gravity;
                    updateXPos(xSpeed);
                } else {
                    hitBox.y = (int) GetEntityYPosUnderRoofOrAboveFloor(hitBox, airSpeed);
                    if (airSpeed > 0)
                        resetInAir();
                    else
                        airSpeed = fallSpeedAfterCollision;
                    updateXPos(xSpeed);
                }
            } else
                updateXPos(xSpeed);

            moving = true;
        }


    }

    private void jump() {
        if (inAir)
            return;
        inAir = true;

        if (!isOnSlimeBlock)
            airSpeed = jumpSpeed;
        else
            airSpeed = 1.5f * jumpSpeed;
    }

    private void resetInAir() {
        inAir = false;
        airSpeed = 0;
    }


    private void updateXPos(float xSpeed) {
        if (canMoveHere(hitBox.x + xSpeed, hitBox.y, hitBox.width, hitBox.height)) {
            hitBox.x += xSpeed;
        } else {
            hitBox.x = (int) GetEntityXPosNextToWall(hitBox, xSpeed);
        }
    }


    public void loadAnimations() {
        BufferedImage imageRed = ImageAddresses.getSprite(ImageAddresses.RED_MARIO);
        BufferedImage imagePink = ImageAddresses.getSprite(ImageAddresses.PINK_MARIO);
        BufferedImage imageGreen = ImageAddresses.getSprite(ImageAddresses.GREEN_MARIO);
        BufferedImage imageYellow = ImageAddresses.getSprite(ImageAddresses.YELLOW_MARIO);
        BufferedImage imageBlack = ImageAddresses.getSprite(ImageAddresses.BLACK_MARIO);
        BufferedImage imageIcy = ImageAddresses.getSprite(ImageAddresses.ICY_MARIO);

        afkAni = new BufferedImage[2];

        if (User.loggedInUser.get(0).redBought && User.loggedInUser.get(0).redChoose)
            for (int i = 0; i < afkAni.length; i++) {
                afkAni[i] = imageRed.getSubimage(i * 200, 0, 200, 280);
            }

        if (User.loggedInUser.get(0).pinkBought && User.loggedInUser.get(0).pinkChoose)
            for (int i = 0; i < afkAni.length; i++) {
                afkAni[i] = imagePink.getSubimage(i * 200, 0, 200, 280);
            }

        if (User.loggedInUser.get(0).yellowBought && User.loggedInUser.get(0).yellowChoose)
            for (int i = 0; i < afkAni.length; i++) {
                afkAni[i] = imageYellow.getSubimage(i * 200, 0, 200, 280);
            }

        if (User.loggedInUser.get(0).greenBought && User.loggedInUser.get(0).greenChoose)
            for (int i = 0; i < afkAni.length; i++) {
                afkAni[i] = imageGreen.getSubimage(i * 200, 0, 200, 280);
            }

        if (User.loggedInUser.get(0).blackBought && User.loggedInUser.get(0).blackChoose)
            for (int i = 0; i < afkAni.length; i++) {
                afkAni[i] = imageBlack.getSubimage(i * 200, 0, 200, 280);
            }

        if (isOnIcyMode)
            for (int i = 0; i < afkAni.length; i++) {
                afkAni[i] = imageIcy.getSubimage(i * 200, 0, 200, 280);
            }


    }

    public float GetEntityXPosNextToWall(Rectangle hitBox, float xSpeed) {

        int currentTile = (hitBox.x / Constants.TILES_SIZE);
        if (xSpeed > 0) {
            // Right
            int tileXPos = currentTile * Constants.TILES_SIZE;
            int xOffset = (Constants.TILES_SIZE - hitBox.width);
            return tileXPos + xOffset - 1;
        } else
            // Left
            return currentTile * Constants.TILES_SIZE;
    }


    public boolean canMoveHere(float x, float y, int width, int height) {

        if (isSolid(x, y))
            if (isSolid(x + width, y + height))
                if (isSolid(x + width, y))
                    return isSolid(x, y + height);

        return false;
    }

    public boolean isSolid(float x, float y) {

        if (x < 0 || x >= 5 * Constants.GAME_WIDTH)
            return false;

        // Gravity Checker for Mario
        if (y < 0 || y >= 480)
            return false;


        if (Game.isInBossFight && (x > Constants.GAME_WIDTH))
            return false;

        // ---------------------------------------------- LEVEL 1 --------------------------------------------------- //

        if (Game.isInLevelOne && Game.isInSectionOne) {
            // tiles in section 1
            if ((x >= 460 && x <= 690) && (y >= 308 && y <= 385))
                return false;
            // slime tile
            if ((x >= 1000) && (x <= 1102) && (y >= 415) && (y <= 478)) {
                isOnSlimeBlock = true;
                return false;
            }

            // pipe
            if ((x <= 3460 && x >= 3350) && (y <= 500 && y >= 360))
                return false;
        }

        if (Game.isInLevelOne && Game.isInSectionTwo) {
            // tiles in section 2
            if ((x >= 660 && x <= 890) && (y >= 308 && y <= 385))
                return false;
            // pipe
            if ((x <= 3120 && x >= 3020) && (y <= 500 && y >= 360))
                return false;

            // hidden pipe
            if ((4120 <= x && x <= 4220) && (370 <= y)) {
//                Game.isInFirstHiddenPart = true;
                return false;
            }
        }

        // ---------------------------------------------------------------------------------------------------------- //

        if (Game.isInLevelOne && Game.isInSectionOne && (x > 1102 || x < 1000))
            isOnSlimeBlock = false;


        return true;
    }

    public float GetEntityYPosUnderRoofOrAboveFloor(Rectangle hitbox, float airSpeed) {
        int currentTile = (hitbox.y / Constants.TILES_SIZE);
        if (airSpeed > 0) {
            // Falling - touching floor - hole?!
            int tileYPos = currentTile * Constants.TILES_SIZE;
            int yOffset = (Constants.TILES_SIZE - hitbox.height);
            return tileYPos + yOffset - 1;
        } else
            // Jumping
            return currentTile * Constants.TILES_SIZE;
    }


    public boolean IsEntityOnFloor(Rectangle hitbox) {
        // Check the pixel below bottomLeft and bottomRight
        if (isSolid(hitbox.x, hitbox.y + hitbox.height + 1))
            if (isSolid(hitbox.x + hitbox.width, hitbox.y + hitbox.height + 1))
                return false;

        if (Game.isInSectionOne)
            // hole
            if (hitbox.x >= 1875 && hitbox.x <= 1960)
                return false;

        if (Game.isInSectionTwo)
            // hole
            return hitbox.x < 1400 || hitbox.x > 1750;

        return true;
    }

    public boolean isFire() {
        return fire;
    }

    public void setFire(boolean fire) {
        this.fire = fire;
    }

    public BufferedImage[] getAfkAni() {
        return afkAni;
    }

    public void setAfkAni(BufferedImage[] afkAni) {
        this.afkAni = afkAni;
    }

    public int getMarioSelectionNumber() {
        return marioSelectionNumber;
    }

    public void setMarioSelectionNumber(int marioSelectionNumber) {
        this.marioSelectionNumber = marioSelectionNumber;
    }

    public int getAniTick() {
        return aniTick;
    }

    public void setAniTick(int aniTick) {
        this.aniTick = aniTick;
    }

    public int getAniIndex() {
        return aniIndex;
    }

    public void setAniIndex(int aniIndex) {
        this.aniIndex = aniIndex;
    }

    public int getAniSpeed() {
        return aniSpeed;
    }

    public void setAniSpeed(int aniSpeed) {
        this.aniSpeed = aniSpeed;
    }

    public int getPlayerAction() {
        return playerAction;
    }

    public void setPlayerAction(int playerAction) {
        this.playerAction = playerAction;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isJump() {
        return jump;
    }

    public void setJump(boolean jump) {
        this.jump = jump;
    }

    public int getxLvlOffset() {
        return xLvlOffset;
    }

    public void setxLvlOffset(int xLvlOffset) {
        this.xLvlOffset = xLvlOffset;
    }

    public int getLeftBorder() {
        return leftBorder;
    }

    public int getRightBorder() {
        return rightBorder;
    }

    public int getMaxOffsetX() {
        return maxOffsetX;
    }

    public void setMaxOffsetX(int maxOffsetX) {
        this.maxOffsetX = maxOffsetX;
    }

    public float getxDrawOffset() {
        return xDrawOffset;
    }

    public void setxDrawOffset(float xDrawOffset) {
        this.xDrawOffset = xDrawOffset;
    }

    public float getyDrawOffset() {
        return yDrawOffset;
    }

    public void setyDrawOffset(float yDrawOffset) {
        this.yDrawOffset = yDrawOffset;
    }

    public float getAirSpeed() {
        return airSpeed;
    }

    public void setAirSpeed(float airSpeed) {
        this.airSpeed = airSpeed;
    }

    public float getGravity() {
        return gravity;
    }

    public void setGravity(float gravity) {
        this.gravity = gravity;
    }

    public float getJumpSpeed() {
        return jumpSpeed;
    }

    public void setJumpSpeed(float jumpSpeed) {
        this.jumpSpeed = jumpSpeed;
    }

    public float getFallSpeedAfterCollision() {
        return fallSpeedAfterCollision;
    }

    public void setFallSpeedAfterCollision(float fallSpeedAfterCollision) {
        this.fallSpeedAfterCollision = fallSpeedAfterCollision;
    }

    public boolean isInAir() {
        return inAir;
    }

    public void setInAir(boolean inAir) {
        this.inAir = inAir;
    }

    public void setJumping(boolean jump) {
        this.jump = jump;
    }

    public boolean isOnMiniMode() {
        return isOnMiniMode;
    }

    public void setOnMiniMode(boolean onMiniMode) {
        isOnMiniMode = onMiniMode;
    }

    public boolean isActiveShield() {
        return activeShield;
    }

    public void setActiveShield(boolean activeShield) {
        this.activeShield = activeShield;
    }
}


//        if (!inHole)
//            if (!IsEntityOnFloor(hitBox))
//                inHole = true;

//        if (inHole) {
//            hitBox.y += airSpeed;
//            airSpeed += gravity;
//            updateXPos(xSpeed);
//            updateYPos(airSpeed);
//
//            if (airSpeed > 0)
//                resetInHole();
//            else
//                airSpeed = fallSpeedAfterCollision;
//            updateXPos(xSpeed);
//        }
//        else {
//            updateXPos(xSpeed);
//            updateYPos(airSpeed);
//        }


//    public void updateYPos(float airSpeed) {
//        if (canMoveHere(hitBox.x, hitBox.y + airSpeed, hitBox.width, hitBox.height)) {
//            hitBox.y += airSpeed;
//        } else hitBox.y = (int) GetEntityYPosUnderRoofOrAboveFloor(hitBox, airSpeed);
//    }