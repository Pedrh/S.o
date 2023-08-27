package controller;

public class OperacoesController {

	public static void main(String[] args) {
		int vet[] = new int[100000];
		int i;
		for (i = 0; i < 100000; i++) {
			vet[i] = 0;
		}
		//desempenho com 1000
		double TempoInicial = System.nanoTime();
		for (i = 0; i < 1000; i++) {
			vet[i] = 0;
		}
		double TempoFinal = System.nanoTime();
		double tempoTotal = TempoFinal - TempoInicial;
		
		

		System.out.println("Tempo total para 1000 posições: " + tempoTotal + "ns.");
		
		//desempenho com 10000
		double TempoInicial2 = System.nanoTime();
		for (i = 0; i < 10000; i++) {
			vet[i] = 0;
		}
		double TempoFinal2 = System.nanoTime();
		double tempoTotal2 = TempoFinal2 - TempoInicial2;
		tempoTotal = tempoTotal / Math.pow(10, 9);
		

		System.out.println("Tempo total para 10000 posições: " + tempoTotal2 + "s.");
		
		//desempenho com 100000
				double TempoInicial3 = System.nanoTime();
				for (i = 0; i < 100000; i++) {
					vet[i] = 0;
				}
				double TempoFinal3 = System.nanoTime();
				double tempoTotal3 = TempoFinal3 - TempoInicial3;
				tempoTotal = tempoTotal / Math.pow(10, 9);
				

				System.out.println("Tempo total para 10000 posições: " + tempoTotal3 + "s.");
	}
}