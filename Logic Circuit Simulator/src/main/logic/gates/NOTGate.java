package main.logic.gates;

import main.gui.ComponentImages;
import main.logic.CircuitComponent;

public class NOTGate extends Gate {
	
	public CircuitComponent[] inputComponent = new CircuitComponent[1];
	
	public NOTGate(int x, int y) {
		
		super();
		this.x = x;
		this.y = y;
		
		image = ComponentImages.NOTImage;
		
		width = image.getWidth();
		height = image.getHeight();
		
		super.inputComponents = this.inputComponent;
		
		outputX = x + width;
		outputY = y + height / 2;
		
	}
	
	public boolean output(){
		
		if(inputComponent != null) {
			input1 = inputComponent[0].output();
		}
		
		output = !input1;
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
