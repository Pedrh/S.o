package view;

import controller.CozinhaController;

public class Principal {

	public static void main(String[] args) {
		for(int idPrato = 0; idPrato < 5; idPrato++) {
			Thread cozinha = new CozinhaController(idPrato);
			cozinha.start();
		}
	}

}
