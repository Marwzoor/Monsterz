package me.martinwerner.entity;

public class Player extends LivingEntity {

	public Player(int health, int damage) {
		super(health, damage);
	}
	
	public String toString() {
		return "Loc X: " + this.getLocation().getX()
			+ ", Loc Y: " + this.getLocation().getY()
			+ ", Health: " + this.getHealth();
	}
	
}
