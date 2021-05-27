
package Pacote_Fonte_v2;

import java.util.ArrayList;

public abstract class Estudante {
    protected long id;
    protected String nome;
    protected String email;
    protected ArrayList<Matricula> matriculas;

    public Estudante(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        
        matriculas = new ArrayList<>();
    }
    
    protected void addMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }
    
    protected ArrayList<Disciplina> getDisciplinasMatriculadas() {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        
        for (Matricula matr : matriculas) {
            disciplinas.add(matr.getDisciplina());
        }
        
        return disciplinas;
    }
    
    protected abstract int getTotalCreditos();  // Método abstrato
    
    /* Métodos Modificadores */
    
    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMatriculas(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
    
    /* Métodos de Acesso */

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }
}
  