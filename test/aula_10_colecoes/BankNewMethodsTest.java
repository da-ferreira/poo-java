
package aula_10_colecoes;

import org.junit.Test;
import static org.junit.Assert.*;
import Aula_10_Colecoes.Bank;
import Aula_10_Colecoes.BankAccount;

/**
 * @author daferreira
 */

public class BankNewMethodsTest {
    @Test
    public void testeContains() {
        Bank banco = new Bank("entrada.txt");
        
        BankAccount conta1 = new BankAccount("Roberto Rodrigues", 1011, 1500.00, "123456");  // conta que está no banco
        BankAccount conta2 = new BankAccount("Felipe Monte Belo", 5588, 32.99, "444558");  // conta que não está no banco
        
        assertTrue(banco.contains(conta1));
        assertFalse(banco.contains(conta2));
    }
    
    @Test
    public void testeRemoveAccount() {
        Bank banco = new Bank("entrada.txt");
        
        assertEquals(5, banco.size());
        
        BankAccount conta1 = banco.getAccounts().get(0);  // Remoção por instancia.
        banco.removeAccount(conta1);
        assertEquals(4, banco.size());
        
        banco.removeAccount(1037);  // Remoção por número da conta.
        assertEquals(3, banco.size());
    }    
    
    @Test
    public void testeSort() {
         Bank banco = new Bank("entrada.txt");
         
         assertEquals(5, banco.size());
         assertEquals(1011, banco.getAccounts().get(0).getAccountNumber());
         assertEquals(1037, banco.getAccounts().get(1).getAccountNumber());
         assertEquals(2045, banco.getAccounts().get(2).getAccountNumber());
         assertEquals(1033, banco.getAccounts().get(3).getAccountNumber());
         assertEquals(2062, banco.getAccounts().get(4).getAccountNumber());
         
         banco.sort();  // Ordenando as contas pelos seus números.
         
         assertEquals(5, banco.size());
         assertEquals(1011, banco.getAccounts().get(0).getAccountNumber());
         assertEquals(1033, banco.getAccounts().get(1).getAccountNumber());
         assertEquals(1037, banco.getAccounts().get(2).getAccountNumber());
         assertEquals(2045, banco.getAccounts().get(3).getAccountNumber());
         assertEquals(2062, banco.getAccounts().get(4).getAccountNumber());
    }
    
    @Test
    public void testeDump() {
        Bank banco = new Bank("entrada.txt");
        banco.dump("saida.txt");
    }
    
    @Test
    public void testeFind() {
        Bank banco = new Bank("entrada.txt");
        banco.sort();
        
        BankAccount conta = banco.find(1033);
        
        assertEquals(1033, conta.getAccountNumber());
        assertEquals("45678", conta.getPassword());
        assertEquals("Guilherme Freitas", conta.getOwner());
        assertEquals(4700.00, conta.getBalance(), 0.0001);
        
        assertNull(banco.find(5566));
    }
}
