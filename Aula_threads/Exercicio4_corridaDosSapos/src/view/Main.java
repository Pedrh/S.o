package view;

import controller.ThreadCorrida;

public class Main {

	public static void main(String[] args) {
		int sapoNum = 1;
		int chegada = 40;
		int limitePulo = 5;
		
		Thread Tc = new ThreadCorrida(chegada, sapoNum, limitePulo);
		Tc.start();
	}

}
