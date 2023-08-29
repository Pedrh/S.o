package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class DistroController {

	public DistroController() {
		super();
	}
	
	private String os() {
		String so = System.getProperty("os.name");
		return so;
	}
	
	public void exibeDistro(String processo) {
		String nomeSo = os();
		if(nomeSo.contains("Windows")) {
			System.out.println("O sistema operacional não é linux!! Por favor, desista");
		}else {
			try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				
				String lerLinha = buffer.readLine();
				while(lerLinha != null) {
					if(lerLinha.contains("PRETTY")) {
						lerLinha = buffer.readLine();
						System.out.println(lerLinha);
					}else if(lerLinha.contains("VERSION=")) {
						System.out.println(lerLinha);
					}
					lerLinha = buffer.readLine();
				}
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}