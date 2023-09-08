package controller;

public class ThreadSoma extends Thread {
	
	private int[] vetor;
	public ThreadSoma(int[] vetor) {
		this.vetor = vetor;
	}
	
	@Override
	public void run() {
		soma(vetor);
	}

	private void soma(int[] vetor) {
		int soma = 0;
		for(int i = 0; i <= vetor.length - 1; i++) {
			soma = soma + vetor[i];
		}
		System.out.println("#" +getId() + ": " + soma);
		
	}
}
