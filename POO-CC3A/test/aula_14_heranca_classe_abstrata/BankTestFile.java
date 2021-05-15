
package aula_14_heranca_classe_abstrata;

import org.junit.Test;
import static org.junit.Assert.*;
import Aula_14_Heranca_Classe_Abstrata.Bank;
import Aula_12_Heranca.BankAccount;
import Aula_12_Heranca.SavingsAccount;

/**
 * @author daferreira
 */

public class BankTestFile {  
    @Test
    public void testeConstrutor() {
        Bank banco = new Bank("entrada3.txt");
        assertEquals(5, banco.size());
        assertNotNull(banco);
    }
    
    @Test
    public void testeAddAccount() {
        Bank banco = new Bank("entrada3.txt");
        assertEquals(5, banco.size());
         
        assertEquals(2045, banco.getAccounts().get(2).getAccountNumber());
        assertEquals(1890.00, banco.getAccounts().get(2).getBalance(), 0.0001);
        
        assertEquals(1011, banco.accounts().get(0).getAccountNumber());
        assertEquals(1033, banco.accounts().get(2).getAccountNumber());
        
        assertEquals(4700.0, banco.getMaximum().getBalance(), 0.0001);
        assertEquals(1890.0, banco.savingsAccounts().get(0).getBalance(), 0.0001);
        
        assertTrue(banco.getMaximum() instanceof BankAccount);
        assertTrue(banco.savingsAccounts().get(0) instanceof SavingsAccount);
    }  
    
    @Test
    public void testeSortBalance() {
        Bank banco = new Bank("entrada3.txt");
        banco.sortBalance();
        
        assertEquals(2062, banco.getAccounts().get(0).getAccountNumber());
        assertEquals(1037, banco.getAccounts().get(1).getAccountNumber());
        assertEquals(1011, banco.getAccounts().get(2).getAccountNumber());
        assertEquals(2045, banco.getAccounts().get(3).getAccountNumber());
        assertEquals(1033, banco.getAccounts().get(4).getAccountNumber());
        
        assertEquals(282.80, banco.getAccounts().get(0).getBalance(), 0.0001);
        assertEquals(630.00, banco.getAccounts().get(1).getBalance(), 0.0001);
        assertEquals(1500.00, banco.getAccounts().get(2).getBalance(), 0.0001);
        assertEquals(1890.00, banco.getAccounts().get(3).getBalance(), 0.0001);
        assertEquals(4700.00, banco.getAccounts().get(4).getBalance(), 0.0001);
    }
    
    @Test
    public void testeAccounts() {
        Bank banco = new Bank("entrada3.txt");
        
        assertEquals(3, banco.accounts().size());
        assertEquals(1011, banco.accounts().get(0).getAccountNumber());
        assertEquals(1037, banco.accounts().get(1).getAccountNumber());
        assertEquals(1033, banco.accounts().get(2).getAccountNumber());
    }
    
    @Test
    public void testeSavingsAccounts() {
        Bank banco = new Bank("entrada3.txt");
        
        assertEquals(2, banco.savingsAccounts().size());
        assertEquals("Renato Rodrigues", banco.savingsAccounts().get(0).getOwner());
        assertEquals(2045, banco.savingsAccounts().get(0).getAccountNumber());
        
        assertEquals("Felipe Silva", banco.savingsAccounts().get(1).getOwner());
        assertEquals(2062, banco.savingsAccounts().get(1).getAccountNumber());
    }
}
