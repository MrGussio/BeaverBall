package nl.gussio.beaverball.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import nl.gussio.beaverball.BeaverBall;
import nl.gussio.beaverball.screen.GameScreen;
import nl.gussio.beaverball.screen.ScreenManager;

public class Ball extends Entity {

	public Vector2 velocity;
	
	public Rectangle collision;
	public int speed = 10;
	public Sprite texture;
	public Ball(int x, int y) {
		super(x, y);
		texture = new Sprite(new Texture(Gdx.files.internal("ball.png")));
		velocity = new Vector2(0, speed);
		collision = new Rectangle(x,y,texture.getWidth(), texture.getHeight());
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.draw(texture, location.x, location.y, texture.getTexture().getWidth(), texture.getTexture().getHeight());
	}

	@Override
	public void update() {
			collision.x = location.x + velocity.x;
			collision.y = location.y + velocity.y;
			if(doesCollideWithPlayer()){
				collision.x = -location.x - velocity.x;
				collision.y = -location.y - velocity.y;
			}
			
			location.x += velocity.x;
			location.y += velocity.y;
		
		if(location.y > Gdx.graphics.getHeight()-texture.getHeight()){
			velocity.y *= -1;
		}
		
		if(location.x < 0){
			velocity.x *= -1;
		}

		if(location.x > Gdx.graphics.getWidth()-texture.getWidth()){
			velocity.x *= -1;
		}
		
		if(location.y < 0){
			BeaverBall.gameOver();
		}
	}
	
	private boolean doesCollideWithPlayer() {
		if(ScreenManager.getStaticScreen() instanceof GameScreen){
			GameScreen gs = (GameScreen) ScreenManager.getStaticScreen();
			for(Entity e : gs.em.entities){
				if(e instanceof Player){
					Player p = (Player) e;
					if(p.collision.overlaps(collision)){
						float relativeIntersectX = (p.location.x + (p.texture.getTexture().getWidth()/2));
						float normalIntersectX = (relativeIntersectX/(p.texture.getTexture().getWidth()/2));
						float angle = normalIntersectX * 75;
						velocity.x = (float) (speed *  Math.cos(angle));
						velocity.y = (float) (speed *  Math.sin(angle));
						return true;
					}
				}
			}
		}
		
		return false;
		
	}

	@Override
	public void dispose() {
		texture.getTexture().dispose();
	}

	@Override
	public void create() {
		
	}

}
