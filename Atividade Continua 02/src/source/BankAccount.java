
package source;

import java.util.Random;

/**
 * @author david-ferreira
 */

public class BankAccount {
    private static int lastAccountNumber = 1000;  // Guarda o proximo número a ser utilizado.
    
    private String owner;       // Nome do proprietário da conta.
    private int accountNumber;  // Numero da conta.
    private double balance;     // Saldo da conta.
    private String password;    // Senha do cliente
    private int cpmf;           // Valores da cobrança de cpmf (0.25 % de cada saque)
    
    
    public BankAccount(String owner) {  // Cria uma conta com saldo igual a 0.0
        this(owner, 0.0);
    }
    
    public BankAccount( String owner, double balance) {
        checkName(owner);
        
        this.owner = owner;
        this.balance = balance;
        this.password = makePassword();
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
        
        /*
         * De cada operação saque será retirado da conta
         * 0.25 % do saque e guardado no atributo cpmf.
         */
        double calc_cmpf = 0.25 * value / 100;
        this.balance -= calc_cmpf;
        this.cpmf += calc_cmpf;
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
    
    /**
     * Verifica se um nome de um dado correntista está correto
     * @param owner: Nome do correntista
     * @return O nome caso esteja certo.
     */
    private static String checkName(String owner) {
        /* 
         * Aceita apenas caracters de a-z, A-Z, espaco(" ")
         * vogais acentuadas em maiusculo e minusculo.
         * retorna true caso o regex tenha se aplicado a toda string.
         */ 
        boolean check = owner.matches("[a-zA-Z áàâãéèêíïóôõöúçñÁÀÂÃÉÈÊÍÏÓÔÕÖÚÇÑ]+");

        if (check)
            return owner;
        
        throw new RuntimeException("ERRO: Nome inválido.");    
    }
    
    /**
     * Gera uma senha de 7 digitos, com os 3 primeiros de letras de a-z
     * e os 4 ultimos de digitos 0-9.
     * @return a senha gerada.
     */
    private static String makePassword() {
        /*
         * A string alfabeto armazena de a-z.
         * Depois, no loop (3 vezes) será concatenado
         * algum caracter, aleatoriamente, desse alfabeto (entre 0 e 25 a-z).
         * Depois adiciona 4 numeros entre 0-9 a senha.
         */
        
        String senha = "";
        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        
        Random gerador = new Random();
        
        for (int i=0; i < 3; i++) {
            senha += alfabeto.charAt(gerador.nextInt(26));  // Escolhe um numero entre 0 e 25.
        }
        
        for (int i=0; i < 4; i++) {
            senha += String.format("%d", gerador.nextInt(10));  // Escolhe um numero entre 0 e 9.
        }
        
        return senha;
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
    
    public double getCpmf() {
        return cpmf;
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
        return String.format("Owner: %s | Balance: %.4f | AccountNumber: %d | Password: %s", this.owner, this.balance, this.accountNumber, this.password);
    }
}
