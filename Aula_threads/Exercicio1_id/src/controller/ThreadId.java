package controller;
/* 3 regras pra ser uma thread:
 * extends thread (herda característica de thread)
 * todos os parâmetros são pelo construtor
 * só é executado o que estiver dentro do run
 * */

public class ThreadId extends Thread {

	
	public ThreadId() {	
	}
	@Override
	public void run() {
		//só executa o que está aqui dentro
		System.out.println("#" + getId());
	}
}
