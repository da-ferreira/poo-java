
package source;

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
        if (value < 0) {  // Caso o usuario passe um numero negativo como deposito.
            throw new RuntimeException("ERRO! Valor do depósito está negativo.");
        }
        
        this.balance += value;
    }
    
    /**
     * Operação de saque
     * @param value: valor na qual será sacado.
     */
    public void withDraw(double value) {
        if (this.balance - value < 0) {
            throw new RuntimeException("ERRO! Valor do saque maior do que contém na conta.");
        }
        
        this.balance -= value;
    }
    
    /**
     * Operação de transferencia.
     * @param valor: valor que será transferido.
     * (Pré-condição: valor >= 0.0 && valor <= this.getBalance())
     * @param target: conta que será depositado o valor transferido.
     */
    public void transfer(double valor, BankAccount target) {
        if (valor < 0) {
            throw new RuntimeException("ERRO! Valor da transferencia está negativo.");
        }
        
        if (valor > this.getBalance()) {
            throw new RuntimeException("ERRO! Valor da transferencia maior do que contém na conta.");
        }
        
        this.balance -= valor;
        target.balance += valor;
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
