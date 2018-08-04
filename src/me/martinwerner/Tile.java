package me.martinwerner;

import java.util.ArrayList;
import java.util.List;

import me.martinwerner.entity.Entity;
import me.martinwerner.entity.Item;
import me.martinwerner.entity.LivingEntity;
import me.martinwerner.entity.Player;

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
	
	public List<Item> getItems() {
		List<Item> items = new ArrayList<Item>();
		
		for(Entity entity : this.entities) {
			if(entity instanceof Item) {
				items.add((Item) entity);
			}
		}
		
		return items;
	}
	
	public List<Player> getPlayers() {
		List<Player> players = new ArrayList<Player>();
		
		for(Entity entity : this.entities) {
			if(entity instanceof Player) {
				players.add((Player) entity);
			}
		}
		
		return players;
	}
	
	public void addEntity(Entity entity) {
		this.entities.add(entity);
	}
	
	public void removeEntity(Entity entity) {
		this.entities.remove(entity);
	}
	
}
