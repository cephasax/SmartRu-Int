package br.ufrn.imd.smartRu.modelo;

import java.util.ArrayList;

public class FilaRu{

	//Identico ao numero de raspberrys
	private int numeroLinhas;
	
	//Identico ao numero de sensores por linha
	private int numeroColunas;
	private ArrayList<Raspberry> rasps;
	
	public FilaRu(int numeroLinhas, int numeroColunas){
		this.numeroLinhas = numeroLinhas;
		this.numeroColunas = numeroColunas;
	}
	
	public Raspberry getRaspberryNome(String nome){
		for(Raspberry rasp: rasps){
			if(rasp.getIdentificador().equals(nome)){
				return rasp;
			}
		}
		return null;
	}
	
	public int getNumeroLinhas() {
		return numeroLinhas;
	}

	public String setNumeroLinhas(int numeroLinhas) {
		if(rasps.size() > numeroLinhas){
			return "Reduza a quantidade de raspberrys antes de modificar";
		}
		this.numeroLinhas = numeroLinhas;
		return "numero de linhas modificado com sucesso";
	}

	public int getNumeroColunas() {
		return numeroColunas;
	}

	public String setNumeroColunas(int numeroColunas) {
		for(Raspberry rasp: rasps){
			if(rasp.getSensores().size() > numeroColunas){
				return "Existe raspberry no sistema com mais sensores que esse valor.\n"
						+ "Diminua a quantidade de sensores em todos os raspberrys para que"
						+ "todos tenham no máximo o novo valor.";
			}
		}
		this.numeroColunas = numeroColunas;
		return "numero de colunas modificado com sucesso";
	}

	public String incluirRasp(Raspberry raspberry){
		for(Raspberry rasp: rasps){
			if(rasp.getIdentificador().equals(raspberry.getIdentificador())){
				return "Raspberry ja faz parte do sistema";
			}
		}
		rasps.add(raspberry);
		return "Raspberry incluido com sucesso";
	}
	
	public ArrayList<Raspberry> getRasps() {
		return rasps;
	}

	public void setRasps(ArrayList<Raspberry> rasps) {
		this.rasps = rasps;
	}
}
