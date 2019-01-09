package game;

import org.newdawn.slick.BasicGame;
import java.awt.geom.Point2D;
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
	ArrayList<ArrayList<Integer>>  coordinates = new ArrayList<>();
	int i,j;
	int color = 0;
	int joueur = 1;
	int tour = 0;
	ArrayList<ArrayList<Integer>> possible = new ArrayList<>();

	
	
	
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
						for(int a=0 ;a<30;a++)
						{
							for (int b=0; b<30;b++)
							{
								
								if (xpos>(windows.WIDTH/27)*a && xpos<(windows.WIDTH/27)*(a+1) && ypos>(windows.HEIGHT/27)*b && ypos<(windows.HEIGHT/27)*(b+1) )
								{
									ArrayList<Integer> point = new ArrayList<>();
									point.add((windows.WIDTH/27)*a);
									point.add(((windows.HEIGHT/27)*(26-b)));
									
									ArrayList<Integer> departdroite = new ArrayList<>();
									departdroite.add(284+71);
									departdroite.add(880);
									ArrayList<Integer> departgauche = new ArrayList<>();
									departgauche.add(284-71);
									departgauche.add(880);
									ArrayList<Integer> departhaut = new ArrayList<>();
									departhaut.add(284);
									departhaut.add(920);
									ArrayList<Integer> departbas = new ArrayList<>();
									departbas.add(284);
									departbas.add(840);
									
									possible.add(departdroite);
									possible.add(departgauche);
									possible.add(departhaut);
									possible.add(departbas);
									
									g.setColor(Color.yellow);
									System.out.println("point : "+point);
									System.out.println("possible : "+possible);
										if(!coordinates.contains(point) )
										{
											if(coordinates.size()==0 && possible.contains(point))
											{
												g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
												
												listx.add(xpos);
												listy.add(ypos);
												ArrayList<Integer> droite = new ArrayList<>();
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												ArrayList<Integer> gauche = new ArrayList<>();
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												ArrayList<Integer> haut = new ArrayList<>();
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												ArrayList<Integer> bas = new ArrayList<>();
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												
												
												possible.add(droite);
												possible.add(gauche);
												possible.add(haut);
												possible.add(bas);
												
												
												coordinates.add(point);
												possible.remove(point);
												tour++;
												System.out.println("possible:  "+possible);

												System.out.println("point : "+point);
												System.out.println("coordinates:  "+coordinates);
											}
											else if(possible.contains(point))
											{
												g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
												
												listx.add(xpos);
												listy.add(ypos);
												
												
												ArrayList<Integer> droite = new ArrayList<>();
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												ArrayList<Integer> gauche = new ArrayList<>();
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												ArrayList<Integer> haut = new ArrayList<>();
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												ArrayList<Integer> bas = new ArrayList<>();
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possible.add(droite);
												possible.add(gauche);
												possible.add(haut);
												possible.add(bas);
												coordinates.add(point);
												possible.remove(point);
												tour++;
											}
										}
								}
							}
						}
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
								if (xpos>(windows.WIDTH/27)*a && xpos<(windows.WIDTH/27)*(a+1) && ypos>(windows.HEIGHT/27)*b && ypos<(windows.HEIGHT/27)*(b+1) )
								{
									ArrayList<Integer> point2 = new ArrayList<>();
									point2.add((windows.WIDTH/27)*a);
									point2.add(((windows.HEIGHT/27)*(26-b)));
									g.setColor(Color.yellow);
									if(!coordinates.contains(point2))
									{
										g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
			
										listx.add(xpos);
										listy.add(ypos);
										coordinates.add(point2);
										tour++;
										if(tour == 2 )
										{
											joueur = 3;
											tour =0;
										}
									}
								}
							}
						}
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
									ArrayList<Integer> point3 = new ArrayList<>();
									point3.add((windows.WIDTH/27)*a);
									point3.add(((windows.HEIGHT/27)*(26-b)));
									g.setColor(Color.yellow);
									if(!coordinates.contains(point3))
									{
										g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
			
										listx.add(xpos);
										listy.add(ypos);
										coordinates.add(point3);
										tour++;
										if(tour == 2 )
										{
											joueur = 4;
											tour =0;
										}
									}
								}
							}
						}
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
									ArrayList<Integer> point4 = new ArrayList<>();
									point4.add((windows.WIDTH/27)*a);
									point4.add(((windows.HEIGHT/27)*(26-b)));
									g.setColor(Color.yellow);
									if(!coordinates.contains(point4))
									{
										g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
			
										listx.add(xpos);
										listy.add(ypos);
										coordinates.add(point4);
										tour++;
										if(tour == 2 )
										{
											joueur = 1;
											tour = 0;
										}
									}
								}
							}
						}
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
		castle.draw(284, 160,213/3,40);
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
		castle.draw(284, 880,213/3,40);
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
