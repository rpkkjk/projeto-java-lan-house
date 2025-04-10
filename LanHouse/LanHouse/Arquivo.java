package LanHouse;

import static LanHouse.Main.clientes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Arquivo {
    public void lerArquivo(){
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Clientes.txt"))) {
            for(Cliente cl : clientes){
                bw.write(cl.getNome() + " " + cl.getCpf() + " " + cl.getTelefone() + " " + cl.getPlano() + " " + cl.getMinutos() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
