package game;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import org.lwjgl.input.Mouse;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Domination extends BasicGameState {

	public String mouse = "";
	
	public Domination(int state) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
		
		g.drawString(mouse, 100, 100);
		int i,j;
		for (i=0;i<10;i++)
		{
			g.drawRect((windows.WIDTH/9)*i,0,(windows.WIDTH/9)*i,windows.HEIGHT);
		}
		for (j=0;j<10;j++)
		{
			g.drawRect(0,(windows.HEIGHT/9)*j,windows.WIDTH,(windows.HEIGHT/9)*j);
		}
		
		Input input =gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		if(input.isMousePressed(0))
			{
				mouse = "Xpos= "+xpos + " Ypost = "+ypos;
				for(int a=0 ;a<10;a++)
				{
					for (int b=0; b<10;b++)
					{
						if (xpos>(windows.WIDTH/9)*a && xpos<(windows.WIDTH/9)*(a+1) && ypos>(windows.HEIGHT/9)*b && ypos<(windows.HEIGHT/9)*(b+1))
						{
							System.out.println(a);
							
							g.setColor(Color.yellow);
							g.fillRect((windows.WIDTH/9)*a,(windows.HEIGHT/9)*b, 210, 120);
							g.setColor(Color.white);
							
							System.out.println(b);
						}
					}
				}
			}
	
		
		/*
		int i,j;
		for (i=0;i<10;i++)
		{
			g.drawRect((windows.WIDTH/9)*i,0,(windows.WIDTH/9)*i,windows.HEIGHT);
		}
		for (j=0;j<10;j++)
		{
			g.drawRect(0,(windows.HEIGHT/9)*j,windows.WIDTH,(windows.HEIGHT/9)*j);
		}
		*/
		
		/*
		int i,j;
		
		// Joueur 1 en haut à gauche 
		for (i=0;i<10;i++)
		{
			g.drawLine((windows.WIDTH/27)*i,0,(windows.WIDTH/27)*i,windows.HEIGHT/3);
		}
		for (j=0;j<10;j++)
		{
			g.drawLine(0,(windows.HEIGHT/27)*j,windows.WIDTH/3,(windows.HEIGHT/27)*j);
		}
		
		
		//Joueur 2 en bas à gauche
		
		for (i=0;i<10;i++)
		{
			g.drawLine((windows.WIDTH/27)*i,windows.HEIGHT,(windows.WIDTH/27)*i,windows.HEIGHT*2/3);
		}
	
		for(j=0;i<10;i++)
		{
			g.drawLine(0,windows.HEIGHT,windows.WIDTH/3,windows.HEIGHT*2/3);
		}
		*/
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
