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
	int joueur = 2;
	int tour = 0;

	ArrayList<ArrayList<Integer>> possible = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possible2 = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possible3 = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possible4 = new ArrayList<>();
	
	ArrayList<ArrayList<Integer>> possibledeux = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possibledeux2 = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possibledeux3 = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possibledeux4 = new ArrayList<>();
	
	ArrayList<Integer> interdit = new ArrayList<>();
	
	int demi = 1;

	
	
	
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
									System.out.println("ypos"+ypos);
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
									System.out.println("possible:  "+possible);

									System.out.println("coordinates:  "+coordinates);
									System.out.println("possibledeux:   " + possibledeux);
									System.out.println("demi  "+ demi);
									System.out.println("interdit"+interdit);
									System.out.println("size"+interdit.size());
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
												
												possibledeux.add(droite);
												possibledeux.add(gauche);
												possibledeux.add(haut);
												possibledeux.add(bas);
												

												interdit.add((windows.WIDTH/27)*a+(71*5));
												interdit.add((windows.WIDTH/27)*a-(71*5));
												interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
												interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
											
												
												
												coordinates.add(point);
												possible.remove(point);
												tour++;
												demi++;
												
											}
											else if((demi == 1 && possible.contains(point)) && (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))))
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
												
												possibledeux.add(droite);
												possibledeux.add(gauche);
												possibledeux.add(haut);
												possibledeux.add(bas);
												
												
												
												interdit.add((windows.WIDTH/27)*a+(71*5));
												interdit.add((windows.WIDTH/27)*a-(71*5));
												interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
												interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
												
												
												coordinates.add(point);
												possible.remove(point);
												demi++;
												tour++;
												
											}
											else if(demi == 2 && possibledeux.contains(point) && possible.contains(point) && (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))) )
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
												
												
												interdit.add((windows.WIDTH/27)*a+(71*5));
												interdit.add((windows.WIDTH/27)*a-(71*5));
												interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
												interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
												
												
												possible.add(droite);
												possible.add(gauche);
												possible.add(haut);
												possible.add(bas);
												
												possibledeux.clear();
												
												coordinates.add(point);
												possible.remove(point);
												tour++;
												demi = 1;
												
											}
										}
								}
							}
						}
					}
					if(tour ==2)
					{
						joueur =1;
						tour =0;
						
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
									System.out.println("ypos"+ypos);
									ArrayList<Integer> point = new ArrayList<>();
									point.add((windows.WIDTH/27)*a);
									point.add(((windows.HEIGHT/27)*(26-b)));
									
									ArrayList<Integer> departdroite = new ArrayList<>();
									departdroite.add(1562+71);
									departdroite.add(160);
									ArrayList<Integer> departgauche = new ArrayList<>();
									departgauche.add(1562-71);
									departgauche.add(160);
									ArrayList<Integer> departhaut = new ArrayList<>();
									departhaut.add(1562);
									departhaut.add(200);
									ArrayList<Integer> departbas = new ArrayList<>();
									departbas.add(1562);
									departbas.add(120);
									
									possible2.add(departdroite);
									possible2.add(departgauche);
									possible2.add(departhaut);
									possible2.add(departbas);
									
									
									g.setColor(Color.yellow);
									if(!coordinates.contains(point) )
									{
										if(coordinates.size()==0 && possible2.contains(point))
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
											
											
											
											possible2.add(droite);
											possible2.add(gauche);
											possible2.add(haut);
											possible2.add(bas);
											
											possibledeux2.add(droite);
											possibledeux2.add(gauche);
											possibledeux2.add(haut);
											possibledeux2.add(bas);
											
											interdit.add((windows.WIDTH/27)*a+(71*5));
											interdit.add((windows.WIDTH/27)*a-(71*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
											
											
											coordinates.add(point);
											possible2.remove(point);
											tour++;
											demi++;
											
										}
										else if(demi == 1 && possible2.contains(point)&& (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))))
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
											
											possible2.add(droite);
											possible2.add(gauche);
											possible2.add(haut);
											possible2.add(bas);
											
											possibledeux2.add(droite);
											possibledeux2.add(gauche);
											possibledeux2.add(haut);
											possibledeux2.add(bas);
											
											interdit.add((windows.WIDTH/27)*a+(71*5));
											interdit.add((windows.WIDTH/27)*a-(71*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
											
											coordinates.add(point);
											possible2.remove(point);
											demi++;
											tour++;
											
										}
										else if(demi == 2 && possibledeux2.contains(point) && possible2.contains(point)&& (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))) )
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
											
											possible2.add(droite);
											possible2.add(gauche);
											possible2.add(haut);
											possible2.add(bas);
											
											interdit.add((windows.WIDTH/27)*a+(71*5));
											interdit.add((windows.WIDTH/27)*a-(71*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
											
											possibledeux2.clear();
											
											coordinates.add(point);
											possible.remove(point);
											tour++;
											demi = 1;
										}
									}
								}
							}
						}
					}
					if(tour ==2)
					{
						joueur =2;
						tour =0;
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
									
									ArrayList<Integer> point = new ArrayList<>();
									point.add((windows.WIDTH/27)*a);
									point.add(((windows.HEIGHT/27)*(26-b)));
									
									ArrayList<Integer> departdroite = new ArrayList<>();
									departdroite.add(284+71);
									departdroite.add(160);
									ArrayList<Integer> departgauche = new ArrayList<>();
									departgauche.add(284-71);
									departgauche.add(160);
									ArrayList<Integer> departhaut = new ArrayList<>();
									departhaut.add(284);
									departhaut.add(200);
									ArrayList<Integer> departbas = new ArrayList<>();
									departbas.add(284);
									departbas.add(120);
									
									possible3.add(departdroite);
									possible3.add(departgauche);
									possible3.add(departhaut);
									possible3.add(departbas);
									
									g.setColor(Color.yellow);
									if(!coordinates.contains(point) )
									{
										if(coordinates.size()==0 && possible3.contains(point))
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
											
											
											
											possible3.add(droite);
											possible3.add(gauche);
											possible3.add(haut);
											possible3.add(bas);
											
											possibledeux3.add(droite);
											possibledeux3.add(gauche);
											possibledeux3.add(haut);
											possibledeux3.add(bas);
											
											interdit.add((windows.WIDTH/27)*a+(71*5));
											interdit.add((windows.WIDTH/27)*a-(71*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
											
											
											coordinates.add(point);
											possible3.remove(point);
											tour++;
											demi++;
											
										}
										else if(demi == 1 && possible3.contains(point) && (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))))
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
											
											possible3.add(droite);
											possible3.add(gauche);
											possible3.add(haut);
											possible3.add(bas);
											
											possibledeux3.add(droite);
											possibledeux3.add(gauche);
											possibledeux3.add(haut);
											possibledeux3.add(bas);
											
											interdit.add((windows.WIDTH/27)*a+(71*5));
											interdit.add((windows.WIDTH/27)*a-(71*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
											
											coordinates.add(point);
											possible.remove(point);
											demi++;
											tour++;
											
										}
										else if(demi == 2 && possibledeux3.contains(point) && possible3.contains(point)&& (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))) )
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
											
											possible3.add(droite);
											possible3.add(gauche);
											possible3.add(haut);
											possible3.add(bas);
											
											interdit.add((windows.WIDTH/27)*a+(71*5));
											interdit.add((windows.WIDTH/27)*a-(71*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
											
											possibledeux3.clear();
											
											coordinates.add(point);
											possible.remove(point);
											tour++;
											demi = 1;
										}
									}
								}
							}
						}
					}
					if(tour ==2)
					{
						joueur =3;
						tour =0;
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
									ArrayList<Integer> point = new ArrayList<>();
									point.add((windows.WIDTH/27)*a);
									point.add(((windows.HEIGHT/27)*(26-b)));
									
									ArrayList<Integer> departdroite = new ArrayList<>();
									departdroite.add(1562+71);
									departdroite.add(880);
									ArrayList<Integer> departgauche = new ArrayList<>();
									departgauche.add(1562-71);
									departgauche.add(880);
									ArrayList<Integer> departhaut = new ArrayList<>();
									departhaut.add(1562);
									departhaut.add(920);
									ArrayList<Integer> departbas = new ArrayList<>();
									departbas.add(1562);
									departbas.add(840);
									
									possible4.add(departdroite);
									possible4.add(departgauche);
									possible4.add(departhaut);
									possible4.add(departbas);
									g.setColor(Color.yellow);
									if(!coordinates.contains(point) )
									{
										if(coordinates.size()==0 && possible4.contains(point))
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
											
											
											
											possible4.add(droite);
											possible4.add(gauche);
											possible4.add(haut);
											possible4.add(bas);
											
											possibledeux4.add(droite);
											possibledeux4.add(gauche);
											possibledeux4.add(haut);
											possibledeux4.add(bas);
											
											interdit.add((windows.WIDTH/27)*a+(71*5));
											interdit.add((windows.WIDTH/27)*a-(71*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
											
											
											coordinates.add(point);
											possible.remove(point);
											tour++;
											demi++;
											
										}
										else if(demi == 1 && possible4.contains(point)&& (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))))
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
											
											possible4.add(droite);
											possible4.add(gauche);
											possible4.add(haut);
											possible4.add(bas);
											
											possibledeux4.add(droite);
											possibledeux4.add(gauche);
											possibledeux4.add(haut);
											possibledeux4.add(bas);
											
											interdit.add((windows.WIDTH/27)*a+(71*5));
											interdit.add((windows.WIDTH/27)*a-(71*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
											
											coordinates.add(point);
											possible.remove(point);
											demi++;
											tour++;
											
										}
										else if(demi == 2 && possibledeux4.contains(point) && possible4.contains(point) && (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))))
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
											
											possible4.add(droite);
											possible4.add(gauche);
											possible4.add(haut);
											possible4.add(bas);
											
											interdit.add((windows.WIDTH/27)*a+(71*5));
											interdit.add((windows.WIDTH/27)*a-(71*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
											
											possibledeux4.clear();
											
											coordinates.add(point);
											possible.remove(point);
											tour++;
											demi = 1;
										}
									}
								}
							}
						}
					}
				}
				if(tour ==2)
				{
					joueur =4;
					tour =0;
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
		castle.draw(1562, 160,213/3,40);
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
		castle.draw(1562, 880,213/3,40);
		g.drawString("Tour du joueur :  "+joueur, windows.WIDTH/2 , windows.HEIGHT/2);
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		

	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}


	
}
