package me.martinwerner.util;

public class TextUtil {
	
	public static void displayText(String text) {
		System.out.print(text + TextColor.RESET);
	}

	public static void displayTextLine(String text) {
		System.out.println(text + TextColor.RESET);
	}
	
}
