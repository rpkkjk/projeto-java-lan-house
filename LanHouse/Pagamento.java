package LanHouse;

import java.util.Scanner;

class Pagamento{
    String formaPagamento;

    String  maquinasOcupadas(Scanner sc) {
        String nome;
        System.out.println("Máquinas ocupadas");
        for (int i = 0; i < 5; i++) {
            if (!Maquinas.pc[i].disponibilidade) {
                System.out.println(Maquinas.pc[i].nome + " - " + Maquinas.pc[i].jogo + " - " + Maquinas.pc[i].horaInicio.getHour() + ":" + Maquinas.pc[i].horaInicio.getMinute());
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!Maquinas.playstation[i].disponibilidade) {
                System.out.println(Maquinas.playstation[i].nome + " - " + Maquinas.playstation[i].jogo + " - " + Maquinas.playstation[i].horaInicio.getHour() + ":" + Maquinas.playstation[i].horaInicio.getMinute());
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!Maquinas.xbox[i].disponibilidade) {
                System.out.println(Maquinas.xbox[i].nome + " - " + Maquinas.xbox[i].jogo + " - " + Maquinas.xbox[i].horaInicio.getHour() + ":" + Maquinas.xbox[i].horaInicio.getMinute());
            }
        }
        System.out.println("Digite o nome da máquina que deseja pagar");
        Scanner sc1 = new Scanner(System.in);
        nome = sc1.nextLine();
        sc1.close();
        return nome;
    }

}

class RealizarPagamento{
    static void realizarPagamento(Scanner sc) throws InterruptedException {
        Pagamento pagamento = new Pagamento();
        String nome = pagamento.maquinasOcupadas(sc);
        while (true) 
        {
            for(int i = 0; i < 5; i++) {
                if (Maquinas.pc[i].nome.equals(nome)) {
                    Maquinas.pc[i].liberar();
                    break;
                }
                if (Maquinas.playstation[i].nome.equals(nome)) {
                    Maquinas.playstation[i].liberar();
                    break;
                }
                if (Maquinas.xbox[i].nome.equals(nome)) {
                    Maquinas.xbox[i].liberar();
                    break;
                }
            }
            break;
        }

        System.out.println("=== Escolha uma opção ===");
        System.out.println("=== 1- dinheiro ===");
        System.out.println("=== 2- cartão ===");

        int opcao = sc.nextInt();
        sc.nextLine();
        if(opcao == 1){
            pagamento.formaPagamento = "dinheiro";
        } else if(opcao == 2){
            pagamento.formaPagamento = "cartão";
        }
        System.out.println("Pagamento realizado com " + pagamento.formaPagamento);

        Thread.sleep(2000);

    }
}
