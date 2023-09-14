package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ThreadPing extends Thread {

	private String[] servidor;
	private int i;

	public ThreadPing(String[] servidor, int i) {
		this.servidor = servidor;
		this.i = i;
	}

	@Override
	public void run() {
		ping();
	}

	private String os() {
		return System.getProperty("os.name");
	}

	private void ping() {
		String nomeOs = os();
		if (nomeOs.contains("Linux")) {
			try {
				String processo = "ping -4 -c 10 www." + servidor[i] + ".com.br";
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);

				String LerLinha = buffer.readLine();

				do {
					if (LerLinha.contains("avg")) {
						String[] tempo = LerLinha.split("/");
						System.out.println("servidor: " + servidor[i] + ", média: " + tempo[4]);
					}
					LerLinha = buffer.readLine();
				} while (LerLinha != null);

				fluxo.close();
				leitor.close();
				buffer.close();

			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		} else {
			System.out.println("Esse Sistema Operacional não será considerado");
		}
	}

}
