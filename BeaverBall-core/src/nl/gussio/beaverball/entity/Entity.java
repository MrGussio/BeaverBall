package nl.gussio.beaverball.entity;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {

	
	
	protected Vector2 location;
	public abstract void render(SpriteBatch sb);
	public abstract void update();
	public abstract void dispose();
	public abstract void create();
	
	public Entity(int x, int y){
		location = new Vector2(x,y);
	}
	
	
}
