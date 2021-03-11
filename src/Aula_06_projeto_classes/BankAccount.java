
package Aula_06_projeto_classes;

/**
 * @author david-ferreira
 */

public class BankAccount {
    private static int lastAccountNumber = 1000;  // Guarda o proximo número a ser utilizado.
    
    private String owner;       // Nome do proprietário da conta.
    private int accountNumber;  // Numero da conta.
    private double balance;     // Saldo da conta.
    
    
    public BankAccount(String owner) {  // Cria uma conta com saldo igual a 0.0
        this(owner, 0.0);
    }
    
    public BankAccount( String owner, double balance) {
        this.owner = owner;
        this.balance = balance;
        this.accountNumber = lastAccountNumber++;
    }
    
    /**
     * Deposita dinheiro nesta conta.
     * (Pós-condição: getBalance() >= 0.0)
     * @param value a quantidade de dinheiro  a depositar.
     * (Pré-condição: value >= 0.0)
     */
    public void deposit(double value) {
        this.balance += value;
    }
    
    public void withDraw(double value) {
        this.balance -= value;
    }
    
    // Métodos de acesso:
    public int getAccountNumber() {
        return accountNumber;
    }

    public static int getLastAccountNumber() {   // Acessado pela classe (static).
        return lastAccountNumber;
    }

    public double getBalance() {
        return balance;
    }
    
    public String getOwner() {
        return owner;
    }
    
    // Métodos modificadores:
    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    
    @Override
    public String toString() {
        return String.format("Owner: %s | Balance: %.4f | AccountNumber: %d", this.owner, this.balance, this.accountNumber);
    }
      
}
