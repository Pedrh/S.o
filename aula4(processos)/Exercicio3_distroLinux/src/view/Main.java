package view;

import javax.swing.JOptionPane;

import controller.DistroController;

public class Main {

	public static void main(String[] args) {
		DistroController dc = new DistroController();
		int distro = 0;
		do{
			distro = Integer.parseInt(JOptionPane.showInputDialog("Gostaria de ver a distribuição do seu Linux? \n1- Sim 2- Não: "));
			
			if(distro == 1) {
				String processo= "cat /etc/os-release";
				dc.exibeDistro(processo);
			}else {
				JOptionPane.showMessageDialog(null, "Tudo bem então, volte sempre!");
			}
		}while(distro != 2);
		
		
	}
}
