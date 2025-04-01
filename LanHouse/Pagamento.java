package LanHouse;

import java.util.Scanner;
import static LanHouse.Main.*;

class Pagamento{
    String formaPagamento;

    byte  maquinasOcupadas() {
        byte flag = 0;   

        System.out.println("Máquinas ocupadas");
        for (int i = 0; i < 5; i++) {
            if (!pcArrey[i].getDisponivel()) {
                System.out.println(pcArrey[i].getNome() + " - " + pcArrey[i].getJogo() + " - " + pcArrey[i].getHoraInicio() + "\n");
                flag = 1;
            }

            if (!playStationArrey[i].getDisponivel()) {
                System.out.println(playStationArrey[i].getNome() + " - " + playStationArrey[i].getJogo() + " - " + playStationArrey[i].getHoraInicio() + "\n");
                flag = 1;
            }

            if (!xboxArrey[i].getDisponivel()) {
                System.out.println(xboxArrey[i].getNome() + " - " + xboxArrey[i].getJogo() + " - " + xboxArrey[i].getHoraInicio() + "\n");
                flag = 1;
            }
        }
        return flag;
    }

    void formaPagamento(Scanner sc) throws InterruptedException {
        String formaPagamento = "";
        
        System.out.println("=== Escolha uma opção ===");
        System.out.println("=== 1- dinheiro ===");
        System.out.println("=== 2- cartão ===");
        
        int opcao = sc.nextInt();
        sc.nextLine();
        if(opcao == 1){
            formaPagamento = "dinheiro";
            System.out.println("Pagamento realizado com " + formaPagamento);
        } else if(opcao == 2){
            formaPagamento = "cartão";
            System.out.println("Pagamento realizado com " + formaPagamento);
        }
        
        Thread.sleep(3000);
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
                if (pcArrey[i].getNome().equals(nome)) {
                pcArrey[i].liberar();
                break;
            }
            if (playStationArrey[i].getNome().equals(nome)) {
                playStationArrey[i].liberar();
                break;
            }
            if (xboxArrey[i].getNome().equals(nome)) {
                xboxArrey[i].liberar();
                break;
            }
        }
        
        pagamento.formaPagamento(sc);
        }else{
            System.out.println("Não há máquinas ocupadas");
            Thread.sleep(1500);
        }
    }
}
