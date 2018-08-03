package me.martinwerner;

import java.util.ArrayList;
import java.util.List;

import me.martinwerner.entity.Entity;
import me.martinwerner.entity.LivingEntity;

public class Tile {
	
	/**
	 * Location of the Tile, unmovable
	 */
	private final Location loc;
	private List<Entity> entities;
	private GameMap gameMap;
	
	public Tile(GameMap gameMap, Location loc) {
		this.gameMap = gameMap;
		this.loc = loc;
		
		this.entities = new ArrayList<Entity>();
	}
	
	public GameMap getGameMap() {
		return this.gameMap;
	}
	
	public Location getLocation() {
		return this.loc;
	}
	
	public List<Entity> getEntities() {
		return this.entities;
	}
	
	public List<LivingEntity> getLivingEntities() {
		List<LivingEntity> livingEntities = new ArrayList<LivingEntity>();
		
		for(Entity entity : this.entities) {
			if(entity instanceof LivingEntity) {
				livingEntities.add((LivingEntity) entity);
			}
		}
		
		return livingEntities;
	}
	
	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}
	
	public void removeEntity(Entity entity) {
		this.entities.remove(entity);
	}
	
}
