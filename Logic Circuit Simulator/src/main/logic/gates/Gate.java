package main.logic.gates;

import main.logic.CircuitComponent;

public class Gate extends CircuitComponent {

	public Gate() {
		
		input1 = false;
		input2 = false;
		output = false;
		
	}

	@Override
	public boolean output() {
		return output;
	}

	@Override
	public void clicked() {
		
	}
	
}
