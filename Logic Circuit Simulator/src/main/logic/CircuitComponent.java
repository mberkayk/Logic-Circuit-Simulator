package main.logic;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public abstract class CircuitComponent {
	
	public CircuitComponent[] inputComponents;
	
	public boolean input1;
	public boolean input2;
	public boolean output;
	public int inputCount;
	
	public int outputX, outputY;
	
	public CircuitComponent() {
		input1 = false;
		input2 = false;
		output = false;
		level = -1;
	}

	public int level;
	
	public int x, y;

	public int width;

	public int height;
	
	public abstract boolean output();
	
	public BufferedImage image;
	
	public abstract void clicked();
	
	public void display(Graphics2D g) {
		g.drawImage(this.image, x, y, null);
		this.displayWires(g);
	}
	
	public void setLevel() {
		
		for(int i = 0; i < inputComponents.length; i++) {
			
			if(inputComponents[i] == null) {
				return;
			}
			
		}
		
		int highestInputLevel = 0;
		
		for(int i = 0; i < inputComponents.length; i++) {
			
			if(inputComponents[i].level > highestInputLevel) {
				
				highestInputLevel = inputComponents[i].level;
			
			}
		}
		
		this.level = highestInputLevel + 1;

		if(this.level == main.Main.window.circuitPanel.levelArrays.size()) {
			
			main.Main.window.circuitPanel.levelArrays.add(new ArrayList<Integer>());
			
		}
		
	}

	public void displayWires(Graphics2D g) {

		for(int i = 0; i < inputComponents.length; i++) {
			
			if(inputComponents[i] != null) {
			
				if(inputComponents[i].output == true) {
					g.setColor(new Color(100, 200, 100));
				}else {
					g.setColor(new Color(50, 80, 50));
				}
				
				g.setStroke(new BasicStroke(5));
				g.drawLine(this.x, this.y + 10 + i * height - 10, inputComponents[i].outputX, inputComponents[i].outputY);
			
			}
		}
		
	}

	public void setLocation(int x, int y) {
	}
	
	
}
