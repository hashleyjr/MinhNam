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
import java.util.*;
public class Domination extends BasicGameState {

//	mINH nAM
	String mouse = "";
	ArrayList<Integer> listx = new ArrayList<>();
	ArrayList<Integer> listy = new ArrayList<>();
	ArrayList<String> couleur = new ArrayList<>();
	ArrayList<String> couronne = new ArrayList<>();

	ArrayList<ArrayList<Integer>>  coordinates = new ArrayList<>();
	int i,j;
	int color = 0;
	int joueur = 1;
	int tour = 0;
	int choisir=1;
	ArrayList<ArrayList<Integer>> possible = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possible2 = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possible3 = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possible4 = new ArrayList<>();

	
//	Hugo afficher dominos
	Color brown= new Color(126, 51, 0);
	int nbJoueur = 2;
	DominosTour DominosTour = new DominosTour();
//	liste avec les dominos de chaque tour
	ArrayList<ArrayList<ArrayList<ArrayList<String>>>> AllDominos = DominosTour.AllDominoTour(nbJoueur);
	int CompteurTour=1;
//	pour faire la liste des tours.
	ArrayList<Integer> compt1 = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7));
	ArrayList<Integer> compt2 = new ArrayList<>(Arrays.asList(8,9,10,11,12,13,14,15));
	ArrayList<Integer> compt3 = new ArrayList<>(Arrays.asList(16,17,18,19,20,21,22,23));
	ArrayList<Integer> compt4 = new ArrayList<>(Arrays.asList(24,25,26,27,28,29,30,31));
	ArrayList<Integer> compt5 = new ArrayList<>(Arrays.asList(32,33,34,35,36,37,38,39));
	ArrayList<Integer> compt6 = new ArrayList<>(Arrays.asList(40,41,42,43,44,45,46,47));

	ArrayList<ArrayList<Integer>> Listecompteur = new ArrayList<>(Arrays.asList(compt1,compt2,compt3,compt4,compt5,compt6));

