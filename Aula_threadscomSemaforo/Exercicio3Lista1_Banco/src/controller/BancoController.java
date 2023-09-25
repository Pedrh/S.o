package controller;

import java.util.concurrent.Semaphore;

public class BancoController extends Thread {

	private int operacao;
	private Semaphore semaforo;
	
	private int codigoConta;
	private int saldoConta;
	private int valorTransacao;
	public BancoController(int operacao, int codigoConta, int saldoConta, int valorTransacao, Semaphore semaforo) {
		this.operacao = operacao;
		this.codigoConta = codigoConta;
		this.saldoConta = saldoConta;
		this.valorTransacao = valorTransacao;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try {
			semaforo.acquire();
			if(operacao == 1) {
				int novoSaldo = saldoConta - valorTransacao;
				System.out.println("#"+codigoConta+" foi feito um saque de : "+valorTransacao+" R$, no saldo de: "+ saldoConta+" R$, saldo final: "+novoSaldo + " R$");
			}else {
				int novoSaldo = saldoConta + valorTransacao;
				System.out.println("#"+codigoConta+" foi feito um deposito de : "+valorTransacao+" R$, no saldo de: "+ saldoConta+"R$, saldo final: "+novoSaldo+" R$");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			System.out.println("Operação finalizada");
			semaforo.release();
		}
		
	
	}
	
	

}
