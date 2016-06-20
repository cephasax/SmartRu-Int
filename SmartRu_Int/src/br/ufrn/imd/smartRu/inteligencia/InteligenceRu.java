package br.ufrn.imd.smartRu.inteligencia;

import java.util.ArrayList;
import java.util.Random;

import com.google.gson.Gson;

import br.ufrn.imd.smartRu.modelo.FilaRu;
import br.ufrn.imd.smartRu.modelo.Raspberry;
import br.ufrn.imd.smartRu.modelo.Sensor;

public class InteligenceRu {

	private FilaRu appFila;
	private final double VALOR_PADRAO = 90.0;
	
	public InteligenceRu(int NumeroRaspberry, int NumeroSensores){
		this.appFila = new FilaRu(NumeroRaspberry, NumeroSensores);
	}
	
	public void adicionarRaspberryFromJason(String json){
		Raspberry rasp = loadRaspFromJSON(json);
		if(appFila.getRaspberryNome(rasp.getIdentificador()) == null){
			appFila.incluirRasp(rasp);
		}
		System.out.println("Raspberry" + rasp.getIdentificador()+ "incluido com sucesso");
	}
	
 	public Raspberry loadRaspFromJSON(String jsonString) {
	    Gson gson = new Gson();
	    Raspberry rasp = gson.fromJson(jsonString, Raspberry.class);
	    return rasp;
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

	/*public String mock(){
		Raspberry rasp = new Raspberry("Rasp1");
		Random gerador = new Random();

		Gson gson = new Gson();

		for (int i = 0; i < 6; i++) {

			Sensor sensor = new Sensor();
			
			double numero = gerador.nextDouble() * 100; // [0,100[
			double numero1 = Math.round(numero * 100) / 100d;
			System.out.println(numero1);
			sensor.setNome("s" + i);
			sensor.setValor(numero1);
			rasp.adicionarSensor(sensor);
		}

		String userJSONString = gson.toJson(rasp);

		return userJSONString;
	}*/
	
	public double percentFila(int mat[][]){
		int linha = appFila.getNumeroLinhas(), coluna = appFila.getNumeroColunas();
		double cont = 0, total = 0;
		for(int i=0; i<linha; i++){
			for(int j=0; j<coluna; j++){
				if(mat[i][j]==1)
					cont++;
				
				total++;
			}
		}
		
		return (cont/total);
	}
	
}
