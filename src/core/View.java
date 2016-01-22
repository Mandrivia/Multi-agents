package core;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;


public abstract class View implements Observer 	{

	protected JPanel panel;
	protected JFrame frame;
	protected int cellSize;
	
	public View(int gridSize,int cellSize, String name) {

		this.frame = new JFrame(name);
		this.frame.setResizable(false);
		this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.frame.setVisible(true);
		
		this.cellSize = cellSize;
		
		this.panel = new JPanel();
		this.panel.setPreferredSize(new Dimension(gridSize,gridSize));
		this.panel.setBackground(Color.white);
		
		this.frame.setContentPane(this.panel);
		this.frame.pack();
	}
	
	public void update(Observable arg0, Object arg1) {
		SMA sma = (SMA)arg0;
		Graphics g = this.panel.getGraphics();
		panel.paint(g);
		for(Agent a : sma.getAgents()) {
			draw(a, g);
		}
		 this.frame.setVisible(true);
		
	}
	
	public abstract void draw(Agent a, Graphics g);
	


		
}