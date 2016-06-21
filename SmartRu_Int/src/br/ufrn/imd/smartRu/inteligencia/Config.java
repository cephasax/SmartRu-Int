package br.ufrn.imd.smartRu.inteligencia;

import java.util.Random;

import com.google.gson.Gson;

import br.ufrn.imd.smartRu.modelo.Dispositivo;
import br.ufrn.imd.smartRu.modelo.Sensor;


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
	private final double percentLeiturasSensor = 70;
	private final double VALOR_PADRAO = 90.0;
	
	public final String base[][];

	public Config() {
		base = new String[][] { 
			{ "R1-S1", "R1-S2", "R2-S1", "R2-S2" }, 
			{ "R1-S3", "R1-S4", "R2-S3", "R2-S4" },
			{ "R1-S5", "R1-S6", "R2-S5", "R2-S6" }};
	}

	public String mock(String nome) {

		Dispositivo disp = new Dispositivo(nome);
		Random gerador = new Random();

		Gson gson = new Gson();

		for (int i = 0; i < 6; i++) {

			Sensor sensor = new Sensor();

			double numero = gerador.nextDouble() * 100; // [0,100[
			double numero1 = Math.round(numero * 100) / 100d;
			System.out.println(numero1);
			sensor.setNome("s" + i);
			sensor.setValor(numero1);
			disp.adicionarSensor(sensor);
		}

		String userJSONString = gson.toJson(disp);

		return userJSONString;
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
