package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main {

	public static void main(String[] args) {
		RedesController redes =new  RedesController();
		int opt = 0;
		while(opt!=9){
			opt = Integer.parseInt(JOptionPane.showInputDialog("Escolha o processo a ser realizado: \n2- chamar o ip \n3- faz a chamada de ping \n9-Finalizar aplicação"));
			switch(opt) {
			case 2:
				String processo2 = "ipconfig";
				redes.ip(processo2);
				break;
			case 3:
				String processo3 = "ping -4 -n 10 www.google.com.br";
				redes.ping(processo3);
				break;
			case 9:
				System.exit(0);
				break;
		}
	}
	}
}
