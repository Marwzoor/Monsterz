package me.martinwerner.gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

import me.martinwerner.Monsterz;

public class GUIManager implements KeyListener {
	
	private static JFrame mainFrame;
	private static JTextPane consolePrompt;
	private static JScrollBar consoleScrollBar;
	private static JTextField consoleInput;
	private static JTextPane mapPane;
	private static JTextPane inventoryPane;

	public static void prepareGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
	    mainFrame = new JFrame("Monsterz");
	    mainFrame.setLayout(new GridBagLayout());
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.fill = GridBagConstraints.BOTH;
	  
	    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel consolePanel = new JPanel();
	    consolePanel.setLayout(new BoxLayout(consolePanel, BoxLayout.Y_AXIS));
	
	    consolePrompt = new JTextPane();
	    consolePrompt.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
	    consolePrompt.setEditable(false);
	    consolePrompt.setText("");
	    
	    JScrollPane consoleScroll = new JScrollPane(consolePrompt);
	    consoleScroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	    consoleScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    consoleScroll.setBorder(new EmptyBorder(5, 5, 5, 5));
	    
	    consoleScrollBar = consoleScroll.getVerticalScrollBar();
	    	    
	    consolePanel.add(consoleScroll);
	    	    	    
	    consoleInput = new JTextField();
	    consoleInput.setMaximumSize(new Dimension(Integer.MAX_VALUE, consoleInput.getPreferredSize().height));
	    
	    consoleInput.addKeyListener(new GUIManager());
	    
	    consolePanel.add(consoleInput);
	    
	    gbc.weightx = 0.8;
	    gbc.weighty = 1;
	    
	    mainFrame.add(consolePanel, gbc);
	    
	    gbc.weightx = 0.2;
	    
	    JPanel sidebarPanel = new JPanel();
	    sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
	    
	    mapPane = new JTextPane();
	    mapPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
	    mapPane.setEditable(false);
	    mapPane.setText(Monsterz.getMap().getMapDisplay());
	    
	    sidebarPanel.add(mapPane);
	    
	    inventoryPane = new JTextPane();
	    inventoryPane.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
	    inventoryPane.setEditable(false);
	    inventoryPane.setText(Monsterz.getPlayer().getInventory().getInventoryDisplay());
	    
	    sidebarPanel.add(inventoryPane);
	    
	    mainFrame.add(sidebarPanel, gbc);
	    	    
	    mainFrame.pack();
	    
	    mainFrame.setVisible(true);
	    mainFrame.setSize(800, 600);
	    mainFrame.setLocationRelativeTo(null);
	}
	
	public static void printLine(String line, Color color) {
		MutableAttributeSet as = new SimpleAttributeSet(consolePrompt.getInputAttributes());
		StyleConstants.setForeground(as, color);
		
		try {
			consolePrompt.getStyledDocument().insertString(consolePrompt.getDocument().getLength(), line + "\n", as);
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		consoleScrollBar.setValue(consoleScrollBar.getMaximum());
	}
	
	public static void printLine(String line) {
		try {
			consolePrompt.getStyledDocument().insertString(consolePrompt.getDocument().getLength(), line + "\n", consolePrompt.getInputAttributes());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		consoleScrollBar.setValue(consoleScrollBar.getMaximum());
	}
	
	public static void print(String line) {
		try {
			consolePrompt.getStyledDocument().insertString(consolePrompt.getDocument().getLength(), line, consolePrompt.getInputAttributes());
		} catch (BadLocationException e) {
			e.printStackTrace();
		}
		
		consoleScrollBar.setValue(consoleScrollBar.getMaximum());
	}
	
	@Override
    public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			if(e.getComponent().equals(consoleInput)) {
				String inputText = consoleInput.getText();
				
				printLine(inputText, Color.CYAN);
				
				Monsterz.handleCommand(inputText);
				
				consoleInput.setText("");
			}
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {}
	
	public static void refreshMap() {
		mapPane.setText(Monsterz.getMap().getMapDisplay());
	}
	
	public static void refreshInventory() {
		inventoryPane.setText(Monsterz.getPlayer().getInventory().getInventoryDisplay());
	}
	
}
