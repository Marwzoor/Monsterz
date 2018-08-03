package me.martinwerner.entity;

public abstract class LivingEntity extends Entity {

	private int health;
	private int damage;
	
	public LivingEntity(int health, int damage) {
		this.health = health;
		this.damage = damage;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getDamage() {
		return this.damage;
	}
	
	public void setDamage(int damage) {
		this.damage = damage;
	}
	
	public void damage(LivingEntity entity) {
		entity.damage(this.damage);
	}
	
	public void damage(int damage) {
		this.health -= damage;
	}
	
}
