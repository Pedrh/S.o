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

	public void ip(String processo) {
		String nome = os();
		if (nome.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer1 = new BufferedReader(leitor);
				
				
				String lerLinha = buffer1.readLine();
				System.out.println("Endereços com IPv4:\n");
				String Adap = "";
				while (lerLinha != null) {
					if (lerLinha.contains("Adaptador")) {
						Adap = lerLinha;
					}else if(lerLinha.contains("IPv4")) {
						String[] valorIP = lerLinha.split(":");
						System.out.println(Adap + " " + valorIP[1]);
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
				processo = "ip addr";
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer1 = new BufferedReader(leitor);
				
				
				String lerLinha = buffer1.readLine();
				System.out.println("Endereços com IPv4:\n");
				String Adap = "";
				while (lerLinha != null) {
					if (lerLinha.contains("UP")) {
						String[] nomeAdap = lerLinha.split(":");
						Adap = nomeAdap[1];
					}else if(lerLinha.contains("inet ")) {
						String[] valorIP = lerLinha.split("/");
						System.out.println(Adap + " " + valorIP[0]);
					}
					lerLinha = buffer1.readLine();
				}
				buffer1.close();
				leitor.close();
				fluxo.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	
	public void ping(String processo) {
		String nome = os();
		if(nome.contains("Windows")) {
			try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				
				String lerLinha = buffer.readLine();
				while(lerLinha != null) {
					if(lerLinha.contains("milissegundos")) {
						lerLinha = buffer.readLine();
						String[] valorPing = lerLinha.split("=");
						System.out.println("\nTempo Médio ="+ valorPing[3]);
					}
					lerLinha = buffer.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			try {
				processo = "ping -4 -c 10 www.google.com.br";
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				
				String lerLinha = buffer.readLine();
				while(lerLinha != null) {
					if(lerLinha.contains("avg")) {
						String[] valorPing = lerLinha.split("/");
						System.out.println("\nTempo Médio = "+ valorPing[4]);
					}
					lerLinha = buffer.readLine();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
