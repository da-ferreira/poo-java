
package Pacote_Fonte_v1;

/**
 * @author david-ferreira
 */

public class Matricula {
    private Estudante estudante;
    private Disciplina disciplina;

    public Matricula(Estudante estudante, Disciplina disciplina) {
        this.estudante = estudante;
        this.disciplina = disciplina;
    }
  
    /* Métodos Modificadores */
    
    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }    
    
    /* Métodos de Acesso */

    public Estudante getEstudante() {
        return estudante;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
   