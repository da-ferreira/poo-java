
package aula_09_colecoes;

import org.junit.Test;
import static org.junit.Assert.*;
import Aula_09_Colecoes.Bank;

/**
 * @author david-ferreira
 */

public class BankFileTest {
    @Test
    public void testeContrutor() {
        Bank banco = new Bank("entrada.txt");
        assertNotNull(banco);
    }
    
    @Test
    public void testeNumberAccounts() {
        Bank banco = new Bank("entrada.txt");
        assertEquals(5, banco.getAccounts().size());
    }
    
    @Test
    public void testeGetTotalBalance() {
        Bank banco = new Bank("entrada.txt");
        assertEquals(8910.0, banco.getTotalBalance(), 0.0001);
    }
    
    @Test
    public void testeFind() {
        Bank banco = new Bank("entrada.txt");
        
        assertEquals("Roberto Rodrigues", banco.find(1011).getOwner());
        assertNull(banco.find(1037111));
        assertNotNull(banco.find(2062));
        assertEquals("Renato Rodrigues", banco.find(2045).getOwner());
    }
    
    @Test
    public void testeGetMaximum() {
        Bank banco = new Bank("entrada.txt");
        assertEquals("Guilherme Freitas", banco.getMaximum().getOwner());
        assertEquals(1033, banco.getMaximum().getAccountNumber());
    }
    
    @Test
    public void testeCount() {
        Bank banco = new Bank("entrada.txt");

        assertEquals(3, banco.count(1500.0));
        assertEquals(5, banco.count(275.0));
        assertEquals(1, banco.count(4000.0));
        assertEquals(2, banco.count(1650.0));
        assertEquals(0, banco.count(5000.0));
    }
}
      