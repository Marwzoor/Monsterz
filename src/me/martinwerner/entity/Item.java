package me.martinwerner.entity;

public class Item extends Entity {

	private String name;
	
	public Item(String name) {
		this.name = name;
	}
	
	public Item(Item item) {
		this(item.getName());
	}
	
	public String getName() {
		return this.name;
	}
	
}
