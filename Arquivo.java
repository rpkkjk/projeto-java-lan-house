package LanHouse;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Arquivo {
    public static void salvarTodosPlanos(ArrayList<Cliente> listaClientes) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("planos.txt"))) {
            for (Cliente cl : listaClientes) {
                writer.write("Nome: " + cl.getNome() + ", CPF: " + cl.getCpf() +
                             ", Telefone: " + cl.getTelefone() + ", Plano: " + cl.getPlano());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar clientes: " + e.getMessage());
        }
    }

    public static ArrayList<Cliente> lerPlanos() {
        ArrayList<Cliente> lista = new ArrayList<>();
    
        File arquivo = new File("planos.txt");
    
        if (!arquivo.exists()) {
            System.out.println("Arquivo planos.txt não encontrado. Começando com lista vazia.");
            return lista;
        }
    
        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
    
                try {
                    String[] partes = linha.split(", ");
    
                    if (partes.length < 4) {
                        System.out.println("Linha ignorada (formato incorreto): " + linha);
                        continue;
                    }
    
                    String nome = partes[0].split(": ")[1];
                    String cpf = partes[1].split(": ")[1];
                    String telefone = partes[2].split(": ")[1];
                    String plano = partes[3].split(": ")[1];
    
                    Cliente cliente = new Cliente(nome, cpf, telefone, plano);
                    lista.add(cliente);
    
                } catch (Exception e) {
                    System.out.println("Erro ao processar linha: " + linha);
                    System.out.println("Detalhes: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }
    
        return lista;
    }
    
}
