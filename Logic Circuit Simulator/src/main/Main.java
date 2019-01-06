package main;

import main.gui.ComponentImages;
import main.gui.Window;

public class Main {
	
	private static final int WIDTH = 1000, HEIGHT = 600;
	
	public static Window window;
	
	public static void main(String[] args) {
		window = new Window(WIDTH, HEIGHT);
		ComponentImages.init();
	}

	public static int getWidth() {
		return WIDTH;
	}

	public static int getHeight() {
		return HEIGHT;
	}
	

}
