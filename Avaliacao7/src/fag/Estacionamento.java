package fag;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Estacionamento {
	static Scanner sc = new Scanner(System.in);
	private static List<Veiculo> listaDeVeiculos = new ArrayList<>(); 
	private static List<Vaga> listaDeVagas = new ArrayList<>();
	private static List<ReservaVaga> listaDeReservas = new ArrayList<>(); 
	private static List<ReservaVaga> listaDeReservasConcluidas = new ArrayList<>(); 
	
	/*Veiculo*/
	public static void adicionarVeiculo(String placa, String modelo, int tamanhoVeiculo) {
		Veiculo veiculo = new Veiculo(placa, modelo, tamanhoVeiculo);
		listaDeVeiculos.add(veiculo);
	}
	
	public static void cadastrarVeiculo() {
		System.out.print("Quantos veiculos deseja cadastrar? ");
		    int quantidade = sc.nextInt();
	        System.out.println("\n");
	        sc.nextLine();
	        
	        for (int i = 0; i < quantidade; i++) {
	        	System.out.println("=== Cadastro do Veiculo " + (i+1) + " ===");
	        	System.out.print("Digite a placa do veiculo: ");
		        String placa = sc.next();
	        	
		        System.out.print("Digite o modelo do veiculo: ");
		        String modelo = sc.next();
		        
		        System.out.print("Qual o tamanho desse veiculo? \n1- Pequeno \n2- Médio \n3- Grande \n Digite apenas o numero da opção desejada: ");
		        int tamanhoVeiculo = sc.nextInt();
		        
		        
		        System.out.println("========================= \n");
		        
		        adicionarVeiculo(placa, modelo, tamanhoVeiculo); 
	        }
	}
	
	public static void listarVeiculos() {
		System.out.println("\n=== Lista de veiculos cadastrados ===");
        int j = 1;
        for (Veiculo veiculo : listaDeVeiculos) {
        	System.out.println(j+"- "+veiculo.toString()+"\n");
        	
        	j++;
        }
        System.out.println("\n");
	}
	
	public static List<Veiculo> buscarVeiculo(String tituloBusca){
		List<Veiculo> veiculosEncontrados = listaDeVeiculos.stream()
                .filter(veiculo -> veiculo.getPlaca().contains(tituloBusca))
                .collect(Collectors.toList());	     
		return veiculosEncontrados; 
	} 
	
	public static void removerVeiculo(String tituloBusca) {
        List<Veiculo> veiculosEncontrados = buscarVeiculo(tituloBusca);

        if (!veiculosEncontrados.isEmpty()) {
        	listaDeVeiculos.removeAll(veiculosEncontrados);
            System.out.println("Todos os Veiculos encontradas com a seguinte placa digitada foram removidos, seguintes veiculos: \n"
            																						+ veiculosEncontrados.toString());
        } else {
            System.out.println("Nenhum Veiculo encontrado para remoção. \n");
        }
    }
	
	public static void editarVeiculos(String tituloBusca) {
	    List<Veiculo> veiculosEncontrados = buscarVeiculo(tituloBusca);

	    if (!veiculosEncontrados.isEmpty()) {
	        System.out.println("Veiculos encontrados: \n\n");
	        for (int i = 0; i < veiculosEncontrados.size(); i++) {
	            System.out.println((i + 1) + ": " + veiculosEncontrados.get(i).toString());
	        }

	        System.out.print(" \n\n Selecione o número do veiculo que deseja editar: ");
	        int escolha = sc.nextInt();
	        sc.nextLine(); 

	        if (escolha > 0 && escolha <= veiculosEncontrados.size()) {
	            Veiculo veiculoSelecionado = veiculosEncontrados.get(escolha - 1);

	            System.out.print("Digite a nova placa do veiculo (ou digite 0 para manter o atual): ");
	            String novaPlaca = sc.next();
	            if (!novaPlaca.contains("0")) {
	            	veiculoSelecionado.setPlaca(novaPlaca);
	            }
	            
	            System.out.print("Digite o novo modelo do veiculo (ou digite 0 para manter o atual): ");
	            String novoModelo = sc.next();
	            if (!novoModelo.contains("0")) {
	            	veiculoSelecionado.setModelo(novoModelo);
	            }

	            System.out.print("Digite o novo tamanho do veiculo: \n1- Pequeno \n2- Médio \n3- Grande \n Digite apenas o numero da opção desejada: (ou digite 0 para manter o atual): ");
	            int novoTamanho = sc.nextInt();
	            if (novoTamanho>0) {
	            	veiculoSelecionado.setTamanhoVeiculo(novoTamanho);
	            }
	            System.out.println("Veiculo atualizado com sucesso!\n");
	            
	            System.out.println("Novo estado do veiculo: " + veiculoSelecionado.toString());

	        } else {
	            System.out.println("Escolha inválida.\n");
	        }
	    } else {
	        System.out.println("Nenhum veiculo encontrado com a placa "+ tituloBusca +" \n");
	    }
	}
	
	
	/*Vaga*/
	public static void adicionarVaga(int numero, int tamanhoVaga) {
		Vaga vaga = new Vaga(numero, tamanhoVaga);
		listaDeVagas.add(vaga);
	}
	
	public static void cadastrarVaga() {
		System.out.print("Quantos vagas deseja cadastrar? ");
		    int quantidade = sc.nextInt();
	        System.out.println("\n");
	        sc.nextLine();
	        
	        for (int i = 0; i < quantidade; i++) {
	        	System.out.println("=== Cadastro da Vaga " + (i+1) + " ===");      	
		        System.out.print("Digite o numero da vaga: ");
		        int numero = sc.nextInt();
		        
		        System.out.print("Qual o tamanho dessa vaga? \n1- Pequeno \n2- Médio \n3- Grande \n Digite apenas o numero da opção desejada: ");
		        int tamanhoVaga = sc.nextInt();
		        
		        
		        System.out.println("========================= \n");
		        
		        adicionarVaga(numero, tamanhoVaga); 
	        }
	}
	
	public static void listarVagas() {
		System.out.println("\n=== Lista de vagas cadastrados ===");
        int j = 1;
        for (Vaga vaga : listaDeVagas) {
        	System.out.println(j+"- "+vaga.toString()+"\n");
        	
        	j++;
        }
        System.out.println("\n");
	}
	
	public static List<Vaga> buscarVaga(int numeroBusca){
		List<Vaga> vagaEncontradas = listaDeVagas.stream()
                .filter(vaga -> vaga.getNumero() == numeroBusca)
                .collect(Collectors.toList());	     
		return vagaEncontradas; 
	} 
	
	public static void removerVaga(int numeroBusca) {
		List<Vaga> vagaEncontradas = buscarVaga(numeroBusca);

        if (!vagaEncontradas.isEmpty()) {
        	listaDeVagas.removeAll(vagaEncontradas);
            System.out.println("Todas as vagas encontradas com o nome digitado foram removidas, seguintes vagas: \n"
            																						+ vagaEncontradas.toString());
        } else {
            System.out.println("Nenhuma vaga encontrada para remoção. \n");
        }
    }
	
	public static void gerarReserva(){
		Vaga vagaEscolhida = new Vaga(0,0);
		Veiculo veiculoEscolhido = new Veiculo(null,null,0);
		if (!listaDeVeiculos.isEmpty()) {
			System.out.println("Iniciando uma nova reserva.\n Será feita para qual veiculo? \n");
	        System.out.println("Veiculo encontrados: ");
	        listarVeiculos();
	        System.out.print("Selecione o número do veiculo: ");
		    int escolha = sc.nextInt();
		    sc.nextLine();
		    if (escolha > 0 && escolha <= listaDeVeiculos.size()) {
		    	veiculoEscolhido = listaDeVeiculos.get(escolha - 1);
		    }else {
		    	System.out.println("Opção inválida");
		    }
		    limparConsole();
		    int escolhaSair;
		    
	    	System.out.println("Qual vaga você irá ficar? \n");
	        System.out.println("Vaga disponiveis: ");
	        
	        
	        
	        int i=0;
	        for (Vaga vagaSelecionada : listaDeVagas) {
	        	if(vagaSelecionada.getTamanhoVaga()==veiculoEscolhido.getTamanhoVeiculo()&&vagaSelecionada.isStatus()==true) {
	        		System.out.println((i + 1) + ": " + listaDeVagas.get(i).toString());
	        	}
	        	i++;
       	 	}
	        
	        System.out.print("Selecione o número da vaga que você irá ocupar: ");
		    escolha = sc.nextInt();
		    
		    sc.nextLine();
		    if (escolha > 0 && escolha <= listaDeVagas.size()) {
		    	if(listaDeVagas.get(escolha - 1).isStatus()==true) {
		    		vagaEscolhida = listaDeVagas.get(escolha - 1);
		    		vagaEscolhida.setStatus(false);			    		
		    	}
		    }else {
		    	System.out.println("Opção inválida");
		    }
		    	
		    		    
		   
		    limparConsole();
		    
		    System.out.println("Insira a horario de entrada: ");
		    int horaEntrada = sc.nextInt();
		    
			ReservaVaga novaReserva = new ReservaVaga(veiculoEscolhido,vagaEscolhida,horaEntrada);		    
		    listaDeReservas.add(novaReserva);
		    
		}
	}
	
	public static void listarReservas() {
		System.out.println("\n=== Lista de Reservas cadastradas ===");
        int j = 1;
        for (ReservaVaga reserva : listaDeReservas) {
        	System.out.println(j+"- "+reserva.toString()+"\n");
        	
        	j++;
        }
        System.out.println("\n");
	}
	
	public static List<ReservaVaga> buscarReserva (String tituloBusca){
		List<ReservaVaga> reservasEncontradas = listaDeReservas.stream()
                .filter(reserva -> reserva.getCarro().getPlaca().contains(tituloBusca))
                .collect(Collectors.toList());	     
		return reservasEncontradas; 
	} 
	
	public static void concluirReserva(String tituloBusca) {
		List<ReservaVaga> reservasEncontradas = buscarReserva(tituloBusca);

        if (!reservasEncontradas.isEmpty()) {
        	for(ReservaVaga reserva : reservasEncontradas) {
        		System.out.println("Digite o Horario de saida: ");
        		int saidaHora = sc.nextInt();
        		reserva.setHoraSaida(saidaHora);
        		reserva.getVagaUtilizada().setStatus(true);
        		System.out.println(reserva.getVagaUtilizada().isStatus());
        		limparConsole();
        		int i, j;
        		i = reserva.getHoraEntrada();
        		j = reserva.getHoraSaida();
        		if(j-i==1) {
        			reserva.setTotalPagar(5);        			
        		}else if(j-i>1&&j-i<=3) {
        			reserva.setTotalPagar(10);        			
        		}else {
        			reserva.setTotalPagar(15);
        		}
        		System.out.println("Valor a pagar: " + reserva.getTotalPagar());
        		System.out.println("Qual será a forma de pagamento? \n1-Cartão de Crédito \n2-Cartão de Débito \n3-Dinheiro");
        		int opcao  = sc.nextInt();
        		limparConsole();
        		System.out.println("Valor Pago!");
        	}
        	listaDeReservasConcluidas.addAll(reservasEncontradas);
        	listaDeReservas.removeAll(reservasEncontradas);
        } else {
            System.out.println("Nenhuma reserva encontrada para remoção. \n");
        }
	}
	
	public static void listarReservasConcluidas() {
		System.out.println("\n=== Lista de Reservas concluidas ===");
        int j = 1;
        for (ReservaVaga reserva : listaDeReservasConcluidas) {
        	System.out.println(j+"- "+reserva.toString()+"\n");
        	
        	j++;
        }
        System.out.println("\n");
	}	
	
		public static void limparConsole() {
		    for (int i = 0; i < 50; i++) {
		        System.out.println();
		    }
		}
}
