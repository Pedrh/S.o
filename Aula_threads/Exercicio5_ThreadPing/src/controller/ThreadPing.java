package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ThreadPing extends Thread {

	private String[] servidor;
	public ThreadPing(String[] servidor) {
		this.servidor = servidor;
	}

	@Override
	public void run() {
		so();		
		ping();
	}
	
	private String so() {
		String nome = System.getProperty("so.name");
		return nome;
	}

	private void ping() {
//		if(so().contains("linux")) {
			try {
				Process p = Runtime.getRuntime().exec(servidor);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				
				String LerLinha = buffer.readLine();
				String[] nome = {""};
				
				do {
					if(LerLinha.contains("PING")) {
						nome = LerLinha.split(".");
					}else if(LerLinha.contains("avg")) {
						String[] tempo = LerLinha.split("/");
						System.out.println("servidor: "+ nome[1] + ", média: " + tempo[4]);
					}
					LerLinha = buffer.readLine();
				}while(LerLinha != null);
			} catch (Exception e) {
				// TODO: handle exception
			}
//		}else{
//			System.out.println("Esse Sistema Operacional não será considerado");
//		}
	}

	
}

