
package Aula_14_Heranca_Classe_Abstrata;

import Aula_12_Heranca.BankAccount;
import java.util.Date;

/**
 * @author david-ferreira
 */

public class LawAccount extends BankAccount { 
    private String aim;     // Toda conta juridica tem um objetivo ao ser aberta.
    private Date start;     // Data de criação da conta
    private Date end;       // Data de liberação da conta
    private double admFee;  // taxa de adm(%)

    public LawAccount(String aim, Date start, Date end, double admFee, String owner, int accountNumber, double balance, String password) {
        super(owner, accountNumber, balance, password);
        this.aim = aim;
        this.start = start;
        this.end = end;
        this.admFee = admFee;
    }
    
    @Override
    public double getBalance() {
        return super.getBalance() * (1 - admFee / 100);
    }

    public String getAim() {
        return aim;
    }

    public Date getStart() {
        return start;
    }

    public Date getEnd() {
        return end;
    }

    public double getAdmFee() {
        return admFee;
    }

    public void setAim(String aim) {
        this.aim = aim;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public void setAdmFee(double admFee) {
        this.admFee = admFee;
    }

    @Override
    public String toString() {
        return "LawAccount{" + "aim=" + aim + ", start=" + start + ", end=" + end + ", admFee=" + admFee + '}';
    }
}
