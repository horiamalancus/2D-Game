package PaooGame.Collision;
import PaooGame.Items.Item;

import java.awt.*;
import java.util.concurrent.RecursiveAction;

public class CollisionRectangles {
        Item item;

        Rectangle top;
        Rectangle buttom;
        Rectangle left;
        Rectangle right;

        public CollisionRectangles(Item item)
        {
            this.item=item;

            top=new Rectangle();
            buttom=new Rectangle();
            left=new Rectangle();
            right=new Rectangle();
        }

        public void Draw(Graphics g)
        {
            /*g.setColor(Color.GREEN);
            g.drawRect(top.x,top.y,top.width,top.height);
            g.setColor(Color.RED);
            g.drawRect(buttom.x,buttom.y,buttom.width,buttom.height);
            g.setColor(Color.YELLOW);
            g.drawRect(left.x,left.y,left.width,left.height);
            g.setColor(Color.BLUE);
            g.drawRect(right.x,right.y,right.width,right.height);*/
        }

    public void Update()
    {
        top.x=(int)(item.characterMovement.getPositionx()+item.characterMovement.getWidth()/3.2);
        top.y=(int)(item.characterMovement.getPositiony());
        top.width = (int)(item.characterMovement.getWidth()/3.15);
        top.height = (int)(item.characterMovement.getHeight()/2);

        buttom.x = (int)(item.characterMovement.getPositionx() + item.characterMovement.getWidth()/3.13);
        buttom.y = (int)(item.characterMovement.getPositiony() + item.characterMovement.getHeight()/2);
        buttom.width = (int)(item.characterMovement.getWidth()/3.15);
        buttom.height = (int)(item.characterMovement.getHeight()/2);

        left.x = (int)(item.characterMovement.getPositionx() + item.characterMovement.getWidth()/4.8);
        left.y = (int)(item.characterMovement.getPositiony() + 10);
        left.width = (int)(item.characterMovement.getWidth()/4);
        left.height = (int)(item.characterMovement.getHeight() - 40);

        right.x = (int)(item.characterMovement.getPositionx() + item.characterMovement.getWidth()/2);
        right.y = (int)(item.characterMovement.getPositiony() + 10);
        right.width = (int)(item.characterMovement.getWidth()/4);
        right.height = (int)(item.characterMovement.getHeight() - 40);
    }

    public void Draw(Graphics2D g)
    {
        g.draw(top);
        g.draw(buttom);
        g.draw(left);
        g.draw(right);
    }

    /*! \fn public Rectangle getBoundsDown()
        \brief Returneaza o referinta catre dreptunghiul de coliziune din partea de jos.
     */
    public Rectangle getBoundsDown()
    {
        return buttom;
    }

    /*! \fn public Rectangle getBoundsTop()
       \brief Returneaza o referinta catre dreptunghiul de coliziune din partea de sus.
    */
    public Rectangle getBoundsTop()
    {
        return top;
    }

    /*! \fn public Rectangle getBoundsLeft()
       \brief Returneaza o referinta catre dreptunghiul de coliziune din partea din stanga.
    */
    public Rectangle getBoundsLeft()
    {
        return left;
    }

    /*! \fn public Rectangle getBoundsRight()
       \brief Returneaza o referinta catre dreptunghiul de coliziune din partea din dreapta.
    */
    public Rectangle getBoundsRight()
    {
        return right;
    }

}
