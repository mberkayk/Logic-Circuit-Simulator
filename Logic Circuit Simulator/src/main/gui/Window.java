package main.gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	private static final long serialVersionUID = 1L;
	
	ToolbarPanel toolbarPanel;
	JPanel arrangerPanel;// To hold the component tree and circuitPanel for the layout
	public CircuitPanel circuitPanel;
	TreePanel treePanel;
	
	public Window(int w, int h) {
		
		super();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(w, h);
		this.setLayout(new BorderLayout());

		this.toolbarPanel = new ToolbarPanel(w, 100);
		this.arrangerPanel = new JPanel(new BorderLayout());
		
		this.treePanel = new TreePanel();
		this.circuitPanel = new CircuitPanel(this.getWidth() - treePanel.getWidth(), h - 100);

		this.add(toolbarPanel, BorderLayout.NORTH);
		
		this.arrangerPanel.add(treePanel, BorderLayout.WEST);
		this.arrangerPanel.add(circuitPanel, BorderLayout.CENTER);
		
		this.add(arrangerPanel, BorderLayout.CENTER);
		
		this.setVisible(true);
		
	}
	
}
