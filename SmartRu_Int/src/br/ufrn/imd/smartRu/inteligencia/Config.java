package br.ufrn.imd.smartRu.inteligencia;

import java.util.Random;

import br.ufrn.imd.smartRu.modelo.Raspberry;
import br.ufrn.imd.smartRu.modelo.Sensor;

import com.google.gson.Gson;

public class Config {

	private int numeroLinhas = 3;
	private int numeroColunas = 4;
	private String base[][];

	public Config() {
		base = new String[][] { 
			{ "R1-S1", "R1-S2", "R2-S1", "R2-S2" }, 
			{ "R1-S3", "R1-S4", "R2-S3", "R2-S4" },
			{ "R1-S5", "R1-S6", "R2-S5", "R2-S6" } };
	}

	public String mock(String nome) {

		Raspberry rasp = new Raspberry(nome);
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
	}

	public int getNumeroLinhas() {
		return numeroLinhas;
	}

	public void setNumeroLinhas(int numeroLinhas) {
		this.numeroLinhas = numeroLinhas;
	}

	public int getNumeroColunas() {
		return numeroColunas;
	}

	public void setNumeroColunas(int numeroColunas) {
		this.numeroColunas = numeroColunas;
	}

	public String[][] getBase() {
		return base;
	}

	public void setBase(String[][] base) {
		this.base = base;
	}

}
