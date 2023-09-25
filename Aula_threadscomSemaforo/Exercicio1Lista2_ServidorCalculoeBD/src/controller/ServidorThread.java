package controller;

import java.util.concurrent.Semaphore;

public class ServidorThread extends Thread {
	private Semaphore semaforoCalculo = new Semaphore(3);
	private Semaphore semaforoBD = new Semaphore(1);
	private Semaphore semaforoThread = new Semaphore(1);

	private int idThread;

	public ServidorThread(int idThread) {
		this.idThread = idThread;
	}

	@Override
	public void run() {
		try {
		semaforoThread.acquire();
		if (idThread % 3 == 1) {
			for (int i = 0; i < 4; i++) {
				if (i % 2 == 0) {
					try {
						semaforoCalculo.acquire();
						System.out.println("#" + idThread + "cálculo sendo feito");
						int tempo = (int) (Math.random() * 801) + 200;
						sleep(tempo);
						System.out.println("Cálculo #"+ idThread+" realizado");
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						semaforoCalculo.release();
					}
				} else {
					try {
						semaforoBD.acquire();
						System.out.println("#" + idThread + "Transação sendo feita");
						sleep(1000);
						System.out.println("Transação #"+ idThread+" realizada");
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						semaforoBD.release();
					}
				}
			}
		} else if (idThread % 3 == 2) {
			for (int i = 0; i < 6; i++) {
				if (i % 2 == 0) {
					try {
						semaforoCalculo.acquire();
						System.out.println("#" + idThread + "cálculo sendo feito");
						int tempo = (int) (Math.random() * 1001) + 500;
						sleep(tempo);
						System.out.println("Cálculo #"+ idThread+" realizado");
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						semaforoCalculo.release();
					}
				} else {
					try {
						semaforoBD.acquire();
						System.out.println("#" + idThread + "Transação sendo feita");
						sleep(1500);
						System.out.println("Transação #"+ idThread+" realizada");
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						semaforoBD.release();
					}
				}
			}
		} else {
			for (int i = 0; i < 6; i++) {
				if (i % 2 == 0) {
					try {
						semaforoCalculo.acquire();
						System.out.println("#" + idThread + "cálculo sendo feito");
						int tempo = (int) (Math.random() * 1001) + 1000;
						sleep(tempo);
						System.out.println("Cálculo #"+ idThread+" realizado");
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						semaforoCalculo.release();
					}
				} else {
					try {
						semaforoBD.acquire();
						System.out.println("#" + idThread + "Transação sendo feita");
						sleep(1500);
						System.out.println("Transação #"+ idThread+" realizada");
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						semaforoBD.release();
					}
				}
			}
		}
		System.out.println("Operações da thread de id "+ idThread + " encerradas");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			semaforoThread.release();
		}
	}

}
