
package Pacote_Fonte_v2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        try {
            BufferedReader reader = new BufferedReader(new FileReader(nome_arquivo_estudantes));
            
            while (true) {
                String linha = reader.readLine();
                
                if (linha == null) // se for null, não tem mais dados no arquivo.
                    break;
                
                String dadosLinha[] = linha.split(":");
                
                if (dadosLinha.length == 5) {  // Estudante de graduação
                    estudantes.add(new EstudanteGrad(Integer.parseInt(dadosLinha[0]), dadosLinha[1], dadosLinha[2], Integer.parseInt(dadosLinha[4])));
                }
                else {  // Estudante de pós-graduação
                    estudantes.add(new EstudantePos(Integer.parseInt(dadosLinha[0]), dadosLinha[1], dadosLinha[2], dadosLinha[4], dadosLinha[5]));
                }                
            }
            
            reader.close();
            reader = new BufferedReader(new FileReader(nome_arquivo_disciplinas));
            
            while (true) {
                String linha = reader.readLine();
                
                if (linha == null)
                    break;
                
                String dadosLinha[] = linha.split(":");
                disciplinas.add(new Disciplina(dadosLinha[0], Integer.parseInt(dadosLinha[1])));
            }
            
            reader.close();
            reader = new BufferedReader(new FileReader(nome_arquivo_matriculas));
            
            while (true) {
                String linha = reader.readLine();
                
                if (linha == null)
                    break;
                
                String dadosLinha[] = linha.split(":");
                
                /* Vinculando estudante e disciplina. */
                
                long id_student = Integer.parseInt(dadosLinha[0]);  // Id do estudante matriculado na materia i.
                String materia_matriculada = dadosLinha[1];         // Materia que o estudante i está matriculado (disciplina).
                
                for (Estudante student : estudantes) {
                    if (student.getId() == id_student) {   
                        for (Disciplina discipline : disciplinas) {
                            if (discipline.getCodigo().equals(materia_matriculada)) {
                                student.addMatricula(new Matricula(student, discipline));
                                discipline.addMatricula(new Matricula(student, discipline));
                            }
                        }
                    }
                }
            }
            
            reader.close();
        }
        catch (IOException error) {
            System.exit(-1);
        }
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
  