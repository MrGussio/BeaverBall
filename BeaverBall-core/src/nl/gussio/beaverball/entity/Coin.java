package nl.gussio.beaverball.entity;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import nl.gussio.beaverball.CurrencyManager;
import nl.gussio.beaverball.screen.GameScreen;
import nl.gussio.beaverball.screen.ScreenManager;

public class Coin extends Entity {

	public Sprite texture;
	public Rectangle collision;
	public EntityManager em;
	
	public Coin(int x, int y, EntityManager em) {
		super(x, y);
		texture = new Sprite(new Texture(Gdx.files.internal("coin.png")));
		collision = new Rectangle(x,y,texture.getTexture().getWidth(), texture.getTexture().getHeight());
		this.em = em;
	}

	@Override
	public void render(SpriteBatch sb) {
		sb.draw(texture, location.x, location.y);
	}

	@Override
	public void update() {
		if(collides()){
			CurrencyManager.addCoin();
			em.removeEntity(this);
		}
	}

	@Override
	public void dispose() {
		
	}

	@Override
	public void create() {
		
	}
	
	private boolean collides() {
		if(ScreenManager.getStaticScreen() instanceof GameScreen){
			GameScreen gs = (GameScreen) ScreenManager.getStaticScreen();
			for(Entity e : gs.em.entities){
				if(e instanceof Player){
					Player p = (Player) e;
					if(p.collision.overlaps(collision)){
						return true;
					}
				}
				
				if(e instanceof Ball){
					Ball b = (Ball) e;
					if(b.collision.overlaps(collision)){
						return true;
					}
				}
			}
		}
		
		return false;
	}

}
