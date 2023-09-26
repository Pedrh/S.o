package controller;

import java.util.concurrent.Semaphore;

//import libQuickSort.QuickSort;
import model.PosicaoCarro;

public class Formula1 extends Thread {
	private Semaphore semaforoEscuderia;
	private Semaphore semaforoPista;
	private int idCarro;
	private int Escuderia;
	public static PosicaoCarro[] posicao = new PosicaoCarro[14];
		
//	QuickSort<Double> quickSort = new QuickSort<>();
	
	public Formula1(int idCarro, int Escuderia, Semaphore semaforoEscuderia, Semaphore semaforoPista) {
		this.semaforoEscuderia = semaforoEscuderia;
		this.semaforoPista = semaforoPista;
		this.idCarro = idCarro;
		this.Escuderia = Escuderia+1;
	}
	
	@Override
	public void run() {
		try {
//			---------------------Inicio da Secao Critica ----------------------------
			semaforoEscuderia.acquire();
			semaforoPista.acquire();
			carroNaPista();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
//			-----------------------Fim da Secao Critica -----------------------------
			semaforoEscuderia.release();
			semaforoPista.release();
			if(idCarro == 13) {
				qualificacao();
			}
		}
		
		
	}

	

	private void carroNaPista() {
		try {
		double aux = 0;
		System.out.println("#"+idCarro +" da "+ Escuderia+"º escuderia, entrou na pista");
		for(int i = 1; i <4; i++) {
			double tempo = (double)(Math.random() * 30001) + 70000 ; // tempo entre 2 e 5 segundos
			tempo /=1000;
			System.out.printf("#%d levou %2.2fs para dar a sua %dª volta\n", idCarro, tempo, i);
			if(aux < tempo) {
				aux = tempo;
			}
		}
		posicao[idCarro] = new PosicaoCarro(idCarro, aux);
		System.out.println("#"+idCarro+" saiu da escuderia");
		}catch(Exception e) {
		}
	}

	
	private void qualificacao() {
	    try {
	        sleep(2000);
	        int tamanho = 14;
		    ordenacao(posicao, tamanho);
		    sleep(2000);
	    } catch (InterruptedException e) {
	        e.printStackTrace();
	    } finally {
	    	for(int cont = 0; cont < 14 ; cont++) {
	    		System.out.println(posicao + ", ");
	    	}
	    }
	    
	    
	}	
	
	public PosicaoCarro[] ordenacao(PosicaoCarro[] posicao, int tamanho) {
		
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
