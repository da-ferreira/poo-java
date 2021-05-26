
package Aula_15_Interface;

/**
 * Classe para contas poupanças
 * @author david-ferreira
 */

public class SavingsAccount extends BankAccount {
    private double interestRate;  // taxa de juros

    public SavingsAccount(double interestRate, String owner, int accountNumber, double balance, String password) {
        super(owner, accountNumber, balance, password);  // chamando o construtor da classe BankAccount
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }
    
    @Override
    public double getBalance() {
        return super.balance * (1 + interestRate);
    }
    
    @Override
    public String toString() {
        return String.format("InterestRate: %.2f | %s", this.interestRate, super.toString());
    }
}
