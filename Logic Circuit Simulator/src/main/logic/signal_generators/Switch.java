package main.logic.signal_generators;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.Main;
import main.gui.ComponentImages;
import main.logic.CircuitComponent;

public class Switch extends CircuitComponent {
	
	public static BufferedImage activeImage = ComponentImages.SwitchActiveImage;
	public static BufferedImage inactiveImage = ComponentImages.SwitchInactiveImage;
	
	public Switch(int x, int y) {
		
		level = 0;
		this.x = x;
		this.y = y;
		
		output = false;
		
		image = ComponentImages.SwitchInactiveImage;
		
		width = this.image.getWidth();
		height = this.image.getHeight();
		
		outputX = x + width;
		outputY = y + height / 2;
		
	}
	
	@Override
	public boolean output() {
		
		if(output == true) {
			image = activeImage;
		}else {
			image = inactiveImage;
		}
		
		return output;
	}
	
	@Override
	public void clicked() {
		
		System.out.println("A switch is clicked");
		output = !output;
		output();
		Main.window.circuitPanel.renderImage();
	
	}
	
	@Override
	public void display(Graphics2D g) {
		
		if(output) {
			g.drawImage(activeImage, x, y, null);
		}else {
			g.drawImage(inactiveImage, x, y, null);
		}
		
	}
	
	@Override
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
		outputX = x + width;
		outputY = y + height / 2;
		
	}

}
