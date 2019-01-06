package main.logic.gates;

import main.logic.CircuitComponent;

public class AndGate extends Gate {
	
	public CircuitComponent[] inputComponents = new CircuitComponent[2]; 
	
	public AndGate(int x, int y) {
		
		super();
		this.x = x;
		this.y = y;
		
		image = main.gui.ComponentImages.ANDImage;
		
		this.width = image.getWidth();
		this.height = image.getHeight();
		super.inputComponents = this.inputComponents;
		
		outputX = x + width;
		outputY = y + height / 2;
		
	}
	
	@Override
	public boolean output() {
		
		if(inputComponents[0] != null) {
			input1 = inputComponents[0].output();
		}
		
		if(inputComponents[1] != null) {
			input2 = inputComponents[1].output();
		}
		
		output = input1 && input2;
		return output;
		
	}
	
	@Override
	public void setLocation(int x, int y) {
		
		this.x = x;
		this.y = y;
		outputX = x + width;
		outputY = y + height / 2;
		
	}
}
