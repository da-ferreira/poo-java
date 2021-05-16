
package Aula_12_Heranca;

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
        return super.getBalance() * (1 + interestRate);
    }
}
