package controller;

import model.PosicaoCarro;

public class Ordena{

	public Ordena() {
		super();
	}
	
	public PosicaoCarro[] ordenacao(PosicaoCarro[] posicao) {
		int tamanho = 13;
		for(int i=0; i < tamanho; i++) {
			for(int j=0; j< tamanho; j++) {
				if(posicao[j].maiorTempo > posicao[j+1].maiorTempo) {
					PosicaoCarro aux = new PosicaoCarro();
					aux = posicao[j+1];
					posicao[j+1] = posicao[j];
					posicao[j] = aux;
				}
			}
		}
		return posicao;
	}
}
