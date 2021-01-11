package PaooGame.Mechanics;

/*! \class CharacterMovement
    \brief Este responsabila cu tot ce tine de miscarea fiecarui caracter din joc.
 */

public class CharacterMovement {

    private PositionVector position;
    private PositionVector speed;
    private PositionVector velocity;
    private PositionVector widthHeight;

    private final float gravity = 0.05f;
    private final float maximumSpeed = 7.0f;
    private boolean isfalling = true;
    private boolean isjumping = true;

    public void setPositionx(float x){position.x=x;}
    public void setPositiony(float y){position.y=y;}
    public void setSpeedx(float x) { speed.x = x; }
    public void setSpeedy(float y) { speed.y = y; }
    public void setVelocityx(float x) { velocity.x = x; }
    public void setVelocityy(float y) { velocity.y = y; }

    public float getPositionx() { return position.x; }
    public float getPositiony() { return position.y; }
    public float getSpeedx() { return speed.x; };
    public float getSpeedy() { return speed.y; };
    public float getVelocityx() { return velocity.x; }
    public float getVelocityy() { return velocity.y; }

    public void setWidth(float x) { widthHeight.x = x; }
    public void setHeight(float y) { widthHeight.y = y; }
    public float getWidth() { return widthHeight.x; }
    public float getHeight() { return widthHeight.y; }

    public void setFalling(boolean falling) { this.isfalling = falling; }
    public void setJumping(boolean jumping) { this.isjumping = jumping; }
    public boolean isFalling() { return isfalling; }
    public boolean isJumping() { return isjumping; }

    public CharacterMovement()
    {
        position = new PositionVector(0.0f,0.0f);
        velocity = new PositionVector(0.0f, 0.0f);
        speed = new PositionVector(0.0f, 0.0f);
        widthHeight = new PositionVector(0.0f, 0.0f);
    }

    public CharacterMovement(float x, float y,float width,float height)
    {
        position = new PositionVector(x,y);
        velocity = new PositionVector(0.0f, 0.5f);
        speed = new PositionVector(0.0f, 5.0f);
        widthHeight=new PositionVector(width,height);
    }

    public void WalkingUpdate()
    {
        position.x += velocity.x * speed.x;
        position.y += velocity.y * speed.y;
    }

    public void GravityUpdate()
    {
        if(isfalling)
        {
            velocity.y += gravity;

            if(velocity.y > maximumSpeed)
                velocity.y = maximumSpeed;
        }
    }

}
