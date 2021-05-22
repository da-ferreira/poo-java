
package Pacote_Fonte_v2;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author david-ferreira
 */

public class GestaoAcademicaApp2 {
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
        Scanner in = new Scanner(System.in);
        System.out.print("\nInforme o código da disciplina (nome): ");
        String escolha = in.nextLine();
                
        Disciplina disciplina_escolhida = null;
        
        for (Disciplina discipline : faculdade.getDisciplinas()) {
            if (discipline.getCodigo().equals(escolha))
                disciplina_escolhida = discipline;
        }
        
        if (disciplina_escolhida != null) {
            System.out.printf("\nNa disciplina %s tem %d estudantes matriculados:\n", disciplina_escolhida.getCodigo(), 
                                                                                      disciplina_escolhida.getMatriculas().size());
            
            for (Matricula student : disciplina_escolhida.getMatriculas()) {
                System.out.printf("ID: %d, Nome: %s, E-mail: %s\n", student.getEstudante().getId(), student.getEstudante().getNome(),
                                                                                                    student.getEstudante().getNome());
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
            System.out.println("");
            int horas = 0;  // total de créditos 
            
            for (Matricula matr : estudante_escolhido.getMatriculas()) {
                System.out.printf("Código: %s, Créditos: %d\n", matr.getDisciplina().getCodigo(), matr.getDisciplina().getCreditos());
                horas += matr.getDisciplina().getCreditos();
            }
            
            System.out.printf("\nO estudante %s do id %d tem um total de créditos (horas) de %d em sua matrículas.\n", estudante_escolhido.getNome(),
                                                                                                                   estudante_escolhido.getId(), horas);
        }
        else {
            System.out.println("\nO ID do estudante escolhido não está na faculdade. Tente novamente.");
        }
    }
}
   