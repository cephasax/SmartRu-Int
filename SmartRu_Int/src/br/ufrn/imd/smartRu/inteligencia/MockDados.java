package br.ufrn.imd.smartRu.inteligencia;

import java.util.Random;

import com.google.gson.Gson;

import br.ufrn.imd.smartRu.modelo.Dispositivo;
import br.ufrn.imd.smartRu.modelo.Sensor;

public class MockDados {

	public String geraDadosDispositivo(String nome) {

		Dispositivo disp = new Dispositivo(nome);
		Random gerador = new Random();

		Gson gson = new Gson();

		for (int i = 0; i < 7; i++) {

			Sensor sensor = new Sensor();

			double numero = gerador.nextDouble() * 100; // [0,100[
			double numero1 = Math.round(numero * 100) / 100d;
			//System.out.println(numero1);
			sensor.setNome("S" + i);
			sensor.setValor(numero1);
			disp.adicionarSensor(sensor);
		}

		String userJSONString = gson.toJson(disp);

		return userJSONString;
	}
	
}
