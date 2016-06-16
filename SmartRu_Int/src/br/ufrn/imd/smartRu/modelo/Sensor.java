package br.ufrn.imd.smartRu.modelo;

public class Sensor {

	//deve ser um nome relacionado a linha e coluna em que esta posicionado
	private String nome;
	
	private double valor;
	private boolean estado;

	public Sensor() {
		this.valor = 0.0;
		this.estado = false;
	}

	public Sensor(String nome) {
		this.valor = 0.0;
		this.estado = false;
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

}
