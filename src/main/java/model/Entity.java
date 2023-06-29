package model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import controller.LevelManager;
import model.items.Coin;

import java.awt.*;

public abstract class Entity extends GameObject {

    LevelManager levelManager;
//    public float x, y;
    public int x, y;
    public int width, height;
    @JsonIgnore
    public Rectangle hitBox;
    public Coin coin;

//    public Entity(float x, float y, int width, int height) {
//        this.x = x;
//        this.y = y;
//        this.width = width;
//        this.height = height;
//    }

    public Entity(int x, int y, int width, int height, LevelManager levelManager) {
        super(x, y, width, height, levelManager);
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

//    public Entity() {
//
//    }


    protected void initHitBox(float x, float y, float width, float height) {
        hitBox = new Rectangle((int) x, (int) y, (int) width, (int) height);
    }


    public Coin getCoin() {
        return coin;
    }

    public Rectangle getHitBox() {
        return hitBox;
    }

//    public float getX() {
//        return x;
//    }

//    public void setX(float x) {
//        this.x = x;
//    }

//    public float getY() {
//        return y;
//    }

//    public void setY(float y) {
//        this.y = y;
//    }
}


//    public boolean intersects(Rectangle rectangle) {
//        int tw = this.width;
//        int th = this.height;
//        int rw = rectangle.width;
//        int rh = rectangle.height;
//        if (rw <= 0 || rh <= 0 || tw <= 0 || th <= 0) {
//            return false;
//        }
//        int tx = (int) this.x;
//        int ty = (int) this.y;
//        int rx = rectangle.x;
//        int ry = rectangle.y;
//        rw += rx;
//        rh += ry;
//        tw += tx;
//        th += ty;
//        //      overflow || intersect
//        return ((rw < rx || rw > tx) &&
//                (rh < ry || rh > ty) &&
//                (tw < tx || tw > rx) &&
//                (th < ty || th > ry));
//    }
