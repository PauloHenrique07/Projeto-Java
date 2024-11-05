package fag;

import java.util.Scanner;

public class SistemaPrincipalEstacionamento {
	static Estacionamento estacionameento = new Estacionamento();
	static Scanner sc = new Scanner(System.in);
	
	
	public static void fluxoEstacioamento() {
		int i;
		do {
			System.out.println("\n ----- Bem vindo ao Estacioamento -----\n");
			System.out.println("\n Digite o número da opção desejada: ");
	    	System.out.println("1- Gerenciamento do Estacionamento");
	    	System.out.println("2- Gerenciar Reservas");
	    	System.out.println("3- Histórico de Reservas");
	    	System.out.println("4- Sair");
	    	i = sc.nextInt();
	    	
	    	if(i==1) {
	    		limparConsole();
	    		int y = 0,j=0;
				do {
					System.out.println("\n ----- Estacionamento -----\n");
					System.out.println("\n Digite o número da opção desejada: ");
			    	System.out.println("1- Gerenciar Veiculo");
			    	System.out.println("2- Gerenciar Vaga");
			    	System.out.println("3 <-- Voltar");
			    	j = sc.nextInt();
			    	
			    	if(j==1) {
			    		y=0;
			    		limparConsole();
			    		do {
			    			System.out.println("\n ----- Estacionamento -----\n");
							System.out.println("\n Digite o número da opção desejada: ");
					    	System.out.println("1- Listar Veiculo");
					    	System.out.println("2- Adicionar Veiculo");
					    	System.out.println("3- Editar Veiculo");
					    	System.out.println("4- Remover Veiculo");
					    	System.out.println("5 <-- Voltar");
					    	y = sc.nextInt();
					    	
					    	if(y==1) {
					    		limparConsole();
					    		Estacionamento.listarVeiculos();
					    	}else if(y==2) {
					    		limparConsole();
					    		Estacionamento.cadastrarVeiculo();
					    	}else if(y==3) {
					    		limparConsole();
					    		System.out.println("-> Digite o numero da placa do veiculo que deseja editar <-");
						    	String nome = sc.nextLine();
						    	Estacionamento.editarVeiculos(nome);
					    	}else if(y==4) {
					    		limparConsole();
					    		sc.nextLine();
					    		System.out.println("-> Digite o numero da placa do veiculo que deseja remover <-");
						    	String nome = sc.nextLine();
						    	Estacionamento.removerVeiculo(nome);
					    	}
					    	
			    		}while(y!=5);
			    		limparConsole();
			    	}else if(j==2) {
			    		y=0;
			    		limparConsole();
			    		do {
			    			System.out.println("\n ----- Estacionamento -----\n");
							System.out.println("\n Digite o número da opção desejada: ");
					    	System.out.println("1- Listar Vaga");
					    	System.out.println("2- Adicionar Vaga");
					    	System.out.println("3- Remover Vaga");
					    	System.out.println("4 <-- Voltar");
					    	y = sc.nextInt();
					    	
					    	if(y==1) {
					    		limparConsole();
					    		Estacionamento.listarVagas();
					    	}else if(y==2) {
					    		limparConsole();
					    		Estacionamento.cadastrarVaga();
					    	}else if(y==3) {
					    		limparConsole();
					    		System.out.println("-> Digite o numero da vaga que deseja remover <-");
						    	int numero = sc.nextInt();
						    	Estacionamento.removerVaga(numero);
					    	}
					    	
			    		}while(y!=4);
			    		limparConsole();
			    	}
	    		}while(j!=3);
				limparConsole();
	    	} else if(i==2) {
		    	int y = 0;
	    		limparConsole();
	    		do {
	    			System.out.println("1- Verificar Reservas");
	    			System.out.println("2- Realizar uma nova Reserva");
			    	System.out.println("3- Finalizar Reserva");
			    	System.out.println("4 <-- Voltar");
			    	y = sc.nextInt();
			    	
			    	if(y==1) {
			    		limparConsole();
			    		Estacionamento.listarReservas();					    		
			    	}else if(y==2) {
			    		limparConsole();
			    		System.out.println("Reserva Inciada");
			    		Estacionamento.gerarReserva();
			    	}else if(y==3) {
			    		limparConsole();
			    		Estacionamento.listarReservas();
			    		System.out.println("-> Qual a placa do carro para finalizar a reserva? <-");
				    	String nome = sc.next();
				    	Estacionamento.concluirReserva(nome);			    	
			    	}
			    	
	    		}while(y!=4);
	    		limparConsole();
	    	}else if(i==3) {
	    		Estacionamento.listarReservasConcluidas();
	    	}
	    	
		}while(i!=4);    	
    	limparConsole();
    	System.out.println("SISTEMA ENCERRADO!");
    	sc.close();
	}
	
	
	
	public static void limparConsole() {
	    for (int i = 0; i < 50; i++) {
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) {
		fluxoEstacioamento();
	}
	
	
	
	
	
	
}
