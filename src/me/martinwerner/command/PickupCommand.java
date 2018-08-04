package me.martinwerner.command;

import me.martinwerner.Monsterz;
import me.martinwerner.Tile;
import me.martinwerner.entity.Item;
import me.martinwerner.util.TextUtil;

public class PickupCommand extends Command {

	public PickupCommand() {
		super("pickup", false);
	}

	public boolean execute(String args[]) {
		Tile tile = Monsterz.getPlayer().getCurrentTile();
		
		if(args.length < 1) {
			TextUtil.displayTextLine("Which item do you want to pickup?");
			return false;
		}
		
		if(tile.getItems().size() > 0) {
			int itemToPickup = Integer.parseInt(args[0]);
			
			if(itemToPickup < 1 || itemToPickup > tile.getItems().size()) {
				TextUtil.displayTextLine("That number does not represent an item.");
				return false;
			} else {
				Item item = tile.getItems().get(itemToPickup - 1);
				
				tile.removeEntity(item);
				Monsterz.getPlayer().getInventory().addItem(item);
				TextUtil.displayTextLine("You picked up " + item.getName() + "!");
			}
		} else {
			TextUtil.displayTextLine("There are no items here, what are you doing?");
			return false;
		}
		
		return true;
	}
	
}
