package nl.gussio.beaverball.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.FitViewport;

import nl.gussio.beaverball.BeaverBall;
import nl.gussio.beaverball.entity.Ball;
import nl.gussio.beaverball.entity.Coin;
import nl.gussio.beaverball.entity.Entity;
import nl.gussio.beaverball.entity.EntityManager;
import nl.gussio.beaverball.entity.Player;

public class GameScreen extends Screen {

	public EntityManager em;
	Sprite background;
	@Override
	public void render(SpriteBatch sb) {
		sb.begin();
		sb.setProjectionMatrix(camera.combined);
		sb.draw(background, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		em.renderEntities(sb);
		
		sb.end();
	}

	@Override
	public void update() {
		em.updateEntities();
		camera.update();
	}

	@Override
	public void dispose() {
		em.disposeTextures();
	}

	@Override
	public void create() {
		camera = new OrthographicCamera();
		viewport = new FitViewport(BeaverBall.GAME_WORLD_WIDTH*BeaverBall.aspectRatio, BeaverBall.GAME_WORLD_HEIGHT, camera);

		camera.position.set(BeaverBall.GAME_WORLD_WIDTH/2f, BeaverBall.GAME_WORLD_HEIGHT/2f, 0);
		viewport.apply();
		camera.update();
		em = new EntityManager();
		em.addEntity(new Ball((int) (camera.viewportWidth/2), 600));
		em.addEntity(new Player(0, (int) (camera.viewportHeight/100*8)));
		em.addEntity(new Coin((int) (camera.viewportWidth/2), 600, em));
		background = new Sprite(new Texture(Gdx.files.internal("background.png")));
	}

	@Override
	public void resize(int width, int height, float aspectRatio) {
		camera.viewportWidth = width;
	    camera.viewportHeight = height;
	    
	    aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();
	    camera.position.set(width/2f, height/2f, 0);
	}

	@Override
	public void handleKey(float x, float y) {
			for(Entity e : em.entities){
				if(e instanceof Player){
					Player p = (Player) e;
					if(x < Gdx.graphics.getWidth()/2){
						p.setVelX(-10);
						p.flip(1);
					}else{
						p.setVelX(10);
						p.flip(0);
					}
				}
			}
		
	}

}