//	Selectionner les dominos
	Joueur Joueur = new Joueur(mouse);
	public String mouseString = "Pas d'input";
	ArrayList<ArrayList<String>> ChoixJ1;
	ArrayList<ArrayList<String>> ChoixJ2;
	ArrayList<ArrayList<String>> ChoixJ3;
	ArrayList<ArrayList<String>> ChoixJ4;

	
	public Domination(int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		System.out.println("liste colour"+couleur);
		for(int size=0;size<listx.size();size++)
		{
			for(int c=0 ;c<30;c++)
			{
				for (int d=0; d<30;d++)
				{
					if (listx.get(size)>(windows.WIDTH/27)*c && listx.get(size)<(windows.WIDTH/27)*(c+1) && listy.get(size)>(windows.HEIGHT/27)*d && listy.get(size)<(windows.HEIGHT/27)*(d+1))
					{
						System.out.println("choix J1"+ChoixJ1);
						System.out.println("choix J2"+ChoixJ2);

						System.out.println("taille "+couleur.size());

						if(couleur.get(size).equals("Champs")) {
						g.setColor(Color.yellow);}
						else if(couleur.get(size).equals("Mer")) {
							g.setColor(Color.blue);}
						else if(couleur.get(size).equals("Mine")) {
							g.setColor(Color.gray);}
						else if(couleur.get(size).equals("Montagne")) {
							g.setColor(brown);}
						else if(couleur.get(size).equals("Foret")) {
							g.setColor(Color.green);}
						else if(couleur.get(size).equals("Prairie")) {
							g.setColor(Color.orange);
						}
						else {
							g.setColor(Color.pink);
						}
						
						g.fillRect((windows.WIDTH/27)*c,(windows.HEIGHT/27)*(26-d), 213/3, 120/3);
						
					}
				}
			}
		}
		int affich=8;
		if (compt1.contains(CompteurTour) ) {
			 affich=0;
		}
		if (compt2.contains(CompteurTour) ) {
			 affich=1;
		}if (compt3.contains(CompteurTour) ) {
			 affich=2;
		}if (compt4.contains(CompteurTour) ) {
			 affich=3;
		}if (compt5.contains(CompteurTour) ) {
			 affich=4;
		}if (compt6.contains(CompteurTour) ) {
			 affich=5;
		}
//			pour afficher les rectangles
			for(int k=0; k<4;k++) {
				String area1= ((AllDominos.get(affich)).get(k)).get(0).get(1);
				String couronne1= ((AllDominos.get(affich)).get(k)).get(0).get(0);
				String area2= ((AllDominos.get(affich)).get(k)).get(1).get(1);
				String couronne2=((AllDominos.get(affich)).get(k)).get(1).get(0);

//				afficher le 1er demi domino
				switch(area1) {
				case "Champs":
					g.setColor(Color.yellow);
					g.fillRect( 700, 500-100*k,100,30);

					break;
				case "Mer":
					g.setColor(Color.blue);
					g.fillRect( 700, 500-100*k,100,30);
					break;
				case "Foret":
					g.setColor(Color.green);
					g.fillRect( 700, 500-100*k,100,30);
					break;
				case "Mine":
					g.setColor(Color.gray);
					g.fillRect( 700, 500-100*k,100,30);
					break;
					
				case "Montagne":
					g.setColor(brown);
					g.fillRect( 700, 500-100*k,100,30);
					break;
				case "Prairie":
					g.setColor(Color.orange);
					g.fillRect( 700, 500-100*k,100,30);
					break;
				default:
				}
				
//				afficher le 2e demi domino
				switch(area2) {
				case "Champs":
					g.setColor(Color.yellow);
					g.fillRect( 800, 500-100*k,100,30);

					break;
				case "Mer":
					g.setColor(Color.blue);
					g.fillRect( 800, 500-100*k,100,30);
					break;
				case "Foret":
					g.setColor(Color.green);
					g.fillRect( 800, 500-100*k,100,30);
					break;
				case "Mine":
					g.setColor(Color.gray);
					g.fillRect( 800, 500-100*k,100,30);
					break;
					
				case "Montagne":
					g.setColor(brown);
					g.fillRect( 800, 500-100*k,100,30);
					break;
				case "Prairie":
					g.setColor(Color.orange);
					g.fillRect( 800, 500-100*k,100,30);
					break;
				default:
				}
				g.setColor(Color.white);
				
//				afficher les couronnes du 1er demi domino
				switch(couronne1) {
				case "1":
					g.fillOval(720,510-100*k , 10, 10);

					break;
				case "2":
					g.fillOval(720,510-100*k ,10, 10);
					g.fillOval(740,510-100*k , 10, 10);
					break;
				case "3":
					g.fillOval(720,510-100*k , 10, 10);
					g.fillOval(740,510-100*k , 10, 10);
					g.fillOval(760,510-100*k , 10, 10);
					break;
				default:
				
				}
				g.setColor(Color.white);
				
//				aficher les couronnes du 2e demi domino
				switch(couronne2) {
				case "1":
					g.fillOval(820,510-100*k , 10, 10);

					break;
				case "2":
					g.fillOval(820,510-100*k , 10, 10);
					g.fillOval(840,510-100*k , 10, 10);
					break;
				case "3":
					g.fillOval(820,510-100*k ,10, 10);
					g.fillOval(840,510-100*k , 10, 10);
					g.fillOval(860,510-100*k ,10, 10);
					break;
				default:
				
				}
			}
			for(int k=0; k<4;k++) {
				String area1= ((AllDominos.get(affich+1)).get(k)).get(0).get(1);
				String couronne1= ((AllDominos.get(affich+1)).get(k)).get(0).get(0);
				String area2= ((AllDominos.get(affich+1)).get(k)).get(1).get(1);
				String couronne2=((AllDominos.get(affich+1)).get(k)).get(1).get(0);

//				afficher le 1er demi domino
				switch(area1) {
				case "Champs":
					g.setColor(Color.yellow);
					g.fillRect( 950, 500-100*k,100,30);

					break;
				case "Mer":
					g.setColor(Color.blue);
					g.fillRect( 950, 500-100*k,100,30);
					break;
				case "Foret":
					g.setColor(Color.green);
					g.fillRect( 950, 500-100*k,100,30);
					break;
				case "Mine":
					g.setColor(Color.gray);
					g.fillRect( 950, 500-100*k,100,30);
					break;
					
				case "Montagne":
					g.setColor(brown);
					g.fillRect( 950, 500-100*k,100,30);
					break;
				case "Prairie":
					g.setColor(Color.orange);
					g.fillRect( 950, 500-100*k,100,30);
					break;
				default:
				}
				
//				afficher le 2e demi domino
				switch(area2) {
				case "Champs":
					g.setColor(Color.yellow);
					g.fillRect( 1050, 500-100*k,100,30);

					break;
				case "Mer":
					g.setColor(Color.blue);
					g.fillRect( 1050, 500-100*k,100,30);
					break;
				case "Foret":
					g.setColor(Color.green);
					g.fillRect( 1050, 500-100*k,100,30);
					break;
				case "Mine":
					g.setColor(Color.gray);
					g.fillRect( 1050, 500-100*k,100,30);
					break;
					
				case "Montagne":
					g.setColor(brown);
					g.fillRect( 1050, 500-100*k,100,30);
					break;
				case "Prairie":
					g.setColor(Color.orange);
					g.fillRect( 1050, 500-100*k,100,30);
					break;
				default:
				}
				
//				afficher les couronnes du 1er demi domino
				switch(couronne1) {
				case "1":
					g.setColor(Color.white);
					g.fillOval(970,510-100*k , 10, 10);

					break;
				case "2":
					g.setColor(Color.white);
					g.fillOval(970,510-100*k ,10, 10);
					g.fillOval(990,510-100*k , 10, 10);
					break;
				case "3":
					g.setColor(Color.white);
					g.fillOval(970,510-100*k , 10, 10);
					g.fillOval(990,510-100*k , 10, 10);
					g.fillOval(10100,510-100*k , 10, 10);
					break;
				default:
				
				}
				
//				aficher les couronnes du 2e demi domino
				switch(couronne2) {
				case "1":
					g.setColor(Color.white);
					g.fillOval(1070,510-100*k , 10, 10);

					break;
				case "2":
					g.setColor(Color.white);
					g.fillOval(1070,510-100*k , 10, 10);
					g.fillOval(1090,510-100*k , 10, 10);
					break;
				case "3":
					g.setColor(Color.white);
					g.fillOval(1070,510-100*k ,10, 10);
					g.fillOval(1090,510-100*k , 10, 10);
					g.fillOval(1110,510-100*k ,10, 10);
					break;
				default:
				
				}
			}
		
		Image castle = new Image("res/domination.jpg");
		

		//g.drawString(mouse, 100, 100);
		
		g.drawString(mouseString, 400, 40);

		Input input =gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		g.drawString("Choisir un dominos", 700, 100);
				System.out.println("TOur J1");
				if(joueur == 1 )
				{
					if(tour==0) {
					if(choisir==1) {

						if(input.isMousePressed(0)) {

							if(xpos>700 && xpos<900 &&ypos<880 && ypos>830) {
								ChoixJ1 = Joueur.Choix(3, affich, AllDominos);
								choisir=0;
								System.out.println("sominos 4"+ChoixJ1);
								
							}
						
							else if(xpos>700 && xpos<900 &&ypos<780 && ypos>730) {
								ChoixJ1 = Joueur.Choix(2, affich, AllDominos);
								choisir=0;
								System.out.println("sominos 3"+ChoixJ1);

							
						}			
						
							else if(xpos>700 && xpos<900 &&ypos<680 && ypos>630) {
								ChoixJ1 = Joueur.Choix(1, affich, AllDominos);
								choisir=0;
								System.out.println("sominos 2"+ChoixJ1);

							}
									
							else if(xpos>700 && xpos<900 &&ypos<580 && ypos>530) {
								ChoixJ1 = Joueur.Choix( 0, affich, AllDominos);
								choisir=0;
								System.out.println("Dominos 1"+ChoixJ1);
							}
							else {
								System.out.println("rieeeeeeeeeen");
							}
						
					}}}
					if(input.isMousePressed(0)) {

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
									
									System.out.println("point : "+point);
									System.out.println("possible : "+possible);
										if(!coordinates.contains(point) )
										{
											if(coordinates.size()==0 && possible.contains(point))
											{

//												Domino sélectionné
												String area1= ((ChoixJ1.get(0)).get(1));
												String couronne1= ((ChoixJ1.get(0)).get(0));
												String area2= ((ChoixJ1.get(1)).get(1));
												String couronne2=((ChoixJ1.get(1)).get(0));
												System.out.println("dominos J1"+ area1 + ""+couronne1+area2+couronne2);
												//
												if(tour==0) {
												
												couleur.add(area1);
												System.out.println("area1 "+ area1);
												}
												else if(tour==1) {
													
													couleur.add(area2);
													}
												
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
												
												//Domino sélectionné
												String area1= ((ChoixJ1.get(0)).get(1));
												String couronne1= ((ChoixJ1.get(0)).get(0));
												String area2= ((ChoixJ1.get(1)).get(1));
												String couronne2=((ChoixJ1.get(1)).get(0));
												System.out.println("dominos J1"+ area1 + ""+couronne1+area2+couronne2);
												System.out.println("tour "+ tour);
												//
												if(tour==0) {
												
												couleur.add(area1);
												}
												else if(tour==1) {
													
													couleur.add(area2);
													}

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
												CompteurTour++;

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
							choisir=1;
							ChoixJ1.remove(0);
							ChoixJ1.remove(0);
						}
				}}
				System.out.println("TOur J2");
				System.out.println("  ");

				if(joueur == 2 )
				{	
					System.out.println("joueur2"+ChoixJ1);
					System.out.println("tour : "+tour);
					System.out.println("choisir : "+choisir);

					if(tour==0) {
						if(choisir==1) {

							if(input.isMousePressed(0)) {

								if(xpos>700 && xpos<900 &&ypos<880 && ypos>830) {
									ChoixJ1 = Joueur.Choix(3, affich, AllDominos);
									choisir=0;
									System.out.println("4");
									System.out.println("joueur2      1"+ChoixJ2);
									
								}
							
								else if(xpos>700 && xpos<900 &&ypos<780 && ypos>730) {
									ChoixJ1 = Joueur.Choix(2, affich, AllDominos);
									choisir=0;
									System.out.println("3");

									System.out.println("joueur2        2"+ChoixJ1);

								
							}			
							
								else if(xpos>700 && xpos<900 &&ypos<680 && ypos>630) {
									ChoixJ1 = Joueur.Choix(1, affich, AllDominos);
									choisir=0;
									System.out.println("2");

									System.out.println("joueur2"+ChoixJ1);

								}
										
								else if(xpos>700 && xpos<900 &&ypos<580 && ypos>530) {
									ChoixJ1 = Joueur.Choix( 0, affich, AllDominos);
									choisir=0;
									System.out.println("joueur2"+ChoixJ1);

									System.out.println("Dominos 1"+ChoixJ1);
								}
							
						}}}
						if(input.isMousePressed(0)) {
					if(xpos>windows.WIDTH*2/3 && xpos<windows.WIDTH && ypos<windows.HEIGHT && ypos>windows.HEIGHT*2/3 )
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
									
									
									
									if(!coordinates.contains(point) )
									{
										if(coordinates.size()==0 && possible2.contains(point))
										{
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											
											//Domino sélectionné
											String area1= ((ChoixJ1.get(0)).get(1));
											String couronne1= ((ChoixJ1.get(0)).get(0));
											String area2= ((ChoixJ1.get(1)).get(1));
											String couronne2=((ChoixJ1.get(1)).get(0));
											System.out.println("dominos"+ area1 + ""+couronne1+area2+couronne2);
											System.out.println("tour "+ tour);
											System.out.println("joueur2"+ChoixJ2);
											//
											if(tour==0) {
											
											couleur.add(area1);
											}
											else if(tour==1) {
												
												couleur.add(area2);
												}
											
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
											
											
											coordinates.add(point);
											possible2.remove(point);
											tour++;
											System.out.println("possible:  "+possible);

											System.out.println("point : "+point);
											System.out.println("coordinates:  "+coordinates);
										}
										else if(possible2.contains(point))
										{
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											//Domino sélectionné
											String area1= ((ChoixJ1.get(0)).get(1));
											String couronne1= ((ChoixJ1.get(0)).get(0));
											String area2= ((ChoixJ1.get(1)).get(1));
											String couronne2=((ChoixJ1.get(1)).get(0));
											System.out.println("dominos"+ area1 + ""+couronne1+area2+couronne2);
											System.out.println("tour "+ tour);
											System.out.println("joueur2"+ChoixJ2);

											//
											if(tour==0) {
											couleur.add(area1);
											}
											else if(tour==1) {
												couleur.add(area2);

												}
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
											coordinates.add(point);
											possible2.remove(point);
											tour++;
											CompteurTour++;

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
						choisir=1;
						ChoixJ1.remove(0);
						ChoixJ1.remove(0);
					

					}
				}}
				if(joueur == 3 )
				{	
					if(tour==0) {
						if(choisir==1) {

							if(input.isMousePressed(0)) {

								if(xpos>700 && xpos<900 &&ypos<880 && ypos>830) {
									ChoixJ1 = Joueur.Choix(3, affich, AllDominos);
									choisir=0;
									System.out.println("sominos 4"+ChoixJ1);
									
								}
							
								else if(xpos>700 && xpos<900 &&ypos<780 && ypos>730) {
									ChoixJ1 = Joueur.Choix(2, affich, AllDominos);
									choisir=0;
									System.out.println("sominos 3"+ChoixJ1);

								
							}			
							
								else if(xpos>700 && xpos<900 &&ypos<680 && ypos>630) {
									ChoixJ1 = Joueur.Choix(1, affich, AllDominos);
									choisir=0;
									System.out.println("sominos 2"+ChoixJ1);

								}
										
								else if(xpos>700 && xpos<900 &&ypos<580 && ypos>530) {
									ChoixJ1 = Joueur.Choix( 0, affich, AllDominos);
									choisir=0;
									System.out.println("Dominos 1"+ChoixJ1);
								}
								else {
									System.out.println("rieeeeeeeeeen");
								}
							
						}}}
						if(input.isMousePressed(0)) {
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
									
									
									if(!coordinates.contains(point) )
									{
										if(coordinates.size()==0 && possible3.contains(point))
										{
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											
											//Domino sélectionné
											String area1= ((ChoixJ1.get(0)).get(1));
											String couronne1= ((ChoixJ1.get(0)).get(0));
											String area2= ((ChoixJ1.get(1)).get(1));
											String couronne2=((ChoixJ1.get(1)).get(0));
											System.out.println("dominos"+ area1 + ""+couronne1+area2+couronne2);
											System.out.println("tour "+ tour);
											//
											if(tour==0) {
											
											couleur.add(area1);
											System.out.println("area1 "+ area1);
											}
											else if(tour==1) {
												
												couleur.add(area2);
												}

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
											
											
											coordinates.add(point);
											possible3.remove(point);
											tour++;
											System.out.println("possible:  "+possible);

											System.out.println("point : "+point);
											System.out.println("coordinates:  "+coordinates);
										}
										else if(possible3.contains(point))
										{
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											//Domino sélectionné
											String area1= ((ChoixJ1.get(0)).get(1));
											String couronne1= ((ChoixJ1.get(0)).get(0));
											String area2= ((ChoixJ1.get(1)).get(1));
											String couronne2=((ChoixJ1.get(1)).get(0));
											System.out.println("dominos"+ area1 + ""+couronne1+area2+couronne2);
											System.out.println("tour "+ tour);
											//
											if(tour==0) {
											
											couleur.add(area1);
											System.out.println("area1 "+ area1);
											}
											else if(tour==1) {
												
												couleur.add(area2);
												}

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
											coordinates.add(point);
											possible3.remove(point);
											tour++;
											CompteurTour++;
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
						choisir=1;
						ChoixJ1.remove(0);
						ChoixJ1.remove(0);
					}
				}
				}
				if(joueur == 4 )
				{	
					if(tour==0) {
						if(choisir==1) {

							if(input.isMousePressed(0)) {

								if(xpos>700 && xpos<900 &&ypos<880 && ypos>830) {
									ChoixJ1 = Joueur.Choix(3, affich, AllDominos);
									choisir=0;
									System.out.println("sominos 4"+ChoixJ1);
									
								}
							
								else if(xpos>700 && xpos<900 &&ypos<780 && ypos>730) {
									ChoixJ1 = Joueur.Choix(2, affich, AllDominos);
									choisir=0;
									System.out.println("sominos 3"+ChoixJ1);

								
							}			
							
								else if(xpos>700 && xpos<900 &&ypos<680 && ypos>630) {
									ChoixJ1 = Joueur.Choix(1, affich, AllDominos);
									choisir=0;
									System.out.println("sominos 2"+ChoixJ1);

								}
										
								else if(xpos>700 && xpos<900 &&ypos<580 && ypos>530) {
									ChoixJ1 = Joueur.Choix( 0, affich, AllDominos);
									choisir=0;
									System.out.println("Dominos 1"+ChoixJ1);
								}
								else {
									System.out.println("rieeeeeeeeeen");
								}
							
						}}}
						if(input.isMousePressed(0)) {
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
									
									
									if(!coordinates.contains(point) )
									{
										if(coordinates.size()==0 && possible4.contains(point))
										{
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											//Domino sélectionné
											String J4area1= ((ChoixJ1.get(0)).get(1));
											String J4couronne1= ((ChoixJ1.get(0)).get(0));
											String J4area2= ((ChoixJ1.get(1)).get(1));
											String J4couronne2=((ChoixJ1.get(1)).get(0));
											System.out.println("dominos"+ J4area1 + ""+J4couronne1+J4area2+J4couronne2);
											System.out.println("tour "+ tour);
											//Domino sélectionné
											String area1= ((ChoixJ1.get(0)).get(1));
											String couronne1= ((ChoixJ1.get(0)).get(0));
											String area2= ((ChoixJ1.get(1)).get(1));
											String couronne2=((ChoixJ1.get(1)).get(0));
											System.out.println("dominos"+ area1 + ""+couronne1+area2+couronne2);
											System.out.println("tour "+ tour);
											//
											if(tour==0) {
											
											couleur.add(area1);
											System.out.println("area1 "+ area1);
											}
											else if(tour==1) {
												
												couleur.add(area2);
												}
											
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
											
											
											coordinates.add(point);
											possible4.remove(point);
											tour++;
											System.out.println("possible:  "+possible);

											System.out.println("point : "+point);
											System.out.println("coordinates:  "+coordinates);
										}
										else if(possible4.contains(point))
										{
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											//Domino sélectionné
											String area1= ((ChoixJ1.get(0)).get(1));
											String couronne1= ((ChoixJ1.get(0)).get(0));
											String area2= ((ChoixJ1.get(1)).get(1));
											String couronne2=((ChoixJ1.get(1)).get(0));
											System.out.println("dominos"+ area1 + ""+couronne1+area2+couronne2);
											System.out.println("tour "+ tour);
											//
											if(tour==0) {
											
											couleur.add(area1);
											System.out.println("area1 "+ area1);
											}
											else if(tour==1) {
												
												couleur.add(area2);
												}

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
											coordinates.add(point);
											possible4.remove(point);
											tour++;
											CompteurTour++;
											System.out.println("compteur : "+CompteurTour);

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
					choisir=1;
					ChoixJ1.remove(0);
					ChoixJ1.remove(0);
				}
			}}
			
			
	

		
		
	
		

		
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
