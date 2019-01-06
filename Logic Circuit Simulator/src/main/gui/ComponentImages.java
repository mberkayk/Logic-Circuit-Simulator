package main.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;

public class ComponentImages {

	public static BufferedImage ANDImage, ORImage, NOTImage, XORImage, 
	SwitchInactiveImage, SwitchActiveImage, InactiveLEDImage, ActiveLEDImage;
	
	static Graphics2D g;
	
	public static void init() {
		
		////////////Inactive Switch Image///////////
		SwitchInactiveImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
		g = SwitchInactiveImage.createGraphics();
		
		g.setColor(new Color(125, 125, 125));
		g.fillRect(0, 0, SwitchInactiveImage.getWidth(), SwitchInactiveImage.getHeight());
		g.setColor(Color.black);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 10));
		g.drawString("SWITCH", 0, SwitchInactiveImage.getHeight()/2);
		g.drawString("0", SwitchInactiveImage.getWidth()*2/5, SwitchInactiveImage.getHeight()*7/10);
		
		/////////////Active Switch Image/////////////
		SwitchActiveImage = new BufferedImage(50, 50, BufferedImage.TYPE_INT_RGB);
		g = SwitchActiveImage.createGraphics();
		
		g.setColor(new Color(150, 200, 150));
		g.fillRect(0, 0, SwitchActiveImage.getWidth(), SwitchActiveImage.getHeight());
		g.setColor(Color.black);
		g.setFont(new Font(Font.SERIF, Font.BOLD, 10));
		g.drawString("SWITCH", 0, SwitchActiveImage.getHeight()/2);
		g.drawString("1", SwitchActiveImage.getWidth()*2/5, SwitchActiveImage.getHeight()*7/10);
		
		System.out.println("Component images are initiated");
		
		////////AND GATE///////////////
		try {
			ANDImage = ImageIO.read(new File("assets/AndGateImage.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		////////OR GATE///////////////
		try {
			ORImage = ImageIO.read(new File("assets/OrGateImage.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		////////XOR GATE///////////////
		try {
			XORImage = ImageIO.read(new File("assets/XORGateImage.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		///////////NOT GATE////////////////
		try {
			NOTImage = ImageIO.read(new File("assets/NotGateImage.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//////////INACTIVE LED////////////////
		try {
			InactiveLEDImage = ImageIO.read(new File("assets/InactiveLEDImage.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//////////INACTIVE LED////////////////
		try {
			ActiveLEDImage = ImageIO.read(new File("assets/ActiveLEDImage.png"));
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
