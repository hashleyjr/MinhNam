package game;
import java.util.ArrayList;
import java.util.Collections;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;


public class menu extends BasicGameState {
	public String mouseString = "Pas d'input";
	public String welcome = "Bienvenue sur Domination!";
	public String resultat = "";
	public String ordre = "";
	
	Image playNow;
	Image exitGame;
	Image deux;
	Image trois;
	Image quatre;

	/*
	int faceX = 200;
	int faceY = 200;
	*/
	public menu(int state) {

	}

	public void init(GameContainer gc, StateBasedGame sbg)
			throws SlickException {
		
		playNow = new Image("res/playNow.png");
		exitGame = new Image("res/exitGame.png");
		deux = new Image("res/2.png");
		trois = new Image("res/3.png");
		quatre= new Image("res/4.png");
		
		
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)
			throws SlickException {
	
		String consigne = "Combien de joueurs êtes-vous?" ; 
		g.drawString(mouseString, 400, 40);
		
		g.drawString(consigne, 700,350);
		g.drawString(welcome, 700,300);
		
		g.drawString(ordre, 1100, 400);
		g.drawString(resultat, 1100, 350);
			
			
		deux.draw(700, 400);
		trois.draw(700, 500);
		quatre.draw(700,600);
		exitGame.draw(700,700);
		if (ordre!="") {
			playNow.draw(1100,500);
		}
		
	}

		
	

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		ListDominos listeDominos= new ListDominos();
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
	
		ArrayList<String> listeJoueur = new ArrayList<String>();
		mouseString = "Mouse x:" + xpos + " y: " + ypos;
		
		
		listeJoueur.add("J1");
		listeJoueur.add("J2");
		Joueur J1 = new Joueur("J1");
		Joueur J2 = new Joueur("J2");
			
		if ((xpos > 700 && xpos < 1000) && (ypos > 640 && ypos < 679)) {
			if (input.isMouseButtonDown(0)) {
				int nbJoueur = 2;
				resultat = "Vous etes " + nbJoueur + " joueurs pour cette partie.";
				listeDominos.ListeDepart(nbJoueur);
				Collections.shuffle(listeJoueur);
				ordre ="Ordre des joueurs au premier tour" + listeJoueur;

				}
				
			}
		
	
		if ((xpos > 700 && xpos < 1000) && (ypos > 540 && ypos < 577)) {
					if (input.isMouseButtonDown(0)) {
						int nbJoueur = 3;
						resultat = "Vous etes " + nbJoueur + " joueurs pour cette partie.";
						listeDominos.ListeDepart(nbJoueur);
						listeJoueur.add("J3");
						Joueur J3 = new Joueur("J3");
						Collections.shuffle(listeJoueur);
						ordre ="Ordre des joueurs au premier tour" + listeJoueur;
					
					}
		}
		if ((xpos > 700 && xpos < 1000) && (ypos > 440 && ypos < 477)) {
			if (input.isMouseButtonDown(0)) {
				int nbJoueur = 4;
				resultat = "Vous etes " + nbJoueur + " joueurs pour cette partie.";
				listeDominos.ListeDepart(nbJoueur);
				listeJoueur.add("J3");
				Joueur J3 = new Joueur("J3");
				listeJoueur.add("J4");
				Joueur J4 = new Joueur("J4");
				Collections.shuffle(listeJoueur);
				ordre ="Ordre des joueurs au premier tour" + listeJoueur;

			}
		}
		// Play button 
		if (ordre!="") {
		if ((xpos > 1100 && xpos < 1300) && (ypos > 540 && ypos < 577)) {
			if (input.isMouseButtonDown(0)) {
				sbg.enterState(2);
			}
		}
		}
		// Exit Game
		if ((xpos > 700 && xpos < 1000) && (ypos > 340&& ypos < 377)) {
			if (input.isMouseButtonDown(0)) {
				System.exit(0);
			}
		}
		

	}

	public int getID() {
		return 0;
	}

}