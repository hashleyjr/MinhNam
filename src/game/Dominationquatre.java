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
import java.util.*;
public class Dominationquatre extends BasicGameState {
	
	
//	mINH nAM
	String mouse = "";
	ArrayList<Integer> listx = new ArrayList<>();
	ArrayList<Integer> listy = new ArrayList<>();
	ArrayList<String> couleur = new ArrayList<>();
	ArrayList<String> couronne = new ArrayList<>();

	ArrayList<ArrayList<Integer>>  coordinates = new ArrayList<>();
	int i,j;
	int color = 0;
	

	int tour = 0;
	int choisir=1;
	ArrayList<ArrayList<Integer>> possible = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possible2 = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possible3 = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possible4 = new ArrayList<>();
	
	ArrayList<ArrayList<Integer>> possiblechamps = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possiblemer = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possiblemine = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possiblemontagne = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possibleforet = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possibleprairie = new ArrayList<>();
	

//	new Minh Nam
	
	ArrayList<ArrayList<Integer>> possibledeux = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possibledeux2 = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possibledeux3 = new ArrayList<>();
	ArrayList<ArrayList<Integer>> possibledeux4 = new ArrayList<>();
	
	ArrayList<Integer> interdit = new ArrayList<>();
	ArrayList<Integer> interdit2 = new ArrayList<>();
	ArrayList<Integer> interdit3 = new ArrayList<>();
	ArrayList<Integer> interdit4 = new ArrayList<>();
	
	int demi = 1;
	
//	Hugo afficher dominos
	Color brown= new Color(126, 51, 0);
	int nbJoueur = 4;
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
	ArrayList<Integer> compt7 = new ArrayList<>(Arrays.asList(48,49,50,51,52,53,54,55));
	ArrayList<Integer> compt8 = new ArrayList<>(Arrays.asList(56,57,58,59,60,61,62,63));
	ArrayList<Integer> compt9 = new ArrayList<>(Arrays.asList(64,65,66,67,68,69,70,71));
	ArrayList<Integer> compt10 = new ArrayList<>(Arrays.asList(72,73,74,75,76,77,78,79));
	ArrayList<Integer> compt11 = new ArrayList<>(Arrays.asList(80,81,82,83,84,85,86,87));
	

	ArrayList<ArrayList<Integer>> Listecompteur = new ArrayList<>(Arrays.asList(compt1,compt2,compt3,compt4,compt5,compt6));
//	ArrayList<Integer> OrdreJoueur= DominosTour.ordreRandom();
	ArrayList<Integer> OrdreJoueur=DominosTour.ordreRandom(4);
	ArrayList<Integer> NextOrdreJoueur= new ArrayList<Integer>(Arrays.asList(1,2,3,4));

