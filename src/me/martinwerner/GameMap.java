package me.martinwerner;

import java.util.HashSet;
import java.util.Set;

public class GameMap {

	private int xSize, ySize;
	private Set<Tile> tiles;
	
	public GameMap(int xSize, int ySize) {
		this.tiles = new HashSet<Tile>();
		
		this.xSize = xSize;
		this.ySize = ySize;
		
		for(int x=0;x<xSize;++x) {
			for(int y=0;y<ySize;++y) {
				this.tiles.add(new Tile(this, new Location(x, y)));
			}
		}
	}
	
	public Set<Tile> getTiles() {
		return this.tiles;
	}
	
	public Tile getTileAtLocation(Location loc) {		
		for(Tile tile : this.tiles) {					
			if(tile.getLocation().equals(loc)) {
				return tile;
			}
		}
		
		return null;
	}
	
	public Tile getRandomTile() {		
		int tileX = (int) Math.floor(Math.random() * this.xSize);
		int tileY = (int) Math.floor(Math.random() * this.ySize);
		
		return this.getTileAtLocation(new Location(tileX, tileY));
	}
	
	public int getSizeX() {
		return this.xSize;
	}
	
	public int getSizeY() {
		return this.ySize;
	}
	
	public String getMapDisplay() {
		String mapString = "";
		
		mapString += "|";
		
		for(int x=0;x<this.xSize;++x) {
			mapString += "-";
		}
		
		mapString += "|\n";
		
		for(int y=0;y<this.ySize;++y) {
			mapString += "|";
			
			for(int x=0;x<this.xSize;++x) {
				Tile tile = this.getTileAtLocation(new Location(x, y));
								
				if(tile.getLivingEntities().size() > 0) {
					mapString += "x";
				} else {
					mapString += ".";
				}
			}
			
			mapString += "|\n";
		}
		
		mapString += "|";
		
		for(int x=0;x<this.xSize;++x) {
			mapString += "-";
		}
		
		mapString += "|";
		
		return mapString;
	}
}
