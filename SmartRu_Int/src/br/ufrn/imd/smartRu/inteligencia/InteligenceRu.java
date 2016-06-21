package br.ufrn.imd.smartRu.inteligencia;

import java.util.ArrayList;

import com.google.gson.Gson;

import br.ufrn.imd.smartRu.modelo.Dispositivo;
import br.ufrn.imd.smartRu.modelo.FilaRu;

public class InteligenceRu {

	private FilaRu appFila;
	private ArrayList<int[][]> historicoBases;
	
	// Configuracoes e mock
	private Config config; // 3 linhas e 4 colunas - 20-06-2016

	// controles
	private int controleMatriz = 0;
	private ArrayList<Integer> controlesUpdate;
	
	public InteligenceRu(){
		this.config = new Config();
		this.appFila = new FilaRu(config.getNumeroLinhas(), config.getNumeroColunas());
		this.historicoBases = new ArrayList<int[][]>();
	}
	
	public void registrarDispositivo(String nomeDispositivo){
		if(appFila.getDispositivos().size() < config.getNumeroDispositivos()){
			Dispositivo disp = appFila.getDispositivoNome(nomeDispositivo);
			if(disp != null){
				System.out.println("Dispositivo: " + nomeDispositivo + " ja existe no sistema");
			}
			else{
				disp = new Dispositivo(nomeDispositivo);
				appFila.incluirDispositivo(disp);
				System.out.println("Dispositivo: " + nomeDispositivo + " incluido com sucesso");
				controlesUpdate.set(appFila.getDispositivos().indexOf(disp), 0);
			}
		}
		else{
			System.out.println("Numero maximo de dispositivos alcancado"
					+ " \n - modifique as configuracoes para poder incluir");
		}
	}
	
	public void salvarLeiturasDispositivo(String jsonData){
		Dispositivo disp = new Gson().fromJson(jsonData, Dispositivo.class);
		Dispositivo temp = appFila.getDispositivoNome(disp.getIdentificador());
		if(temp != null){
			int onde = appFila.getDispositivos().indexOf(temp);
			if(controlesUpdate.get(onde) == 0){
				appFila.getDispositivos().set(onde, disp);
				controlesUpdate.set(appFila.getDispositivos().indexOf(disp), 1);
			}
		}
		else{
			System.out.println("Dispositivo nao incluido no sistema");
		}
	}

	public int[][] montarMatriz(){
		int a = 0;
		double v = -1;
		int matriz[][] = new int[config.getNumeroLinhas()][config.getNumeroColunas()];
		StringBuilder st = new StringBuilder();
		st.append("Dispositivos pendentes de leitura: ");
		
		//checar se todos os dispositivos tem leituras validas
		for(int i = 0; i < controlesUpdate.size(); i++){
			if(controlesUpdate.get(i) == 0){
				a++;
				st.append("\n Dispositivo: " + i);
			}
		}
		
		//imprimir indices de dispositivos sem leitura atual
		if(a > 0){
			System.out.println(st.toString());
			return null;
		}
		
		//montar matriz
		else{
			for(int i = 0; i < config.getNumeroLinhas(); i++){
				for(int j = 0; j < config.getNumeroColunas(); j++){
					String nomeDispositivo = config.base[i][j].substring(0, 1);
					String nomeSensor = config.base[i][j].substring(3, 4);
					v = appFila.getDispositivoNome(nomeDispositivo)
									.getSensorNome(nomeSensor).getValor();
					
					if(v >= 0 && v <= config.getValorPadrao()){
						matriz[i][j] = 1;
					}
					else if(v > config.getValorPadrao()){
						matriz[i][j] = 0;
					}
					else{
						matriz[i][j] = -1;
					}
				}
			}
			//zerar controles de updates
			for(int i = 0; i < controlesUpdate.size(); i++){
				controlesUpdate.set(i, 0);
			}
			historicoBases.add(matriz);
			return matriz;
		}
	}
	
	public double percentFila(int mat[][]) {

		if(historicoBases.size() == config.getNumeroLeituras()){
			int matriz[][]  = calcularMatrizGeral();
			
			double cont = 0, total = 0;
			for (int i = 0; i < config.getNumeroLinhas(); i++) {
				for (int j = 0; j < config.getNumeroColunas(); j++) {
					if (mat[i][j] == 1){
						cont++;
						total++;
					}
				}
			}
			return (cont / total);
		}
		return 0.0;
	}
	
	private int[][] calcularMatrizGeral(){
		int matriz[][]  = new int[config.getNumeroLinhas()][config.getNumeroColunas()]; 
		
		//carregar matrizGeral com zeros
		for(int i = 0; i < config.getNumeroLinhas(); i++){
			for(int j = 0; j < config.getNumeroColunas(); j++){
				matriz[i][j] = 0;
			}
		}
		
		for(int i = 0; i < config.getNumeroLinhas(); i++){
			for(int j = 0; j < config.getNumeroColunas(); j++){
				for(int cont = 0; cont < historicoBases.size(); cont++){
					if(historicoBases.get(cont)[i][j] >= 0){
						matriz[i][j] += historicoBases.get(cont)[i][j];
					}
				}
			}
		}
		
		for (int i = 0; i < config.getNumeroLinhas(); i++) {
			for (int j = 0; j < config.getNumeroColunas(); j++) {
				if ((matriz[i][j] / config.getNumeroLeituras()) * 100 > config.getPercentLeiturasSensor()){
					matriz[i][j] = 1;
				}
				else{
					matriz[i][j] = 0;
				}
			}
		}
		return matriz;
	}
}