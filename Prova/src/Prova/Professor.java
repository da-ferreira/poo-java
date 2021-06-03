
package Prova;

/**
 * @author david-ferreira
 */

public class Professor extends Pessoa implements Motivacao {
    public int anoContratacao;
    public String drt;
    public double reputacao;
    
    public Professor() {
        this(2021, "111111", 0.0);
    }

    public Professor(int anoContratacao, String drt, double reputacao) {
        this.anoContratacao = anoContratacao;
        this.drt = drt;
        this.reputacao = reputacao;
    }

    public Professor(int anoContratacao, String drt, double reputacao, int anoNascimento, String nome) {
        super(anoNascimento, nome);
        this.anoContratacao = anoContratacao;
        this.drt = drt;
        this.reputacao = reputacao;
    }
    
    @Override
    public void incentiva(double value) {
        if (reputacao + value <= 10.0) {
            reputacao += value;
        }
        else {
            reputacao = 10.0;
        }
    }

    public int getAnoContratacao() {
        return anoContratacao;
    }

    public void setAnoContratacao(int anoContratacao) {
        this.anoContratacao = anoContratacao;
    }

    public String getDrt() {
        return drt;
    }

    public void setDrt(String drt) {
        this.drt = drt;
    }

    public double getReputacao() {
        return reputacao;
    }

    public void setReputacao(double reputacao) {
        this.reputacao = reputacao;
    }
}
