package PaooGame.Items;

import PaooGame.Collision.CollisionRectangles;
import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.Mechanics.CharacterMovement;
import PaooGame.RefLinks;

import java.awt.*;
import java.awt.image.BufferedImage;

/*! \class public abstract class Character extends Item
    \brief Defineste notiunea abstracta de caracter/individ/fiinta din joc.

    Notiunea este definita doar de viata, viteza de deplasare si distanta cu care trebuie sa se
    miste/deplaseze in urma calculelor.
 */
public abstract class Character extends Item
{
    //public CharacterMovement characterMovement;
    public static final int DEFAULT_LIFE            = 10;   /*!< Valoarea implicita a vietii unui caracter.*/
    public static final float DEFAULT_SPEED         = 3.0f; /*!< Viteza implicita a unu caracter.*/
    public static final int DEFAULT_CREATURE_WIDTH  = 96;   /*!< Latimea implicita a imaginii caracterului.*/
    public static final int DEFAULT_CREATURE_HEIGHT = 96;   /*!< Inaltimea implicita a imaginii caracterului.*/

    protected CollisionRectangles bounds;
    //protected Animation animation;

    //protected BufferedImage[][] image;

    protected int life;     /*!< Retine viata caracterului.*/
    protected float speed;  /*!< Retine viteza de deplasare caracterului.*/
    protected float xMove;  /*!< Retine noua pozitie a caracterului pe axa X.*/
    protected float yMove;  /*!< Retine noua pozitie a caracterului pe axa Y.*/

    /*! \fn public Character(RefLinks refLink, float x, float y, int width, int height)
        \brief Constructor de initializare al clasei Character

        \param refLink Referinta catre obiectul shortcut (care retine alte referinte utile/necesare in joc).
        \param x Pozitia de start pa axa X a caracterului.
        \param y Pozitia de start pa axa Y a caracterului.
        \param width Latimea imaginii caracterului.
        \param height Inaltimea imaginii caracterului.
     */
    public Character(RefLinks refLink, float x, float y, int width, int height)
    {
            ///Apel constructor la clasei de baza
        super(refLink, x,y, width, height);
            //Seteaza pe valorile implicite pentru viata, viteza si distantele de deplasare
        bounds=new CollisionRectangles(this);
        //animation=new Animation(this);
        life    = DEFAULT_LIFE;
        speed   = DEFAULT_SPEED;
    }

    @Override
    public void Update()
    {
        this.characterMovement.WalkingUpdate();
        this.characterMovement.GravityUpdate();
        animation.Update();
        bounds.Update();
    }


    /*! \fn public int GetLife()
        \brief Returneaza viata caracterului.
     */
    public int GetLife()
    {
        return life;
    }

    /*! \fn public int GetSpeed()
        \brief Returneaza viteza caracterului.
     */
    public float GetSpeed()
    {
        return speed;
    }

    /*! \fn public void SetLife(int life)
        \brief Seteaza viata caracterului.
     */
    public void SetLife(int life)
    {
        this.life = life;
    }

    /*! \fn public void SetSpeed(float speed)
        \brief
     */
    public void SetSpeed(float speed) {
        this.speed = speed;
    }

    /*! \fn public float GetXMove()
        \brief Returneaza distanta in pixeli pe axa X cu care este actualizata pozitia caracterului.
     */
    public float GetXMove()
    {
        return xMove;
    }

    /*! \fn public float GetYMove()
        \brief Returneaza distanta in pixeli pe axa Y cu care este actualizata pozitia caracterului.
     */
    public float GetYMove()
    {
        return yMove;
    }

    /*! \fn public void SetXMove(float xMove)
        \brief Seteaza distanta in pixeli pe axa X cu care va fi actualizata pozitia caracterului.
     */
    public void SetXMove(float xMove)
    {
        this.xMove = xMove;
    }

    /*! \fn public void SetYMove(float yMove)
        \brief Seteaza distanta in pixeli pe axa Y cu care va fi actualizata pozitia caracterului.
     */
    public void SetYMove(float yMove)
    {
        this.yMove = yMove;
    }

    public CollisionRectangles getCollisionBounds() {
        return this.bounds;
    }
}

