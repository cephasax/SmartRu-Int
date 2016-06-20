package br.ufrn.imd.smartRu.inteligencia;

import java.util.Random;

import br.ufrn.imd.smartRu.modelo.Raspberry;
import br.ufrn.imd.smartRu.modelo.Sensor;

import com.google.gson.Gson;

public class Config {

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

}
