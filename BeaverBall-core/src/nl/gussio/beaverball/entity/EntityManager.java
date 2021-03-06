package nl.gussio.beaverball.entity;

import java.util.concurrent.CopyOnWriteArrayList;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class EntityManager {
	
	public CopyOnWriteArrayList<Entity> entities = new CopyOnWriteArrayList<Entity>();
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	public void removeEntity(Entity e){
		entities.remove(e);
	}
	
	public Entity getEntity(int id){
		return entities.get(id);
	}
	
	public void updateEntities(){
		for(Entity e : entities){
			e.update();
		}
		
	}
	
	public void renderEntities(SpriteBatch sb){
		for(Entity e: entities){
			e.render(sb);
		}
	}
	
	public void disposeTextures(){
		for(Entity e : entities){
			e.dispose();
		}
	}
}
