package LanHouse;
import java.util.Scanner;
import java.time.Duration;
import java.time.LocalDateTime;

class Maquinas {
	String nome;
	boolean disponibilidade = true;
	String jogo;
	double valorMinuto;
	LocalDateTime horaInicio;
	LocalDateTime horaTermino;
		

	private Maquinas(String nome, double valorMinuto) {
		this.nome = nome;
		this.valorMinuto = valorMinuto;
	}

	boolean disponivel() {
		return disponibilidade;
	}

	void alugar(String jogo ) throws InterruptedException {
		if(disponibilidade) {
			this.jogo = jogo;
			this.disponibilidade = false;
			this.horaInicio = LocalDateTime.now();
			System.out.println(nome + " alugada com sucesso para o jogo " + jogo + " às " + horaInicio.getHour() + ":" + horaInicio.getMinute());
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

	static Maquinas[] pc = new Maquinas[5];
	static	Maquinas[] playstation = new Maquinas[5];
	static	Maquinas[] xbox = new Maquinas[5];
		
	static void inicializarMaquinas() {
		for (int i = 0; i < 5; i++) {
			pc[i] = new Maquinas("PC" + (i+1), 0.15f);
			playstation[i] = new Maquinas("Playstation" + (i+1), 0.30f);
			xbox[i] = new Maquinas("Xbox" + (i+1), 0.45f);
		}
	}	
}

class AlugarMaquinas{
	static void alugarMaquinas(Scanner sc) throws InterruptedException {
		
		System.out.println("=== Escolha uma opção ===");
		System.out.println("=== 1- PC ===");
		System.out.println("=== 2- playstatio ===");
		System.out.println("=== 3- xbox ===");
		System.out.println("=== 4- voltar ===");
		
		int opcao = sc.nextInt();
		sc.nextLine();
		
		String jogo = "";
		boolean alugou = false;
		
		switch (opcao) {
			case 1:
			//Aluga primeiro PC disponível
				for(int i = 0; i < 5;i++) {
					if((Maquinas.pc[i]).disponivel()){
						System.out.println("=== Digite o nome do jogo excolhido ===");
						jogo = sc.nextLine();
						Maquinas.pc[i].alugar(jogo);
						alugou = true;
						break;
					}
				}
				if(!alugou){
					System.out.println("Não há máquinas disponíveis");
					Thread.sleep(1500);
				}
				break;
			case 2:
			//Aluga primeiro Playstation disponível
				for(int i = 0; i < 5;i++) {
					if((Maquinas.playstation[i]).disponivel()){
						System.out.println("=== Digite o nome do jogo excolhido ===");
						jogo = sc.nextLine();
						Maquinas.playstation[i].alugar(jogo);
						alugou = true;
						break;
					}
					
				}
				if(!alugou){
					System.out.println("Não há máquinas disponíveis");
					Thread.sleep(1500);
				}
				break;
			case 3:
			//Aluga primeiro Xbox disponível
				for(int i = 0; i < 5; i++) {
					if((Maquinas.xbox[i]).disponivel()){
						System.out.println("=== Digite o nome do jogo excolhido ===");
						jogo = sc.nextLine();
						Maquinas.xbox[i].alugar(jogo);
						alugou = true;
						break;
					}
				}
				if(!alugou){
					System.out.println("Não há máquinas disponíveis");
					Thread.sleep(1500);
				}
				break;
			case 4:
				System.out.println("Voltando...");
				Thread.sleep(1500);
				break;
			default:
			System.out.println("Opção inválida");
			Thread.sleep(1500);
			break;
		}
	}
}