package PaooGame.Graphics;

import PaooGame.Items.Item;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Animation {
    Item chr;

    private int direction=0;  //directia pe care s a oprit personajul -1->stanga 1->dreapta
    private int animationState;

    private int speed;      //Animation Speed
    private int frames;     //Animation frames

    private int index=0;       //Frame-ul curent
    private int count=0;        //Frame-ul ce urmeaza

    private BufferedImage[] images; //Vectorul de imagini
    private BufferedImage currentImg;  //Imaginea curenta, care va fi si cea desenata


    public Animation(Item chr)
    {
        this.chr=chr;
        frames=Assets.frames;
    }

    public void Draw(Graphics g)
    {
        if(direction<0)
        {
            g.drawImage(currentImg, (int)(chr.characterMovement.getPositionx() + chr.characterMovement.getWidth()), (int)chr.characterMovement.getPositiony(), -(int)chr.characterMovement.getWidth(), (int)chr.characterMovement.getHeight(), null);
        }
        else
        {
            g.drawImage(currentImg, (int)chr.characterMovement.getPositionx(), (int)chr.characterMovement.getPositiony(), (int)chr.characterMovement.getWidth(), (int)chr.characterMovement.getHeight(), null);
        }
    }

    public void Update()
    {
        index++;
        if(index>speed)
        {
            index=0;
            nextFrame();
        }

    }

    private void nextFrame()
    {
        if (chr.characterMovement.getVelocityx()>0)
        {
            direction=1;
            animationState=3;
        }
        else if (chr.characterMovement.getVelocityx()<0)
        {
            direction=-1;
            animationState=1;
        }

        for(int i=0;i<frames;i++)
        {
            if(count == i)
            {
                currentImg=images[i];
            }
        }

        if(images==Assets.player)//
        {//
            if(chr.characterMovement.getVelocityx()!=0)
                count++;
            else
            {
                count=0;
                if(images==Assets.player)//
                    currentImg=Assets.playerStanding;
            }
        }//
        else
            count++;

        if(count>frames)
        {
            count=0;
        }


    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setImages(BufferedImage[] chrImages) {
        this.images = chrImages;
    }
}
