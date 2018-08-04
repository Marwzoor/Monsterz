package me.martinwerner.command;

import me.martinwerner.Monsterz;
import me.martinwerner.util.TextUtil;

public class MoveCommand extends Command {
	
	public MoveCommand() {
		super("move", true);
	}

	public boolean execute(String args[]) {
		if(args.length < 1) {
			TextUtil.displayTextLine("Where do you wanna go?");
			return false;
		}

		String direction = args[0].toLowerCase();
		
		int moveX = 0;
		int moveY = 0;
		
		switch(direction) {
			case "up":
				moveY -= 1;
				break;
			
			case "down":
				moveY += 1;
				break;
				
			case "left":
				moveX -= 1;
				break;
				
			case "right":
				moveX += 1;
				break;
		}
		
		if(!Monsterz.getPlayer().move(moveX, moveY)) {
			TextUtil.displayTextLine("I'm sorry but you can't move that way.");
			return false;
		}
		
		return true;
	}
	
}
