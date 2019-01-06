package main.gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import main.Main;
import main.logic.gates.AndGate;
import main.logic.gates.NOTGate;
import main.logic.gates.OrGate;
import main.logic.gates.XORGate;
import main.logic.indicators.LED;
import main.logic.signal_generators.Switch;

public class TreePanel extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	
	JTree componentTree;
	
	public TreePanel() {
		
		componentTree = initTree();
		componentTree.setRootVisible(false);
		
		this.add(componentTree);
		componentTree.addMouseListener(this);
		this.setVisible(true);
		
	}
	
	private JTree initTree() {

		DefaultMutableTreeNode t = new DefaultMutableTreeNode();
		
		DefaultMutableTreeNode category;
		////Gates/////
		category = new DefaultMutableTreeNode("Gates");
		
		category.add(new DefaultMutableTreeNode("AND"));
		category.add(new DefaultMutableTreeNode("OR"));
		category.add(new DefaultMutableTreeNode("NOT"));
		category.add(new DefaultMutableTreeNode("XOR"));
		
		t.add(category);
		/////Signal Generators//////
		category = new DefaultMutableTreeNode("Signal Generators");
		
		category.add(new DefaultMutableTreeNode("Switch"));
		category.add(new DefaultMutableTreeNode("Clock"));
		
		t.add(category);
		/////Indicators////////
		category = new DefaultMutableTreeNode("Indicators");
		
		category.add(new DefaultMutableTreeNode("LED"));
		
		t.add(category);
		
		return new JTree(t);
		
	}

	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(e.getClickCount() >= 2) {
			
			addComponents();
			
		}
		
	}
	

	public void addComponents() {
		switch(this.componentTree.getPathForRow(
				this.componentTree.getSelectionRows()[0]).toString()) {
		
			case "[, Gates, AND]":
	
				Main.window.circuitPanel.cc.add(new AndGate(90, 90));
				Main.window.circuitPanel.renderImage();
				break;
				
			case "[, Gates, OR]":
				Main.window.circuitPanel.cc.add(new OrGate(150, 130));
				Main.window.circuitPanel.renderImage();
				break;
				
			case "[, Gates, XOR]":
				
				Main.window.circuitPanel.cc.add(new XORGate(300, 300));
				Main.window.circuitPanel.renderImage();
				break;
				
			case "[, Gates, NOT]":
				
				Main.window.circuitPanel.cc.add(new NOTGate(0, 300));
				Main.window.circuitPanel.renderImage();
				break;
				
			case "[, Signal Generators, Switch]":
	
				Main.window.circuitPanel.cc.add(new Switch(200, 200));
				Main.window.circuitPanel.renderImage();
				Main.window.circuitPanel.levelArrays.get(0).add(Main.window.circuitPanel.cc.size() -  1);
				break;
				
			case "[, Indicators, LED]":
				Main.window.circuitPanel.cc.add(new LED(400, 0));
				Main.window.circuitPanel.renderImage();
				break;
				
			default:System.out.println(this.componentTree.getPathForRow(
					this.componentTree.getSelectionRows()[0]).toString());
			break;
		}
	}
	
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
