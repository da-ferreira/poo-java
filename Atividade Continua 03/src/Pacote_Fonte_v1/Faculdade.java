
package Pacote_Fonte_v1;

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
                
                String dados_linha[] = linha.split(":");
                estudantes.add(new Estudante(Integer.parseInt(dados_linha[0]), dados_linha[1], dados_linha[2]));
            }
            
            reader.close();
            reader = new BufferedReader(new FileReader(nome_arquivo_disciplinas));
            
            while (true) {
                String linha = reader.readLine();
                
                if (linha == null)
                    break;
                
                String dados_linha[] = linha.split(":");
                disciplinas.add(new Disciplina(dados_linha[0], Integer.parseInt(dados_linha[1])));
            }
            
            reader.close();
            reader = new BufferedReader(new FileReader(nome_arquivo_matriculas));
            
            while (true) {
                String linha = reader.readLine();
                
                if (linha == null)
                    break;
                
                String dados_linha[] = linha.split(":");
                /* Terminar fazendo com que no estudante e disciplina seja adicionado as matriculas do arquivo. */
                
                long id_student = Integer.parseInt(dados_linha[0]);  // Id do estudante matriculado na materia i.
                String materia_matriculada = dados_linha[1];         // Materia que o estudante i está matriculado.
                
                for (Estudante student : estudantes) {
                    if (student.getId() == id_student)
                        
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
  