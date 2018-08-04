package me.martinwerner.command;

import me.martinwerner.Monsterz;
import me.martinwerner.Tile;
import me.martinwerner.entity.Item;
import me.martinwerner.entity.Player;
import me.martinwerner.util.TextUtil;

public class DropCommand extends Command {

	public DropCommand() {
		super("drop", false);
	}

	public boolean execute(String args[]) {
		Tile tile = Monsterz.getPlayer().getCurrentTile();
		
		if(args.length < 1) {
			TextUtil.displayTextLine("Which item do you want to drop?");
			return false;
		}
		
		Player player = Monsterz.getPlayer();
		
		if(player.getInventory().getItems().length > 0) {
			int itemToDrop = Integer.parseInt(args[0]);
			
			if(itemToDrop < 1 || itemToDrop > player.getInventory().getItems().length) {
				TextUtil.displayTextLine("That number does not represent an item.");
				return false;
			} else {
				Item item = player.getInventory().getItems()[itemToDrop - 1];
				
				tile.addEntity(item);
				Monsterz.getPlayer().getInventory().removeItem(item);
				TextUtil.displayTextLine("You dropped " + item.getName() + "!");
			}
		} else {
			TextUtil.displayTextLine("You can't drop anything i you don't have anything silly.");
			return false;
		}
		
		return true;
	}
	
}
