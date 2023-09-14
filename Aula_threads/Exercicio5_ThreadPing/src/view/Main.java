package view;

import controller.ThreadPing;

public class Main {

	
	public static void main(String[] args) {
		String[] processo = {"google", "oul", "terra"};
		for(int i = 0; i<3; i++) {
			Thread Ping = new ThreadPing(processo, i);
			Ping.start();
		}
		
	}

}
