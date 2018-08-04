package me.martinwerner;

import java.awt.Color;

import me.martinwerner.command.Command;
import me.martinwerner.command.CommandManager;
import me.martinwerner.command.DropCommand;
import me.martinwerner.command.LookCommand;
import me.martinwerner.command.MapCommand;
import me.martinwerner.command.MoveCommand;
import me.martinwerner.command.PickupCommand;
import me.martinwerner.command.QuitCommand;
import me.martinwerner.command.StatsCommand;
import me.martinwerner.entity.Item;
import me.martinwerner.entity.ItemManager;
import me.martinwerner.entity.Player;
import me.martinwerner.gui.GUIManager;
import me.martinwerner.util.TextUtil;

public class Monsterz {
	
	private static GameMap gameMap;
	private static Player player;
	
	public static void main(String[] args) {
		registerCommands();
		
		setupMap();
		
		GUIManager.prepareGUI();
		
		TextUtil.displayTextLine("=== Welcome to Monsterz (Beta) ===", Color.RED);
		TextUtil.displayTextLine("In this interactive game, you will scout your way through the map and find a lot of exciting things.", Color.RED);
		TextUtil.displayTextLine("Good luck!", Color.RED);
	}
	
	public static GameMap getMap() {
		return gameMap;
	}
	
	public static void setupMap() {
		int mapXSize = 20;
		int mapYSize = 10;
		
		gameMap = new GameMap(mapXSize, mapYSize);
		
		player = new Player(100, 20);
		
		Tile playerTile = gameMap.getRandomTile();
				
		player.move(playerTile);
		
		spawnItems();
	}
	
	public static void spawnItems() {
		ItemManager.loadItems();
		
		int itemsToSpawn = 2 + (int) Math.floor(Math.random() * 5);
		
		for(int i=0;i<itemsToSpawn;++i) {
			Tile tile = gameMap.getRandomTile();
			Item newItem = ItemManager.getRandomItem();
			
			newItem.move(tile);
		}
	}
	
	public static void handleCommand(String line) {
		String fullCommand[] = line.trim().split(" ");
		
		if(fullCommand.length <= 0) {
			TextUtil.displayTextLine("You try to make a sound, but the words won't come out...");
		} else {
			Command command = CommandManager.getCommandByName(fullCommand[0]);
			
			if(command != null) {
				String args[] = new String[fullCommand.length - 1];
								
				for(int i=0;i<fullCommand.length;++i) {
					if(i == 0) {
						continue;
					}
										
					args[i-1] = fullCommand[i].trim();
				}
				
				// Proceed to next turn if this command is an action
				if(command.willEndTurn() && command.execute(args)) {
					nextTurn();
				}
				
				GUIManager.refreshMap();
				GUIManager.refreshInventory();
			} else {
				TextUtil.displayTextLine("Now you're just talking jibberish!");
			}
		}
	}
	
	public static void nextTurn() {
		// TODO Move monster(s) and other stuff
	}
	
	public static void registerCommands() {
		CommandManager.registerCommand(new MoveCommand());
		CommandManager.registerCommand(new StatsCommand());
		CommandManager.registerCommand(new QuitCommand());
		CommandManager.registerCommand(new MapCommand());
		CommandManager.registerCommand(new LookCommand());
		CommandManager.registerCommand(new PickupCommand());
		CommandManager.registerCommand(new DropCommand());
	}
	
	public static Player getPlayer() {
		return player;
	}
}
