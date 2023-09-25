package view;

import java.util.concurrent.Semaphore;

import controller.BancoController;

public class Principal {

	public static void main(String[] args) {
		Semaphore semaforoDeposito = new Semaphore(1);
		Semaphore semaforoSaque = new Semaphore(1);
		
		for(int codigoConta = 1; codigoConta <=20; codigoConta++) {
			int operacao = (int) (Math.random() * 2) + 1;
			int saldoConta = (int) (Math.random() * 1001) + 1000;
			int valorTransacao = (int) (Math.random() * 1001) + 1000;
			if(operacao ==1) {
				Thread banco =new BancoController(operacao, codigoConta, saldoConta, valorTransacao, semaforoSaque);
				banco.start();
			}else {
				Thread banco =new BancoController(operacao, codigoConta, saldoConta, valorTransacao, semaforoDeposito);
				banco.start();
			}
			
		}
	}

}
