/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thethrow;

import org.newdawn.slick.*;
/**
 *
 * @author GO
 */
class Weapon {
    // Needed Variables 
    protected float x,y,x2,y2;
    protected Integer power,speed,w,h;
    protected Image sprite = null;
    protected boolean fire = false;
    
    // Constructor
    public Weapon( float x, float y) throws SlickException
    {
        this.x = x;
        this.y = y;
    }
 
    // Rendering
    public void draw() throws SlickException 
    {
        sprite.draw(this.x, this.y);
    }
    
    public void update(Input input, float playerX, float playerY)
    {
        if( input.isKeyDown( Input.KEY_SPACE ) )
        {
            fire = true;
            sprite.setAlpha(1);
            x = playerX;
            y = playerY;
            x2 = x + w;
            y2 = y + h;
        }
        
        if ( y > 0 )
        {
            y -= speed;
            y2 -= speed;
        }
        
        if ( y < 0)
        {
            fire = false;
            sprite.setAlpha(0);
        }
    }
    
    public void gone()
    {
        y = 0;
        y2 = 0;
        sprite.setAlpha(0);
    }
    
}
