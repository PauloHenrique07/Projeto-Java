package fag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
@SuppressWarnings("unused")

public class Veiculo {
	private String placa;
	private String modelo;
	private int tamanhoVeiculo;
	
	public Veiculo (String placa, String modelo, int tamanhoVeiculo) {
		this.placa = placa;
		this.modelo = modelo;
		this.tamanhoVeiculo = tamanhoVeiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getTamanhoVeiculo() {
		return tamanhoVeiculo;
	}

	public void setTamanhoVeiculo(int tamanhoVeiculo) {
		this.tamanhoVeiculo = tamanhoVeiculo;
	}

	@Override
	public String toString() {
		String tamanho = null;
		if(tamanhoVeiculo==1) {
			tamanho = "Pequeno";
		}else if(tamanhoVeiculo == 2) {
			tamanho = "Médio";
		}else {
			tamanho = "Grande";
		}
		return " Veiculo \n\n Placa:" + placa + "\n Modelo:" + modelo + "\n Tamanho do Veiculo:" + tamanho;
	}
}
