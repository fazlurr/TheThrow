package thethrow;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
/**
 *
 * @author fazzman
 */
public class TheThrow extends BasicGame {
    
    public static int gameWidth = 500;
    public static int gameHeight = 750;
    boolean gamestate = true;
    
    Image land = null;
    Player player;
    KoruptorTeri teri;
    Sendal sendal = null;
    
    float x = 180;
    float y = 680;
    
    float sendalX = 0;
    float sendalY = 0;
    
    float ex = 200;
    float ey = 200;
    
    public TheThrow()
    {
    	super("The Throw");
    }
    
    @Override
    public void init(GameContainer gc) throws SlickException
    {
    	land = new Image("data/BGI/land.png");
        player = new Player(x, y);
        teri = new KoruptorTeri(ex, ey);
        sendal = new Sendal(sendalX, sendalY);
    }
    
    @Override
    public void render(GameContainer gc, Graphics g) throws SlickException
    {
    	land.draw(0,0);
        player.draw();
        teri.draw();
        
        if ( sendal.fire )
        {
            sendal.draw();
        }
        
        if ( teri.hp <= 0)
        {
            g.drawString("YOU WIN", 220, 400);
        }
        
        g.drawString("Enemy HP : " + teri.hp + "/" + KoruptorTeri.HP, 20, 50);
    }
    
    @Override
    public void update(GameContainer gc, int delta) throws SlickException
    {
    	if (gamestate)
        {
            Input input = gc.getInput();
            
            teri.update();
            
            player.update(input);
            
            sendal.update(input, player.x, player.y);
            
            if ( teri.collide(sendal.x, sendal.y, sendal.x2, sendal.y2) ) 
            {
                sendal.gone();
                teri.hp -= sendal.power;
                gc.getGraphics().setColor( Color.red );
            }
            else
            {
                gc.getGraphics().setColor( Color.white );
            }
            
            if ( teri.hp <= 0)
            {
                teri.hp = 0;
                gamestate = false;
            }
            
        } 
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SlickException 
    {
        AppGameContainer app = new AppGameContainer(new TheThrow());
	app.setDisplayMode(gameWidth, gameHeight, false);
	app.start();
    }
}
