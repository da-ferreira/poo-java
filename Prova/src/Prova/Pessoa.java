
package Prova;

/**
 * @author david-ferreira
 */

public class Pessoa {
    public int anoNascimento;
    public String nome;
    
    public Pessoa() {
        this(1900, "Não identificado");
    }

    public Pessoa(int anoNascimento, String nome) {
        this.anoNascimento = anoNascimento;
        this.nome = nome;
    }

    public int getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
