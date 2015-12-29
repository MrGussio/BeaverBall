package nl.gussio.beaverball.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Player extends Entity{

	public Sprite texture;
	Vector2 velocity = new Vector2(0,0);
	protected int direction = 0;
	public float resizeValue = 0.90f;
	public Rectangle collision;
	
	public Player(int x, int y) {
		super(x, y);
		texture = new Sprite(new Texture(Gdx.files.internal("beaver sideways.png")));
		this.texture.setSize(texture.getWidth()/2, texture.getWidth());
		collision = new Rectangle(x, y, texture.getTexture().getWidth(), texture.getTexture().getHeight());
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.draw(texture, location.x, location.y, texture.getTexture().getWidth()*resizeValue, texture.getTexture().getHeight()*resizeValue);
	}

	@Override
	public void update() {
		move();
		collision.x = location.x;
		collision.y = location.y;
	}

	@Override
	public void dispose() {
		texture.getTexture().dispose();
	}

	@Override
	public void create() {
		
	}

	public void setVelX(int x){
		velocity.set(x, 0);
	}
	
	public void move(){
		location.x += velocity.x;
		location.y += velocity.y;
		if(location.x < 0){
			location.x = 0;
		}
		if(location.x > Gdx.graphics.getWidth()-texture.getTexture().getWidth()*resizeValue){
			location.x = Gdx.graphics.getWidth()-texture.getTexture().getWidth()*resizeValue;
		}
	}
	
	public void flip(int direction){
		if(direction == 1 && this.direction == 0){
			texture.flip(true, false);
			this.direction = 1;
		}
		if(direction == 0 && this.direction == 1){
			texture.flip(true, false);
			this.direction = 0;
		}
	}
			
	

}
