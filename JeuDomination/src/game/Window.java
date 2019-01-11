package game;
import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Window extends StateBasedGame{

	public static boolean _APPLET = true ;//??
	
	public static final int menu =0;
	public static final int domination2 =1;
	public static final int domination3 =2;
	public static final int domination4 =3;
	
	public Window() {
		super("Domination");
		this.addState(new menu(menu));
		this.addState(new Domination(domination2));
		this.addState(new Dominationtrois(domination3));
		this.addState(new Dominationquatre(domination4));
		
		
	}

	public static void main(String[] args) {

		_APPLET = false;
		File f = new File("natives");
		if(f.exists()) System.setProperty("org.lwljgl.librarypath", f.getAbsolutePath());
		
		
		try {
			AppGameContainer game = new AppGameContainer(new Window());
			game.setTargetFrameRate(60);
			game.setDisplayMode(windows.WIDTH, windows.HEIGHT, false/*plein écran*/);
			game.setAlwaysRender(true);
			game.start();
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
	
		this.getState(menu).init(gc,this);// deux types d'état
		this.getState(domination2).init(gc,this);
		this.getState(domination3).init(gc,this);
		this.getState(domination4).init(gc,this);
		this.enterState(menu);//quel état je veux voir en premier
		gc.setShowFPS(true);
	}

}
