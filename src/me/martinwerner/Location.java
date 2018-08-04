package me.martinwerner;

public class Location {

	private int x, y;
	
	public Location(Location loc) {
		this.x = loc.getX();
		this.y = loc.getY();
	}
	
	public Location(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getX() {
		return this.x;
	}
	
	public boolean equals(Location loc) {
		return (this.getX() == loc.getX() && this.getY() == loc.getY());
	}
	
	public String toString() {
		return "Loc X: "  + this.getX()
			+ ", Loc Y: " + this.getY();
	}
	
	
	
}
