package controller;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JOptionPane;

public class ArquivosController implements IArquivosController {

	public ArquivosController() {
		super();
	}

	@Override
	public void readDir(String path) throws IOException {
		File dir = new File(path);
		if(dir.exists() && dir.isDirectory()) {
			File[] files = dir.listFiles();
			for(File f : files) {
				if(f.isFile()) {
					System.out.println("     \t" + f.getName());
				}else {
					System.out.println("<DIR>\t"+f.getName());
				}
			}
		}else {
			throw new IOException("Diretório inválido");
		}
		
	}

	@Override
	public void creatFile(String path, String nome) throws IOException {
		File dir = new File(path);
		File arq = new File(path, nome);
		if(dir.exists() && dir.isDirectory()) {
			boolean existe = false;
			if(arq.exists()) {
				existe = true;
			}
			String conteudo = geraTxt();
			FileWriter fileWriter = new FileWriter(arq, existe); // abre o arquivo e define a operação (quando true = append, quando false = write)
			PrintWriter print = new PrintWriter(fileWriter); //printa o conteudo do file no fileWriter
			print.write(conteudo); //Escreve o que estiver dentro de conteúdo
			print.flush(); // Faz uma descarga (finaliza a escrita)
			print.close();
			fileWriter.close();
		}else {
			throw new IOException("Diretório inválido");
		}
	}

	private String geraTxt() {
		StringBuffer buffer = new StringBuffer();
		String linha = ""; 
		while(!linha.equalsIgnoreCase("fim")) {
			linha = JOptionPane.showInputDialog(null, "Digite uma frase", "Entrada de texto", JOptionPane.INFORMATION_MESSAGE);
			
			if(!linha.equalsIgnoreCase("fim")) {
				buffer.append(linha + "\r\n");
			}
		}
		return buffer.toString();
	}

	@Override
	public void readFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq); //abre o arquivo e lê esse arquivo (está em fluxo de bits falta traduzir)
			InputStreamReader leitor = new InputStreamReader(fluxo); // le o fluxo traduzindo
			BufferedReader buffer = new BufferedReader(leitor); // joga em um buffer pra juntar
			String linha = buffer.readLine();
			while(linha != null) { // procurando EOF (end of file)
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
			buffer.close();
			fluxo.close();
			leitor.close();
		}else {
			throw new IOException("Arquivo inválido");
		}
	}

	@Override
	public void openFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		if(arq.exists() && arq.isFile()) {
			Desktop desktop = Desktop.getDesktop(); //o desktop não pode ser alterado então é uma chamada estática
			desktop.open(arq);
		}else {
			throw new IOException("Arquivo inválido");
		}
	}

	
	
}
