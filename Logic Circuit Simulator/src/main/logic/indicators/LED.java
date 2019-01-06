package main.logic.indicators;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.gui.ComponentImages;
import main.logic.CircuitComponent;

public class LED extends CircuitComponent {
	
	public static BufferedImage activeImage = ComponentImages.ActiveLEDImage;
	public static BufferedImage inactiveImage = ComponentImages.InactiveLEDImage;
	
	public CircuitComponent[] inputComponents = new CircuitComponent[1];
	
	public LED(int x, int y) {
		
		super();
		this.x = x;
		this.y = y;
		image = inactiveImage;
		
		this.width = image.getWidth();
		this.height = image.getHeight();
		super.inputComponents = this.inputComponents;
		
	}

	@Override
	public boolean output() {
		
		output = inputComponents[0].output;
		return output;
	
	}

	@Override
	public void clicked() {
		
		System.out.println("An LED is clicked  " + output);
	
	}
	
	@Override
	public void display(Graphics2D g) {
		
		if(output) {
			g.drawImage(activeImage, x, y, null);
		}else {
			g.drawImage(inactiveImage, x, y, null);
		}
		
		super.displayWires(g);
		
	}
	
	@Override
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
}
