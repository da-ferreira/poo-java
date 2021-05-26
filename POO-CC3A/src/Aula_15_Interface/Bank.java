
package Aula_15_Interface;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author david-ferreira
 */

public class Bank {
    private ArrayList<BankAccount> accounts;  // Vetor dinamico indexado de contas bancárias.
    
    public Bank() {
        accounts = new ArrayList<>();
    }
    
    /**
     * Lê o arquivo passado e atribui cada linha a seu respectivo tipo bancário.
     * @param filename O endereço do arquivo.
     */
    public Bank(String filename) {
        accounts = new ArrayList<>();
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            int quantidade = Integer.parseInt(reader.readLine());
            
            /* CLA -> City Law Account
             * FLA -> Federation Law Account
             * SA  -> Savings Account
             * SLA -> Station Law Account
             * RA  -> Regular Account
             */
            for (int i=0; i < quantidade; i++) {
                String dados[] = reader.readLine().split("#");
                BankAccount conta;
                
                if (dados[0].equals("RA")) {
                    conta = new RegularAccount(Double.parseDouble(dados[5]), dados[3], Integer.parseInt(dados[1]),
                                                                           Double.parseDouble(dados[4]), dados[2]);
                    accounts.add(conta);
                }
                else if (dados[0].equals("SA")) {
                    conta = new SavingsAccount(Double.parseDouble(dados[5]), dados[3], Integer.parseInt(dados[1]),
                                                                           Double.parseDouble(dados[4]), dados[2]);
                    accounts.add(conta);
                }
                else if (dados[0].equals("CLA")) {
                    try {
                        conta = new CityLawAccount(dados[9], dados[5], formata.parse(dados[6]), formata.parse(dados[7]), Double.parseDouble(dados[8]),
                                                                        dados[3], Integer.parseInt(dados[1]), Double.parseDouble(dados[4]), dados[2]);
                        accounts.add(conta);
                    } catch (ParseException ex) {
                        Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
                    }          
                }
                else if (dados[0].equals("SLA")) {
                    try {
                        conta = new StateLawAccount(dados[9], dados[5], formata.parse(dados[6]), formata.parse(dados[7]), Double.parseDouble(dados[8]),
                                                                         dados[3], Integer.parseInt(dados[1]), Double.parseDouble(dados[4]), dados[2]);
                        accounts.add(conta);
                    } catch (ParseException ex) {
                        Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
                else if (dados[0].equals("FLA")) {
                    try {
                        conta = new FederationLawAccount(dados[9], dados[5], formata.parse(dados[6]), formata.parse(dados[7]), Double.parseDouble(dados[8]),
                                                                         dados[3], Integer.parseInt(dados[1]), Double.parseDouble(dados[4]), dados[2]);
                        accounts.add(conta);
                    } catch (ParseException ex) {
                        Logger.getLogger(Bank.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
            
            reader.close();  // Fechando a comunicação do arquivo físico com o arquivo lógico.
        }
        catch (IOException error) {
            System.exit(-1);
        }
    }
    
    public int size() {
        return accounts.size();
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
        int inicio = 0;
        int fim = accounts.size() - 1;
        
        while (inicio <= fim) {  // Caso contrario, a conta não está no banco.
            int meio = (inicio + fim) / 2;
            
            if (accountNumber == accounts.get(meio).getAccountNumber()) {
                return accounts.get(meio);
            }
            else if (accountNumber < accounts.get(meio).getAccountNumber()) {
                fim = meio - 1;
            }
            else if (accountNumber > accounts.get(meio).getAccountNumber()) {
                inicio = meio + 1;
            }
        }
        
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
    
    /* MÉTODOS ADICIONAIS */
    
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
    
    /** Remove uma conta no banco por número da conta.
     * @param accountNumber Número da conta do objeto BankAccount a ser removido. */
    public void removeAccount(int accountNumber) {
        for (BankAccount bank : accounts) {
            if (accountNumber == bank.getAccountNumber()) {
                accounts.remove(bank);
                break;
            }
        }
    }
    
    /** Remove uma conta no banco por instância.
     * @param bank Obejto BankAccount a ser removido. */
    public void removeAccount(BankAccount bank) {
        accounts.remove(bank);
    }
    
    /** (SelectionSort) Ordena todas as contas no banco, em ordem crescente, pelos seus números (accountNumber). */
    public void sort() {
        for (int i=0; i < accounts.size() - 1; i++) {
            int posicao_menor = i;
            
            for (int j=i + 1; j < accounts.size(); j++) {  // Cada iteração vai acumulando (a esquerda) a área ordenada.
                if (accounts.get(j).getAccountNumber() < accounts.get(posicao_menor).getAccountNumber())
                    posicao_menor = j;
            }
            
            // Troca (swap)
            BankAccount temp = accounts.get(i);  
            accounts.set(i, accounts.get(posicao_menor));  
            accounts.set(posicao_menor, temp);
        }
    }
    
    /** (SelectionSort) Ordena todas as contas no banco, em ordem crescente, pelos seus saldos (balance). */
    public void sortBalance() {
        for (int i=0; i < accounts.size() - 1; i++) {
            int posicao_menor = i;
            
            for (int j=i + 1; j < accounts.size(); j++) {  // Cada iteração vai acumulando (a esquerda) a área ordenada.
                if (accounts.get(j).getBalance() < accounts.get(posicao_menor).getBalance())
                    posicao_menor = j;
            }
            
            // Troca (swap)
            BankAccount temp = accounts.get(i);  
            accounts.set(i, accounts.get(posicao_menor));  
            accounts.set(posicao_menor, temp);
        }
    }
    
    /** (SelectionSort) Ordena todas as contas no banco, em ordem decrescente, pelos seus saldos (balance). */
    public void sortBalanceDecreasing() {
        for (int i=0; i < accounts.size() - 1; i++) {
            int posicao_maior = i;
            
            for (int j=i + 1; j < accounts.size(); j++) {  // Cada iteração vai acumulando (a esquerda) a área ordenada.
                if (accounts.get(j).getBalance() > accounts.get(posicao_maior).getBalance())
                    posicao_maior = j;
            }
            
            // Troca (swap)
            BankAccount temp = accounts.get(i);  
            accounts.set(i, accounts.get(posicao_maior));  
            accounts.set(posicao_maior, temp);
        }
    }
    
    /**
     * Recebe um nome de um arquivo e escreve todas as informações de cada conta do banco nele.
     * @param filename O nome do arquivo (o caminho em diretorio).
     */
    public void dump(String filename) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));  // gravação
            
            for (BankAccount bank : accounts) {
                writer.write("Conta número: " + bank.getAccountNumber());
                writer.newLine();
                
                writer.write("Senha: " + bank.getPassword());
                writer.newLine();
                
                writer.write("Proprietário: " + bank.getOwner());
                writer.newLine();
                
                writer.write("Saldo: " + bank.getBalance());
                writer.newLine();
                
                writer.newLine();  // Separa as contas por uma linha em branco
            }
            
            writer.flush();
            writer.close();
        }
        catch (IOException error) {
            System.exit(-1);
        }
    }
    
    /** @return A coleção de contas do tipo RegularAccount */
    public ArrayList<RegularAccount> regularAccounts() {
        ArrayList<RegularAccount> contasCorrentes = new ArrayList<>();
        
        for (BankAccount bank : accounts) {
            if (bank instanceof RegularAccount)
                contasCorrentes.add((RegularAccount) bank);
        }
        
        return contasCorrentes;
    }
    
    /** @return A coleção de contas do tipo SavingsAccount */
    public ArrayList<SavingsAccount> savingsAccounts() {
        ArrayList<SavingsAccount> contasPoupancas = new ArrayList<>();
        
        for (BankAccount bank : accounts) {
            if (bank instanceof SavingsAccount)
                contasPoupancas.add((SavingsAccount) bank);  // Casting down
        }
        
        return contasPoupancas;
    }
    
    /** @return A coleção de contas do tipo LawAccount */
    public ArrayList<LawAccount> lawAccounts() {
        ArrayList<LawAccount> contasJuridicas = new ArrayList<>();
        
        for (BankAccount bank : accounts) {
            if (bank instanceof CityLawAccount || bank instanceof StateLawAccount || bank instanceof FederationLawAccount)
                contasJuridicas.add((LawAccount) bank);  // Casting up
        }
        
        return contasJuridicas;
    }
    
    /**
     * @param account Conta a ser examinada
     * @return O tipo da conta, em sigla String
     */
    public String getAccountType(BankAccount account) {
        if (account instanceof RegularAccount)
            return "RA";
        
        if (account instanceof SavingsAccount)
            return "SA";
        
        if (account instanceof CityLawAccount)
            return "CLA";
        
        if (account instanceof StateLawAccount)
            return "SLA";
        
        if (account instanceof FederationLawAccount)
            return "FLA";
        
        return null;
    }
} 
 