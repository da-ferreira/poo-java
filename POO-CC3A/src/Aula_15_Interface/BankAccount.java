
package Aula_15_Interface;

/**
 * @author david-ferreira
 */

public abstract class BankAccount {
    protected String owner;       // Nome do proprietário da conta.
    protected int accountNumber;  // Numero da conta.
    protected double balance;     // Saldo da conta.
    protected String password;    // Senha da conta.

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
    
    // Método abstrato
    public abstract double getBalance();

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
    
    /** 
     * Verifica se dois objetos da classe são iguais, comparando cada um dos atributos.
     * @param bank Objeto a ser verificado.
     * @return true se forem iguais; false, caso contrário.
     */
    public boolean equals(BankAccount bank) {
        return owner.equals(bank.getOwner()) && accountNumber == bank.getAccountNumber() &&
                balance == bank.getBalance() && password.equals(bank.getPassword());
    }
    
    @Override
    public String toString() {
        return String.format("Owner: %s | Balance: %.4f | AccountNumber: %d | Senha: %s", this.owner, this.balance, this.accountNumber, this.password);
    }     
}
  