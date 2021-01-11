package PaooGame.States;

import PaooGame.Collision.MapCollision;
import PaooGame.Factory.CoinsFactory;
import PaooGame.Graphics.Assets;
import PaooGame.Items.Coin;
import PaooGame.Items.Hero;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State
{
    private Hero hero;  /*!< Referinta catre obiectul animat erou (controlat de utilizator).*/
    private Map map;    /*!< Referinta catre harta curenta.*/

    private List<Coin> coins=new ArrayList<>();


    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink)
    {
            ///Apel al constructorului clasei de baza
        super(refLink);
            ///Construieste harta jocului
        map = new Map(refLink);
            ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
            ///Construieste eroul
        hero = new Hero(refLink,96,768 );
        //Construieste banutii
        //Am adaugat vectorul de monede ; coinType poate lua 2 valori: 1 pentru monede aurii, 2 pentru monede aramii
        for(int i=0;i<4;i++)
        {
            coins.add(CoinsFactory.getCoin(refLink, 250*i,768,50,50,1));// Creare Monede folosind Design Patternul Factory
        }
        coins.add(CoinsFactory.getCoin(refLink, 250,500,50,50,1));
        coins.add(CoinsFactory.getCoin(refLink, 700,350,50,50,2));
        coins.add(CoinsFactory.getCoin(refLink, 1700,300,50,50,1));
        coins.add(CoinsFactory.getCoin(refLink, 1800,300,50,50,2));
    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update()
    {
        map.Update();
        hero.Update();
        for(int i=0;i<coins.size();i++)
        {
            coins.get(i).Update();
        }
        MapCollision.Collision(hero,Map.tileBounds,coins);
    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g)
    {
        map.Draw(g);
        hero.Draw(g);
        for(int i=0;i<coins.size();i++)
        {
            if(coins.get(i)!=null)
                coins.get(i).Draw(g);
        }
    }

    public List<Coin> getListCoin()
    {
        return coins;
    }
}
