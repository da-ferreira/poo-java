
package aula_06_projeto_classes;

import org.junit.Test;
import static org.junit.Assert.*;
import Aula_06_projeto_classes.BankAccount;

/**
 * @author david-ferreira
 */

public class BankAccountTest {
    @Test
    public void testeConstrutorPadrao() {
        BankAccount conta1 = new BankAccount("Sergio Freitas");
        assertEquals(0.0, conta1.getBalance(), 0.0001);
        
        BankAccount conta2 = new BankAccount("Vitor Silva");
        assertEquals("Vitor Silva", conta2.getOwner());
    }
    
    @Test
    public void testeConstrutorNaoPadrao() {
        BankAccount conta = new BankAccount("Carlos", 500.00);
        assertEquals(500.0, conta.getBalance(), 0.0001);
    }
    
    @Test
    public void testeDeposit() {
        BankAccount conta = new BankAccount("Felipe", 223.00);
        conta.deposit(200.00);
        assertEquals(423.0, conta.getBalance(), 0.0001);
    }
    
    @Test
    public void testeWithDraw() {
        BankAccount conta = new BankAccount("David", 7.00);
        conta.withDraw(3.00);
        assertEquals(4.0, conta.getBalance(), 0.0001);
    }
}

