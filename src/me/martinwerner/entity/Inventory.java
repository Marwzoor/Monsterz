package me.martinwerner.entity;

public class Inventory {
	
	private final int slots;
	
	private Item items[];
	
	public Inventory(int slots) {
		this.slots = slots;
		this.items = new Item[this.slots];
	}
	
	public int getSlots() {
		return this.slots;
	}
	
	public void clear() {
		this.items = new Item[this.slots];
	}
	
	public Item[] getItems() {
		return this.items;
	}
	
	public boolean addItem(Item item) {
		int lastIndex = -1;
		
		for(int i=0;i<this.items.length;++i) {
			if(!(this.items[i] instanceof Item)) {
				lastIndex = i;
				break;
			}
		}
		
		if(lastIndex >= 0) {
			this.items[lastIndex] = item;
			return true;
		} else {
			return false;
		}
	}
	
	public void removeItem(int itemSlot) {
		this.items[itemSlot] = null;
	}
	
	public void removeItem(Item item) {
		int indexToRemove = -1;
		
		for(int i=0;i<this.items.length;++i) {
			if(this.items[i].equals(item)) {
				indexToRemove = i;
				break;
			}
		}
		
		if(indexToRemove >= 0) {
			this.removeItem(indexToRemove);
		}
	}
	
	public Item getItem(int itemSlot) {
		return this.items[itemSlot];
	}
	
	public String getInventoryDisplay() {
		String inventoryString = "";
		
		for(int i=0;i<this.items.length;++i) {
			inventoryString += (i + 1) + ". ";
			
			if(this.items[i] instanceof Item) {
				inventoryString += this.items[i].getName();
			} else {
				inventoryString += "(Slot empty)";
			}
			
			inventoryString += "\n";
		}
		
		return inventoryString;
	}
	
}
