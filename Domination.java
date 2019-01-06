package game;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import org.lwjgl.input.Mouse;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Domination extends BasicGameState {

	String mouse = "";
	ArrayList<Integer> listx = new ArrayList<>();
	ArrayList<Integer> listy = new ArrayList<>();
	int i,j;
	int color = 0;
	int joueur = 1;
	
	
	public Domination(int state) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub

		Image castle = new Image("res/domination.jpg");
		
		
		
		
		
		for(int size=0;size<listx.size();size++)
		{
			for(int c=0 ;c<30;c++)
			{
				for (int d=0; d<30;d++)
				{
					if (listx.get(size)>(windows.WIDTH/27)*c && listx.get(size)<(windows.WIDTH/27)*(c+1) && listy.get(size)>(windows.HEIGHT/27)*d && listy.get(size)<(windows.HEIGHT/27)*(d+1))
					{
						g.setColor(Color.yellow);
						g.fillRect((windows.WIDTH/27)*c,(windows.HEIGHT/27)*(26-d), 213/3, 120/3);
						
					}
				}
			}
		}

		//g.drawString(mouse, 100, 100);
		

		Input input =gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();

			if(input.isMousePressed(0))
			{
				//mouse = "Xpos= "+xpos + " Ypost = "+ypos;
				if(joueur == 1 )
				{	
					if(xpos>0 && xpos<windows.WIDTH/3 && ypos<windows.HEIGHT/3 && ypos>0 )
					{
						System.out.println(xpos);
						System.out.println(ypos);
						System.out.println(windows.WIDTH/3);
						System.out.println(windows.HEIGHT);
						System.out.println(windows.HEIGHT*2/3);
						
						for(int a=0 ;a<30;a++)
						{
							for (int b=0; b<30;b++)
							{
								if (xpos>(windows.WIDTH/27)*a && xpos<(windows.WIDTH/27)*(a+1) && ypos>(windows.HEIGHT/27)*b && ypos<(windows.HEIGHT/27)*(b+1))
								{
									g.setColor(Color.yellow);
									g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
		
									listx.add(xpos);
									listy.add(ypos);
								}
							}
						}
						joueur = 2;
					}
				}
				if(joueur == 2 )
				{	
					if(xpos>windows.WIDTH*2/3 && xpos<windows.WIDTH && ypos<windows.HEIGHT && ypos>windows.HEIGHT*2/3 )
					{
						
						for(int a=0 ;a<30;a++)
						{
							for (int b=0; b<30;b++)
							{
								if (xpos>(windows.WIDTH/27)*a && xpos<(windows.WIDTH/27)*(a+1) && ypos>(windows.HEIGHT/27)*b && ypos<(windows.HEIGHT/27)*(b+1))
								{
									g.setColor(Color.yellow);
									g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
		
									listx.add(xpos);
									listy.add(ypos);
								}
							}
						}
						joueur = 3;
					}
				}
				if(joueur == 3 )
				{	
					if(xpos>0 && xpos<windows.WIDTH/3 && ypos<windows.HEIGHT && ypos>windows.HEIGHT*2/3 )
					{
						
						for(int a=0 ;a<30;a++)
						{
							for (int b=0; b<30;b++)
							{
								if (xpos>(windows.WIDTH/27)*a && xpos<(windows.WIDTH/27)*(a+1) && ypos>(windows.HEIGHT/27)*b && ypos<(windows.HEIGHT/27)*(b+1))
								{
									g.setColor(Color.yellow);
									g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
		
									listx.add(xpos);
									listy.add(ypos);
								}
							}
						}
						joueur = 4;
					}
				}
				if(joueur == 4 )
				{	
					if(xpos>windows.WIDTH*2/3 && xpos<windows.WIDTH && ypos<windows.HEIGHT/3 && ypos>0 )
					{
						
						for(int a=0 ;a<30;a++)
						{
							for (int b=0; b<30;b++)
							{
								if (xpos>(windows.WIDTH/27)*a && xpos<(windows.WIDTH/27)*(a+1) && ypos>(windows.HEIGHT/27)*b && ypos<(windows.HEIGHT/27)*(b+1))
								{
									g.setColor(Color.yellow);
									g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
		
									listx.add(xpos);
									listy.add(ypos);
								}
							}
						}
						joueur = 1;
					}
				}
			}
		
		
	
		

		
		g.setColor(Color.white);
		// Joueur 3 en haut à gauche 
		for (i=0;i<10;i++)
		{
			g.drawLine((windows.WIDTH/27)*i,0,(windows.WIDTH/27)*i,windows.HEIGHT/3);
		}
		for (j=0;j<10;j++)
		{
			g.drawLine(0,(windows.HEIGHT/27)*j,windows.WIDTH/3,(windows.HEIGHT/27)*j);
		}
		castle.draw(285, 160,213/3,40);
		g.drawString("Joueur 3 ", 15 , windows.HEIGHT/3 +10);
		
		
		//Joueur 1 en bas à gauche
		
		for (i=0;i<10;i++)
		{
			g.drawLine((windows.WIDTH/27)*i,windows.HEIGHT,(windows.WIDTH/27)*i,windows.HEIGHT*2/3);
		}
	
		for(j=0;j<10;j++)
		{
			g.drawLine(0, (windows.HEIGHT/27)*j+(windows.HEIGHT/27)*18, windows.WIDTH/3, (windows.HEIGHT/27)*j+(windows.HEIGHT/27)*18);
		}
		castle.draw(285, 880,213/3,40);
		g.drawString("Joueur 1 ", 15 , windows.HEIGHT*2/3 -25);
		
		//Joueur 2 en haut à droite
		
		for (i=0;i<10;i++)
		{
			g.drawLine((windows.WIDTH/27)*i+(windows.WIDTH/27)*18,0,(windows.WIDTH/27)*i+(windows.WIDTH/27)*18,windows.HEIGHT/3);

		}
	
		for(j=0;j<10;j++)
		{
			g.drawLine(windows.WIDTH*2/3,(windows.HEIGHT/27)*j,windows.WIDTH,(windows.HEIGHT/27)*j);
		}
		castle.draw(1563, 160,213/3,40);
		g.drawString("Joueur 2 ", windows.WIDTH-100 , windows.HEIGHT/3 +10);
		
		
		//Joueur 4 en bas à droite
		
		for (i=0;i<10;i++)
		{
			g.drawLine((windows.WIDTH/27)*i+(windows.WIDTH/27)*18,windows.HEIGHT,(windows.WIDTH/27)*i+(windows.WIDTH/27)*18,windows.HEIGHT*2/3);

		}
	
		for(j=0;j<10;j++)
		{
			g.drawLine(windows.WIDTH*2/3, (windows.HEIGHT/27)*j+(windows.HEIGHT/27)*18, windows.WIDTH, (windows.HEIGHT/27)*j+(windows.HEIGHT/27)*18);		
		}
		g.drawString("Joueur 4 ", windows.WIDTH -100 , windows.HEIGHT*2/3 -25);
		castle.draw(1563, 880,213/3,40);
		g.drawString("Tour du joueur :  "+joueur, windows.WIDTH/2 , windows.HEIGHT/2);
		
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
