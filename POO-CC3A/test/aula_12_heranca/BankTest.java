
package aula_12_heranca;

import org.junit.Test;
import static org.junit.Assert.*;
import Aula_12_Heranca.Bank;
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
        
        assertEquals(0.05, conta.getInterestRate(), 0.0001);
        assertEquals(525.0, conta.getBalance(), 0.0001);
        assertEquals("Joao Carneiro", conta.getOwner());
        assertEquals(123, conta.getAccountNumber());
    }
}
    