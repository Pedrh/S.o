package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {

	public KillController() {
		super();
	}
	
	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}
	
	public void listaProcessos(String processo) {
		String nomeOs = os();
		if(nomeOs.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String lerLista = buffer.readLine();
				
				while(lerLista != null) {
					System.out.println(lerLista);
					lerLista = buffer.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void mataPID(String pid) {
		String nomeOs = os();
		if(nomeOs.contains("Windows")) {
			String cmdPID = "TASKKILL /PID " + pid + " /f";
			try {
				Runtime.getRuntime().exec(cmdPID);
				System.out.println("O processo de número " + pid + " foi morto com sucesso");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public void mataNome(String nome) {
		String nomeOs = os();
		if(nomeOs.contains("Windows")) {
			String cmdPID = "TASKKILL /IM " + nome + " /f";
			try {
				Runtime.getRuntime().exec(cmdPID);
				System.out.println("O processo " + nome + " foi morto com sucesso");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
