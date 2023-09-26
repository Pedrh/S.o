package controller;

import java.util.concurrent.Semaphore;

public class CozinhaController extends Thread {

	private int idPrato;
	private Semaphore semaforoEntrega = new Semaphore(1); 
	public CozinhaController(int idPrato) {
		this.idPrato = idPrato;
	}

	
	@Override
	public void run() {
		cozinhar();
		try {
//			-------------------------------Inicio Secao Critica-------------------------------
			semaforoEntrega.acquire();
			entregar();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			semaforoEntrega.release();
		}
		
	}


	private void cozinhar() {
		try {
			if(idPrato % 2 == 0 ) {
				System.out.println("A lasanha a bolonhesa #"+idPrato+" iniciou");
				int percentualCozimento = 0;
				float tempoCozimento = (float)(Math.random() * 600.01)+ 600;
				while(percentualCozimento < 100){
					sleep(100);
					percentualCozimento += tempoCozimento/100;
					if(percentualCozimento > 100) {
						percentualCozimento = 100;
					}
					System.out.println("#"+idPrato+" está "+percentualCozimento+"% cozido");
				}
			}else {
				System.out.println("A sopa de cebola #"+idPrato+" iniciou");
				int percentualCozimento = 0;
				float tempoCozimento = (float)(Math.random() * 300.01)+ 500;
				while(percentualCozimento < 100){
					sleep(100);
					percentualCozimento += tempoCozimento/100;
					if(percentualCozimento > 100) {
						percentualCozimento = 100;
					}
					System.out.println("#"+idPrato+" está "+percentualCozimento+"% cozido");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}


	private void entregar() {
		System.out.println("O prato #"+idPrato+" está pronto!");
		try {
			sleep(500);
		}catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println("O prato #"+idPrato+" foi entregue");
	}
}
