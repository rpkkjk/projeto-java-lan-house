package LanHouse;
import java.util.Scanner;
import java.time.LocalDateTime;

class Maquinas {
	String nome;
	boolean disponibilidade = true;
	String jogo;
	LocalDateTime horaInicio;
	LocalDateTime horaTermino;

	private Maquinas(String nome) {
		this.nome = nome;
	}

	void alugar(String jogo ) throws InterruptedException {
		if(disponibilidade) {
			this.jogo = jogo;
			this.disponibilidade = false;
			this.horaInicio = LocalDateTime.now();
			System.out.println(nome + " alugada com sucesso para o jogo " + jogo + " às " + horaInicio.getHour() + ":" + horaInicio.getMinute());
			Thread.sleep(2000);
		} else {
			System.out.println("Máquina indisponível");
		}
	}

	boolean disponivel() {
		return disponibilidade;
	}
	
	static Maquinas[] pc = new Maquinas[5];
	static	Maquinas[] playstation = new Maquinas[5];
	static	Maquinas[] xbox = new Maquinas[5];
		
	static void inicializarMaquinas() {
		for (int i = 0; i < 5; i++) {
			pc[i] = new Maquinas("PC" + (i+1));
			playstation[i] = new Maquinas("Playstation" + (i+1));
			xbox[i] = new Maquinas("Xbox" + (i+1));
		}
	}	
}

public class AlugarMaquinas{
	public static void alugarMaquinas(Scanner sc) throws InterruptedException {
		
		System.out.println("=== Escolha uma opção ===");
		System.out.println("=== 1- PC ===");
		System.out.println("=== 2- playstatio ===");
		System.out.println("=== 3- xbox ===");
		
		int opcao = sc.nextInt();
		sc.nextLine();
		
		System.out.println("=== Digite o nome do jogo excolhido ===");
		String jogo = sc.nextLine();
		
		boolean alugou = false;
		
		switch (opcao) {
			case 1:
			//Aluga primeiro PC disponível
			for(int i = 0; i < 5; i++) {
				if((Maquinas.pc[i]).disponivel()){
					Maquinas.pc[i].alugar(jogo);
					alugou = true;
					break;
				}
			}
			break;
			case 2:
			//Aluga primeiro Playstation disponível
			for(int i = 0; i < 5; i++) {
				if((Maquinas.playstation[i]).disponivel()){
					Maquinas.playstation[i].alugar(jogo);
					alugou = true;
					break;
				}
			}
			break;
			case 3:
			//Aluga primeiro Xbox disponível
			for(int i = 0; i < 5; i++) {
				if((Maquinas.xbox[i]).disponivel()){
					Maquinas.xbox[i].alugar(jogo);
					alugou = true;
					break;
				}
			}
			break;
			default:
			System.out.println("Opção inválida");
			break;
		}
		if(!alugou) {
			System.out.println("Não há máquinas disponíveis");
		}
	}
}