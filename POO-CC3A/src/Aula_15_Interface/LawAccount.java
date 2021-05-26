
package Aula_15_Interface;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Classe para contas juridicas
 * @author david-ferreira
 */

public abstract class LawAccount extends BankAccount { 
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
        return super.balance * (1 - admFee / 100);
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
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("Aim: %s | Start: %s | End: %s | AdmFee: %.2f | %s", this.aim, formata.format(start), formata.format(end), this.admFee, 
                                                                                                                                    super.toString());
    }
}
