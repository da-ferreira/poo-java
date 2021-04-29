
package aula_12_heranca;

import org.junit.Test;
import static org.junit.Assert.*;
import Aula_09_Colecoes.Bank;
import Aula_09_Colecoes.BankAccount;
import Aula_12_Heranca.SavingsAccount;

/**
 * @author david-ferreira
 */

public class BankTest {
    @Test
    public void testeContrutor() {
        Bank banco = new Bank();
        assertNotNull(banco);
    }
    
    @Test
    public void testeAddSavingsAccount() {
        Bank banco = new Bank();
        
        assertNotNull(banco);
        
        SavingsAccount conta = new SavingsAccount(0.05, "Joao Carneiro", 123, 500.00, "abc123");
        banco.addAccount(conta);
        
        assertEquals(1, banco.getAccounts().size());
        assertEquals(123, banco.getAccounts().get(0).getAccountNumber());
        assertEquals("Joao Carneiro", banco.getAccounts().get(0).getOwner());
        assertEquals(500.0, banco.getAccounts().get(0).getBalance(), 0.0001);
        
        banco.addAccount(new BankAccount("Carlos Freitas Filho", 66, 89.63, "carlos555"));
        
        assertEquals(2, banco.getAccounts().size());
        assertEquals(66, banco.getAccounts().get(1).getAccountNumber());
        assertEquals("Carlos Freitas Filho", banco.getAccounts().get(1).getOwner());
        assertEquals(89.63, banco.getAccounts().get(1).getBalance(), 0.0001);
    }
}
    