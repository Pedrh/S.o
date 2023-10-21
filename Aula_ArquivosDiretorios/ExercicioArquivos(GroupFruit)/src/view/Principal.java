package view;

import java.io.IOException;

import controller.ArquivosController;

public class Principal {

	public static void main(String[] args) {
		ArquivosController arqCont = new ArquivosController();
		
		String path = "C:\\TEMP";
		String nome = "generic_food.csv";
		
		try {
			arqCont.AnalisaArquivo(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
