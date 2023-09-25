package view;

import java.util.concurrent.Semaphore;

import controller.PortaController;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforo =new Semaphore(1);
		for(int idPessoa = 1; idPessoa < 5; idPessoa++) {
			Thread porta = new PortaController(idPessoa, semaforo);
			porta.start();
		}
	}

}
