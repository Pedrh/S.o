package view;

import java.io.IOException;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		IArquivosController arqCont = new ArquivosController(); 
//		String dirWin = "C:\\WIndows";
		String path = "C:\\ExemploArquivos";
		String nome = "Teste.txt";
		try {
//			arqCont.readDir(dirWin);
//			arqCont.creatFile(path, nome);
//			arqCont.readFile(path, nome);
			arqCont.openFile(path, nome);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
