/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package thethrow;

import org.newdawn.slick.*;
import static thethrow.TheThrow.gameWidth;
import static thethrow.TheThrow.gameHeight;
import static thethrow.TheThrow.gameWidth;

/**
 *
 * @author GO
 */
class Player {
    
    protected float x,y,x2,y2;
    protected Integer speed,w,h,hp;
    protected Image sprite = null;
    
    public static Integer SPEED = 2;
    public static Integer HP = 100;
    public static String IMGPATH = "data/Sprite/player.png";
    
    Player( float x, float y) throws SlickException
    {
        this.x = x;
        this.y = y;
        this.speed = Player.SPEED;
        this.hp = Player.HP;
        this.sprite = new Image(Player.IMGPATH);
        this.w = this.sprite.getWidth();
        this.h = this.sprite.getHeight();
        this.x2 = this.x + this.w;
        this.y2 = this.y + this.h;
    }
    
    public void draw()
    {
        sprite.draw(this.x, this.y);
    }
    
    public void update(Input input)
    {
        // Player Control
        if( input.isKeyDown(Input.KEY_RIGHT) )
        {
            if( x2 <= gameWidth )
            {
                x+= speed;
                x2+= speed;
            }

        }
        if( input.isKeyDown(Input.KEY_LEFT) )
        {
            if( x >= 0 )
            {
                x-= speed;
                x2-= speed;
            }
        }
    }
}
