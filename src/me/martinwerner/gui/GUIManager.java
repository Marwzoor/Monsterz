package me.martinwerner.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUIManager {
	
	private static JFrame mainFrame;

	public static void prepareGUI() {
	    mainFrame = new JFrame("Monsterz");
	    mainFrame.setSize(400, 400);
	    mainFrame.setLayout(new GridLayout(3, 1));
	
	    JLabel headerLabel = new JLabel("Hello", JLabel.CENTER);
	    JLabel statusLabel = new JLabel("Status", JLabel.CENTER);        
	    statusLabel.setSize(350,100);
	  
	    mainFrame.addWindowListener(new WindowAdapter() {
	        public void windowClosing(WindowEvent windowEvent){
	            System.exit(0);
	        }
	    });
	  
	    JPanel controlPanel = new JPanel();
	    controlPanel.setLayout(new FlowLayout());
	
	    mainFrame.add(headerLabel);
	    mainFrame.add(controlPanel);
	    mainFrame.add(statusLabel);
	    mainFrame.setVisible(true); 
	}
	
}
