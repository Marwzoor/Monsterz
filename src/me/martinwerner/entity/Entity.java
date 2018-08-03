package me.martinwerner.entity;
import me.martinwerner.Location;
import me.martinwerner.Tile;

public abstract class Entity {
	private Location loc;
	private Tile currentTile = null;
	
	public Location getLocation() {
		return this.loc;
	}
	
	public void setLocation(Location loc) {
		this.loc = loc;
	}
	
	public void move(Tile tile) {		
		if(this.currentTile != null) {
			this.currentTile.removeEntity(this);
		}
		
		tile.addEntity(this);
		
		this.loc = tile.getLocation();
		this.currentTile = tile;
	}
	
	public boolean move(Location loc) {
		int newX = loc.getX();
		int newY = loc.getY();
		
		if(newX < 0) {
			newX = 0;
		} else if(newX > this.currentTile.getGameMap().getSizeX() - 1) {
			newX = this.currentTile.getGameMap().getSizeX() - 1;
		}
		
		if(newY < 0) {
			newY = 0;
		} else if(newY > this.currentTile.getGameMap().getSizeY() - 1) {
			newY = this.currentTile.getGameMap().getSizeY() - 1;
		}
		
		if(this.getLocation().equals(new Location(newX, newY))) {
			return false;
		}
		
		Tile tile = this.currentTile.getGameMap().getTileAtLocation(new Location(newX, newY));
		
		this.move(tile);
		
		return true;
	}
	
	public boolean move(int xTiles, int yTiles) {
		int newX = this.getLocation().getX() + xTiles;
		int newY = this.getLocation().getY() + yTiles;
		
		return this.move(new Location(newX, newY));
	}
}
