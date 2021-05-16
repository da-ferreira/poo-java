
package Aula_14_Heranca_Classe_Abstrata;

/**
 * Classe para contas correntes
 * @author david-ferreira
 */

public class RegularAccount extends BankAccount {
    private double specialBalance;

    public RegularAccount(double specialBalance, String owner, int accountNumber, double balance, String password) {
        super(owner, accountNumber, balance, password);
        this.specialBalance = specialBalance;
    }
    
    @Override
    public double getBalance() {
        return super.balance + this.specialBalance;
    }

    public double getSpecialBalance() {
        return specialBalance;
    }

    public void setSpecialBalance(double specialBalance) {
        this.specialBalance = specialBalance;
    }

    @Override
    public String toString() {
        return String.format("RegularAccount{SpecialBalance: %s | %s}", this.specialBalance, super.toString());
    }
}
  