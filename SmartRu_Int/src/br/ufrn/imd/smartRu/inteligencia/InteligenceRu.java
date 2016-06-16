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
	
	public int[][] receberMatriz(){
		int[][] matriz = new int
				[appFila.getNumeroLinhas()][appFila.getNumeroColunas()];
		
		/**
		 * Percorre todos os Raspberrys cadastrados por ordem de cadastro.
		 * Inclui como sensor da fila todos os sensores do raspberry atual 
		 * ate que nao haja mais nenhum sensor. Apos isso segue para o proximo raspberry
		 * 
		 * Repete o passo anterior ate que nao haja mais raspberrys no array
		*/
		
		double v = -1;
		
		for(int i = 0; i < appFila.getNumeroLinhas(); i++){
			for(int j = 0; j < appFila.getNumeroColunas(); j++){
				
				v = -1;
				
				if((i < appFila.getRasps().size()) && 
						(j < appFila.getRasps().get(i).getSensores().size())){
					
					v = appFila.getRasps().get(i).getSensores().get(j).getValor();
				}
								
				//verificacao do valor do sensor e insercao na matriz de inteiros
				if( (v >= 0) && (v <= VALOR_PADRAO)){
					matriz[i][j] = 1;
				}
				else if(v > VALOR_PADRAO){
					matriz[i][j] = 0;
				}
				else if(v < 0){
					matriz[i][j] = -1;
				}
			}
		}
		return matriz;
	}
}
