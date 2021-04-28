
package Pacote_Fonte_v1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author david-ferreira
 */

public class GestaoAcademicaApp1 {
    public static void main(String[] args) {
        Faculdade faculdade = new Faculdade("Faculdade Impacta de Tecnologia (FIT)");
        faculdade.carregarDadosArquivo("disciplinas-baabdaccde.txt", "estudantes-baabdaccde.txt", "matriculas-baabdaccde.txt");
        Scanner in = new Scanner(System.in);
        
        System.out.println(" -=- Bem vindo à " + faculdade.getNome() + "-=-");
        
        boolean sair = true;
        
        while (sair) {
            System.out.println("\nEscolha uma consulta.\n");
            System.out.println("1. Listar os números e nomes de todos os estudantes");
            System.out.println("2. Listar os códigos de todas as disciplinas");
            System.out.println("3. Listar todas as informações dos estudantes matriculados em uma determinada disciplina");
            System.out.println("4. Listar todas as informações das disciplinas em que um determinado estudante está matriculado.");
            System.out.println("5. Sair do sistema");
            
            System.out.print(">>> ");
            int escolha = in.nextInt();
            
            switch (escolha) {
                case 1:
                    mostrar_estudantes(faculdade);
                    break;
                case 2:
                    mostrar_disciplinas(faculdade);
                    break;
                case 3:
                    informacoes_estudantes_disciplina(faculdade);
                    break;
                case 4:
                    informacoes_disciplinas_estudante(faculdade);
                    break;
                case 5:
                    sair = false;
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
        
        System.out.println(" -= Volte sempre! =-");
    }
    
    public static void mostrar_estudantes(Faculdade faculdade) {
        ArrayList<Estudante> estudantes = faculdade.getEstudantes();
        
        System.out.println("\nINFORMAÇÕES DOS ESTUDANTES\n");
        
        for (Estudante student : estudantes) {
            System.out.printf("ESTUDANTE: %s, ID: %d\n", student.getNome(), student.getId());
        }
    }
    
    public static void mostrar_disciplinas(Faculdade faculdade) {
        ArrayList<Disciplina> disciplinas = faculdade.getDisciplinas();
        
        System.out.println("\nCÓDIGOS DAS DISCIPLINAS\n");
        
        for (Disciplina discipline : disciplinas) {
            System.out.println(discipline.getCodigo());
        }
    }
    
    public static void informacoes_estudantes_disciplina(Faculdade faculdade) {
        
    }
    
    public static void informacoes_disciplinas_estudante(Faculdade faculdade) {
        
    }
}

/*
System.out.println(faculdade.getNome());
System.out.println(faculdade.getDisciplinas());
System.out.println(faculdade.getEstudantes().get(0).getMatriculas().get(0).getDisciplina().getCodigo()); // Estrutura de Dados
*/
