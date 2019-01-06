package game;
import java.io.File;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Window extends StateBasedGame{

	public static boolean _APPLET = true ;
	public static final int menu =0;
	public static final int play =1;
	public static final int jeu =2;

	
	public Window() {
		super("Domination");
		this.addState(new Domination(jeu));
		this.addState(new Play(play));
		this.addState(new menu(menu));

		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		_APPLET = false;
		File f = new File("natives");
		if(f.exists()) System.setProperty("org.lwljgl.librarypath", f.getAbsolutePath());
		
		
		try {
			AppGameContainer game = new AppGameContainer(new Window());
			game.setTargetFrameRate(60);
			game.setDisplayMode(windows.WIDTH, windows.HEIGHT, true/*plein écran*/);
			game.setAlwaysRender(true);
			game.start();
			
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		this.getState(jeu).init(gc,this);
		this.getState(play).init(gc,this);
		this.getState(menu).init(gc,this);

		this.enterState(menu);
		gc.setShowFPS(true);
	}

}
