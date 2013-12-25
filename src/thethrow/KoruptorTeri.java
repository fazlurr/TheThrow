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
class KoruptorTeri extends Enemy {
    
    public static String IMGPATH = "data/Sprite/enemy.png";
    public static Integer SPEED = 1;
    public static Integer HP = 50;
    
    KoruptorTeri(float x, float y) throws SlickException
    {
        super(x, y);
        this.x = x;
        this.y = y;
        this.speed = KoruptorTeri.SPEED;
        this.hp = KoruptorTeri.HP;
        this.sprite = new Image(KoruptorTeri.IMGPATH);
        this.w = this.sprite.getWidth();
        this.h = this.sprite.getHeight();
        this.x2 = this.x + this.w;
        this.y2 = this.y + this.h;
    }
    
}
