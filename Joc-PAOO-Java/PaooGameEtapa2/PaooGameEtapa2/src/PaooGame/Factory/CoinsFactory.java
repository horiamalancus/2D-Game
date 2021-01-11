package PaooGame.Factory;

import PaooGame.Graphics.Assets;
import PaooGame.Items.Coin;
import PaooGame.RefLinks;

import java.awt.image.BufferedImage;

public class CoinsFactory {

    public static final int GOLD_COIN=1;
    public static final int BROWN_COIN=2;

    public static Coin getCoin(RefLinks reflinks, float x, float y, int width, int height,int coinType)
    {
        switch(coinType)
        {
            case GOLD_COIN:
                return new Coin(reflinks,x,y,width,height, Assets.coin);
            case BROWN_COIN:
                return new Coin(reflinks,x,y,width,height, Assets.fancycoin);
            default: return null;
        }

    }
}