	int joueur = OrdreJoueur.get(0);



//	Selectionner les dominos
	Joueur Joueur = new Joueur(mouse);
	public String mouseString = "Pas d'input";
//	pour selectionner 1 domino
	ArrayList<ArrayList<String>> ChoixJ1;
	

	
	public Dominationquatre(int state) {
	}

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {

		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
g.drawString(mouse, 100, 100);
		
		g.drawString(mouseString, 400, 40);

		Input input =gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();

		

		
//		a quel tour on en est ?
		int affich=8;
		if (compt1.contains(CompteurTour) ) {
			 affich=0;
		}else if (compt2.contains(CompteurTour) ) {
			 affich=1;
		}else if (compt3.contains(CompteurTour) ) {
			 affich=2;
		}else if (compt4.contains(CompteurTour) ) {
			 affich=3;
		}else if (compt5.contains(CompteurTour) ) {
			 affich=4;
		}else if (compt6.contains(CompteurTour) ) {
			 affich=5;
		}else if (compt7.contains(CompteurTour) ) {
			 affich=6;
		}else if (compt8.contains(CompteurTour) ) {
			 affich=7;
		}else if (compt9.contains(CompteurTour) ) {
			 affich=8;
		}else if (compt10.contains(CompteurTour) ) {
			 affich=9;
		}else if (compt11.contains(CompteurTour) ) {
			 affich=10;
		}
		else {
			affich=11;
		}

		if(affich==11) {
			g.setColor(Color.red);
			g.fillRect(0, 0, 2000, 1200);
			g.setColor(Color.white);
			g.drawString("gagnant joueur 3 avec 26 points", 850, 400);
		}
		
		for(int size=0;size<listx.size();size++)
		{
			for(int c=0 ;c<30;c++)
			{
				for (int d=0; d<30;d++)
				{
					if (listx.get(size)>(windows.WIDTH/27)*c && listx.get(size)<(windows.WIDTH/27)*(c+1) && listy.get(size)>(windows.HEIGHT/27)*d && listy.get(size)<(windows.HEIGHT/27)*(d+1))
					{

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
//						afficher les couronnes
						if(couronne.get(size).equals("1")) {
							g.setColor(Color.black);
							g.fillOval((listx.get(size)-20), (1080-listy.get(size)), 7, 7);
						}
						else if(couronne.get(size).equals("2")) {
							g.setColor(Color.black);
							g.fillOval((listx.get(size)-20), (1080-listy.get(size)), 7, 7);
							g.fillOval((listx.get(size)), (1080-listy.get(size)), 7, 7);
						}
						else if(couronne.get(size).equals("3")) {
							g.setColor(Color.black);
							g.fillOval((listx.get(size)-20), (1080-listy.get(size)), 7, 7);
							g.fillOval((listx.get(size)), (1080-listy.get(size)), 7, 7);
							g.fillOval((listx.get(size))+20, (1080-listy.get(size)), 7, 7);

						}
					}
				}
			}
		}

		
		if(affich!=11) {
//pour afficher les rectangles
			for(int k=0; k<4;k++) {
				String area1= ((AllDominos.get(affich)).get(k)).get(0).get(1);
				String couronne1= ((AllDominos.get(affich)).get(k)).get(0).get(0);
				String area2= ((AllDominos.get(affich)).get(k)).get(1).get(1);
				String couronne2=((AllDominos.get(affich)).get(k)).get(1).get(0);

//afficher le 1er demi domino et le deuxieme
				for(int demiDomino=0; demiDomino<2;demiDomino++) {
					String area="";
					if(demiDomino==0){
						area=area1;
					}
					if(demiDomino==1) {
						area=area2;
					}
					switch(area) {
					case "Champs":
						g.setColor(Color.yellow);
						g.fillRect( 700+100*demiDomino, 500-100*k,100,30);
						break;
					case "Mer":
						g.setColor(Color.blue);
						g.fillRect( 700+100*demiDomino, 500-100*k,100,30);
						break;
					case "Foret":
						g.setColor(Color.green);
						g.fillRect( 700+100*demiDomino, 500-100*k,100,30);
						break;
					case "Mine":
						g.setColor(Color.gray);
						g.fillRect( 700+100*demiDomino, 500-100*k,100,30);
						break;
						
					case "Montagne":
						g.setColor(brown);
						g.fillRect( 700+100*demiDomino, 500-100*k,100,30);
						break;
					case "Prairie":
						g.setColor(Color.orange);
						g.fillRect( 700+100*demiDomino, 500-100*k,100,30);
						break;
					default:
				}}
				
				g.setColor(Color.white);
				
//afficher les couronnes du 1er demi domino et le 2e
				for(int demidomino=0; demidomino<2;demidomino++) {
					String couronne="";
					if(demidomino==0){
						couronne=couronne1;
					}
					if(demidomino==1) {
						couronne=couronne2;
					}
					switch(couronne) {
						case "1":
							g.fillOval(720+demidomino*100,510-100*k , 10, 10);
		
							break;
						case "2":
							g.fillOval(720+demidomino*100,510-100*k ,10, 10);
							g.fillOval(740+demidomino*100,510-100*k , 10, 10);
							break;
						case "3":
							g.fillOval(720+demidomino*100,510-100*k , 10, 10);
							g.fillOval(740+demidomino*100,510-100*k , 10, 10);
							g.fillOval(760+demidomino*100,510-100*k , 10, 10);
							break;
						default:
				}}
				g.setColor(Color.white);
				
			}
			if(affich<11) {
			for(int k=0; k<4;k++) {
				String area1= ((AllDominos.get(affich+1)).get(k)).get(0).get(1);
				String couronne1= ((AllDominos.get(affich+1)).get(k)).get(0).get(0);
				String area2= ((AllDominos.get(affich+1)).get(k)).get(1).get(1);
				String couronne2=((AllDominos.get(affich+1)).get(k)).get(1).get(0);

//afficher le 1er demi domino et le 2e
				for(int demidomino=0; demidomino<2;demidomino++) {
					String area="";
					if(demidomino==0){
						area=area1;
					}
					if(demidomino==1) {
						area=area2;
					}
					switch(area) {
						case "Champs":
							g.setColor(Color.yellow);
							g.fillRect( 950+100*demidomino, 500-100*k,100,30);
		
							break;
						case "Mer":
							g.setColor(Color.blue);
							g.fillRect( 950+100*demidomino, 500-100*k,100,30);
							break;
						case "Foret":
							g.setColor(Color.green);
							g.fillRect( 950+100*demidomino, 500-100*k,100,30);
							break;
						case "Mine":
							g.setColor(Color.gray);
							g.fillRect( 950+100*demidomino, 500-100*k,100,30);
							break;
							
						case "Montagne":
							g.setColor(brown);
							g.fillRect( 950+100*demidomino, 500-100*k,100,30);
							break;
						case "Prairie":
							g.setColor(Color.orange);
							g.fillRect( 950+100*demidomino, 500-100*k,100,30);
							break;
						default:
				}}
				
//afficher les couronnes du 1er demi domino
				for(int demidomino=0; demidomino<2;demidomino++) {
					String couronne="";
					if(demidomino==0){
						couronne=couronne1;
					}
					if(demidomino==1) {
						couronne=couronne2;
					}
				switch(couronne) {
				case "1":
					g.setColor(Color.white);
					g.fillOval(970+100*demidomino,510-100*k , 10, 10);

					break;
				case "2":
					g.setColor(Color.white);
					g.fillOval(970+100*demidomino,510-100*k ,10, 10);
					g.fillOval(990+100*demidomino,510-100*k , 10, 10);
					break;
				case "3":
					g.setColor(Color.white);
					g.fillOval(970+100*demidomino,510-100*k , 10, 10);
					g.fillOval(990+100*demidomino,510-100*k , 10, 10);
					g.fillOval(10100+100*demidomino,510-100*k , 10, 10);
					break;
				default:
				
				}}
				
			}}}
		
		Image castle = new Image("res/domination.jpg");
		

		
		g.drawString("Choisir un dominos", 700, 100);
				if(joueur == 1 )
				{
					if(tour==0) {
					if(choisir==1) {

						if(input.isMousePressed(0)) {

							if(xpos>950 && xpos<1150 &&ypos<880 && ypos>830) {
								ChoixJ1 = Joueur.Choix(OrdreJoueur.indexOf(joueur), affich, AllDominos);
								choisir=0;
								NextOrdreJoueur.set(3,1);

								
							}
						
							else if(xpos>950 && xpos<1150 &&ypos<780 && ypos>730) {
								ChoixJ1 = Joueur.Choix(OrdreJoueur.indexOf(joueur), affich, AllDominos);
								choisir=0;
								NextOrdreJoueur.set(2,1);
							
						}			
						
							else if(xpos>950 && xpos<1150 &&ypos<680 && ypos>630) {
								ChoixJ1 = Joueur.Choix(OrdreJoueur.indexOf(joueur), affich, AllDominos);
								choisir=0;
								NextOrdreJoueur.set(1,1);
							}
									
							else if(xpos>950 && xpos<1150 &&ypos<580 && ypos>530) {
								ChoixJ1 = Joueur.Choix( OrdreJoueur.indexOf(joueur), affich, AllDominos);
								choisir=0;
								NextOrdreJoueur.set(0,1);
						}
							else {
								System.out.println("Rien");
							}
						
					}}}
					if(input.isMousePressed(0)) {
						if(xpos>800 && xpos<950 &&ypos<100 && ypos>40) {
							CompteurTour=CompteurTour+2;
							tour=2;
						}

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
									

									possiblechamps.add(departbas);
									possiblechamps.add(departgauche);
									possiblechamps.add(departhaut);
									possiblechamps.add(departdroite);
									

									possiblemer.add(departdroite);
									possiblemer.add(departgauche);
									possiblemer.add(departhaut);
									possiblemer.add(departbas);
									
									possiblemine.add(departdroite);
									possiblemine.add(departgauche);
									possiblemine.add(departhaut);
									possiblemine.add(departbas);
									
									possiblemontagne.add(departdroite);
									possiblemontagne.add(departgauche);
									possiblemontagne.add(departhaut);
									possiblemontagne.add(departbas);
									
									possibleforet.add(departdroite);
									possibleforet.add(departgauche);
									possibleforet.add(departhaut);
									possibleforet.add(departbas);
									
									possibleprairie.add(departdroite);
									possibleprairie.add(departgauche);
									possibleprairie.add(departhaut);
									possibleprairie.add(departbas);
									
//									System.out.println("champs   "+possiblechamps);
//									System.out.println("mine   "+possiblemine);
//									System.out.println("montagne   "+possiblemontagne);
//									System.out.println("mer   "+possiblemer);
									
									
									
										if(!coordinates.contains(point) )
										{
											String area1= ((ChoixJ1.get(0)).get(1));
											String couronne1= ((ChoixJ1.get(0)).get(0));
											String area2= ((ChoixJ1.get(1)).get(1));
											String couronne2=((ChoixJ1.get(1)).get(0));
											
											if(coordinates.size()==0 && possible.contains(point))
											{

//												Domino sélectionné
												
												g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
												listx.add(xpos);
												listy.add(ypos);
												ArrayList<Integer> droite = new ArrayList<>();
												ArrayList<Integer> gauche = new ArrayList<>();
												ArrayList<Integer> haut = new ArrayList<>();
												ArrayList<Integer> bas = new ArrayList<>();
												
												if(tour==0) {
													
													couleur.add(area1);
													couronne.add(couronne1);
												}
													else if(tour==1) {
														
														couleur.add(area2);
														couronne.add(couronne2);
														}
												
												

												interdit.add((windows.WIDTH/27)*a+(71*5));
												interdit.add((windows.WIDTH/27)*a-(71*5));
												interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
												interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
												
												if(area1.equals("Champs"))
												{
													
													droite.add((windows.WIDTH/27)*a+71);
													droite.add(((windows.HEIGHT/27)*(26-b)));
													gauche.add((windows.WIDTH/27)*a-71);
													gauche.add(((windows.HEIGHT/27)*(26-b)));
													haut.add((windows.WIDTH/27)*a);
													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													bas.add((windows.WIDTH/27)*a);
													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													possiblechamps.add(droite);
													possiblechamps.add(gauche);
													possiblechamps.add(haut);
													possiblechamps.add(bas);
													possiblechamps.remove(point);
													
													
												}
												else if(area1.equals("Mer"))
												{
													
													droite.add((windows.WIDTH/27)*a+71);
													droite.add(((windows.HEIGHT/27)*(26-b)));
													gauche.add((windows.WIDTH/27)*a-71);
													gauche.add(((windows.HEIGHT/27)*(26-b)));
													haut.add((windows.WIDTH/27)*a);
													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													bas.add((windows.WIDTH/27)*a);
													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													possiblemer.add(droite);
													possiblemer.add(gauche);
													possiblemer.add(haut);
													possiblemer.add(bas);
													possiblemer.remove(point);
													
												}
												else if(area1.equals("Mine"))
												{
													
													droite.add((windows.WIDTH/27)*a+71);
													droite.add(((windows.HEIGHT/27)*(26-b)));
													gauche.add((windows.WIDTH/27)*a-71);
													gauche.add(((windows.HEIGHT/27)*(26-b)));
													haut.add((windows.WIDTH/27)*a);
													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													bas.add((windows.WIDTH/27)*a);
													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													possiblemine.add(droite);
													possiblemine.add(gauche);
													possiblemine.add(haut);
													possiblemine.add(bas);
													
													
													possiblemine.remove(point);
													
												}
												else if(area1.equals("Montagne"))
												{
													
													droite.add((windows.WIDTH/27)*a+71);
													droite.add(((windows.HEIGHT/27)*(26-b)));
													gauche.add((windows.WIDTH/27)*a-71);
													gauche.add(((windows.HEIGHT/27)*(26-b)));
													haut.add((windows.WIDTH/27)*a);
													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													bas.add((windows.WIDTH/27)*a);
													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													possiblemontagne.add(droite);
													possiblemontagne.add(gauche);
													possiblemontagne.add(haut);
													possiblemontagne.add(bas);
													
													
													
													possiblemontagne.remove(point);
													
												}
												else if(area1.equals("Foret"))
												{
													
													droite.add((windows.WIDTH/27)*a+71);
													droite.add(((windows.HEIGHT/27)*(26-b)));
													gauche.add((windows.WIDTH/27)*a-71);
													gauche.add(((windows.HEIGHT/27)*(26-b)));
													haut.add((windows.WIDTH/27)*a);
													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													bas.add((windows.WIDTH/27)*a);
													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													possibleforet.add(droite);
													possibleforet.add(gauche);
													possibleforet.add(haut);
													possibleforet.add(bas);
													
													
													possibleforet.remove(point);
													
												}
												else if(area1.equals("Prairie"))
												{
													
													droite.add((windows.WIDTH/27)*a+71);
													droite.add(((windows.HEIGHT/27)*(26-b)));
													gauche.add((windows.WIDTH/27)*a-71);
													gauche.add(((windows.HEIGHT/27)*(26-b)));
													haut.add((windows.WIDTH/27)*a);
													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													bas.add((windows.WIDTH/27)*a);
													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													possibleprairie.add(droite);
													possibleprairie.add(gauche);
													possibleprairie.add(haut);
													possibleprairie.add(bas);
													
													
													possibleprairie.remove(point);
													
												}
												
												possible.add(droite);
												possible.add(gauche);
												possible.add(haut);
												possible.add(bas);
												
												
												possibledeux.add(droite);
												possibledeux.add(gauche);
												possibledeux.add(haut);
												possibledeux.add(bas);
												
												coordinates.add(point);
												possible.remove(point);
												tour++;
												demi++;
												
											}
											else if((demi == 1 && possible.contains(point)) && (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))) )
											{
												if((area1.equals("Champs")&& possiblechamps.contains(point)) || (area1.equals("Mer")&& possiblemer.contains(point)) ||(area1.equals("Mine")&& possiblemine.contains(point)) ||(area1.equals("Montagne")&& possiblemontagne.contains(point)) || (area1.equals("Foret")&& possibleforet.contains(point)) || (area1.equals("Prairie")&& possibleprairie.contains(point)) ){
												
												g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
												
//												//Domino sélectionné
//												String area1= ((ChoixJ1.get(0)).get(1));
//												String couronne1= ((ChoixJ1.get(0)).get(0));
//												String area2= ((ChoixJ1.get(1)).get(1));
//												String couronne2=((ChoixJ1.get(1)).get(0));
//												System.out.println("dominos"+ area1 + ""+couronne1+area2+couronne2);
//												System.out.println("tour "+ tour);
//												//
												if(tour==0) {
												
												couleur.add(area1);
												couronne.add(couronne1);
												}
												else if(tour==1) {
													
													couleur.add(area2);
													couronne.add(couronne2);
													}

												listx.add(xpos);
												listy.add(ypos);
												
												
												ArrayList<Integer> droite = new ArrayList<>();
												ArrayList<Integer> gauche = new ArrayList<>();
												ArrayList<Integer> haut = new ArrayList<>();
												ArrayList<Integer> bas = new ArrayList<>();
												
												if(area1.equals("Champs"))
												{
													
													droite.add((windows.WIDTH/27)*a+71);
													droite.add(((windows.HEIGHT/27)*(26-b)));
													gauche.add((windows.WIDTH/27)*a-71);
													gauche.add(((windows.HEIGHT/27)*(26-b)));
													haut.add((windows.WIDTH/27)*a);
													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													bas.add((windows.WIDTH/27)*a);
													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													possiblechamps.add(droite);
													possiblechamps.add(gauche);
													possiblechamps.add(haut);
													possiblechamps.add(bas);
													possiblechamps.remove(point);
													
													
												}
												else if(area1.equals("Mer"))
												{
													
													droite.add((windows.WIDTH/27)*a+71);
													droite.add(((windows.HEIGHT/27)*(26-b)));
													gauche.add((windows.WIDTH/27)*a-71);
													gauche.add(((windows.HEIGHT/27)*(26-b)));
													haut.add((windows.WIDTH/27)*a);
													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													bas.add((windows.WIDTH/27)*a);
													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													possiblemer.add(droite);
													possiblemer.add(gauche);
													possiblemer.add(haut);
													possiblemer.add(bas);
													possiblemer.remove(point);
													
												}
												else if(area1.equals("Mine"))
												{
													
													droite.add((windows.WIDTH/27)*a+71);
													droite.add(((windows.HEIGHT/27)*(26-b)));
													gauche.add((windows.WIDTH/27)*a-71);
													gauche.add(((windows.HEIGHT/27)*(26-b)));
													haut.add((windows.WIDTH/27)*a);
													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													bas.add((windows.WIDTH/27)*a);
													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													possiblemine.add(droite);
													possiblemine.add(gauche);
													possiblemine.add(haut);
													possiblemine.add(bas);
													
													
													possiblemine.remove(point);
													
												}
												else if(area1.equals("Montagne"))
												{
													
													droite.add((windows.WIDTH/27)*a+71);
													droite.add(((windows.HEIGHT/27)*(26-b)));
													gauche.add((windows.WIDTH/27)*a-71);
													gauche.add(((windows.HEIGHT/27)*(26-b)));
													haut.add((windows.WIDTH/27)*a);
													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													bas.add((windows.WIDTH/27)*a);
													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													possiblemontagne.add(droite);
													possiblemontagne.add(gauche);
													possiblemontagne.add(haut);
													possiblemontagne.add(bas);
													
													
													
													possiblemontagne.remove(point);
													
												}
												else if(area1.equals("Foret"))
												{
													
													droite.add((windows.WIDTH/27)*a+71);
													droite.add(((windows.HEIGHT/27)*(26-b)));
													gauche.add((windows.WIDTH/27)*a-71);
													gauche.add(((windows.HEIGHT/27)*(26-b)));
													haut.add((windows.WIDTH/27)*a);
													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													bas.add((windows.WIDTH/27)*a);
													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													possibleforet.add(droite);
													possibleforet.add(gauche);
													possibleforet.add(haut);
													possibleforet.add(bas);
													
													
													possibleforet.remove(point);
													
												}
												else if(area1.equals("Prairie"))
												{
													
													droite.add((windows.WIDTH/27)*a+71);
													droite.add(((windows.HEIGHT/27)*(26-b)));
													gauche.add((windows.WIDTH/27)*a-71);
													gauche.add(((windows.HEIGHT/27)*(26-b)));
													haut.add((windows.WIDTH/27)*a);
													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													bas.add((windows.WIDTH/27)*a);
													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													possibleprairie.add(droite);
													possibleprairie.add(gauche);
													possibleprairie.add(haut);
													possibleprairie.add(bas);
													
													
													possibleprairie.remove(point);
													
												}
												
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
												CompteurTour++;
												}
											}
												else if(demi == 2 && possibledeux.contains(point) && possible.contains(point) && (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))) )
												{
													
													g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
													
//													//Domino sélectionné
//													String area1= ((ChoixJ1.get(0)).get(1));
//													String couronne1= ((ChoixJ1.get(0)).get(0));
//													String area2= ((ChoixJ1.get(1)).get(1));
//													String couronne2=((ChoixJ1.get(1)).get(0));
//													System.out.println("dominos"+ area1 + ""+couronne1+area2+couronne2);
//													System.out.println("tour "+ tour);
//													//
													if(tour==0) {
													
													couleur.add(area1);
													couronne.add(couronne1);
													}
													else if(tour==1) {
														
														couleur.add(area2);
														couronne.add(couronne2);
														}

													listx.add(xpos);
													listy.add(ypos);
													
													
													ArrayList<Integer> droite = new ArrayList<>();
//													droite.add((windows.WIDTH/27)*a+71);
//													droite.add(((windows.HEIGHT/27)*(26-b)));
													ArrayList<Integer> gauche = new ArrayList<>();
//													gauche.add((windows.WIDTH/27)*a-71);
//													gauche.add(((windows.HEIGHT/27)*(26-b)));
													ArrayList<Integer> haut = new ArrayList<>();
//													haut.add((windows.WIDTH/27)*a);
//													haut.add(((windows.HEIGHT/27)*(26-b))+40);
													ArrayList<Integer> bas = new ArrayList<>();
//													bas.add((windows.WIDTH/27)*a);
//													bas.add(((windows.HEIGHT/27)*(26-b))-40);
													
													if(area2.equals("Champs"))
													{
														
														droite.add((windows.WIDTH/27)*a+71);
														droite.add(((windows.HEIGHT/27)*(26-b)));
														gauche.add((windows.WIDTH/27)*a-71);
														gauche.add(((windows.HEIGHT/27)*(26-b)));
														haut.add((windows.WIDTH/27)*a);
														haut.add(((windows.HEIGHT/27)*(26-b))+40);
														bas.add((windows.WIDTH/27)*a);
														bas.add(((windows.HEIGHT/27)*(26-b))-40);
														
														possiblechamps.add(droite);
														possiblechamps.add(gauche);
														possiblechamps.add(haut);
														possiblechamps.add(bas);
														possiblechamps.remove(point);
														
														
													}
													else if(area2.equals("Mer"))
													{
														
														droite.add((windows.WIDTH/27)*a+71);
														droite.add(((windows.HEIGHT/27)*(26-b)));
														gauche.add((windows.WIDTH/27)*a-71);
														gauche.add(((windows.HEIGHT/27)*(26-b)));
														haut.add((windows.WIDTH/27)*a);
														haut.add(((windows.HEIGHT/27)*(26-b))+40);
														bas.add((windows.WIDTH/27)*a);
														bas.add(((windows.HEIGHT/27)*(26-b))-40);
														
														possiblemer.add(droite);
														possiblemer.add(gauche);
														possiblemer.add(haut);
														possiblemer.add(bas);
														possiblemer.remove(point);
														
													}
													else if(area2.equals("Mine"))
													{
														
														droite.add((windows.WIDTH/27)*a+71);
														droite.add(((windows.HEIGHT/27)*(26-b)));
														gauche.add((windows.WIDTH/27)*a-71);
														gauche.add(((windows.HEIGHT/27)*(26-b)));
														haut.add((windows.WIDTH/27)*a);
														haut.add(((windows.HEIGHT/27)*(26-b))+40);
														bas.add((windows.WIDTH/27)*a);
														bas.add(((windows.HEIGHT/27)*(26-b))-40);
														
														possiblemine.add(droite);
														possiblemine.add(gauche);
														possiblemine.add(haut);
														possiblemine.add(bas);
														
														
														possiblemine.remove(point);
														
													}
													else if(area2.equals("Montagne"))
													{
														
														droite.add((windows.WIDTH/27)*a+71);
														droite.add(((windows.HEIGHT/27)*(26-b)));
														gauche.add((windows.WIDTH/27)*a-71);
														gauche.add(((windows.HEIGHT/27)*(26-b)));
														haut.add((windows.WIDTH/27)*a);
														haut.add(((windows.HEIGHT/27)*(26-b))+40);
														bas.add((windows.WIDTH/27)*a);
														bas.add(((windows.HEIGHT/27)*(26-b))-40);
														
														possiblemontagne.add(droite);
														possiblemontagne.add(gauche);
														possiblemontagne.add(haut);
														possiblemontagne.add(bas);
														
														
														
														possiblemontagne.remove(point);
														
													}
													else if(area2.equals("Foret"))
													{
														
														droite.add((windows.WIDTH/27)*a+71);
														droite.add(((windows.HEIGHT/27)*(26-b)));
														gauche.add((windows.WIDTH/27)*a-71);
														gauche.add(((windows.HEIGHT/27)*(26-b)));
														haut.add((windows.WIDTH/27)*a);
														haut.add(((windows.HEIGHT/27)*(26-b))+40);
														bas.add((windows.WIDTH/27)*a);
														bas.add(((windows.HEIGHT/27)*(26-b))-40);
														
														possibleforet.add(droite);
														possibleforet.add(gauche);
														possibleforet.add(haut);
														possibleforet.add(bas);
														
														
														possibleforet.remove(point);
														
													}
													else if(area2.equals("Prairie"))
													{
														
														droite.add((windows.WIDTH/27)*a+71);
														droite.add(((windows.HEIGHT/27)*(26-b)));
														gauche.add((windows.WIDTH/27)*a-71);
														gauche.add(((windows.HEIGHT/27)*(26-b)));
														haut.add((windows.WIDTH/27)*a);
														haut.add(((windows.HEIGHT/27)*(26-b))+40);
														bas.add((windows.WIDTH/27)*a);
														bas.add(((windows.HEIGHT/27)*(26-b))-40);
														
														possibleprairie.add(droite);
														possibleprairie.add(gauche);
														possibleprairie.add(haut);
														possibleprairie.add(bas);
														
														
														possibleprairie.remove(point);
														
													}
													
													possible.add(droite);
													possible.add(gauche);
													possible.add(haut);
													possible.add(bas);
													
													interdit.add((windows.WIDTH/27)*a+(71*5));
													interdit.add((windows.WIDTH/27)*a-(71*5));
													interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
													interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
													
													possibledeux.clear();
													coordinates.add(point);
													possible.remove(point);
													tour++;
													demi=1;
													CompteurTour++;
												}
											
										}
								}
							}
						}
					}
						if(tour ==2)
						{	
							if(OrdreJoueur.indexOf(1)+1<4) {
									joueur =OrdreJoueur.get(OrdreJoueur.indexOf(1)+1);
									
								}
								else {
									
									for(int h=0;h<4;h++) {
										OrdreJoueur.set(h, NextOrdreJoueur.get(h));
									}
									
									joueur=OrdreJoueur.get(0);

								}
							tour =0;
							choisir=1;
							ChoixJ1.remove(0);
							ChoixJ1.remove(0);
						}
				}}

				if(joueur == 2 )
				{	

					if(tour==0) {
						if(choisir==1) {

							if(input.isMousePressed(0)) {

								if(xpos>950 && xpos<1150 &&ypos<880 && ypos>830) {
									ChoixJ1 = Joueur.Choix(OrdreJoueur.indexOf(joueur), affich, AllDominos);
									choisir=0;
									NextOrdreJoueur.set(3,2);
									
								}
							
								else if(xpos>950 && xpos<1150 &&ypos<780 && ypos>730) {
									ChoixJ1 = Joueur.Choix(OrdreJoueur.indexOf(joueur), affich, AllDominos);
									choisir=0;
									NextOrdreJoueur.set(2,2);


								
							}			
							
								else if(xpos>950 && xpos<1150 &&ypos<680 && ypos>630) {
									ChoixJ1 = Joueur.Choix(OrdreJoueur.indexOf(joueur), affich, AllDominos);
									choisir=0;
									NextOrdreJoueur.set(1,2);


								}
										
								else if(xpos>950 && xpos<1150 &&ypos<580 && ypos>530) {
									ChoixJ1 = Joueur.Choix( OrdreJoueur.indexOf(joueur), affich, AllDominos);
									choisir=0;
									NextOrdreJoueur.set(0,2);
								}
							
						}}}
						if(input.isMousePressed(0)) {
							if(xpos>800 && xpos<950 &&ypos<100 && ypos>40) {
								CompteurTour=CompteurTour+2;
								tour=2;
							}
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
									
									possiblechamps.add(departbas);
									possiblechamps.add(departgauche);
									possiblechamps.add(departhaut);
									possiblechamps.add(departdroite);
									

									possiblemer.add(departdroite);
									possiblemer.add(departgauche);
									possiblemer.add(departhaut);
									possiblemer.add(departbas);
									
									possiblemine.add(departdroite);
									possiblemine.add(departgauche);
									possiblemine.add(departhaut);
									possiblemine.add(departbas);
									
									possiblemontagne.add(departdroite);
									possiblemontagne.add(departgauche);
									possiblemontagne.add(departhaut);
									possiblemontagne.add(departbas);
									
									possibleforet.add(departdroite);
									possibleforet.add(departgauche);
									possibleforet.add(departhaut);
									possibleforet.add(departbas);
									
									possibleprairie.add(departdroite);
									possibleprairie.add(departgauche);
									possibleprairie.add(departhaut);
									possibleprairie.add(departbas);
									
									
									
									if(!coordinates.contains(point) )
									{
										String area1= ((ChoixJ1.get(0)).get(1));
										String couronne1= ((ChoixJ1.get(0)).get(0));
										String area2= ((ChoixJ1.get(1)).get(1));
										String couronne2=((ChoixJ1.get(1)).get(0));
										
										if(coordinates.size()==0 && possible2.contains(point))
										{
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											
											
											if(tour==0) {
											
											couleur.add(area1);
											couronne.add(couronne1);
											}
											else if(tour==1) {
												
												couleur.add(area2);
												couronne.add(couronne2);
											}
											
											listx.add(xpos);
											listy.add(ypos);
											ArrayList<Integer> droite = new ArrayList<>();
											ArrayList<Integer> gauche = new ArrayList<>();
											ArrayList<Integer> haut = new ArrayList<>();
											ArrayList<Integer> bas = new ArrayList<>();
											
											if(area1.equals("Champs"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblechamps.add(droite);
												possiblechamps.add(gauche);
												possiblechamps.add(haut);
												possiblechamps.add(bas);
												possiblechamps.remove(point);
												
												
											}
											else if(area1.equals("Mer"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemer.add(droite);
												possiblemer.add(gauche);
												possiblemer.add(haut);
												possiblemer.add(bas);
												possiblemer.remove(point);
												
											}
											else if(area1.equals("Mine"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemine.add(droite);
												possiblemine.add(gauche);
												possiblemine.add(haut);
												possiblemine.add(bas);
												
												
												possiblemine.remove(point);
												
											}
											else if(area1.equals("Montagne"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemontagne.add(droite);
												possiblemontagne.add(gauche);
												possiblemontagne.add(haut);
												possiblemontagne.add(bas);
												
												
												
												possiblemontagne.remove(point);
												
											}
											else if(area1.equals("Foret"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleforet.add(droite);
												possibleforet.add(gauche);
												possibleforet.add(haut);
												possibleforet.add(bas);
												
												
												possibleforet.remove(point);
												
											}
											else if(area1.equals("Prairie"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleprairie.add(droite);
												possibleprairie.add(gauche);
												possibleprairie.add(haut);
												possibleprairie.add(bas);
												
												
												possibleprairie.remove(point);
												
											}
											
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
											if((area1.equals("Champs")&& possiblechamps.contains(point)) || (area1.equals("Mer")&& possiblemer.contains(point)) ||(area1.equals("Mine")&& possiblemine.contains(point)) ||(area1.equals("Montagne")&& possiblemontagne.contains(point)) || (area1.equals("Foret")&& possibleforet.contains(point)) || (area1.equals("Prairie")&& possibleprairie.contains(point)) ){
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											
											if(tour==0) {
											couleur.add(area1);
											couronne.add(couronne1);
											}
											else if(tour==1) {
												couleur.add(area2);
												couronne.add(couronne2);

												}
											listx.add(xpos);
											listy.add(ypos);
											
											
											ArrayList<Integer> droite = new ArrayList<>();
											ArrayList<Integer> gauche = new ArrayList<>();
											ArrayList<Integer> haut = new ArrayList<>();
											ArrayList<Integer> bas = new ArrayList<>();
											
											if(area1.equals("Champs"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblechamps.add(droite);
												possiblechamps.add(gauche);
												possiblechamps.add(haut);
												possiblechamps.add(bas);
												possiblechamps.remove(point);
												
												
											}
											else if(area1.equals("Mer"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemer.add(droite);
												possiblemer.add(gauche);
												possiblemer.add(haut);
												possiblemer.add(bas);
												possiblemer.remove(point);
												
											}
											else if(area1.equals("Mine"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemine.add(droite);
												possiblemine.add(gauche);
												possiblemine.add(haut);
												possiblemine.add(bas);
												
												
												possiblemine.remove(point);
												
											}
											else if(area1.equals("Montagne"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemontagne.add(droite);
												possiblemontagne.add(gauche);
												possiblemontagne.add(haut);
												possiblemontagne.add(bas);
												
												
												
												possiblemontagne.remove(point);
												
											}
											else if(area1.equals("Foret"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleforet.add(droite);
												possibleforet.add(gauche);
												possibleforet.add(haut);
												possibleforet.add(bas);
												
												
												possibleforet.remove(point);
												
											}
											else if(area1.equals("Prairie"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleprairie.add(droite);
												possibleprairie.add(gauche);
												possibleprairie.add(haut);
												possibleprairie.add(bas);
												
												
												possibleprairie.remove(point);
												
											}
											
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
											CompteurTour++;
											}
										}
										else if(demi == 2 && possibledeux2.contains(point) && possible2.contains(point)&& (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))) ) {
											
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											
											if(tour==0) {
											couleur.add(area1);
											couronne.add(couronne1);
											}
											else if(tour==1) {
												couleur.add(area2);
												couronne.add(couronne2);

												}
											listx.add(xpos);
											listy.add(ypos);
											
											
											ArrayList<Integer> droite = new ArrayList<>();
//											droite.add((windows.WIDTH/27)*a+71);
//											droite.add(((windows.HEIGHT/27)*(26-b)));
											ArrayList<Integer> gauche = new ArrayList<>();
//											gauche.add((windows.WIDTH/27)*a-71);
//											gauche.add(((windows.HEIGHT/27)*(26-b)));
											ArrayList<Integer> haut = new ArrayList<>();
//											haut.add((windows.WIDTH/27)*a);
//											haut.add(((windows.HEIGHT/27)*(26-b))+40);
											ArrayList<Integer> bas = new ArrayList<>();
//											bas.add((windows.WIDTH/27)*a);
//											bas.add(((windows.HEIGHT/27)*(26-b))-40);
											
											if(area2.equals("Champs"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblechamps.add(droite);
												possiblechamps.add(gauche);
												possiblechamps.add(haut);
												possiblechamps.add(bas);
												possiblechamps.remove(point);
												
												
											}
											else if(area2.equals("Mer"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemer.add(droite);
												possiblemer.add(gauche);
												possiblemer.add(haut);
												possiblemer.add(bas);
												possiblemer.remove(point);
												
											}
											else if(area2.equals("Mine"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemine.add(droite);
												possiblemine.add(gauche);
												possiblemine.add(haut);
												possiblemine.add(bas);
												
												
												possiblemine.remove(point);
												
											}
											else if(area2.equals("Montagne"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemontagne.add(droite);
												possiblemontagne.add(gauche);
												possiblemontagne.add(haut);
												possiblemontagne.add(bas);
												
												
												
												possiblemontagne.remove(point);
												
											}
											else if(area2.equals("Foret"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleforet.add(droite);
												possibleforet.add(gauche);
												possibleforet.add(haut);
												possibleforet.add(bas);
												
												
												possibleforet.remove(point);
												
											}
											else if(area2.equals("Prairie"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleprairie.add(droite);
												possibleprairie.add(gauche);
												possibleprairie.add(haut);
												possibleprairie.add(bas);
												
												
												possibleprairie.remove(point);
												
											}
											
											possible2.add(droite);
											possible2.add(gauche);
											possible2.add(haut);
											possible2.add(bas);
											possible2.remove(point);
											
											
											interdit.add((windows.WIDTH/27)*a+(71*5));
											interdit.add((windows.WIDTH/27)*a-(71*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))+(40*5));
											interdit.add(((windows.HEIGHT/27)*(26-b))-(40*5));
											
											possibledeux2.clear();
											
											coordinates.add(point);
											possible2.remove(point);
											tour++;
											demi=1;
											CompteurTour++;
										}

									}
								}
							}
						}
					}
					if(tour ==2)
					{
						if(OrdreJoueur.indexOf(2)+1<4) {
								joueur =OrdreJoueur.get(OrdreJoueur.indexOf(2)+1);
								}
							else {
								for(int h=0;h<4;h++) {
									OrdreJoueur.set(h, NextOrdreJoueur.get(h));
								}
								joueur=OrdreJoueur.get(0);

							}
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
								
								if(xpos>950 && xpos<1150 &&ypos<880 && ypos>830) {
									ChoixJ1 = Joueur.Choix(OrdreJoueur.indexOf(joueur), affich, AllDominos);
									choisir=0;
									NextOrdreJoueur.set(3,3);
									
									
								}
							
								else if(xpos>950 && xpos<1150 &&ypos<780 && ypos>730) {
									ChoixJ1 = Joueur.Choix(OrdreJoueur.indexOf(joueur), affich, AllDominos);
									choisir=0;
									NextOrdreJoueur.set(2,3);

								
							}			

								else if(xpos>950 && xpos<1150 &&ypos<680 && ypos>630) {
									ChoixJ1 = Joueur.Choix(OrdreJoueur.indexOf(joueur), affich, AllDominos);
									choisir=0;
									NextOrdreJoueur.set(1,3);

								}
										
								else if(xpos>950 && xpos<1150 &&ypos<580 && ypos>530) {
									ChoixJ1 = Joueur.Choix( OrdreJoueur.indexOf(joueur), affich, AllDominos);
									choisir=0;
									NextOrdreJoueur.set(0,3);
								}
								else {
									System.out.println("Rien");
								}
							
						}}}
						if(input.isMousePressed(0)) {
							if(xpos>800 && xpos<950 &&ypos<100 && ypos>40) {
								CompteurTour=CompteurTour+2;
								tour=2;
							}
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
									
									possiblechamps.add(departbas);
									possiblechamps.add(departgauche);
									possiblechamps.add(departhaut);
									possiblechamps.add(departdroite);
									

									possiblemer.add(departdroite);
									possiblemer.add(departgauche);
									possiblemer.add(departhaut);
									possiblemer.add(departbas);
									
									possiblemine.add(departdroite);
									possiblemine.add(departgauche);
									possiblemine.add(departhaut);
									possiblemine.add(departbas);
									
									possiblemontagne.add(departdroite);
									possiblemontagne.add(departgauche);
									possiblemontagne.add(departhaut);
									possiblemontagne.add(departbas);
									
									possibleforet.add(departdroite);
									possibleforet.add(departgauche);
									possibleforet.add(departhaut);
									possibleforet.add(departbas);
									
									possibleprairie.add(departdroite);
									possibleprairie.add(departgauche);
									possibleprairie.add(departhaut);
									possibleprairie.add(departbas);
									
									
									if(!coordinates.contains(point) )
									{
										String area1= ((ChoixJ1.get(0)).get(1));
										String couronne1= ((ChoixJ1.get(0)).get(0));
										String area2= ((ChoixJ1.get(1)).get(1));
										String couronne2=((ChoixJ1.get(1)).get(0));
										if(coordinates.size()==0 && possible3.contains(point))
										{
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											
											
											if(tour==0) {
											
											couleur.add(area1);
											couronne.add(couronne1);
											}
											else if(tour==1) {
												
												couleur.add(area2);
												couronne.add(couronne2);
												}

											listx.add(xpos);
											listy.add(ypos);
											
											ArrayList<Integer> droite = new ArrayList<>();
											ArrayList<Integer> gauche = new ArrayList<>();
											ArrayList<Integer> haut = new ArrayList<>();
											ArrayList<Integer> bas = new ArrayList<>();
											
											if(area1.equals("Champs"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblechamps.add(droite);
												possiblechamps.add(gauche);
												possiblechamps.add(haut);
												possiblechamps.add(bas);
												possiblechamps.remove(point);
												
												
											}
											else if(area1.equals("Mer"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemer.add(droite);
												possiblemer.add(gauche);
												possiblemer.add(haut);
												possiblemer.add(bas);
												possiblemer.remove(point);
												
											}
											else if(area1.equals("Mine"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemine.add(droite);
												possiblemine.add(gauche);
												possiblemine.add(haut);
												possiblemine.add(bas);
												
												
												possiblemine.remove(point);
												
											}
											else if(area1.equals("Montagne"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemontagne.add(droite);
												possiblemontagne.add(gauche);
												possiblemontagne.add(haut);
												possiblemontagne.add(bas);
												
												
												
												possiblemontagne.remove(point);
												
											}
											else if(area1.equals("Foret"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleforet.add(droite);
												possibleforet.add(gauche);
												possibleforet.add(haut);
												possibleforet.add(bas);
												
												
												possibleforet.remove(point);
												
											}
											else if(area1.equals("Prairie"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleprairie.add(droite);
												possibleprairie.add(gauche);
												possibleprairie.add(haut);
												possibleprairie.add(bas);
												
												
												possibleprairie.remove(point);
												
											}
											
											
											
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
											if((area1.equals("Champs")&& possiblechamps.contains(point)) || (area1.equals("Mer")&& possiblemer.contains(point)) ||(area1.equals("Mine")&& possiblemine.contains(point)) ||(area1.equals("Montagne")&& possiblemontagne.contains(point)) || (area1.equals("Foret")&& possibleforet.contains(point)) || (area1.equals("Prairie")&& possibleprairie.contains(point)) ){
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											
											if(tour==0) {
											
											couleur.add(area1);
											couronne.add(couronne1);
											}
											else if(tour==1) {
												
												couleur.add(area2);
												couronne.add(couronne2);
												}

											listx.add(xpos);
											listy.add(ypos);
											
											
											ArrayList<Integer> droite = new ArrayList<>();
											ArrayList<Integer> gauche = new ArrayList<>();
											ArrayList<Integer> haut = new ArrayList<>();
											ArrayList<Integer> bas = new ArrayList<>();
											
											if(area1.equals("Champs"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblechamps.add(droite);
												possiblechamps.add(gauche);
												possiblechamps.add(haut);
												possiblechamps.add(bas);
												possiblechamps.remove(point);
												
												
											}
											else if(area1.equals("Mer"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemer.add(droite);
												possiblemer.add(gauche);
												possiblemer.add(haut);
												possiblemer.add(bas);
												possiblemer.remove(point);
												
											}
											else if(area1.equals("Mine"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemine.add(droite);
												possiblemine.add(gauche);
												possiblemine.add(haut);
												possiblemine.add(bas);
												
												
												possiblemine.remove(point);
												
											}
											else if(area1.equals("Montagne"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemontagne.add(droite);
												possiblemontagne.add(gauche);
												possiblemontagne.add(haut);
												possiblemontagne.add(bas);
												
												
												
												possiblemontagne.remove(point);
												
											}
											else if(area1.equals("Foret"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleforet.add(droite);
												possibleforet.add(gauche);
												possibleforet.add(haut);
												possibleforet.add(bas);
												
												
												possibleforet.remove(point);
												
											}
											else if(area1.equals("Prairie"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleprairie.add(droite);
												possibleprairie.add(gauche);
												possibleprairie.add(haut);
												possibleprairie.add(bas);
												
												
												possibleprairie.remove(point);
												
											}
											
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
											CompteurTour++;
											}
										}
										else if(demi == 2 && possibledeux3.contains(point) && possible3.contains(point)&& (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))) )
										{
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											
											if(tour==0) {
											
											couleur.add(area1);
											couronne.add(couronne1);
											}
											else if(tour==1) {
												
												couleur.add(area2);
												couronne.add(couronne2);
												}

											listx.add(xpos);
											listy.add(ypos);
											
											
											ArrayList<Integer> droite = new ArrayList<>();
//											droite.add((windows.WIDTH/27)*a+71);
//											droite.add(((windows.HEIGHT/27)*(26-b)));
											ArrayList<Integer> gauche = new ArrayList<>();
//											gauche.add((windows.WIDTH/27)*a-71);
//											gauche.add(((windows.HEIGHT/27)*(26-b)));
											ArrayList<Integer> haut = new ArrayList<>();
//											haut.add((windows.WIDTH/27)*a);
//											haut.add(((windows.HEIGHT/27)*(26-b))+40);
											ArrayList<Integer> bas = new ArrayList<>();
//											bas.add((windows.WIDTH/27)*a);
//											bas.add(((windows.HEIGHT/27)*(26-b))-40);
											
											if(area2.equals("Champs"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblechamps.add(droite);
												possiblechamps.add(gauche);
												possiblechamps.add(haut);
												possiblechamps.add(bas);
												possiblechamps.remove(point);
												
												
											}
											else if(area2.equals("Mer"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemer.add(droite);
												possiblemer.add(gauche);
												possiblemer.add(haut);
												possiblemer.add(bas);
												possiblemer.remove(point);
												
											}
											else if(area2.equals("Mine"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemine.add(droite);
												possiblemine.add(gauche);
												possiblemine.add(haut);
												possiblemine.add(bas);
												
												
												possiblemine.remove(point);
												
											}
											else if(area2.equals("Montagne"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemontagne.add(droite);
												possiblemontagne.add(gauche);
												possiblemontagne.add(haut);
												possiblemontagne.add(bas);
												
												
												
												possiblemontagne.remove(point);
												
											}
											else if(area2.equals("Foret"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleforet.add(droite);
												possibleforet.add(gauche);
												possibleforet.add(haut);
												possibleforet.add(bas);
												
												
												possibleforet.remove(point);
												
											}
											else if(area2.equals("Prairie"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleprairie.add(droite);
												possibleprairie.add(gauche);
												possibleprairie.add(haut);
												possibleprairie.add(bas);
												
												
												possibleprairie.remove(point);
												
											}
											
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
											possible3.remove(point);
											tour++;
											demi=1;
											CompteurTour++;	
										}
									}
								}
							}
						}
					}
					if(tour ==2)
					{
						if(OrdreJoueur.indexOf(3)+1<4) {
								int next=OrdreJoueur.indexOf(3)+1;
								joueur =OrdreJoueur.get(next);
								
							}
							else {
								for(int h=0;h<4;h++) {
									OrdreJoueur.set(h, NextOrdreJoueur.get(h));
								}
								joueur=OrdreJoueur.get(0);

							}
							
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

								if(xpos>950 && xpos<1150 &&ypos<880 && ypos>830) {
									ChoixJ1 = Joueur.Choix(OrdreJoueur.indexOf(joueur), affich, AllDominos);
									choisir=0;
									NextOrdreJoueur.set(3,4);
									
								}
							
								else if(xpos>950 && xpos<1150 &&ypos<780 && ypos>730) {
									ChoixJ1 = Joueur.Choix(OrdreJoueur.indexOf(joueur), affich, AllDominos);
									choisir=0;
									NextOrdreJoueur.set(2,4);

								
							}			
							
								else if(xpos>950 && xpos<1150 &&ypos<680 && ypos>630) {
									ChoixJ1 = Joueur.Choix(OrdreJoueur.indexOf(joueur), affich, AllDominos);
									choisir=0;
									NextOrdreJoueur.set(1,4);

								}
										
								else if(xpos>950 && xpos<1150 &&ypos<580 && ypos>530) {
									ChoixJ1 = Joueur.Choix( OrdreJoueur.indexOf(joueur), affich, AllDominos);
									choisir=0;
									NextOrdreJoueur.set(0,4);
								}
								else {
									System.out.println("rieeeeeeeeeen");
								}
							
						}}}
						if(input.isMousePressed(0)) {
							if(xpos>800 && xpos<950 &&ypos<100 && ypos>40) {
								CompteurTour=CompteurTour+2;
								tour=2;
							}
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
									
									possiblechamps.add(departbas);
									possiblechamps.add(departgauche);
									possiblechamps.add(departhaut);
									possiblechamps.add(departdroite);
									

									possiblemer.add(departdroite);
									possiblemer.add(departgauche);
									possiblemer.add(departhaut);
									possiblemer.add(departbas);
									
									possiblemine.add(departdroite);
									possiblemine.add(departgauche);
									possiblemine.add(departhaut);
									possiblemine.add(departbas);
									
									possiblemontagne.add(departdroite);
									possiblemontagne.add(departgauche);
									possiblemontagne.add(departhaut);
									possiblemontagne.add(departbas);
									
									possibleforet.add(departdroite);
									possibleforet.add(departgauche);
									possibleforet.add(departhaut);
									possibleforet.add(departbas);
									
									possibleprairie.add(departdroite);
									possibleprairie.add(departgauche);
									possibleprairie.add(departhaut);
									possibleprairie.add(departbas);
									
									
									
									if(!coordinates.contains(point) )
									{
										String area1= ((ChoixJ1.get(0)).get(1));
										String couronne1= ((ChoixJ1.get(0)).get(0));
										String area2= ((ChoixJ1.get(1)).get(1));
										String couronne2=((ChoixJ1.get(1)).get(0));
										
										if(coordinates.size()==0 && possible4.contains(point))
										{
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											
											//Domino sélectionné
											
											if(tour==0) {
											
											couleur.add(area1);
											couronne.add(couronne1);
											}
											else if(tour==1) {
												
												couleur.add(area2);
												couronne.add(couronne2);
												}
											
											listx.add(xpos);
											listy.add(ypos);


											ArrayList<Integer> droite = new ArrayList<>();
											ArrayList<Integer> gauche = new ArrayList<>();
											ArrayList<Integer> haut = new ArrayList<>();
											ArrayList<Integer> bas = new ArrayList<>();
											
											if(area1.equals("Champs"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblechamps.add(droite);
												possiblechamps.add(gauche);
												possiblechamps.add(haut);
												possiblechamps.add(bas);
												possiblechamps.remove(point);
												
												
											}
											else if(area1.equals("Mer"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemer.add(droite);
												possiblemer.add(gauche);
												possiblemer.add(haut);
												possiblemer.add(bas);
												possiblemer.remove(point);
												
											}
											else if(area1.equals("Mine"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemine.add(droite);
												possiblemine.add(gauche);
												possiblemine.add(haut);
												possiblemine.add(bas);
												
												
												possiblemine.remove(point);
												
											}
											else if(area1.equals("Montagne"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemontagne.add(droite);
												possiblemontagne.add(gauche);
												possiblemontagne.add(haut);
												possiblemontagne.add(bas);
												
												
												
												possiblemontagne.remove(point);
												
											}
											else if(area1.equals("Foret"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleforet.add(droite);
												possibleforet.add(gauche);
												possibleforet.add(haut);
												possibleforet.add(bas);
												
												
												possibleforet.remove(point);
												
											}
											else if(area1.equals("Prairie"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleprairie.add(droite);
												possibleprairie.add(gauche);
												possibleprairie.add(haut);
												possibleprairie.add(bas);
												
												
												possibleprairie.remove(point);
												
											}
											
											
											
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
											possible4.remove(point);
											tour++;
											demi++;
										}
										else if(demi == 1 && possible4.contains(point)&& (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))))
										{
											if((area1.equals("Champs")&& possiblechamps.contains(point)) || (area1.equals("Mer")&& possiblemer.contains(point)) ||(area1.equals("Mine")&& possiblemine.contains(point)) ||(area1.equals("Montagne")&& possiblemontagne.contains(point)) || (area1.equals("Foret")&& possibleforet.contains(point)) || (area1.equals("Prairie")&& possibleprairie.contains(point)) ){
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											//Domino sélectionné
											
											if(tour==0) {
											
											couleur.add(area1);
											couronne.add(couronne1);
											}
											else if(tour==1) {
												
												couleur.add(area2);
												couronne.add(couronne2);
												}

											listx.add(xpos);
											listy.add(ypos);
											
											
											ArrayList<Integer> droite = new ArrayList<>();
											ArrayList<Integer> gauche = new ArrayList<>();
											ArrayList<Integer> haut = new ArrayList<>();
											ArrayList<Integer> bas = new ArrayList<>();
											
											if(area1.equals("Champs"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblechamps.add(droite);
												possiblechamps.add(gauche);
												possiblechamps.add(haut);
												possiblechamps.add(bas);
												possiblechamps.remove(point);
												
												
											}
											else if(area1.equals("Mer"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemer.add(droite);
												possiblemer.add(gauche);
												possiblemer.add(haut);
												possiblemer.add(bas);
												possiblemer.remove(point);
												
											}
											else if(area1.equals("Mine"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemine.add(droite);
												possiblemine.add(gauche);
												possiblemine.add(haut);
												possiblemine.add(bas);
												
												
												possiblemine.remove(point);
												
											}
											else if(area1.equals("Montagne"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemontagne.add(droite);
												possiblemontagne.add(gauche);
												possiblemontagne.add(haut);
												possiblemontagne.add(bas);
												
												
												
												possiblemontagne.remove(point);
												
											}
											else if(area1.equals("Foret"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleforet.add(droite);
												possibleforet.add(gauche);
												possibleforet.add(haut);
												possibleforet.add(bas);
												
												
												possibleforet.remove(point);
												
											}
											else if(area1.equals("Prairie"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleprairie.add(droite);
												possibleprairie.add(gauche);
												possibleprairie.add(haut);
												possibleprairie.add(bas);
												
												
												possibleprairie.remove(point);
												
											}
											
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
											possible4.remove(point);
											tour++;
											demi++;
											CompteurTour++;
											}
										}
										else if(demi == 2 && possibledeux4.contains(point) && possible4.contains(point) && (!interdit.contains(point.get(0)) && !interdit.contains(point.get(1))))
										{
											g.fillRect((windows.WIDTH/27)*a,(windows.HEIGHT/27)*(26-b), 213/3, 120/3);
											
											if(tour==0) {
											
											couleur.add(area1);
											couronne.add(couronne1);
											}
											else if(tour==1) {
												
												couleur.add(area2);
												couronne.add(couronne2);
												}

											listx.add(xpos);
											listy.add(ypos);
											
											
											ArrayList<Integer> droite = new ArrayList<>();
//											droite.add((windows.WIDTH/27)*a+71);
//											droite.add(((windows.HEIGHT/27)*(26-b)));
											ArrayList<Integer> gauche = new ArrayList<>();
//											gauche.add((windows.WIDTH/27)*a-71);
//											gauche.add(((windows.HEIGHT/27)*(26-b)));
											ArrayList<Integer> haut = new ArrayList<>();
//											haut.add((windows.WIDTH/27)*a);
//											haut.add(((windows.HEIGHT/27)*(26-b))+40);
											ArrayList<Integer> bas = new ArrayList<>();
//											bas.add((windows.WIDTH/27)*a);
//											bas.add(((windows.HEIGHT/27)*(26-b))-40);
											
											if(area2.equals("Champs"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblechamps.add(droite);
												possiblechamps.add(gauche);
												possiblechamps.add(haut);
												possiblechamps.add(bas);
												possiblechamps.remove(point);
												
												
											}
											else if(area2.equals("Mer"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemer.add(droite);
												possiblemer.add(gauche);
												possiblemer.add(haut);
												possiblemer.add(bas);
												possiblemer.remove(point);
												
											}
											else if(area2.equals("Mine"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemine.add(droite);
												possiblemine.add(gauche);
												possiblemine.add(haut);
												possiblemine.add(bas);
												
												
												possiblemine.remove(point);
												
											}
											else if(area2.equals("Montagne"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possiblemontagne.add(droite);
												possiblemontagne.add(gauche);
												possiblemontagne.add(haut);
												possiblemontagne.add(bas);
												
												
												
												possiblemontagne.remove(point);
												
											}
											else if(area2.equals("Foret"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleforet.add(droite);
												possibleforet.add(gauche);
												possibleforet.add(haut);
												possibleforet.add(bas);
												
												
												possibleforet.remove(point);
												
											}
											else if(area2.equals("Prairie"))
											{
												
												droite.add((windows.WIDTH/27)*a+71);
												droite.add(((windows.HEIGHT/27)*(26-b)));
												gauche.add((windows.WIDTH/27)*a-71);
												gauche.add(((windows.HEIGHT/27)*(26-b)));
												haut.add((windows.WIDTH/27)*a);
												haut.add(((windows.HEIGHT/27)*(26-b))+40);
												bas.add((windows.WIDTH/27)*a);
												bas.add(((windows.HEIGHT/27)*(26-b))-40);
												
												possibleprairie.add(droite);
												possibleprairie.add(gauche);
												possibleprairie.add(haut);
												possibleprairie.add(bas);
												
												
												possibleprairie.remove(point);
												
											}
											
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
											possible4.remove(point);
											tour++;
											demi=1;
											CompteurTour++;
										}
									}
								}
							}
						}
					}
				
				if(tour ==2)
				{
					if(OrdreJoueur.indexOf(4)+1<4) {
							joueur =OrdreJoueur.get(OrdreJoueur.indexOf(4)+1);
							}
						else {
							for(int h=0;h<4;h++) {
								OrdreJoueur.set(h, NextOrdreJoueur.get(h));
							}
							joueur=OrdreJoueur.get(0);

						}
					
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
		
		if(affich!=11) {
		g.drawString("Ordre de tour :  "+OrdreJoueur, 850 , 700);
		g.drawString("Tour du joueur :  "+joueur, windows.WIDTH/2 , windows.HEIGHT/2);
		g.drawString("Defosser", 850, 1000);
		}
		else {
		g.drawString("jeu terminé",850 , 50);
		g.drawRect(820, 40, 150, 50);
		}
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {


	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 3;
	}


	
}
