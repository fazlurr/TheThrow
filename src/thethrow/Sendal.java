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
class Sendal extends Weapon {
    
    public static String IMGPATH = "data/Sprite/sendal1.png";
    public static Integer SPEED = 2;
    public static Integer POWER = 5;
    
    public Sendal(float x, float y) throws SlickException
    {
        super(x, y);
        this.x = x;
        this.y = y;
        this.power = Sendal.POWER;
        this.speed = Sendal.SPEED;
        this.sprite = new Image(Sendal.IMGPATH);
        this.w = this.sprite.getWidth();
        this.h = this.sprite.getHeight();
        this.x2 = this.x + this.w;
        this.y2 = this.y + this.h;
    }
    
}
