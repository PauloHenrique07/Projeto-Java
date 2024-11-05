package fag;


public class ReservaVaga {
	private Veiculo carro;
	private Vaga vagaUtilizada;
	private int HoraEntrada;
    private int HoraSaida;
    private int totalPagar;
    
    public ReservaVaga (Veiculo carro, Vaga vagaUtilizada, int HoraEntrada) {
    	this.carro = carro;
    	this.vagaUtilizada = vagaUtilizada;
    	this.HoraEntrada = HoraEntrada;
    	this.HoraSaida = 0;
    	this.totalPagar = 0;
    }

	public Veiculo getCarro() {
		return carro;
	}

	public void setCarro(Veiculo carro) {
		this.carro = carro;
	}

	public Vaga getVagaUtilizada() {
		return vagaUtilizada;
	}

	public void setVagaUtilizada(Vaga vagaUtilizada) {
		this.vagaUtilizada = vagaUtilizada;
	}

	public int getHoraEntrada() {
		return HoraEntrada;
	}

	public void setHoraEntrada(int horaEntrada) {
		HoraEntrada = horaEntrada;
	}

	public int getHoraSaida() {
		return HoraSaida;
	}

	public void setHoraSaida(int horaSaida) {
		HoraSaida = horaSaida;
	}

	public int getTotalPagar() {
		return totalPagar;
	}

	public void setTotalPagar(int totalPagar) {
		this.totalPagar = totalPagar;
	}

	@Override
	public String toString() {
		return "Reserva da Vaga \n\n Carro:" + carro.getPlaca() + "\n Vaga Utilizada:" + vagaUtilizada.getNumero() + "\n Hora Entrada:" + HoraEntrada
				+ "\n Hora Saida:" + HoraSaida;
	}
    
    

}
