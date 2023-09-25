package model;

public class PosicaoCarro {

	public int idCarro;
	public float maiorTempo;
	public PosicaoCarro(int idCarro, float maiorTempo) {
		this.idCarro = idCarro;
		this.maiorTempo = maiorTempo;
	}
	@Override
	public String toString() {
		return "#" + idCarro + " Tempo = " + maiorTempo;
	}
	
	
}
