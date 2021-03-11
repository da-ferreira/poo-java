
package Aula_06_projeto_classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author david-ferreira
 */

public class testaBankAccount {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BankAccount contas[] = new BankAccount[4];        
        preencheBanco(contas, "C:\\Users\\ferre\\Documents\\NetBeansProjects\\POO-CC3A\\src\\Aula_06_projeto_classes\\ENTRADA.txt");
        mostrarInfo(contas);
    }
    
    public static void mostrarInfo(BankAccount contas[]) {
        System.out.println("Nome \t\t\t Saldo \t\t\t Número da Conta");
        
        for (BankAccount conta : contas) {
            System.out.printf("%s \t\t %.4f \t\t   %d\n", conta.getOwner(), conta.getBalance(), conta.getAccountNumber());
        }
    }
    
    public static void preencheBanco(BankAccount contas[], String arquivo) throws FileNotFoundException, IOException {
        BufferedReader in = new BufferedReader(new FileReader(arquivo));
        
        int quantidade = Integer.parseInt(in.readLine());  // Quantidade de usuario no arquivo (Banco)
        
        for (int i=0; i < quantidade; i++) {
            String linha[] = in.readLine().split(";");  // Passando os dados (nome e saldo) para um array.
            
            contas[i] = new BankAccount(linha[0], Double.parseDouble(linha[1]));
        }
        
        in.close();
    }
}

