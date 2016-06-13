package br.ufrn.imd.smartRu.inteligencia;

import br.ufrn.imd.smartRu.modelo.FilaRu;
import br.ufrn.imd.smartRu.modelo.Raspberry;

public class InteligenceRu {

	private FilaRu appFila;
	private final double VALOR_PADRAO = 30.0;
	
	public InteligenceRu(int NumeroRaspberry, int NumeroSensores){
		this.appFila = new FilaRu(NumeroRaspberry, NumeroSensores);
	}
	
	public void construirAplicacao(String dados){
		//Parse do dado para um appFila
	}
	
	public void atualizarAplicacao(String dados){
		//Parse do dado para o appFila colocando novos dados
	}
	
	public String VerificarRasps(){
		StringBuilder builder = new StringBuilder();
		builder.append("Raspberrys pertencentes ao sistema: \n");
		for(Raspberry rasp: appFila.getRasps()){
			builder.append(rasp.getIdentificador());
			builder.append("\n");
		}
		return builder.toString();
	}
	
	public boolean[][] receberMatriz(){
		boolean[][] matriz = new boolean
				[appFila.getNumeroLinhas()][appFila.getNumeroColunas()];
		
		for(int i = 0; i < appFila.getNumeroLinhas(); i++){
			for(int j = 0; j < appFila.getNumeroColunas(); j++){
				if(appFila.getRasps().get(i).getSensores().get(j).getValor() >= VALOR_PADRAO){
					matriz[i][j] = true;
				}
				else{
					matriz[i][j] = false;
				}
			}
		}
		return matriz;
	}
}
