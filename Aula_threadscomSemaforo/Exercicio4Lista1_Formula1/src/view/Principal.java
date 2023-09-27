package view;

import java.util.concurrent.Semaphore; 

import controller.Formula1;
import controller.Ordena;
import model.PosicaoCarro;

public class Principal {

	static PosicaoCarro[] posicaoCarro = new PosicaoCarro[14];
	
	public static void main(String[] args) {
		Semaphore[] semaforoEscuderia = new Semaphore[7];
		Semaphore semaforoPista = new Semaphore(5);
		Thread[] formula1 = new Formula1[14];
		
		for( int i = 0; i < 14; i++) {
			posicaoCarro[i] = new PosicaoCarro();
		}
		
		int idCarro = 0;
		for(int i = 0; i < 7; i++) {
			semaforoEscuderia[i] = new Semaphore(1);
			for(int j = 0; j <2; j++) {
				int Escuderia = i;
				formula1[idCarro] = new Formula1(idCarro, Escuderia, semaforoEscuderia[i], semaforoPista, posicaoCarro);
				formula1[idCarro].start();
				idCarro++;
			}
		}
		
		for(Thread carro: formula1) {
			try {
				carro.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		Ordena ordena = new Ordena();
		posicaoCarro = ordena.ordenacao(posicaoCarro);
		int pos = 1;
		for(PosicaoCarro carro : posicaoCarro) {
			System.out.println(pos + "º lugar: " + carro);
			pos++;
		}

	}
}
