
package source;

import java.util.Scanner;

/**
 * @author david-ferreira
 */

public class Utilities {
    public static void mostrarInfo(BankAccount contas[]) {
        System.out.println("\nCONTAS DE TODOS OS CLINTES:");
        
        for (int i=0; i < contas.length; i++) {
            System.out.printf("\n[%d] %s", i, contas[i].toString());
        }
        
        System.out.println("");
    }
    
    public static void interacaoSacar(BankAccount contas[]) {
        Scanner in = new Scanner(System.in);
        mostrarInfo(contas);
        
        boolean clienteValido = false;
        int cliente = -1;
        
        while (! clienteValido) {
            System.out.printf("\nO saque será efetuado na conta de qual cliente [0 a %d]: ", contas.length - 1);
            cliente = in.nextInt();
            
            if (cliente >= 0 && cliente < contas.length) {
                clienteValido = true;
            }
            else {
                System.out.println("Índice do cliente inválido!");
            }
        }
        
        System.out.print("Qual o valor do saque: ");
        double valor = in.nextDouble();
        contas[cliente].withDraw(valor);
        System.out.println("Saque efetuado com sucesso!\n");
    }
    
    public static void interacaoDepositar(BankAccount contas[]) {
        Scanner in = new Scanner(System.in);
        mostrarInfo(contas);
        
        boolean clienteValido = false;
        int cliente = -1;
        
        while (! clienteValido) {
            System.out.printf("\nO depósito será efetuado na conta de qual cliente [0 a %d]: ", contas.length - 1);
            cliente = in.nextInt();
            
            if (cliente >= 0 && cliente < contas.length) {
                clienteValido = true;
            }
            else {
                System.out.println("Índice do cliente inválido!");
            }
            
        }
        
        System.out.print("Qual o valor do depósito: ");
        double valor = in.nextDouble();
        contas[cliente].deposit(valor);
        System.out.println("Depósito efetuado com sucesso!\n");
    }
    
    public static void interacaoTransferir(BankAccount contas[]) {
        Scanner in = new Scanner(System.in);
        mostrarInfo(contas);
        
        boolean clienteValido = false;
        int cliente = -1;
        
        while (! clienteValido) {
            System.out.printf("\nInforme o cliente que efetuará a transferencia [0 a %d]: ", contas.length - 1);
            cliente = in.nextInt();
            
            if (cliente >= 0 && cliente < contas.length) {
                clienteValido = true;
            }
            else {
                System.out.println("Índice do cliente inválido!");
            }
        }
        
        clienteValido = false;
        int clienteTransferido = -1;
        
        while (! clienteValido) {
            System.out.printf("Informe o cliente que receberá a transferencia [0 a %d]: ", contas.length - 1);
            clienteTransferido = in.nextInt();
            
            if (clienteTransferido >= 0 && clienteTransferido < contas.length && clienteTransferido != cliente) {
                clienteValido = true;
            }
            else if (clienteTransferido == cliente) {
                System.out.println("Voce não pode transferir para sí mesmo.");
            }
            else {
                System.out.println("Índice do cliente inválido!");
            }
        }        
        
        System.out.print("Qual o valor da transferencia: ");
        double valor = in.nextDouble();
        contas[cliente].transfer(valor, contas[clienteTransferido]);
        System.out.println("Transferencia efetuada com sucesso!");
    }
}
