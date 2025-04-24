package LanHouse;

import java.util.Scanner;
import static LanHouse.Main.*;

class Pagamento{
    String formaPagamento;

    byte maquinasOcupadas() {
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

    void formaPagamentoComPlano(Scanner sc) throws Exception {
        String formaPagamento = "";

        System.out.println("=== Escolha uma opção ===");
        System.out.println("=== 1- dinheiro ===");
        System.out.println("=== 2- cartão ===");
        System.out.println("=== 3- Descontar horas do plano ===");

        int opcao = sc.nextInt();
        sc.nextLine();
        if(opcao == 1){
            formaPagamento = "dinheiro";
            System.out.println("Pagamento realizado com " + formaPagamento);
        } else if(opcao == 2){
            formaPagamento = "cartão";
            System.out.println("Pagamento realizado com " + formaPagamento);
        }
        else if(opcao == 3){
            AcoesPlano.descontarHoras(sc);
            Thread.sleep(6000);
        }
    }
}

class RealizarPagamento{
    static void realizarPagamento(Scanner sc) throws Exception {
        //Scanner sc = new Scanner(System.in);
        Pagamento pagamento = new Pagamento();

        byte falg = pagamento.maquinasOcupadas();

        if(falg != 0){
            System.out.println("Digite o nome da máquina que deseja pagar");

            String nome = sc.nextLine();
            
            int indice = 0, mqn = 0;

            for(int i = 0; i < 5; i++) {
                if(nome.isBlank()){

                    if (pcArrey[i].getNome().equals(nome)) {
                        pcArrey[i].calculaValor();
                        indice = i;
                        mqn = 1;
                        break;
                    }
                    else if (playStationArrey[i].getNome().equals(nome)) {
                        playStationArrey[i].calculaValor();
                        indice = i;
                        mqn = 2;
                        break;
                    }
                    else if (xboxArrey[i].getNome().equals(nome)) {
                        xboxArrey[i].calculaValor();
                        indice = i;
                        mqn = 3;
                        break;
                    }
                }else{
                    throw new IllegalAccessError("nome da maquina não encontrado");
                }
                throw new IllegalAccessError("nome da maquina não encontrado");
            }

            pagamento.formaPagamentoComPlano(sc);
            
            switch (mqn){
                case 1: pcArrey[indice].liberar(); break;
                case 2: playStationArrey[indice].liberar(); break;
                case 3: xboxArrey[indice].liberar(); break;
            }
        }else{
            System.out.println("Não há máquinas ocupadas");
            Thread.sleep(1500);
        }
    }
} 