package view;

import controller.ServidorThread;

public class Principal {

	public static void main(String[] args) {
		for(int idThread = 1; idThread < 22; idThread++ ) {
			Thread servidor = new ServidorThread(idThread);
			servidor.start();
		}
	}

}
