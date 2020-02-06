package com.psl.training.model;

public class CalculatorService {

	Calculator cal;
	
	
	public Calculator getCal() {
		return cal;
	}


	public void setCal(Calculator cal) {
		this.cal = cal;
	}


	public int performAddition(int x, int y){
		return cal.add(x, y);
	}
	
	public int performDivision(int x,int y) {
		cal.validateArgument();
		return cal.div(x, y);
	}
}
