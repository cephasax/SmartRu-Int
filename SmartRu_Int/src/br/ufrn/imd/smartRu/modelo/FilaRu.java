package br.ufrn.imd.smartRu.modelo;

import java.util.ArrayList;

public class FilaRu{

	private ArrayList<Dispositivo> dispositivos;
	
	public FilaRu(int numeroLinhas, int numeroColunas){
		dispositivos = new ArrayList<Dispositivo>();
	}
	
	public void incluirDispositivo(Dispositivo dispositivo){
		dispositivos.add(dispositivo);
	}
	
	public Dispositivo getDispositivoNome(String nome){
		for(Dispositivo disp: dispositivos){
			if(disp.getIdentificador().equals(nome)){
				return disp;
			}
		}
		return null;
	}
	
	public ArrayList<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(ArrayList<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}
	
	public void imprimirDadosFila(){
		for(Dispositivo d: dispositivos){
			System.out.println("Dispositivo : " + d.getIdentificador());
			for(Sensor s: d.getSensores()){
				System.out.println("\t Sensor: " + s.getNome() + " - valor: " + s.getValor());
			}
		}
	}
}
