package br.ufrn.imd.smartRu.inteligencia;

import java.util.ArrayList;

import com.google.gson.Gson;

import br.ufrn.imd.smartRu.modelo.FilaRu;
import br.ufrn.imd.smartRu.modelo.Raspberry;

public class InteligenceRu {

	private FilaRu appFila;
	private ArrayList<int[][]> historicoBases;

	// Constantes
	private Config config; // 3 linhas e 4 colunas - 20-06-2016
	private final double VALOR_PADRAO = 90.0;

	// controles
	private int controleMatriz = 0;
	private ArrayList<String> nomesRasps;

	public InteligenceRu() {
		this.config = new Config();
		this.appFila = new FilaRu(config.getNumeroLinhas(), config.getNumeroColunas());
		historicoBases = new ArrayList<int[][]>();
		nomesRasps = new ArrayList<String>();
	}

	public void adicionarRaspberryFromJason(String json) {
		Raspberry rasp = loadRaspFromJSON(json);
		if (appFila.getRaspberryNome(rasp.getIdentificador()) == null) {
			appFila.incluirRasp(rasp);
			nomesRasps.add(rasp.getIdentificador());
			System.out.println("Raspberry " + rasp.getIdentificador() + " incluido com sucesso");
		}
<<<<<<< HEAD
=======
		System.out.println("Raspberry " + rasp.getIdentificador() + " incluido com sucesso");
>>>>>>> a263669dc6bff88a193477ec13119a51565af969
	}

	public Raspberry loadRaspFromJSON(String jsonString) {
		Gson gson = new Gson();
		Raspberry rasp = gson.fromJson(jsonString, Raspberry.class);
		return rasp;
	}

	public void atualizarAplicacao(String dados) {
		
	}

	public String VerificarRasps() {
		StringBuilder builder = new StringBuilder();
		builder.append("Raspberrys pertencentes ao sistema: \n");
		for (String nome: nomesRasps) {
			builder.append(nome);
			builder.append("\n");
		}
		return builder.toString();
	}

	public int[][] receberMatriz() {
		int[][] matriz = new int[appFila.getNumeroLinhas()][appFila.getNumeroColunas()];

		/**
		 * Percorre todos os Raspberrys cadastrados por ordem de cadastro.
		 * Inclui como sensor da fila todos os sensores do raspberry de acordo
		 * com a posicao declarada no atributo base da classe Config
		 * 
		 * Repete o passo anterior ate que nao haja mais raspberrys no array
		 */

		double v = -1;

		for (int i = 0; i < appFila.getNumeroLinhas(); i++) {
			for (int j = 0; j < appFila.getNumeroColunas(); j++) {
				
				String registro = new String(config.base[i][j]);
				String nomeRasp = new String(registro.substring(0, 1));
				String nomeSensor = new String(registro.substring(3, 4));;
			
				v = appFila.getRaspberryNome(nomeRasp).getSensorNome(nomeSensor).getValor();				
				// verificacao do valor do sensor e insercao na matriz de
				// inteiros
				if ((v >= 0) && (v <= VALOR_PADRAO)) {
					matriz[i][j] = 1;
				}
				else if (v > VALOR_PADRAO) {
					matriz[i][j] = 0;
				}
				else if (v < 0) {
					matriz[i][j] = -1;
				}
			}
		}
		return matriz;
	}

	/*
	 * public String mock(){ Raspberry rasp = new Raspberry("Rasp1"); Random
	 * gerador = new Random();
	 * 
	 * Gson gson = new Gson();
	 * 
	 * for (int i = 0; i < 6; i++) {
	 * 
	 * Sensor sensor = new Sensor();
	 * 
	 * double numero = gerador.nextDouble() * 100; // [0,100[ double numero1 =
	 * Math.round(numero * 100) / 100d; System.out.println(numero1);
	 * sensor.setNome("s" + i); sensor.setValor(numero1);
	 * rasp.adicionarSensor(sensor); }
	 * 
	 * String userJSONString = gson.toJson(rasp);
	 * 
	 * return userJSONString; }
	 */

	public double percentFila(int mat[][]) {
		int linha = appFila.getNumeroLinhas(), coluna = appFila.getNumeroColunas();
		double cont = 0, total = 0;
		for (int i = 0; i < linha; i++) {
			for (int j = 0; j < coluna; j++) {
				if (mat[i][j] == 1)
					cont++;

				total++;
			}
		}

		return (cont / total);
	}

}
