
package Prova;

/**
 * @author david-ferreira
 */

public class Estudante extends Pessoa implements Motivacao {
    public double mediaGeral;
    public String RA;

    public Estudante(double mediaGeral, String RA, int anoNascimento, String nome) {
        super(anoNascimento, nome);
        this.mediaGeral = mediaGeral;
        this.RA = RA;
    }

    @Override
    public void incentiva(double value) {
        if (mediaGeral + value <= 10.0) {
            mediaGeral += value;
        }
        else {
            mediaGeral = 10.0; 
        }
    }

    public double getMediaGeral() {
        return mediaGeral;
    }

    public void setMediaGeral(double mediaGeral) {
        this.mediaGeral = mediaGeral;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }
}
