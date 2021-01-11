package PaooGame.Items;

import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Coin extends Item {

    public static final int COIN_WIDTH  = 50;
    public static final int COIN_HEIGHT = 50;
    Rectangle boundaries;

    public Coin(RefLinks reflinks, float x, float y, int width, int height, BufferedImage[] img)
    {
        super(reflinks, x,y, width, height);
        boundaries=new Rectangle((int)x,(int)y,COIN_WIDTH,COIN_HEIGHT);
        coinAnimation.setImages(img);
        coinAnimation.setSpeed(2);

    }
    @Override
    public void Update()
    {
        coinAnimation.Update();
    }

    @Override
    public void Draw(Graphics g)
    {
        coinAnimation.Draw(g);
    }

    public Rectangle getBoundaries()
    {
        return boundaries;
    }
}
