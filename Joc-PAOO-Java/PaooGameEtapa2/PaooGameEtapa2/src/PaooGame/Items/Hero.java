package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;

import PaooGame.Input.KeyManager;
import PaooGame.Mechanics.CharacterMovement;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;

import static PaooGame.Maps.Tiles.Tile.TILE_WIDTH;

/*! \class public class Hero extends Character
    \brief Implementeaza notiunea de erou/player (caracterul controlat de jucator).

    Elementele suplimentare pe care le aduce fata de clasa de baza sunt:
        imaginea (acest atribut poate fi ridicat si in clasa de baza)
        deplasarea
        atacul (nu este implementat momentan)
        dreptunghiul de coliziune
 */
public class Hero extends Character
{
    private BufferedImage image;    /*!< Referinta catre imaginea curenta a eroului.*/

    /*! \fn public Hero(RefLinks refLink, float x, float y)
        \brief Constructorul de initializare al clasei Hero.

        \param refLink Referinta catre obiectul shortcut (obiect ce retine o serie de referinte din program).
        \param x Pozitia initiala pe axa X a eroului.
        \param y Pozitia initiala pe axa Y a eroului.
     */
    public Hero(RefLinks refLink, float x, float y)
    {
            ///Apel al constructorului clasei de baza
        super(refLink, x,y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);

        animation.setSpeed(2);
        animation.setImages(Assets.player);

    }

    /*! \fn public void Update()
        \brief Actualizeaza pozitia si imaginea eroului.
     */
    @Override
    public void Update()
    {
            ///Verifica daca a fost apasata o tasta
        GetInput();
        super.Update();

    }

    /*! \fn private void GetInput()
        \brief Verifica daca a fost apasata o tasta din cele stabilite pentru controlul eroului.
     */
    private void GetInput()
    {
            ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        this.characterMovement.setVelocityx(0);
        this.characterMovement.setSpeedx(speed);

            ///Verificare apasare tasta "sus"
        if(refLink.GetKeyManager().up && !characterMovement.isJumping())
        {
            characterMovement.setSpeedy(20.0f);
            characterMovement.setJumping(true);
            this.characterMovement.setVelocityy(-1);
        }
            ///Verificare apasare tasta "jos"
        if(refLink.GetKeyManager().down)
        {
            this.characterMovement.setVelocityy(1);
            characterMovement.setSpeedy(7.0f);

        }
            ///Verificare apasare tasta "left"
        if(refLink.GetKeyManager().left)
        {
            this.characterMovement.setVelocityx(-1);
            this.characterMovement.setSpeedx(7.0f);

        }
            ///Verificare apasare tasta "dreapta"
        if(refLink.GetKeyManager().right) {
            this.characterMovement.setVelocityx(1);
            this.characterMovement.setSpeedx(7.0f);
        }
        if(refLink.GetKeyManager().getReleasedKey()!=null)
        {
            if(refLink.GetKeyManager().left)
            {
                characterMovement.setSpeedx(0);
                characterMovement.setVelocityx(0);

            }
            if(refLink.GetKeyManager().right)
            {
                characterMovement.setSpeedx(0);
                characterMovement.setVelocityx(0);
            }
        }
    }

    /*! \fn public void Draw(Graphics g)
        \brief Randeaza/deseneaza eroul in noua pozitie.

        \brief g Contextul grafi in care trebuie efectuata desenarea eroului.
     */
    @Override
    public void Draw(Graphics g)
    {

        this.bounds.Draw(g);
        animation.Draw(g);
    }
}
