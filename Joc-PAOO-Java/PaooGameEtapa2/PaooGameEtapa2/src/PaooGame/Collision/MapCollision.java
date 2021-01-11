package PaooGame.Collision;
import PaooGame.Items.Character;
import PaooGame.Items.Coin;
import PaooGame.Maps.Map;
import PaooGame.Items.Item;

import java.util.LinkedList;
import java.util.List;

import java.awt.*;


public class MapCollision {
        Character chr;
        public static void Collision(Character chr, LinkedList<Rectangle> bounds, List<Coin> coins)
        {
            for(int i=0;i<coins.size();i++)
            {
                if(coins.get(i).getBoundaries().intersects(chr.getCollisionBounds().buttom))
                {
                    coins.remove(coins.get(i));
                    continue;
                }
                if(coins.get(i).getBoundaries().intersects(chr.getCollisionBounds().top))
                {
                    coins.remove(coins.get(i));
                    continue;
                }
                if(coins.get(i).getBoundaries().intersects(chr.getCollisionBounds().left))
                {
                    coins.remove(coins.get(i));
                    continue;
                }
                if(coins.get(i).getBoundaries().intersects(chr.getCollisionBounds().right))
                {
                    coins.remove(coins.get(i));
                    continue;
                }
            }


            for(Rectangle r:bounds) {
                if (chr.getCollisionBounds().buttom.intersects(r)) {
                    chr.characterMovement.setPositiony(r.y - chr.characterMovement.getHeight());
                    chr.characterMovement.setFalling(false);
                    chr.characterMovement.setJumping(false);
                    chr.characterMovement.setVelocityy(0);
                }
                else
                {
                    chr.characterMovement.setFalling(true);
                }
                if (chr.getCollisionBounds().top.intersects(r)) {
                    chr.characterMovement.setPositiony(r.y + r.height);
                }
                if(chr.getCollisionBounds().left.intersects(r)){
                    chr.characterMovement.setPositionx(r.x+r.width-20);
                }
                if(chr.getCollisionBounds().right.intersects(r)) {
                    chr.characterMovement.setPositionx(r.x - chr.characterMovement.getWidth() + 20);
                }

            }
        }

}
