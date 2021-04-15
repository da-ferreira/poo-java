
package Aula_04_matrizes_arquivos;

import java.util.Scanner;

/**
 * @author david-ferreira
 */

public class Ex05_BancoAppV1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String nomes[] = {"Marcos", "Júlia", "João", "Roberto", "Janaína"};
        double saldos[][] = {
            {1000.00, 2500.00},
            {250.00,  1500.00},
            {2500.00,  750.00},
            {3000.00,   50.00}, 
            {4500.00, 3200.00}
        };
        
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
                    mostrarSaldo(nomes, saldos);
                    break;
                case 2:
                    interacaoSacar(saldos);
                    break;
                case 3:
                    interacaoDepositar(saldos);
                    break;
                case 4:
                    transferencia(saldos);
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

    public static void mostrarSaldo(String nomes[], double saldos[][]) {
        System.out.println("SALDOS DE TODOS OS CLIENTES");
        System.out.println("N. Nome \t Conta Corrente \t Conta Poupança");
        
        for (int i=0; i < saldos.length; i++) {
            String mensagem = String.format("%d. %s \t %.2f \t\t %.2f", i, nomes[i], saldos[i][0], saldos[i][1]);   
            System.out.println(mensagem);
        }
    }
    
    public static void depositar(double saldos[][], double valor, int cliente, int tipo_da_conta) {
        // cliente e conta corrente ou poupança
        saldos[cliente][tipo_da_conta] += valor;
    }
    
    public static void sacar(double saldos[][], double valor, int cliente, int tipo_da_conta) {
        // cliente e conta corrente ou poupança
        saldos[cliente][tipo_da_conta] -= valor;
    }
    
    public static void interacaoSacar(double saldos[][]) {
        Scanner in = new Scanner(System.in);
        
        boolean clienteValido = false;
        int cliente = -1;
        
        while (! clienteValido) {
            System.out.printf("\nO saque será efetuado na conta de qual cliente [0 a %d]: ", saldos.length - 1);
            cliente = in.nextInt();
            
            if (cliente >= 0 && cliente < saldos.length) {
                clienteValido = true;
            }
            else {
                System.out.println("Índice do cliente inválido!");
            }
        }
        
        boolean contaValida = false;
        int tipoConta = -1;
        
        while (! contaValida) {
            System.out.print("O saque será efetuado em qual tipo conta [0-CC,  1-CP]: ");
            tipoConta = in.nextInt();
            
            if (tipoConta == 0 || tipoConta == 1) {
                contaValida = true;
            }
            else {
                System.out.println("Índice inválido!");
            }            
        }
        
        System.out.print("Qual o valor do saque: ");
        double valor = in.nextDouble();
        sacar(saldos, valor, cliente, tipoConta);
    }

    public static void interacaoDepositar(double saldos[][]) {
        Scanner in = new Scanner(System.in);
        
        boolean clienteValido = false;
        int cliente = -1;
        
        while (! clienteValido) {
            System.out.printf("\nO depósito será efetuado na conta de qual cliente [0 a %d]: ", saldos.length - 1);
            cliente = in.nextInt();
            
            if (cliente >= 0 && cliente < saldos.length) {
                clienteValido = true;
            }
            else {
                System.out.println("Índice do cliente inválido!");
            }
        }
        
        boolean contaValida = false;
        int tipoConta = -1;
        
        while (! contaValida) {
            System.out.print("O deposito será efetuado em qual tipo conta [0-CC,  1-CP]: ");
            tipoConta = in.nextInt();
            
            if (tipoConta == 0 || tipoConta == 1) {
                contaValida = true;
            }
            else {
                System.out.println("Índice inválido!");
            }            
        }
        
        System.out.print("Qual o valor do depósito: ");
        double valor = in.nextDouble();
        depositar(saldos, valor, cliente, tipoConta);
    }
    
    public static void transferencia(double saldos[][]) {
        Scanner in = new Scanner(System.in);
        
        int cliente_transferidor;  // conta do cliente que vai transferir
        int conta_transferidor;  // tipo conta do cliente que vai transferir
        int cliente_recebedor;  // conta do cliente que vai receber.
        int conta_recebedor;  // tipo conta do cliente que vai receber.
        
        // Cliente que irá fazer a transferencia: cliente e tipo de conta
        
        do {
            System.out.printf("\nInforme o cliente que efetuará a transferencia [0 a %d]: ", saldos.length - 1);
            cliente_transferidor = in.nextInt();
            
            if (cliente_transferidor < 0 || cliente_transferidor > saldos.length - 1)
                System.out.println("Cliente inválido. Por favor informe corretamente.");
            
        } while (cliente_transferidor < 0 || cliente_transferidor > saldos.length - 1);
        
        do {
            System.out.printf("Informe o tipo de conta do cliente que efetuará a transferencia [0-CC,  1-CP]: ");
            conta_transferidor = in.nextInt();
            
            if (conta_transferidor != 0 && conta_transferidor != 1)
                System.out.println("Conta inválida. Por favor informe corretamente.");
            
        } while (conta_transferidor != 0 && conta_transferidor != 1);
        
        // Cliente que irá receber a transferencia: cliente e tipo de conta
        
        do {
            System.out.printf("Informe o cliente que receberá a transferencia [0 a %d]: ", saldos.length - 1);
            cliente_recebedor = in.nextInt();
            
            if (cliente_recebedor < 0 || cliente_recebedor > saldos.length - 1) {
                System.out.println("Cliente inválido. Por favor informe corretamente.");
            } else if (cliente_recebedor == cliente_transferidor) {
                System.out.println("Voce está tentando transferir para sí mesmo. Por favor informe corretamente");
            }
            
        } while (cliente_recebedor < 0 || cliente_recebedor > saldos.length - 1 || cliente_recebedor == cliente_transferidor);
        
        do {
            System.out.printf("Informe o tipo de conta do cliente que receberá a transferencia [0-CC,  1-CP]: ");
            conta_recebedor = in.nextInt();
            
            if (conta_recebedor != 0 && conta_recebedor != 1)
                System.out.println("Conta inválida. Por favor informe corretamente.");
            
        } while (conta_recebedor != 0 && conta_recebedor != 1);
        
        System.out.print("Digite o valor da transferencia: ");
        double valor = in.nextDouble();
        
        sacar(saldos, valor, cliente_transferidor, conta_transferidor);
        depositar(saldos, valor, cliente_recebedor, conta_recebedor);        
    }
}
