/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Prova;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author anacris
 */
public class ProvaTest {
    @Test
    public void pessoaConstrutorDefaultTest(){
        Pessoa pessoa = new Pessoa();
        assertEquals(1900, pessoa.getAnoNascimento());
        assertEquals("Não identificado", pessoa.getNome());
    }
    @Test
    public void pessoaConstrutorNOTDefaultTest(){
        Pessoa pessoa = new Pessoa(1970, "Marcos Paulo");
        assertEquals(1970, pessoa.getAnoNascimento());
        assertEquals("Marcos Paulo", pessoa.getNome());
    }
    @Test
    public void professorConstrutorDefaultTest(){
        Professor prof = new Professor();
        assertEquals(2021, prof.getAnoContratacao());
        assertEquals("111111", prof.getDrt());
        assertEquals(0.0, prof.getReputacao(),0.01);

    }
    @Test
    public void professorConstrutorNOTDefaultTest(){
        Professor prof = new Professor(2012,"1223717",6.5,1990,"Leonardo");
        assertEquals(2012, prof.getAnoContratacao());
        assertEquals("1223717", prof.getDrt());
        assertEquals(6.5, prof.getReputacao(),0.01);
        prof.incentiva(1.0);
        assertEquals(7.5, prof.getReputacao(),0.01);

    }
    @Test
    public void estudanteTest(){
        Estudante estudante = new Estudante(7.5,"20211200",1990,"Leonardo");
        assertEquals(7.5, estudante.getMediaGeral(),0.01);
        assertEquals("20211200", estudante.getRA());
        estudante.incentiva(0.5);
        assertEquals(8.0, estudante.getMediaGeral(),0.01);

    } 
}
