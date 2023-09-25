package controller;

import java.util.concurrent.Semaphore;

import model.PosicaoCarro;

public class Formula1 extends Thread {
	private Semaphore semaforoEscuderia;
	private Semaphore semaforoPista;
	private int idCarro;
	private int Escuderia;
	private float[] MelhorTempoCada = new float[14];
	public PosicaoCarro posicaoCarro;
		
	
	
	public Formula1(int idCarro, int Escuderia, Semaphore semaforoEscuderia, Semaphore semaforoPista, PosicaoCarro posicaoCarro) {
		this.semaforoEscuderia = semaforoEscuderia;
		this.semaforoPista = semaforoPista;
		this.idCarro = idCarro;
		this.Escuderia = Escuderia+1;
		this.posicaoCarro = posicaoCarro;
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
		}
//		float[][] MatrizOrdenada = QuickSortMatriz(inicio, fim);
	}

	

	private void carroNaPista() {
		try {
		float aux = 0;
		System.out.println("#"+idCarro+" da "+ Escuderia+"º escuderia, entrou na pista");
		for(int i = 1; i <4; i++) {
			float tempo = (float)(Math.random() * 30001) + 70000 ; // tempo entre 2 e 5 segundos
			tempo /=1000;
			System.out.printf("#%d levou %2.2fs para dar a sua %dª volta\n", idCarro, tempo, i);
			if(aux < tempo) {
				aux = tempo;
			}
		}
		new PosicaoCarro(idCarro, aux);
		System.out.println("#"+idCarro+" saiu da escuderia");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	

	
	
}
