package PaooGame.Items;

import PaooGame.Collision.CollisionRectangles;
import PaooGame.Graphics.Animation;
import PaooGame.Mechanics.CharacterMovement;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;


/*! \class Item
    \brief. Implementeaza notiunea abstracta de entitate activa din joc, "element cu care se poate interactiona: monstru, turn etc.".
 */
public abstract class Item
{
        ///asa cum s-a mai precizat, coordonatele x si y sunt de tip float pentru a se elimina erorile de rotunjire
        ///ce pot sa apara in urma calculelor, urmand a se converti la intreg doar in momentul desenarii.
    public CharacterMovement characterMovement;
    protected float x;                  /*!< Pozitia pe axa X a "tablei" de joc a imaginii entitatii.*/
    protected float y;                  /*!< Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.*/
    protected int width;                /*!< Latimea imaginii entitatii.*/
    protected int height;               /*!< Inaltimea imaginii entitatii.*/
    protected CollisionRectangles bounds;         /*!< Dreptunghiul curent de coliziune.*/

    protected Animation animation;
    protected Animation coinAnimation;

    protected RefLinks refLink;         /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/

    /*! \fn public Item(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructor de initializare al clasei

        \param  reflink Referinte "shortcut" catre alte referinte
        \param  x   Pozitia pe axa X a "tablei" de joc a imaginii entitatii.
        \param  y   Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.
        \param  width   Latimea imaginii entitatii.
        \param  height  Inaltimea imaginii entitatii.
     */
    public Item(RefLinks refLink, float x, float y, int width, int height)
    {
        characterMovement=new CharacterMovement(x,y,width,height);

        this.x = x;             /*!< Retine coordonata pe axa X.*/
        this.y = y;             /*!< Retine coordonata pe axa X.*/
        this.width = width;     /*!< Retine latimea imaginii.*/
        this.height = height;   /*!< Retine inaltimea imaginii.*/
        this.refLink = refLink; /*!< Retine the "shortcut".*/

        animation = new Animation(this);
        coinAnimation= new Animation(this);
            ///Dreptunghiul de coliziune implicit este setat ca fiind cel normal
        bounds = new CollisionRectangles(this);
    }

        ///Metoda abstracta destinata actualizarii starii curente
    public abstract void Update();
        ///Metoda abstracta destinata desenarii starii curente
    public abstract void Draw(Graphics g);

    /*! \fn public float GetX()
        \brief Returneaza coordonata pe axa X.
     */
    public float GetX()
    {
        return x;
    }

    /*! \fn public float GetY()
        \brief Returneaza coordonata pe axa Y.
     */
    public float GetY()
    {
        return y;
    }

    /*! \fn public float GetWidth()
        \brief Returneaza latimea entitatii.
     */
    public int GetWidth()
    {
        return width;
    }

    /*! \fn public float GetHeight()
        \brief Returneaza inaltimea entitatii.
     */
    public int GetHeight()
    {
        return height;
    }

    /*! \fn public float SetX()
        \brief Seteaza coordonata pe axa X.
     */
    public void SetX(float x)
    {
        this.x = x;
    }

    /*! \fn public float SetY()
        \brief Seteaza coordonata pe axa Y.
     */
    public void SetY(float y)
    {
        this.y = y;
    }

    /*! \fn public float SetWidth()
        \brief Seteaza latimea imaginii entitatii.
     */
    public void SetWidth(int width)
    {
        this.width = width;
    }

    /*! \fn public float SetHeight()
        \brief Seteaza inaltimea imaginii entitatii.
     */
    public void SetHeight(int height)
    {
        this.height = height;
    }

    /*! \fn public void SetNormalMode()
        \brief Seteaza modul normal de interactiune
     */

}