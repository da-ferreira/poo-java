
package Aula_14_Heranca_Classe_Abstrata;

import java.util.Date;

/**
 * @author david-ferreira
 */

public class FederationLawAccount extends LawAccount {
    private String judgeInstance;  // 1°,  2° instancia.

    public FederationLawAccount(String judgeInstance, String aim, Date start, Date end, double admFee, String owner, int accountNumber, double balance, String password) {
        super(aim, start, end, admFee, owner, accountNumber, balance, password);
        this.judgeInstance = judgeInstance;
    }
    
    @Override
    public double getBalance() {
        return super.getBalance();
    }

    public String getJudgeInstance() {
        return judgeInstance;
    }

    public void setJudgeInstance(String judgeInstance) {
        this.judgeInstance = judgeInstance;
    }
    
    @Override
    public String toString() {
        return String.format("FederationLawAccount{JudgeInstance: %s | %s}", this.judgeInstance, super.toString());
    }
}
 