package me.martinwerner.util;

import java.awt.Color;

import me.martinwerner.gui.GUIManager;

public class TextUtil {
	
	public static void displayText(String text) {
		// System.out.print(text + TextColor.RESET);
		GUIManager.print(text);
	}
	
	public static void displayTextLine(String text) {
		// System.out.println(text + TextColor.RESET);
		GUIManager.printLine(text);
	}
	
	public static void displayTextLine(String text, Color color) {
		// System.out.println(text + TextColor.RESET);
		GUIManager.printLine(text, color);
	}
	
}
