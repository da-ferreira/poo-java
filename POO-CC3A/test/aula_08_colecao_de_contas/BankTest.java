
package aula_08_colecao_de_contas;

import org.junit.Test;
import static org.junit.Assert.*;
import Aula_08_Relacionamento.Bank;
import Aula_08_Relacionamento.BankAccount;

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
    public void testeAddAccount() {
        Bank banco = new Bank();
        
        assertNotNull(banco);
        
        banco.addAccount(new BankAccount("Joao Carneiro", 123, 500.00, "abc123"));
        
        assertEquals(1, banco.getLast());
        assertEquals(123, banco.getAccounts()[0].getAccountNumber());
        assertEquals("Joao Carneiro", banco.getAccounts()[0].getOwner());
        assertEquals(500.0, banco.getAccounts()[0].getBalance(), 0.0001);
        
        banco.addAccount(new BankAccount("Carlos Freitas Filho", 66, 89.63, "carlos555"));
        
        assertEquals(2, banco.getLast());
        assertEquals(66, banco.getAccounts()[1].getAccountNumber());
        assertEquals("Carlos Freitas Filho", banco.getAccounts()[1].getOwner());
        assertEquals(89.63, banco.getAccounts()[1].getBalance(), 0.0001);
    }
    
    @Test
    public void testeGetTotalBalance() {
        Bank banco = new Bank();
        
        banco.addAccount(new BankAccount("Joao Carneiro", 123, 500.00, "abc123"));
        banco.addAccount(new BankAccount("Felipe Pereira", 555, 23.00, "aaa999"));
        banco.addAccount(new BankAccount("Ana Lima", 113, 1000.00, "asd979"));
        
        assertEquals(3, banco.getLast());
        assertEquals(1523.0, banco.getTotalBalance(), 0.0001);
        assertEquals("Ana Lima", banco.find(113).getOwner());
    }
    
    @Test
    public void testeFind() {
        Bank banco = new Bank();
        
        banco.addAccount(new BankAccount("Joao Carneiro", 123, 500.00, "abc123"));
        banco.addAccount(new BankAccount("Felipe Pereira", 555, 23.00, "aaa999"));
        banco.addAccount(new BankAccount("Ana Lima", 113, 1000.00, "asd979"));
        
        assertEquals(3, banco.getLast());
        assertEquals("Felipe Pereira", banco.find(555).getOwner());
        assertNull(banco.find(763));
        assertNotNull(banco.find(123));
    }
    
    @Test
    public void testeGetMaximum() {
        Bank banco = new Bank();
        
        banco.addAccount(new BankAccount("Joao Carneiro", 123, 500.00, "abc123"));
        banco.addAccount(new BankAccount("Felipe Pereira", 555, 23.00, "aaa999"));
        banco.addAccount(new BankAccount("Ana Lima", 113, 1000.00, "asd979"));
        
        assertEquals("Ana Lima", banco.getMaximum().getOwner());
        assertEquals(113, banco.getMaximum().getAccountNumber());
        assertEquals(1000.00, banco.getMaximum().getBalance(), 0.0001);
    }
    
    @Test
    public void testeCount() {
        Bank banco = new Bank();
        
        banco.addAccount(new BankAccount("Joao Carneiro", 123, 500.00, "abc123"));
        banco.addAccount(new BankAccount("Felipe Pereira", 555, 23.00, "aaa999"));
        banco.addAccount(new BankAccount("Ana Lima", 113, 1000.00, "asd979"));
        
        assertEquals(2, banco.count(400.0));
        assertEquals(1, banco.count(900.0));
        assertEquals(1, banco.count(1000.0));
        assertEquals(3, banco.count(23.0));
        assertEquals(0, banco.count(1001.0));
    }
}
    