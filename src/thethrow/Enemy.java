/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thethrow;

import org.newdawn.slick.*;
import static thethrow.TheThrow.gameWidth;
import static thethrow.TheThrow.gameHeight;

/**
 *
 * @author GO
 */
class Enemy {
    // Needed Variables 
    protected float x,y,x2,y2;
    protected Integer speed,w,h,hp,currentHp;
    protected Image sprite = null;
    protected boolean moveLeft = true;
    protected boolean moveRight = false;
    // Constructor
    Enemy( float x, float y) throws SlickException
    {
        this.x = x;
        this.y = y;
    }
    
    public void draw()
    {
        sprite.draw(this.x, this.y);
    }
    
    public void update()
    {
        if( moveLeft )
        {
            x-= speed;
            x2-= speed;
            
            if( x <= 0)
            {
                moveLeft = false;
                moveRight = true;
            }
        }
        
        if ( moveRight )
        {
            x+= speed;
            x2+= speed;
            
            if( x2 >= gameWidth)
            {
                moveLeft = true;
                moveRight = false;
            }
        }
    }
    
    public boolean collide(float weaponX, float weaponY, float weaponX2, float weaponY2)
    {
        boolean isCollide = true;
        
        if( (weaponY2 < y) ){ isCollide = false; }
            
        if( (weaponX2 < x) ){ isCollide = false; }
            
        if( (weaponY > y2) ){ isCollide = false; }
            
        if( (weaponX > x2) ){ isCollide = false; }
        
        return isCollide;
    }
    
}