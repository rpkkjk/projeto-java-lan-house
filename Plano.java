package LanHouse;

import java.time.Duration;
import java.util.Scanner;
import static LanHouse.Main.*;

class AcoesPlano{
    

    String opcoesPlano(Scanner sc) {
        int opcao = 0;
        System.out.println("=== Escolha um plano ===");
        System.out.println("=== 1- Semanal: 1200 minutos em qualquer maquina por R$20,00  ===");
        System.out.println("=== 2- Mensal: 6000 minutos em qualquer maquina por R$90,00 ===");
        System.out.println("=== 3- Semestral: 48000 minutos em qualquer maquina por R$700,00 ===");
        
        opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                return "semanal";
            case 2:
                return "mensal";
            case 3:
                return "semestral";
            default:
                throw new IllegalArgumentException("Opção invalida");
        }
    }

     static void criaCliente(Scanner sc) throws InterruptedException{
        AcoesPlano acao = new AcoesPlano();

         System.out.println("=== Digite o nome ===");
            String nome = sc.nextLine();

            System.out.println("=== Digite o CPF ===");
            String cpf = sc.nextLine();
            
            System.out.println("=== Digite o telefone ===");
            String telefone = sc.nextLine();
            
            String planoEscolhido = acao.opcoesPlano(sc);
            
            Cliente novoCliente = new Cliente(nome, cpf, telefone, planoEscolhido);
            clientes.add(novoCliente);
            System.out.println("=== Cliente cadastrado com sucesso ===");
            Thread.sleep(1500);
    }

     static void descontarHoras(Scanner sc){

        System.out.println("=== Digite o CPF ===");
        String cpf = sc.nextLine();

        for (Cliente cl : clientes) {

            if (cl.getCpf().equals(cpf)) {

                Duration duracao = Duration.ofMinutes(1);
                int minutos = (int) duracao.toMinutes();
                if (cl.getMinutos() >= minutos) {
                    cl.minutosRestantes = cl.getMinutos() - minutos;
                    System.out.println("=== Minutos descontadas com sucesso ===");
                    System.out.println("=== Minutos restantes: " + cl.getMinutos() / 60 + " ===");
                } else {
                    System.out.println("=== Minutos insuficientes ===");

                }
            } else {
                throw new IllegalAccessError("CPF NÃO ENCONTRADO");
                
            }
        }
    }

    static void listarPlanos(){
        for(Cliente cl : clientes){
            System.out.println(cl.getNome() + "-" + cl.getCpf() + "-" + cl.getTelefone() + "-" + cl.getPlano());
        }
    }
}


class Plano{
    static void plano(Scanner sc) throws Exception{

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
                Thread.sleep(5000);
                break;
            default:
                throw  new IllegalAccessException("opção invalida");
        }
    }

}

