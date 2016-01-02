package nl.gussio.beaverball.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Dam extends Entity {

	public Sprite texture;
	public int health;
	
	public Dam(int y, int health) {
		super((int) Math.random()*(Gdx.graphics.getWidth()-50), y);
		this.health = health;
		this.texture = new Sprite(new Texture(Gdx.files.internal("dam.png")));
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.draw(texture, location.x, location.y);
	}

	@Override
	public void update() {
		
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void create() {
		
	}

}
