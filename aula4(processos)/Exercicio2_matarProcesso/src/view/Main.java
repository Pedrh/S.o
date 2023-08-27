package view;

import javax.swing.JOptionPane;

import controller.KillController;

public class Main {

	public static void main(String[] args) {
		KillController kc =new  KillController();
		int opt = 0;
		while(opt!=9){
			opt = Integer.parseInt(JOptionPane.showInputDialog("Escolha o processo a ser realizado: \n2- mostrar lista de processos \n3- matar por PID \n4- matar por Nome \n9-Finalizar aplicação"));
			switch(opt) {
			case 2:
				String processo = "TASKLIST /FO TABLE";
				kc.listaProcessos(processo);
				break;
			case 3:
				String pid = JOptionPane.showInputDialog("Digite o Pid do processo que quer matar: ");
				kc.mataPID(pid);
				break;
			case 4:
				String nome = JOptionPane.showInputDialog("Digite o nome do processo que quer matar: ");
				kc.mataPID(nome);
				break;
			case 9:
				System.exit(0);
				break;
		}
	}

}
}