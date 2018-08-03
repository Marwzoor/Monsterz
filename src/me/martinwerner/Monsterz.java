package me.martinwerner;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import me.martinwerner.command.Command;
import me.martinwerner.command.CommandManager;
import me.martinwerner.command.MoveCommand;
import me.martinwerner.entity.Player;

public class Monsterz {
	
	private static GameMap gameMap;
	private static Player player;
	
	public static void main(String[] args) {
		registerCommands();
		
		setupMap();
		
		System.out.println("=== Welcome to Monsterz (Beta) ===");
		System.out.println("In this interactive game, you will scout your way through the map and find a lot of exciting things.");
		System.out.println("Good luck!");
		
		try {
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

			String line = in.readLine();

			while (line != null) {
				handleCommand(line);
				line = in.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		
		System.out.println(gameMap.getMapDisplay());
	}
	
	public static void handleCommand(String line) {
		String fullCommand[] = line.split(" ");
		
		if(fullCommand.length <= 0) {
			System.out.println("You try to make a sound, but the words won't come out...");
		} else {
			Command command = CommandManager.getCommandByName(fullCommand[0]);
			
			if(command != null) {
				String args[] = new String[fullCommand.length - 1];
								
				for(int i=0;i<fullCommand.length;++i) {
					if(i == 0) {
						continue;
					}
										
					args[i-1] = fullCommand[i];
				}
				
				// Proceed to next turn if this command is an action
				if(command.willEndTurn() && command.execute(args)) {
					nextTurn();
				}
			} else {
				System.out.println("Now you're just talking jibberish!");
			}
		}
	}
	
	public static void nextTurn() {
		
	}
	
	public static void registerCommands() {
		CommandManager.registerCommand("move", new MoveCommand());
	}
	
	public static Player getPlayer() {
		return player;
	}
}
