package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
        /// Referinte catre elementele grafice (dale) utilizate in joc.
    /*public static BufferedImage heroLeft;
    public static BufferedImage heroRight;*/

    public static final int frames = 6;
    public static final int coinsFrames = 6;

    private static final int    tileWidth1   = 96;
    private static final int    tileHeight1   = 96;

    private static final int    tileWidth2   = 77;
    private static final int    tileHeight2   = 82;

    private static final int objectWidth = 32;
    private static final int objectHeight = 64;

    public static BufferedImage background;

    public static BufferedImage rockIce;
    public static BufferedImage rock;


    public static BufferedImage[]player=new BufferedImage[frames];
    public static BufferedImage playerStanding;

    public static BufferedImage[]coin=new BufferedImage[frames];
    public static BufferedImage[]fancycoin=new BufferedImage[coinsFrames];


    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
            /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.LoadImage("/textures/Rocks.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("/textures/rock.png"));
        //SpriteSheet sheet = new SpriteSheet(ImageLoader.LoadImage("/textures/PaooGameSpriteSheet.png"));
        SpriteSheet sheet10 = new SpriteSheet(ImageLoader.LoadImage("/textures/MyHero.png"));
        SpriteSheet sheet11 = new SpriteSheet(ImageLoader.LoadImage("/textures/GoldCoins.png"));
        SpriteSheet sheet12 = new SpriteSheet(ImageLoader.LoadImage("/textures/fancyCoins.png"));

            /// Se obtin subimaginile corespunzatoare elementelor necesare.

        background=ImageLoader.LoadImage("/textures/background2.jpg");

        rock = sheet1.crop(2, 3,tileWidth1,tileHeight1);
        rockIce = sheet2.crop(0, 0,tileWidth2,tileHeight2);

        playerStanding=sheet10.crop(0,0,objectWidth-1,objectHeight-2);
        player[0]=sheet10.crop(0,3,objectWidth,objectHeight);
        player[1]=sheet10.crop(1,3,objectWidth,objectHeight);
        player[2]=sheet10.crop(2,3,objectWidth,objectHeight);
        player[3]=sheet10.crop(3,3,objectWidth,objectHeight);
        player[4]=sheet10.crop(4,3,objectWidth,objectHeight);
        player[5]=sheet10.crop(5,3,objectWidth,objectHeight);

        coin[0]=sheet11.crop(0,1,83,93);
        coin[1]=sheet11.crop(1,1,83,93);
        coin[2]=sheet11.crop(2,1,83,93);
        coin[3]=sheet11.crop(3,1,83,93);
        coin[4]=sheet11.crop(4,1,83,93);
        coin[5]=sheet11.crop(5,1,83,93);

        fancycoin[0]=sheet12.crop(0,0,116,200);
        fancycoin[1]=sheet12.crop(1,0,116,200);
        fancycoin[2]=sheet12.crop(2,0,116,200);
        fancycoin[3]=sheet12.crop(3,0,116,200);
        fancycoin[4]=sheet12.crop(4,0,116,200);
        fancycoin[5]=sheet12.crop(5,0,116,200);

    }
}
