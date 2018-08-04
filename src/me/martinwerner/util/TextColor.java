package me.martinwerner.util;

import java.awt.Color;

public enum TextColor {
	
	RESET ("\u001B[0m", null),
	BLACK ("\u001B[30m", new Color(0, 0, 0)),
	RED ("\u001B[31m", new Color(0, 0, 0)),
	GREEN ("\u001B[32m", new Color(0, 0, 0)),
	YELLOW ("\u001B[33m", new Color(0, 0, 0)),
	BLUE ("\u001B[34m", new Color(0, 0, 0)),
	PURPLE ("\u001B[35m", new Color(0, 0, 0)),
	CYAN ("\u001B[36m", new Color(0, 0, 0)),
	WHITE ("\u001B[37m", new Color(255, 255, 255));
	
	private final String ansiCode;
	private final Color rgbColor;
		
	TextColor(String ansiCode, Color rgbColor) {
		this.ansiCode = ansiCode;
		this.rgbColor = rgbColor;
	}
	
	public String toString() {
		return this.ansiCode;
	}
	
	public Color getRGBColor() {
		return this.rgbColor;
	}
}
