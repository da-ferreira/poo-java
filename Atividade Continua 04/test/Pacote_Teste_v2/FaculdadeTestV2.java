
package Pacote_Teste_v2;

import Pacote_Fonte_v2.EstudanteGrad;
import Pacote_Fonte_v2.EstudantePos;
import Pacote_Fonte_v2.Faculdade;
import org.junit.Test;
import static org.junit.Assert.*;

public class FaculdadeTestV2 {
    @Test
    public void testNomeFaculdade() {
        Faculdade faculdade = new Faculdade("Faculdade Impacta de Tecnologia (FIT)");
        assertEquals("Faculdade Impacta de Tecnologia (FIT)", faculdade.getNome());
    }
    
    @Test
    public void testCarregarDadosFaculdade() {
        Faculdade faculdade = new Faculdade("Faculdade Impacta de Tecnologia (FIT)");
        faculdade.carregarDadosArquivo("disciplinas.txt", "estudantes.txt", "matriculas.txt");
        
        assertEquals(6, faculdade.getEstudantes().size());
        assertEquals(8, faculdade.getDisciplinas().size());
    }
    
    @Test
    public void testEstudantes() {
        Faculdade faculdade = new Faculdade("Faculdade Impacta de Tecnologia (FIT)");
        faculdade.carregarDadosArquivo("disciplinas.txt", "estudantes.txt", "matriculas.txt");
        
        assertEquals(1000, faculdade.getEstudantes().get(0).getId());
        assertEquals(1001, faculdade.getEstudantes().get(1).getId());
        assertEquals(1002, faculdade.getEstudantes().get(2).getId());
        assertEquals(1003, faculdade.getEstudantes().get(3).getId());
        assertEquals(1004, faculdade.getEstudantes().get(4).getId());
        assertEquals(1005, faculdade.getEstudantes().get(5).getId());
        
        assertTrue(faculdade.getEstudantes().get(0) instanceof EstudanteGrad);
        assertTrue(faculdade.getEstudantes().get(1) instanceof EstudantePos);
        assertFalse(faculdade.getEstudantes().get(4) instanceof EstudantePos);
        assertFalse(faculdade.getEstudantes().get(5) instanceof EstudanteGrad);
    }
    
    @Test
    public void testDisciplinas() {
        Faculdade faculdade = new Faculdade("Faculdade Impacta de Tecnologia (FIT)");
        faculdade.carregarDadosArquivo("disciplinas.txt", "estudantes.txt", "matriculas.txt");
        
        assertEquals("Estrutura de Dados", faculdade.getDisciplinas().get(0).getCodigo());
        assertEquals(80, faculdade.getDisciplinas().get(0).getCreditos());
        
        assertEquals("Programacao Orientada a Objetos", faculdade.getDisciplinas().get(1).getCodigo());
        assertEquals(40, faculdade.getDisciplinas().get(1).getCreditos());
     
        assertEquals("Sistemas Operacionais", faculdade.getDisciplinas().get(2).getCodigo());
        assertEquals(80, faculdade.getDisciplinas().get(2).getCreditos());
        
        assertEquals("Matematica", faculdade.getDisciplinas().get(7).getCodigo());
        assertEquals(80, faculdade.getDisciplinas().get(7).getCreditos());
    }
    
    @Test
    public void testMatriculas() {
        Faculdade faculdade = new Faculdade("Faculdade Impacta de Tecnologia (FIT)");
        faculdade.carregarDadosArquivo("disciplinas.txt", "estudantes.txt", "matriculas.txt");
        
        /* Verificando se um estudante está vinculado a uma determinada disciplina (pegando seu nome) */
        
        assertEquals("Estrutura de Dados", faculdade.getEstudantes().get(0).getMatriculas().get(0).getDisciplina().getCodigo());
        assertEquals("Programacao Orientada a Objetos", faculdade.getEstudantes().get(0).getMatriculas().get(1).getDisciplina().getCodigo());
        assertEquals("Sistemas Operacionais", faculdade.getEstudantes().get(0).getMatriculas().get(2).getDisciplina().getCodigo());
        
        assertEquals("Testes Unitarios", faculdade.getEstudantes().get(1).getMatriculas().get(0).getDisciplina().getCodigo());
        assertEquals("Testes de Integracao", faculdade.getEstudantes().get(1).getMatriculas().get(1).getDisciplina().getCodigo());

        assertEquals("Introducao a Criptografia", faculdade.getEstudantes().get(5).getMatriculas().get(0).getDisciplina().getCodigo());
        assertEquals("Matematica", faculdade.getEstudantes().get(5).getMatriculas().get(1).getDisciplina().getCodigo());
        
        /* Verificando se uma determinada disciplina está vinculada a um determinado estudante (pegando seu e-mail). */
        
        assertEquals("marco@gmail.com", faculdade.getDisciplinas().get(0).getMatriculas().get(0).getEstudante().getEmail());
        assertEquals("marco@gmail.com", faculdade.getDisciplinas().get(1).getMatriculas().get(0).getEstudante().getEmail());
        assertEquals("marco@gmail.com", faculdade.getDisciplinas().get(2).getMatriculas().get(0).getEstudante().getEmail());
        assertEquals("amaria@yahoo.com.br", faculdade.getDisciplinas().get(3).getMatriculas().get(0).getEstudante().getEmail());
        assertEquals("amaria@yahoo.com.br", faculdade.getDisciplinas().get(4).getMatriculas().get(0).getEstudante().getEmail());
    }
    
    @Test
    public void testEstudanteGraducao() {
        Faculdade faculdade = new Faculdade("Faculdade Impacta de Tecnologia (FIT)");
        faculdade.carregarDadosArquivo("disciplinas.txt", "estudantes.txt", "matriculas.txt");
        
        assertEquals(1003, faculdade.getEstudantes().get(3).getId());
        assertEquals("Ana Clara", faculdade.getEstudantes().get(3).getNome());
        assertEquals("aninha@email.br", faculdade.getEstudantes().get(3).getEmail());
        assertEquals(40, ((EstudanteGrad) faculdade.getEstudantes().get(3)).getHorasAtividades());
        assertEquals(160, ((EstudanteGrad) faculdade.getEstudantes().get(3)).getTotalCreditos());        
    }
    
    @Test
    public void testEstudantePosGraducao() {
        Faculdade faculdade = new Faculdade("Faculdade Impacta de Tecnologia (FIT)");
        faculdade.carregarDadosArquivo("disciplinas.txt", "estudantes.txt", "matriculas.txt");
        
        assertEquals(1005, faculdade.getEstudantes().get(5).getId());
        assertEquals("Vanessa Ferreira", faculdade.getEstudantes().get(5).getNome());
        assertEquals("vaferreira545@gmail.com", faculdade.getEstudantes().get(5).getEmail());
        assertEquals("Criptografia", ((EstudantePos) faculdade.getEstudantes().get(5)).getTema());
        assertEquals("Carla Rodrigues", ((EstudantePos) faculdade.getEstudantes().get(5)).getOrientador());
        assertEquals(160, ((EstudantePos) faculdade.getEstudantes().get(5)).getTotalCreditos());
    }
}
 