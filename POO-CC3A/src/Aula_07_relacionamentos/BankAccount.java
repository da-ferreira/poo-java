
package Aula_07_relacionamentos;

/**
 * @author david-ferreira
 */

public class BankAccount {
    private String owner;       // Nome do proprietário da conta.
    private int accountNumber;  // Numero da conta.
    private double balance;     // Saldo da conta.
    private String password;    // Senha da conta.
    private String tipo;        // Tipo da conta (corrente ou poupança)
    
    
    public BankAccount(int accountNumber, double balance) {  // Cria uma conta com saldo igual a 0.0
        this(null, accountNumber, balance, null, null);  // Passando a senha, nome e tipo como null.
    }

    public BankAccount(String owner, int accountNumber, double balance, String password, String tipo) {
        /*
         * A classe BankAccount é responsavel pelo ciclo de vida de passwod, owner e tipo,
         * ou seja, é um relacionamento-composição.
         */
        
        if (owner == null) {
            this.owner = "Nome não informado";  // Cria um nome padrão caso o nome nao seja informado
        }
        else {
            this.owner = owner;
        }
      
        this.accountNumber = accountNumber;
        this.balance = balance;
        
        if (password == null) {
            this.password = "123";  // Cria uma senha padrao caso a senha nao seja informado
        }
        else {
            this.password = password;
        }
        
        if (tipo == null) {
            this.tipo = "Conta-Corrente";
        }
        else {
            this.tipo = tipo;
        }
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
    
    public String getTipo() {
        return tipo;
    }
   
    @Override
    public String toString() {
        return String.format("Owner: %s | Balance: %.4f | AccountNumber: %d | Senha: %s", this.owner, this.balance, this.accountNumber, this.password);
    }     
}
  