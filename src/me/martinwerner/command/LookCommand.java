package me.martinwerner.command;

import me.martinwerner.Monsterz;
import me.martinwerner.Tile;
import me.martinwerner.entity.Item;
import me.martinwerner.util.TextUtil;

public class LookCommand extends Command {

	public LookCommand() {
		super("look", false);
	}

	public boolean execute(String args[]) {
		Tile tile = Monsterz.getPlayer().getCurrentTile();
		
		if(tile.getItems().size() > 0) {
			TextUtil.displayTextLine("Found " + tile.getItems().size() + " items.");
			
			for(int i=0;i<tile.getItems().size();++i) {
				Item item = tile.getItems().get(i);
				TextUtil.displayTextLine((i + 1) + ". " + item.getName());
			}
		}
		
		return true;
	}
	
	
}
