package controller;

public class ThreadSoma extends Thread {
	
	private int[] vetor;
	private int tempo;
	public ThreadSoma(int[] vetor, int tempo) {
		this.vetor = vetor;
		this.tempo = tempo;
	}
	
	@Override
	public void run() {
		soma(vetor, tempo);
	}

	private void soma(int[] vetor, int tempo) {
		int bloqueio = tempo * 1000;
		try {
			sleep(bloqueio);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int soma = 0;
		for(int i = 0; i <= vetor.length - 1; i++) {
			soma = soma + vetor[i];
		}
		System.out.println("#" +getId() + ": " + soma);
		
	}
}
