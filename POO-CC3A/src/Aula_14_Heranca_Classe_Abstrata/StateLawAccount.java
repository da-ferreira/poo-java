
package Aula_14_Heranca_Classe_Abstrata;

import java.util.Date;

/**
 * @author david-ferreira
 */

public class StateLawAccount extends LawAccount {
    private String state;

    public StateLawAccount(String state, String aim, Date start, Date end, double admFee, String owner, int accountNumber, double balance, String password) {
        super(aim, start, end, admFee, owner, accountNumber, balance, password);
        this.state = state;
    }
    
    @Override
    public double getBalance() {
        return super.getBalance();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return String.format("StateLawAccount{State: %s | %s}", this.state, super.toString());
    }
}
 