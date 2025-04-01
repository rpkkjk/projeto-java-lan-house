package LanHouse;
import java.util.Scanner;

import static LanHouse.Main.*;

class AlugarMaquinas {

		static void alugarMaquinas (Scanner sc) throws InterruptedException {

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
					for (int i = 0; i < 5; i++) {
						if (pcArrey[i].getDisponivel()) {
							System.out.println("=== Digite o nome do jogo excolhido ===");
							jogo = sc.nextLine();
							pcArrey[i].alugar(jogo);
							alugou = true;
							break;
						}
					}

					if (!alugou) {
						System.out.println("Não há máquinas disponíveis");
						Thread.sleep(1500);
					}
					break;
				case 2:
					//Aluga primeiro Playstation disponível
					for (int i = 0; i < 5; i++) {
						if (playStationArrey[i].getDisponivel()) {
							System.out.println("=== Digite o nome do jogo excolhido ===");
							jogo = sc.nextLine();
							playStationArrey[i].alugar(jogo);
							alugou = true;
							break;
						}

					}
					if (!alugou) {
						System.out.println("Não há máquinas disponíveis");
						Thread.sleep(1500);
					}
					break;
				case 3:
					//Aluga primeiro Xbox disponível
					for (int i = 0; i < 5; i++) {
						if (xboxArrey[i].getDisponivel()) {
							System.out.println("=== Digite o nome do jogo excolhido ===");
							jogo = sc.nextLine();
							xboxArrey[i].alugar(jogo);
							alugou = true;
							break;
						}
					}
					if (!alugou) {
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