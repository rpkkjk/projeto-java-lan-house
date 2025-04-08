package LanHouse;

import java.time.Duration;
import java.util.Scanner;
import static LanHouse.Main.*;

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

     static void criaCliente(Scanner sc) throws InterruptedException{
        AcoesPlano acao = new AcoesPlano();

         System.out.println("=== Digite o nome ===");
            String nome = sc.nextLine();

            System.out.println("=== Digite o CPF ===");
            String cpf = sc.nextLine();
            
            System.out.println("=== Digite o telefone ===");
            String telefone = sc.nextLine();
            
            int planoEsclhido = acao.opcoesPlado(sc);
            
            Cliente novoCliente = new Cliente(nome, cpf, telefone, planoEsclhido);
            clientes.add(novoCliente);
            System.out.println("=== Cliente cadastrado com sucesso ===");
            Thread.sleep(1500);
    }

     static void descontarHoras(Scanner sc){

        System.out.println("=== Digite o CPF ===");
        String cpf = sc.nextLine();

        for (int i = 0; i < clientes.size(); i++) {

            if (clientes.get(i).getCpf().equals(cpf)) {

                Duration duracao = Duration.ofHours(1);
                int minutos = (int) duracao.toMinutes();
                if (clientes.get(i).getMinutos() >= minutos) {
                    clientes.get(i).setMinutos((clientes.get(i).getMinutos() - minutos));
                    System.out.println("=== Horas descontadas com sucesso ===");
                    System.out.println("=== Horas restantes: " + clientes.get(i).getMinutos() / 60 + " ===");
                } else {
                    System.out.println("=== Horas insuficientes ===");

                }
            } else {
                System.out.println("=== CPF não encontrado ===");
            }
        }
    }

    static void listarPlanos(){
        for(Cliente cl : clientes){
            System.out.println(cl.getNome() + "-" + cl.getCpf() + "-" + cl.getTelefone() + "-" + cl.getMinutos());
        }
    }
}


class Plano{
    static void plano(Scanner sc) throws InterruptedException{

        System.out.println("=== Escolha uma opção  ===");
        System.out.println("=== 1- Novo plano ===");
        System.out.println("=== 2- Cancelar plano ===");
        System.out.println("=== 3- Listar planos ativos ===");
        System.out.println("=== 4- Voltar ===");
        int opcao = sc.nextInt();
        sc.nextLine();

        switch(opcao){
            case 1:
                AcoesPlano.criaCliente(sc);
                break;
            case 2:
                System.out.println("=== Cancelar plano ===");
                System.out.println("=== Digite o CPF ===");
                String cpf = sc.nextLine();
                for (int i = 0; i < clientes.size(); i++) {
                    if (clientes.get(i).getCpf().equals(cpf)) {
                        clientes.remove(i);
                        System.out.println("=== Plano cancelado com sucesso ===");
                        break;
                    }
                }
                break;
                case 3:
                    AcoesPlano.listarPlanos();
            case 4:
                System.out.println("=== Voltando ===");
                Thread.sleep(1500);
                break;
            default:
                System.out.println("=== Opção inválida ===");
                Thread.sleep(1500);
                break;
        }
    }

}

