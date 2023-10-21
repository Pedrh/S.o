package controller;

import java.io.IOException;

public interface IArquivosController {

	public void readDir(String path)throws IOException;
	public void creatFile(String path, String nome) throws IOException;
	public void readFile(String path, String nome) throws IOException;
	public void openFile(String path, String nome) throws IOException;
}
