package br.ufrn.imd.smartRu.modelo;

import java.util.ArrayList;

public class Raspberry {

	private String identificador;
	private ArrayList<Sensor> sensores;

	public Raspberry(String identificador) {
		this.identificador = identificador;
		this.sensores = new ArrayList<Sensor>();
	}
	
	public void adicionarSensor(Sensor s){
		sensores.add(s);
	}
	
	public void removerSensor(Sensor s){
		sensores.remove(s);
	}
	
	public Sensor getSensorNome(String nome){
		for(Sensor sensor: sensores){
			if(sensor.getNome().equals(nome)){
				return sensor;
			}
		}
		return null;
	}

	public String getIdentificador() {
		return identificador;
	}

	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}

	public ArrayList<Sensor> getSensores() {
		return sensores;
	}

	public void setSensores(ArrayList<Sensor> sensores) {
		this.sensores = sensores;
	}
}
