package game;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState{
	
	public Play(int state){
		
	}
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		Input input =gc.getInput();
		int xpos = Mouse.getX();
		int ypos = Mouse.getY();
		if(input.isMousePressed(0))
			{
				for(int a=0 ;a<10;a++)
				{
					for (int b=0; b<10;b++)
					{
						if (xpos>(windows.WIDTH/9)*a && xpos<(windows.WIDTH/9)*(a+1) && ypos>(windows.HEIGHT/9)*b && ypos<(windows.HEIGHT/9)*(b+1))
						{

							g.setColor(Color.yellow);
							g.fillRect((windows.WIDTH/9)*a,(windows.HEIGHT/9)*b, 210, 120);
							g.setColor(Color.white);

						}
					}
				}
			}
	}

	@Override
	public void update(GameContainer arg0, StateBasedGame arg1, int arg2) throws SlickException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}

}
