package fag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
@SuppressWarnings("unused")

public class Vaga {
	private int numero;
	private int tamanhoVaga;
	private boolean status;
	
	public Vaga (int numero, int tamanhoVaga) {
		this.numero = numero;
		this.tamanhoVaga = tamanhoVaga;
		this.status = true;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getTamanhoVaga() {
		return tamanhoVaga;
	}

	public void setTamanhoVaga(int tamanhoVaga) {
		this.tamanhoVaga = tamanhoVaga;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		String disponibilidade = null;
		if(status) {
			disponibilidade = "Disponivel";			
		} else {
			disponibilidade = "Indisponivel";	
		}
		String tamanho = null;
		if(tamanhoVaga==1) {
			tamanho = "Pequeno";
		}else if(tamanhoVaga == 2) {
			tamanho = "Médio";
		}else {
			tamanho = "Grande";
		}
		return "Vaga \n\n Numero da Vaga:" + numero + " \n Tamanho da Vaga:" + tamanho + "\n Status:" + disponibilidade;
	}
	
	
}
