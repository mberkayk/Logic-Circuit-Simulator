package main.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.swing.JPanel;

import main.logic.CircuitComponent;

public class CircuitPanel extends JPanel implements MouseListener {
	
	private static final long serialVersionUID = 1L;
	
	private int gridSize;
	
	BufferedImage image;
	ArrayList<CircuitComponent> cc; // Circuit Components
	
	int mouseDragX, mouseDragY; // integers to keep track of mouse dragging
	int indexOfThePressedCC; // Index of the dragged circuit component, initially -1

	public int activeMode = 0; // 0 = EDIT MODE, 1 = WIRE MODE
	
	int inputComponentIndex = -1;
	
	public ArrayList<ArrayList<Integer>> levelArrays;
	
	public CircuitPanel(int w, int h) {
		
		this.setSize(w, h);
		this.setVisible(true);
		this.addMouseListener(this);
		
		gridSize = 30;
		
		indexOfThePressedCC = -1;
		
		cc = new ArrayList<CircuitComponent>();
		
		image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);//Image of the whole panel
		renderImage();

		levelArrays = new ArrayList<ArrayList<Integer>>();
		levelArrays.add(new ArrayList<Integer>());
		
	}
	
	
	public void renderImage() {
		
		Graphics2D g = image.createGraphics();
		
		//Background
		g.setColor(new Color(60, 50, 70));
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		//Display Grid
		for(int i = 0; i <= this.getHeight() / gridSize; i++) {
			
			for(int j = 0; j <= this.getWidth() / gridSize; j++) {
				
				g.setStroke(new BasicStroke(1));
				g.setColor(Color.black);
				
				g.drawLine(j*gridSize, 0, j*gridSize, this.getHeight());
				g.drawLine(0, i*gridSize, this.getWidth(), i*gridSize);
			
			}
			
		}
		
		//Display all the components
		for(int i = 0; i < cc.size(); i++) {
	
			cc.get(i).display(g);
		
		}
		
		this.repaint();
	
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		g.drawImage(image, 0, 0, null);
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		System.out.println("Mouse is clicked");
		
		if(activeMode == 0) {
			
			mouseClickedMethodEditMode(e);
		
		}else if(activeMode == 1) {
		
			mouseClickedMethodWireMode(e);
		
		}
		
		this.renderImage();
		
	}
	
	private void mouseClickedMethodEditMode(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1) {
			
			int MX = e.getX();
			int MY = e.getY();
			
			System.out.println("X: " + MX + "\nY :" + MY);
			
			for(int i = cc.size() - 1; i >= 0; i--) {
				if(MX >= cc.get(i).x && MX < cc.get(i).x + cc.get(i).image.getWidth()) {
					if(MY >= cc.get(i).y && MY < cc.get(i).y + cc.get(i).image.getHeight()){
						System.out.println("A component is clicked");
						cc.get(i).clicked();
						break;
					}
				}
			}
			
		}
		
	}

	private void mouseClickedMethodWireMode(MouseEvent e) {
		
		if(e.getButton() == MouseEvent.BUTTON1) {
			
			int MX = e.getX();
			int MY = e.getY();
			
			System.out.println("X: " + MX + "\nY :" + MY);
			System.out.println(inputComponentIndex);
			
			if(inputComponentIndex == -1) {
				
				for(int i = cc.size() - 1; i >= 0; i--) {///////////////////
					
					if(checkBounds(MX, MY, cc.get(i))) {
						
						System.out.println("A component is clicked");
						inputComponentIndex = i;
						break;
					
					}
				}
				
			}else {
				
				for(int i = cc.size() - 1; i >= 0; i--) {
					
					if(checkBounds(MX, MY, cc.get(i))) {
						
						System.out.println("A component is clicked");
					
						if(i != inputComponentIndex) {
							
							if(cc.get(i).inputComponents.length > 1) {
								
								if(MY < cc.get(i).y + cc.get(i).height / 2) {
									cc.get(i).inputComponents[0] = cc.get(inputComponentIndex);
								}else {
									cc.get(i).inputComponents[1] = cc.get(inputComponentIndex);
								}
								
								cc.get(i).setLevel();
								if(cc.get(i).level != -1) {
									levelArrays.get(cc.get(i).level).add(i);
								}
								
							}else {
							
								cc.get(i).inputComponents[0] = cc.get(inputComponentIndex);
								cc.get(i).setLevel();
								if(cc.get(i).level != -1) {
									levelArrays.get(cc.get(i).level).add(i);
								}
							
							}
							
						}
						
						inputComponentIndex = -1;
						break;
					
					}
				}
				
			}
		}
			
	}

	

	@Override
	public void mousePressed(MouseEvent e) {

		System.out.println("Mouse is pressed");
		
		if(e.getButton() == MouseEvent.BUTTON1) {
			
			int MX = e.getX();
			int MY = e.getY();
			mouseDragX = MX;
			mouseDragY = MY;
			
			for(int i = cc.size() - 1; i >= 0; i--) {
				if(checkBounds(MX, MY, cc.get(i))) {
					System.out.println("A component is pressed");
					indexOfThePressedCC = i;
					break;
				}
			}
		}
		
	}
	

	@Override
	public void mouseReleased(MouseEvent e) {
		
		int MX = e.getX();
		int MY = e.getY();
		
		if(indexOfThePressedCC != -1) { // -1 indicates no object has been dragged
			
			if((MX - mouseDragX) * (MX - mouseDragX) + (MY - mouseDragY) * (MY - mouseDragY) > 100) { 
				
				
				cc.get(indexOfThePressedCC).setLocation(cc.get(indexOfThePressedCC).x + MX - mouseDragX,
						cc.get(indexOfThePressedCC).y + MY - mouseDragY);
				
				this.renderImage();
				
			}
			
			indexOfThePressedCC = -1; // Resetting the value
			
		}
		
	}

	public void calculateLevel(int i) {
		
		for(int j = 0; j < levelArrays.get(i).size(); j++) {
			
			int index = levelArrays.get(i).get(j);
			
			cc.get(index).output();
			
		}
		
		System.out.println("Level " + i + " is calculated :" + levelArrays.get(i).toString());
		
		this.renderImage();
		
	}
	
	private boolean checkBounds(int x, int y, CircuitComponent cc) {
		
		if(x >= cc.x && x < cc.x + cc.width && y >= cc.y && y < cc.y + cc.height) {
			return true;
		}
		
		return false;
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
