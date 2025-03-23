package LanHouse;

import java.util.Scanner;

class Pagamento{
    String formaPagamento;

    byte  maquinasOcupadas() {
        byte flag = 0;   

        System.out.println("Máquinas ocupadas");
        for (int i = 0; i < 5; i++) {
            if (!Maquinas.pc[i].disponibilidade) {
                System.out.println(Maquinas.pc[i].nome + " - " + Maquinas.pc[i].jogo + " - " + Maquinas.pc[i].horaInicio.getHour() + ":" + Maquinas.pc[i].horaInicio.getMinute() + "\n");
                flag = 1;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!Maquinas.playstation[i].disponibilidade) {
                System.out.println(Maquinas.playstation[i].nome + " - " + Maquinas.playstation[i].jogo + " - " + Maquinas.playstation[i].horaInicio.getHour() + ":" + Maquinas.playstation[i].horaInicio.getMinute() + "\n");
                flag = 1;
            }
        }
        for (int i = 0; i < 5; i++) {
            if (!Maquinas.xbox[i].disponibilidade) {
                System.out.println(Maquinas.xbox[i].nome + " - " + Maquinas.xbox[i].jogo + " - " + Maquinas.xbox[i].horaInicio.getHour() + ":" + Maquinas.xbox[i].horaInicio.getMinute() + "\n");   
                flag = 1;
            }
        }
        return flag;
    }
}

class RealizarPagamento{
    static void realizarPagamento(Scanner sc) throws InterruptedException {
        //Scanner sc = new Scanner(System.in);
        Pagamento pagamento = new Pagamento();
        
        byte falg = pagamento.maquinasOcupadas();
        
        if(falg != 0){
            System.out.println("Digite o nome da máquina que deseja pagar");
            
            String nome = sc.nextLine();
            
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
        
            Thread.sleep(3000);
        }else{
            System.out.println("Não há máquinas ocupadas");
            Thread.sleep(1500);
        }
    }
}

