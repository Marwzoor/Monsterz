package me.martinwerner.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import me.martinwerner.Monsterz;

public class ItemManager {

	private static List<Item> items = new ArrayList<Item>();
	
	public static void loadItems() {
		InputStream in = Monsterz.class.getResourceAsStream("/assets/configuration/items.json");
		
		BufferedReader reader = null;
		
		try {
			reader = new BufferedReader(new InputStreamReader(in));
			
			String dataString = "";
			String line = "";
			
			while((line = reader.readLine()) != null) {
				dataString += line;
			}
						
			JSONArray itemList = (JSONArray) new JSONTokener(dataString).nextValue();
			
			for(int i=0;i<itemList.length();++i) {
				JSONObject item = (JSONObject) itemList.get(i);
				
				items.add(new Item(item.getString("name")));
			}
			
			reader.close();
		} catch(IOException exception) {
			
		}
	}
	
	public static Item getRandomItem() {	
		return new Item((Item) items.get((int) Math.floor(Math.random() * items.size())));
	}
	
}
