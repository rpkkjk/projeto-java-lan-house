package LanHouse;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args) {


		System.out.println("=== Escolha uma opção ===");
		System.out.println("=== 1- alugar máquina ===");
		System.out.println("=== 2- pagamento ===");
		System.out.println("=== 3- plano ===");
		
		Scanner sc = new Scanner(System.in);
		int opcao = sc.nextInt();
		switch(opcao){
			case 1: 
				AlugarMaquinas.main(args);
				break;
			case 2:
				// Adicione o código para pagamento aqui
				break;
			case 3:
				// Adicione o código para plano aqui
				break;
			default:
				System.out.println("Opção inválida");
				break;
		}
		sc.close();
	}
}
















