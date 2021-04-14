
package Aula_09_Colecoes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author david-ferreira
 */

public class Bank {
    private ArrayList<BankAccount> accounts;  // Vetor dinamico indexado de contas bancárias.
    
    public Bank() {
        accounts = new ArrayList<>();
    }
    
    /**
     * Lê o arquivo passado e atribui cada linha a um novo BankAccount.
     * @param filename O endereço do arquivo.
     */
    public Bank(String filename) {
        accounts = new ArrayList<>();
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            
            int quantidade = Integer.parseInt(reader.readLine());
            
            for (int i=0; i < quantidade; i++) {
                String dados[] = reader.readLine().split("#");
                
                int numberAccount = Integer.parseInt(dados[0]);
                String passwordAccount = dados[1];
                String ownerAccount = dados[2];
                double balanceAccount = Double.parseDouble(dados[3]);
                
                accounts.add(new BankAccount(ownerAccount, numberAccount, balanceAccount, passwordAccount));
            }
            
            reader.close();  // Fechando a comunicação do arquivo físico com o arquivo lógico.
        }
        catch (IOException error) {
            System.exit(-1);
        }
    }
   
    /**
     * Adiciona uma nova conta ao Banco.
     * @param newAccount: Nova conta.
     */
    public void addAccount(BankAccount newAccount) {        
        accounts.add(newAccount);  // Insere no final do vetor.
    }
    
    /** @return A soma do saldo de todas as contas. */
    public double getTotalBalance() {
        double soma = 0;
        
        for (BankAccount bank : accounts)
            soma += bank.getBalance();
        
        return soma;
    }
    
    /**
     * @return Devolve a conta vinculada ao numero informado.
     * @param accountNumber: Numero da conta.  
     */
    public BankAccount find(int accountNumber) {
        for (BankAccount bank : accounts)
            if (bank.getAccountNumber() == accountNumber)
                return bank;
        
        return null;  // A conta não está no banco.
    }
    
    /** @return A conta que contém o maior saldo. */
    public BankAccount getMaximum() {
        BankAccount maior = accounts.get(0);
        
        for (BankAccount bank : accounts)
            if (bank.getBalance() > maior.getBalance())
                maior = bank;
        
        return maior;
    }
    
    /**
     * @param limit: Limite de saldo.
     * @return Retorna o numero de contas que tenha o saldo >= ao limit.
     */
    public int count(double limit) {
        int result = 0;
        
       for (BankAccount bank : accounts)
            if (bank.getBalance() >= limit)
                result++;
        
        return result;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }
    
    /**
     * Verifica se, dada uma instancia de BankAccount, a conta está ou não no Banco de contas.
     * @param bank O objeto a ser verificado.
     * @return true se no Banco de contas já existir uma conta igual a bank; false, caso contrário.
     */
    public boolean contains(BankAccount bank) {
        for (BankAccount bank_i : accounts)
            if (bank_i.equals(bank))
                return true;
        
        return false;
    }
    
    public void removeAccount(int accountNumber) {
        BankAccount bank_instance = null;
        
        for (BankAccount bank : accounts) {
            if (accountNumber == bank.getAccountNumber())
                bank_instance = bank;
        }
        
        accounts.remove(bank_instance);
    }
    
    public void removeAccount(BankAccount bank) {
        accounts.remove(bank);
    }
} 
 