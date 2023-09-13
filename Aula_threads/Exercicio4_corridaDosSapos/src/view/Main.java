package view;

import controller.ThreadCorrida;

public class Main {

	public static void main(String[] args) {
		int sapoNum;
		int chegada = 100;
		int[] colocacao = new int[5];
		
		for(sapoNum = 0; sapoNum <5; sapoNum++) {
			Thread Tc = new ThreadCorrida(chegada, sapoNum+1);
			Tc.start();
		}
		
		
	}

}
