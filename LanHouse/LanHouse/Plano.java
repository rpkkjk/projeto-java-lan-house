package LanHouse;

import java.util.Scanner;

class AcoesPlano{
    

    int opcoesPlado(Scanner sc){
        int opcao = 0;
        System.out.println("=== Escolha um plano ===");
        System.out.println("=== 1- Semanal: 20 horas em qualquer maquina por R$20,00  ===");
        System.out.println("=== 2- Mensal: 100 horas em qualquer maquina por R$90,00 ===");
        System.out.println("=== 3- Semestral: 800 horas em qualquer maquina por R$700,00 ===");
        System.out.println("=== 4- Voltar ===");
        
        opcao = sc.nextInt();
        sc.nextLine();
        return opcao;
    }
}


class Plano{
    static void plano(Scanner sc) throws InterruptedException{

        System.out.println("=== Escolha uma opção  ===");
        System.out.println("=== 1- Novo plano ===");
        System.out.println("=== 2- Cancelar plano ===");
        System.out.println("=== 3- Voltar ===");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch(opcao){
            case 1:
                Main.criaCliente(sc);
            break;

        }
    }
}

