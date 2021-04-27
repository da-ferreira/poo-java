
package Pacote_Fonte_v1;

import java.util.ArrayList;

/**
 * @author david-ferreira
 */

public class Faculdade {
    private String nome;
    private ArrayList<Estudante> estudantes;
    private ArrayList<Disciplina> disciplinas;

    public Faculdade(String nome) {
        this.nome = nome;
        
        estudantes = new ArrayList<>();
        disciplinas = new ArrayList<>();
    }
    
    public void carregarDadosArquivo(String nome_arquivo_disciplinas, String nome_arquivo_estudantes, String nome_arquivo_matriculas) {
        
    }
    
    /* Métodos Modificadores */

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEstudantes(ArrayList<Estudante> estudantes) {
        this.estudantes = estudantes;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    /* Métodos de Acesso */

    public String getNome() {
        return nome;
    }

    public ArrayList<Estudante> getEstudantes() {
        return estudantes;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }
}
  