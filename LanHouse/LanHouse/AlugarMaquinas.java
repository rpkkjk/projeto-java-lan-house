package LanHouse;
import java.util.Scanner;
import java.time.LocalDateTime;

class Maquinas {
	String nome;
	boolean disponibilidade = true;
	String jogo;
	LocalDateTime horaInicio;
	LocalDateTime horaTermino;

	void alugar(String jogo ) {
		if(disponibilidade) {
			this.jogo = jogo;
			this.disponibilidade = false;
			this.horaInicio = LocalDateTime.now();
			System.out.println(nome + " alugada com sucesso para o jogo " + jogo);
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
				pc[i] = new Maquinas();
				pc[i].nome = ("PC" + (i+1));
				playstation[i] = new Maquinas();
				playstation[i].nome = ("Playstation" + (i+1));
				xbox[i] = new Maquinas();
				xbox[i].nome = ("Xbox" + (i+1));
			}
				
		}
			
	}
	
	public class AlugarMaquinas{
		public static void main(String[] args) {
		Maquinas.inicializarMaquinas();
		Scanner op = new Scanner(System.in);
		Scanner jg = new Scanner(System.in);
		
		System.out.println("=== Escolha uma opção ===");
		System.out.println("=== 1- PC ===");
		System.out.println("=== 2- playstatio ===");
		System.out.println("=== 3- xbox ===");
		
		int opcao = op.nextInt();

		System.out.println("=== Digite o nome do jogo excolhido ===");
		String jogo = jg.nextLine();
		
		boolean alugou = false;

		switch (opcao) {
			case 1:
				for(int i = 0; i < 5; i++) {
					if((Maquinas.pc[i]).disponivel()){
						Maquinas.pc[i].alugar(jogo);
						alugou = true;
						break;
					}
				}
				break;
			case 2:
				for(int i = 0; i < 5; i++) {
					if((Maquinas.playstation[i]).disponivel()){
						Maquinas.playstation[i].alugar(jogo);
						alugou = true;
						break;
					}
				}
				break;
			case 3:
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
		jg.close();
		op.close();
	}
}