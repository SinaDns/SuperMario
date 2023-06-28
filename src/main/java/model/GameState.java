package model;

import controller.TileManager;
import model.enemies.*;
import model.items.Coin;
import model.items.Star;

public class GameState {
    public TileManager tileManager;
    public Coin coin;
    public Pipe pipe;
    public Plant plant;
    public Checkpoint checkpoint;
    public Star star;

    public Enemy enemy;
    public Goompa goompa;
    public Koopa koopa;
    public Spiny spiny;
    public OgreMagi ogreMagi;
    public NukeBird nukeBird;
    public Bomb bomb;
}
