
package aula_07_relacionamentos;

import org.junit.Test;
import static org.junit.Assert.*;
import Aula_07_relacionamentos.BankAccount;

/**
 * @author david-ferreira
 */

public class BankAccountTest {
    @Test
    public void testeConstrutor2Parametros() {
        BankAccount conta1 = new BankAccount(445, 500.00);
        
        assertEquals(500.0, conta1.getBalance(), 0.0001);
        assertEquals(445, conta1.getAccountNumber());
        assertEquals("123", conta1.getPassword());
        assertEquals("Nome não informado", conta1.getOwner());
        assertEquals("Conta-Corrente", conta1.getTipo());
    }
    
    @Test
    public void testeConstrutor5Parametros() {
        BankAccount conta = new BankAccount("David Ferreira", 8861, 35.0, "abc321", "Conta-Poupança");
        
        assertEquals(35.0, conta.getBalance(), 0.0001);
        assertEquals(8861, conta.getAccountNumber());
        assertEquals("abc321", conta.getPassword());
        assertEquals("David Ferreira", conta.getOwner());
        assertEquals("Conta-Poupança", conta.getTipo());
    }
}
