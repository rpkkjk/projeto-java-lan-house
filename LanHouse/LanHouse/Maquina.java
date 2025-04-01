package LanHouse;

import java.time.Duration;
import java.time.LocalDateTime;

abstract class Maquina{
	private String nome;
	private boolean disponibilidade = true;
	private String jogo;
	private double valorMinuto;
	private LocalDateTime horaInicio;
	private LocalDateTime horaTermino;

	public Maquina(String nome, double valorMinuto) {
		setNome(nome);
		this.valorMinuto = valorMinuto;
	}

	void setNome(String nome){
		this.nome = nome;
	}

	String getNome(){
		return this.nome;
	}

	boolean getDisponivel() {
		return disponibilidade;
	}

	void setJogo(String jogo){
		this.jogo = jogo;
	}

	String getJogo(){
		return jogo;
	}

	void setHoraInicio(){
		this.horaInicio = LocalDateTime.now();
	}

	String getHoraInicio(){
		return horaInicio.getHour() + ":" + horaInicio.getMinute();
	}

	void setHoraTermino(){
		this.horaTermino = LocalDateTime.now();
	}

	String getHoraTermino(){
		return horaTermino.getHour() + ":" + horaTermino.getMinute();
	}

	void alugar(String jogo ) throws InterruptedException {
		if(disponibilidade) {
			setJogo(jogo);
			disponibilidade = false;
			setHoraInicio();
			System.out.println(getNome() + " alugada com sucesso para o jogo " + getJogo() + " às " + getHoraInicio());
			Thread.sleep(5000);
		} else {
			System.out.println("Máquina indisponível");
		}
	}

	void liberar() {
		if(!disponibilidade) {
			this.disponibilidade = true;
			this.horaTermino = LocalDateTime.now();
			Duration duracao = Duration.between(horaInicio, horaTermino);
			double valor = duracao.toMinutes() * valorMinuto;
			System.out.printf("\n\n====Valor a pagar: R$%.2f===\n \n", valor);
			System.out.println(nome + " liberada às " + horaTermino.getHour() + ":" + horaTermino.getMinute());
		} else {
			System.out.println("Máquina já está disponível");
		}
	}
}























