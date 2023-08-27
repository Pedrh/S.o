package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {

	public RedesController() {
		super();
	}

	private String os() {
		String os = System.getProperty("os.name");
		return os;
	}

	public void ip() {
		String process = "ipconfig";
		String nome = os();
		if (nome.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer1 = new BufferedReader(leitor);
				String lerLinha = buffer1.readLine();
				System.out.println("Endereços com IPv4:\n");
				while (lerLinha != null) {
					if (lerLinha.contains("IPv4")) {
						System.out.println(lerLinha);
					}
					lerLinha = buffer1.readLine();
				}
				buffer1.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			try {
				process = "ifconfig";
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer1 = new BufferedReader(leitor);
				String lerLinha = buffer1.readLine();
				System.out.println("Endereços com IPv4:\n");
				while (lerLinha != null) {
					if (lerLinha.contains("IPv4")) {
						System.out.println(lerLinha);
					}
					lerLinha = buffer1.readLine();
				}
				buffer1.close();
				leitor.close();
				fluxo.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

}
