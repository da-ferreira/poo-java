
package source;

import java.util.Scanner;
import static source.Utilities.interacaoDepositar;
import static source.Utilities.interacaoSacar;
import static source.Utilities.interacaoTransferir;
import static source.Utilities.mostrarInfo;

/**
 * @author david-ferreira
 */

public class BancoApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        BankAccount contas[] = new BankAccount[5];  // Criando 5 instancias de contas.
        
        contas[0] = new BankAccount("Marcos", 1000.00);
        contas[1] = new BankAccount("Júlia", 250.00);
        contas[2] = new BankAccount("João Vitor", 2500.00);
        contas[3] = new BankAccount("Roberto", 3000.00);
        contas[4] = new BankAccount("Janaína", 4500.00);
        
        boolean sair = false;
        
        while (! sair) {
            System.out.println("\nEscolha uma operação.");
            System.out.println("1. Mostar os saldos de todas as contas");
            System.out.println("2. Sacar");
            System.out.println("3. Depositar");
            System.out.println("4. Transferir");
            System.out.println("5. Sair do sistema");
            
            System.out.print(">>> ");
            int escolha = in.nextInt();
            
            switch(escolha) {
                case 1: 
                    mostrarInfo(contas);
                    break;
                case 2:
                    interacaoSacar(contas);
                    break;
                case 3:
                    interacaoDepositar(contas);
                    break;
                case 4:
                    interacaoTransferir(contas);
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção Inválida!");  // caso nao for nenhumas acima.
            }
        }
        
        System.out.println("\nAplicação terminada. Volte Sempre :) \n");
        
    }
}
