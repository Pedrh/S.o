package view;

import java.util.concurrent.Semaphore;

import controller.CruzamentoController;

public class Main {

	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(1);
		for(int idCarro = 1; idCarro < 5; idCarro++) {
			Thread cruzamento = new CruzamentoController(idCarro, semaforo);
			cruzamento.start();
		}
		
		
	}

}
