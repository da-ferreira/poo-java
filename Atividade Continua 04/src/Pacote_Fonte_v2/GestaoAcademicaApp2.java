
package Pacote_Fonte_v2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author david-ferreira
 */

public class GestaoAcademicaApp2 {
    public static void main(String[] args) throws InterruptedException {
        Faculdade faculdade = new Faculdade("Faculdade Impacta de Tecnologia (FIT)");
        faculdade.carregarDadosArquivo("disciplinas.txt", "estudantes.txt", "matriculas.txt");
        Scanner in = new Scanner(System.in);
        
        System.out.println("\n >>> Bem vindo à " + faculdade.getNome() + " <<<");
        
        boolean sair = true;
        
        while (sair) {
            System.out.println("\nEscolha uma consulta.\n");
            System.out.println("{ 1 } Listar os números e nomes de todos os estudantes");
            System.out.println("{ 2 } Listar os códigos de todas as disciplinas");
            System.out.println("{ 3 } Listar todas as informações dos estudantes matriculados em uma determinada disciplina");
            System.out.println("{ 4 } Listar todas as informações das disciplinas em que um determinado estudante está matriculado.");
            System.out.println("{ 5 } Sair do sistema");
            
            System.out.print("\n>>> ");
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
                    System.out.println("\nOpção inválida! Tente novamente.");
                    Thread.sleep(1000);
            }
            
            if (escolha > 0 && escolha <= 4)
                Thread.sleep(1500);
        }
        
        System.out.println("\n <-> Volte sempre! <-> \n");
    }
    
    public static void mostrar_estudantes(Faculdade faculdade) {
        ArrayList<Estudante> estudantes = faculdade.getEstudantes();
        
        System.out.println("\n ~=~ INFORMAÇÕES DOS ESTUDANTES ~=~ \n");
        
        for (Estudante student : estudantes) {
            if (student instanceof EstudanteGrad) {
                System.out.printf("Estudante de graduação: %s | ID: %d | Atividades Complementares: %d | Total Créditos: %d\n", 
                        student.getNome(), student.getId(), ((EstudanteGrad) student).getHorasAtividades(), student.getTotalCreditos());
            }
            else {
                System.out.printf("Estudante de pós-graduação: %s | ID: %d | Tema: %s | Orientador: %s | Total Créditos: %d\n", 
                        student.getNome(), student.getId(), ((EstudantePos) student).getTema(), ((EstudantePos) student).getOrientador(), student.getTotalCreditos());
            }
        }
    }
    
    public static void mostrar_disciplinas(Faculdade faculdade) {
        ArrayList<Disciplina> disciplinas = faculdade.getDisciplinas();
        
        System.out.println("\n ~=~ CÓDIGOS DAS DISCIPLINAS ~=~ \n");
        
        for (Disciplina discipline : disciplinas) {
            System.out.println(discipline.getCodigo());
        }
    }
    
    public static void informacoes_estudantes_disciplina(Faculdade faculdade) {
        Scanner in = new Scanner(System.in);
        System.out.print("\nInforme o código da disciplina (nome): ");
        String escolha = in.nextLine();
                
        Disciplina disciplina_escolhida = null;
        
        for (Disciplina discipline : faculdade.getDisciplinas()) {
            if (discipline.getCodigo().equals(escolha))
                disciplina_escolhida = discipline;
        }
        
        if (disciplina_escolhida != null) {
            System.out.printf("\nNa disciplina %s tem %d estudantes matriculados:\n\n", disciplina_escolhida.getCodigo(), 
                                                                                      disciplina_escolhida.getMatriculas().size());
            
            for (Matricula student : disciplina_escolhida.getMatriculas()) {
                if (student.getEstudante() instanceof EstudanteGrad) {
                    System.out.printf("Estudante de graduação: %s | ID: %d | Atividades Complementares: %d | Total Créditos: %d\n", 
                            student.getEstudante().getNome(), student.getEstudante().getId(), 
                            ((EstudanteGrad) student.getEstudante()).getHorasAtividades(), 
                            student.getEstudante().getTotalCreditos());
                }   
                else {
                    System.out.printf("Estudante de pós-graduação: %s | ID: %d | Tema: %s | Orientador: %s | Total Créditos: %d\n", 
                            student.getEstudante().getNome(), student.getEstudante().getId(), ((EstudantePos) student.getEstudante()).getTema(), 
                            ((EstudantePos) student.getEstudante()).getOrientador(), student.getEstudante().getTotalCreditos());
                }
            }
        }
        else {  // não achou a disciplina informada
            System.out.println("\nCódigo da disciplina informada não consta na faculdade. Tente novamente.");
        }
    }
    
    public static void informacoes_disciplinas_estudante(Faculdade faculdade) {
        Scanner in = new Scanner(System.in);
        System.out.print("\nInforme o ID do estudante: ");
        int escolha = in.nextInt();
        
        Estudante estudante_escolhido = null;
        
        for (Estudante student : faculdade.getEstudantes()) {
            if (student.getId() == escolha)
                estudante_escolhido = student;
        }
        
        if (estudante_escolhido != null) {
            System.out.printf("\nO(a) estudante %s tem um total de créditos de %d e está matriculado nas seguintes disciplinas:\n\n", 
                                                             estudante_escolhido.getNome(), estudante_escolhido.getTotalCreditos());
            
            for (Matricula matr : estudante_escolhido.getMatriculas()) {
                System.out.printf("Código: %s | Créditos: %d\n", matr.getDisciplina().getCodigo(), matr.getDisciplina().getCreditos());
            }
        }
        else {
            System.out.println("\nO ID do estudante escolhido não está na faculdade. Tente novamente.");
        }
    }
}
   