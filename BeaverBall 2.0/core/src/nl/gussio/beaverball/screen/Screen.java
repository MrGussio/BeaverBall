package nl.gussio.beaverball.screen;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class Screen {

	public OrthographicCamera camera;
	public Viewport viewport;
	
	public abstract void render(SpriteBatch sb);
	public abstract void update();
	public abstract void dispose();
	public abstract void create();
	public abstract void resize(int width, int height, float aspectRatio);
	public abstract void handleKey(float x, float y);
	
	public Screen(){
		create();
	}
	
	
}
