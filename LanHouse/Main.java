package LanHouse;

import java.io.IOException;
import java.util.Scanner;

public class Main
{
	public static void main(String[] args) throws InterruptedException, IOException {
		Maquinas.inicializarMaquinas();
		Scanner sc = new Scanner(System.in);
		while (true) {
			
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			
			System.out.println("=== Escolha uma opção ===");
			System.out.println("=== 1- alugar máquina ===");
			System.out.println("=== 2- pagamento ===");
			System.out.println("=== 3- plano ===");
			System.out.println("=== 4- sair ===");
			
			int opcao = sc.nextInt();
			
			
			switch(opcao){
				case 1: 
				AlugarMaquinas.alugarMaquinas(sc);
				break;
				case 2:
				// Adicione o código para pagamento aqui
				break;
				case 3:
				// Adicione o código para plano aqui
				break;
				case 4:
				System.out.println("Saindo...");
				sc.close();
				System.exit(0);
				break;
				default:
				System.out.println("Opção inválida");
				break;
			}
		}
	}
}