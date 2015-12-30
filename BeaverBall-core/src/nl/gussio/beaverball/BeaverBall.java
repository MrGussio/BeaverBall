package nl.gussio.beaverball;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

import nl.gussio.beaverball.entity.Ball;
import nl.gussio.beaverball.entity.Entity;
import nl.gussio.beaverball.screen.GameScreen;
import nl.gussio.beaverball.screen.ScreenManager;

public class BeaverBall extends ApplicationAdapter implements GestureListener {
	public ScreenManager sm;
	public SpriteBatch sb;
	public GameScreen gameScreen;
	public AssetManager am;
	public static final float GAME_WORLD_WIDTH = 720;
	public static final float GAME_WORLD_HEIGHT = 1280;
	public static float aspectRatio;
	public static boolean running = false;
	public Texture splashScreen;
	
	@Override
	public void create () {
		am = new AssetManager();
		am.load("beaver_sideways.png", Texture.class);
		am.load("background.png", Texture.class);
		am.load("ball.png", Texture.class);
		aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();
		sb = new SpriteBatch();
		sm = new ScreenManager();
		gameScreen = new GameScreen();
		sm.setCurrentScreen(gameScreen);
		Gdx.input.setInputProcessor(new GestureDetector(this));	
		System.out.println(Gdx.graphics.getWidth()+", "+Gdx.graphics.getHeight());
		Gdx.graphics.requestRendering();
		running = true;
//		splashScreen = new Texture(Gdx.files.internal("splash.png"));
	}

	@Override
	public void resize(int width, int height){
		aspectRatio = (float) Gdx.graphics.getHeight() / (float) Gdx.graphics.getWidth();
		ScreenManager.getStaticScreen().resize(width, height, aspectRatio);
	}
	
	@Override
	public void render () {
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		if(am.update()){
			Gdx.gl.glClearColor(0, 0, 0, 1);
			Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
			if(sm.getCurrentScreen() != null){
				update();
				sm.getCurrentScreen().render(sb);
			}
		}else{
			
			System.out.println("Still loading...");
		}
	}
	
	public void update(){
		
		if(sm.getCurrentScreen() != null)
			sm.getCurrentScreen().update();
	}
	
	@Override
	public void dispose(){
		if(sm.getCurrentScreen() != null)
			sm.getCurrentScreen().dispose();
		sb.dispose();
	}
	
	public static void gameOver(){
		if(ScreenManager.getStaticScreen() instanceof GameScreen){
			GameScreen gs = (GameScreen) ScreenManager.getStaticScreen();
			for(Entity e : gs.em.entities){
				if(e instanceof Ball){
					gs.em.entities.remove(e);
					break;
				}
			}
		}
	}

	public boolean touchDown(float x, float y, int pointer, int button) {
		if(sm.getCurrentScreen() != null)
			sm.getCurrentScreen().handleKey(x, y);
		return false;
	}

	
	public boolean tap(float x, float y, int count, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean longPress(float x, float y) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean fling(float velocityX, float velocityY, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean panStop(float x, float y, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean zoom(float initialDistance, float distance) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean touchDown(int x, int y, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean tap(int x, int y, int count) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean longPress(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean fling(float velocityX, float velocityY) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean pan(int x, int y, int deltaX, int deltaY) {
		// TODO Auto-generated method stub
		return false;
	}
}
