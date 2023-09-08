package controller;

public class ThreadVetor extends Thread {

	private int[] vetor;
	private int num;
	
	public ThreadVetor(int[] vetor, int num) {
		this.vetor = vetor;
		this.num = num;
	}
	
	@Override
	public void run() {
		if(num % 2 == 0) {
			double TempoInicial = System.nanoTime();
			for(int i = 0; i < vetor.length - 1; i++){
				vetor[i] = vetor[i];
			}
			double TempoFinal = System.nanoTime();
			double TempoTotal = TempoFinal - TempoInicial;
			
			TempoTotal = TempoTotal / Math.pow(10, 9);
			System.out.println("O tempo total do número par foi: " + TempoTotal + "s ");
		}else {
			double TempoInicial = System.nanoTime();
			for(int i:vetor){
				vetor[i] = vetor[i];
			}
			double TempoFinal = System.nanoTime();
			double TempoTotal = TempoFinal - TempoInicial;
			
			TempoTotal = TempoTotal / Math.pow(10, 9);
			System.out.println("O tempo total do número impar foi: " + TempoTotal + "s ");
		}
	}

}
