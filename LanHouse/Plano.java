package LanHouse;

import java.util.Scanner;

class Plano{

    int opcoesPlado(Scanner sc){
        int opcao = 0;
        System.out.println("=== Escolha um plano ===");
        System.out.println("=== 1- Semanal: 20 horas em qualquer maquina por R$20,00  ===");
        System.out.println("=== 2- Mensal: 100 horas em qualquer maquina por R$90,00 ===");
        System.out.println("=== 3- anual: 1500 horas em qualquer maquina por R$1300,00 ===");
        System.out.println("=== 4- Voltar ===");
        
        opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }
}



