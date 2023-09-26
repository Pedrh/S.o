package model;

public class PosicaoCarro {

	public int idCarro;
	public Double maiorTempo;
	public PosicaoCarro(int idCarro, Double maiorTempo) {
		this.idCarro = idCarro;
		this.maiorTempo = maiorTempo;
	}
	
	public PosicaoCarro() {
		
	}
	@Override
	public String toString() {
		return "#" + idCarro + " Tempo = " + maiorTempo;
	}
	
	
}
