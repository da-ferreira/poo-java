
package Aula_06_projeto_classes;

import java.util.Scanner;

/**
 * @author david-ferreira
 */

public class testaBankAccount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        BankAccount contas[] = new BankAccount[5];
        
        for (int i=0; i < contas.length; i++) {
            in = new Scanner(System.in);
            System.out.printf("Digite o nome da %d° conta: ", i + 1);
            String nome = in.nextLine();
                        
            System.out.printf("Digite o saldo da %d° conta: ", i + 1);
            double saldo = in.nextDouble();
            
            contas[i] = new BankAccount(nome, saldo);
            System.out.println("");
        }
        
        for (int i=0; i < 5; i++) {
            System.out.println(contas[i]);
        }
    }
}
