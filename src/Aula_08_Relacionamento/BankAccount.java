
package Aula_08_Relacionamento;

/**
 * @author david-ferreira
 */

public class BankAccount {
    private String owner;       // Nome do proprietário da conta.
    private int accountNumber;  // Numero da conta.
    private double balance;     // Saldo da conta.
    private String password;    // Senha da conta.

    public BankAccount(String owner, int accountNumber, double balance, String password) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.password = password;
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
    
    /* Métodos de acesso */
    
    public String getOwner() {
        return owner;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }
    
    /* Métodos modificadores */

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return String.format("Owner: %s | Balance: %.4f | AccountNumber: %d | Senha: %s", this.owner, this.balance, this.accountNumber, this.password);
    }     
}
  