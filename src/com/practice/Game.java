
package com.practice;

public class Game {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Logic lg= new Logic();
		lg.setAmount(41);
		lg.createCircle();
		lg.display();		
		lg.setStart(1);
		lg.setRandom(3);

		lg.go();


	}

}
