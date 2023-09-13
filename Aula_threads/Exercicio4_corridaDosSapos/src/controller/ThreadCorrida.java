package controller;

public class ThreadCorrida extends Thread {
	private int Chegada;
	private int sapoNum;

	public ThreadCorrida(int Chegada, int sapoNum) {
		this.Chegada = Chegada;
		this.sapoNum = sapoNum;
	}
	
	@Override
	public void run() {
		corrida(Chegada, sapoNum);
	}

	

	private void corrida(int chegada, int sapoNum) {
		int i=0;
		try {
			sleep(sapoNum * 1000);
		} catch (InterruptedException e) {
			}
		System.out.print("\nsapo " + sapoNum +"-");
		do {
			
			double pulo = Math.random() * 10 + 1;
			i += (int) pulo;
			System.out.print(" salto: " + (int) pulo + "| ");
		}while(i < chegada);
		
	}
}
