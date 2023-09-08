package view;


import controller.ThreadSoma;

public class Main {

	public static void main(String[] args) {
		int[][] matriz = new int[3][5];
		int[] vetor = new int[5];
		int t = 1;
		for (int i = 0; i < 3; i++) {
			for(int j = 0; j <5; j++) {
				double num = Math.random() * 100 + 1;
				matriz[i][j] = (int)num;
				vetor[j] = (int)num;
			}
			
			Thread TSoma = new ThreadSoma(vetor, t);
			t++;
			TSoma.start();
		}
		
	}

}
