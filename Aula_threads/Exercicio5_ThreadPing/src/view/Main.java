package view;

import controller.ThreadPing;

public class Main {

	
	public static void main(String[] args) {
		String[] processo = {"ping -4 -c 10 www.google.com.br"};
		Thread Ping = new ThreadPing(processo);
		Ping.start();
	}

}

