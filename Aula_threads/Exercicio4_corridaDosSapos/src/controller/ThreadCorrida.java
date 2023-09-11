package controller;

public class ThreadCorrida extends Thread {
	private int Chegada;
	private int sapoNum;
	private int LimitePulo;

	public ThreadCorrida(int Chegada, int sapoNum, int LimitePulo) {
		this.Chegada = Chegada;
		this.sapoNum = sapoNum;
		this.LimitePulo = LimitePulo;
	}
	
	@Override
	public void run() {
		int i=0;
		do {
			int pulo = (int) Math.random() * LimitePulo + 1;
			i += pulo;
			
			System.out.println("O sapo " + sapoNum + " deu um salto de: " + pulo);
		}while(i < Chegada);
	}

}
