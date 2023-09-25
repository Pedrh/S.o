package controller;

import java.util.concurrent.Semaphore;

public class CruzamentoController extends Thread {

	private int idCarro;
	private static String sentido;
	private static int posicao;
	private Semaphore semaforo;
	
	public CruzamentoController(int idCarro, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			switch(posicao) {
			case 0:
				sentido = "baixo";
				break;
			case 1:
				sentido = "cima";
				break;
			case 2:
				sentido = "esquerda";
				break;
			case 3:
				sentido = "direita";
				break;
			}
			System.out.println("#"+idCarro+" foi o "+ posicao+"º. a cruzar e foi para a "+sentido);
			posicao++;
			sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforo.release();
		}
	}

}
