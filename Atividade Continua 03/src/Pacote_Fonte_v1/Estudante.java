
package Pacote_Fonte_v1;

import java.util.ArrayList;

/**
 * @author david-ferreira
 */

public class Estudante {
    private long id;
    private String nome;
    private String email;
    private ArrayList<Matricula> matriculas;

    public Estudante(long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        
        matriculas = new ArrayList<>();
    }
    
    public void addMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }
    
    public ArrayList<Disciplina> getDisciplinasMatriculadas() {
        ArrayList<Disciplina> disciplinas = new ArrayList<>();
        
        for (Matricula matr : matriculas) {
            disciplinas.add(matr.getDisciplina());
        }
        
        return disciplinas;
    }
    
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
  