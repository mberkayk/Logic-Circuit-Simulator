package main.gui;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolbarPanel extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	JButton editModeButton;
	JButton wireModeButton;
	JButton calculateButton;

	public ToolbarPanel(int w, int h) {
		
		this.setSize(w, h);
		this.setLayout(new FlowLayout(FlowLayout.LEADING));
		
		this.editModeButton = new JButton("EDIT");
		this.editModeButton.setActionCommand("EDIT MODE");
		this.editModeButton.addActionListener(this);
		this.editModeButton.setEnabled(false);
		this.editModeButton.setVisible(true);
		
		this.wireModeButton = new JButton("WIRE");
		this.wireModeButton.setActionCommand("WIRE MODE");
		this.wireModeButton.addActionListener(this);
		
		this.calculateButton = new JButton("Calculate");
		this.calculateButton.setActionCommand("CALCULATE");
		this.calculateButton.addActionListener(this);
		
		
		this.add(editModeButton);
		this.add(wireModeButton);
		this.add(calculateButton);
		
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("EDIT MODE")) {
			
			main.Main.window.circuitPanel.activeMode = 0;
			main.Main.window.circuitPanel.inputComponentIndex = -1;
			editModeButton.setEnabled(false);
			wireModeButton.setEnabled(true);
			
		}else if(e.getActionCommand().equals("WIRE MODE")) {
			
			main.Main.window.circuitPanel.activeMode = 1;
			editModeButton.setEnabled(true);
			wireModeButton.setEnabled(false);
			
		}else if(e.getActionCommand().equals("CALCULATE")) {
			
			for(int i = 0; i < main.Main.window.circuitPanel.levelArrays.size(); i++) {
				
				main.Main.window.circuitPanel.calculateLevel(i);
			
			}
			
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		//This part is for debugging purposes
//		g.setColor(Color.black);
//		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
	}
	
}
