package br.ufrn.imd.smartRu.inteligencia;

/**
 * 
 * @authors Anderson, Cephas,  Paulo, Sandino
 *
 *
 *
 */
public class Config {

	//Constantes de configuracao
	private final int numeroDispositivos = 2;
	private final int numeroLinhas = 3;
	private final int numeroColunas = 4;
	private final int numeroLeituras = 20;
	private final double percentLeiturasSensor = 60.0;
	private final double VALOR_PADRAO = 60.0;
	
	public final String base[][];

	public Config() {
		base = new String[][] { 
			{ "R1-S1", "R1-S2", "R2-S1", "R2-S2" }, 
			{ "R1-S3", "R1-S4", "R2-S3", "R2-S4" },
			{ "R1-S5", "R1-S6", "R2-S5", "R2-S6" }};
	}

	public int getNumeroLinhas() {
		return numeroLinhas;
	}

	public int getNumeroColunas() {
		return numeroColunas;
	}

	public String[][] getBase() {
		return base;
	}

	public int getNumeroDispositivos() {
		return numeroDispositivos;
	}

	public int getNumeroLeituras() {
		return numeroLeituras;
	}
	
	public double getValorPadrao() {
		return VALOR_PADRAO;
	}

	public double getPercentLeiturasSensor() {
		return percentLeiturasSensor;
	}	
}
