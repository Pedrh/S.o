package controller;

import java.util.concurrent.Semaphore;

public class PortaController extends Thread {

	private int idPessoa;
	private static int posicaoChegada;
	private Semaphore semaforo;
	
	
	public PortaController(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		percorrerCorredor();
		try {
//			--------------- inicio Seção Crítica -------------------
			semaforo.acquire();
			passarPorta();
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
//			--------------- final Seção Crítica --------------------
			cruzouPorta();
			semaforo.release();
		}
		
	}

	private void percorrerCorredor() {
		int distanciaPercorrida = 0;
		final int DISTANCIACORREDOR  = 200;
		int deslocamento = 0;
		
		while(distanciaPercorrida < DISTANCIACORREDOR) {
			deslocamento = (int) (Math.random() * 3) + 4; 
			distanciaPercorrida += deslocamento;
			System.out.println("Pessoa #"+idPessoa+ " ja andou "+distanciaPercorrida);
		}
		posicaoChegada++;
		System.out.println("Pessoa #"+idPessoa+" foi a " + posicaoChegada+"ª. pessoa a chegar");
	}
	
	private void passarPorta() {
		int tempo = (int) (Math.random() * 2) + 1;
		try {
			sleep(tempo);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void cruzouPorta() {
		System.out.println("Pessoa #"+idPessoa+" cruzou a porta");
	}
}
