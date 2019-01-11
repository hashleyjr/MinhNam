package game;
import java.util.ArrayList;
import java.util.Collections;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*; 
import org.newdawn.slick.state.*;


public class menu extends BasicGameState {
	public String mouseString = "Pas d'input";
	public String welcome = "Bienvenue sur Domination!";
	
	
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
		
	
			
		deux.draw(700, 400);
		trois.draw(700, 500);
		quatre.draw(700,600);
		exitGame.draw(700,700);

	}

		
	

	public void update(GameContainer gc, StateBasedGame sbg, int delta)
			throws SlickException {
		
		Input input = gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		
	
		mouseString = "Mouse x:" + xpos + " y: " + ypos;

			
		if ((xpos > 700 && xpos < 1000) && (ypos > 640 && ypos < 679)) {
			if (input.isMouseButtonDown(0)) {
				
				sbg.enterState(1);
			

				}
				
			}
		
	
		if ((xpos > 700 && xpos < 1000) && (ypos > 540 && ypos < 577)) {
					if (input.isMouseButtonDown(0)) {
						
						sbg.enterState(2);
						
					
					}
		}
		if ((xpos > 700 && xpos < 1000) && (ypos > 440 && ypos < 477)) {
			if (input.isMouseButtonDown(0)) {
				sbg.enterState(3);
		
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