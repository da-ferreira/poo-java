
package Pacote_Fonte_v2;

import java.util.ArrayList;

public class Disciplina {
    private String codigo;
    private int creditos;  // Carga horária da disciplina
    private ArrayList<Matricula> matriculas;

    public Disciplina(String codigo, int creditos) {
        this.codigo = codigo;
        this.creditos = creditos;
        
        matriculas = new ArrayList<>();
    }
    
    public void addMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }
    
    public ArrayList<Estudante> getEstudantesMatriculados() {
        ArrayList<Estudante> estudantes = new ArrayList<>();
        
        for (Matricula matr : matriculas) {
            estudantes.add(matr.getEstudante());
        }
        
        return estudantes;
    }
    
    /* Métodos Modificadores */
    
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public void setMatriculas(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }
    
    /* Métodos de Acesso */

    public String getCodigo() {
        return codigo;
    }

    public int getCreditos() {
        return creditos;
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }
}
    