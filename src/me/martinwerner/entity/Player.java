package me.martinwerner.entity;

public class Player extends LivingEntity {
	
	private static final int INVENTORY_SLOTS = 10;
	
	private final Inventory inventory;

	public Player(int health, int damage) {
		super(health, damage);
		
		this.inventory = new Inventory(INVENTORY_SLOTS);
	}
	
	public String toString() {
		return "Loc X: " + this.getLocation().getX()
			+ ", Loc Y: " + this.getLocation().getY()
			+ ", Health: " + this.getHealth();
	}
	
	public Inventory getInventory() {
		return this.inventory;
	}
	
}
