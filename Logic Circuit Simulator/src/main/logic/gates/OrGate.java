package main.logic.gates;

import main.gui.ComponentImages;
import main.logic.CircuitComponent;

public class OrGate extends Gate {
	
	public CircuitComponent[] inputComponents = new CircuitComponent[2];
	
	public OrGate(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		
		image = ComponentImages.ORImage;
		
		width = this.image.getWidth();
		height = this.image.getHeight();
		
		super.inputComponents = this.inputComponents;
		
		outputX = x + width;
		outputY = y + height / 2;
		
	}

	public boolean output() {
		
		if(inputComponents[0] != null) {
			input1 = inputComponents[0].output();
		}
		
		if(inputComponents[1] != null) {
			input2 = inputComponents[1].output();
		}

		output = input1 || input2;
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
