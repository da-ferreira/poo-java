
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
        assertEquals(1000, conta1.getAccountNumber());
        
        BankAccount conta2 = new BankAccount("Vitor Silva");
        assertEquals(1001, conta2.getAccountNumber());
    }
    /*
    @Test
    public void testeConstrutorNaoPadrao() {
        BankAccount conta = new BankAccount(500.00);
        assertEquals(500.0, conta.getBalance(), 0.0001);
        //assertEquals(1002, conta.getAccountNumber());
    }
    
    @Test
    public void testeDeposit() {
        BankAccount conta = new BankAccount(500.00);
        conta.deposit(200.00);
        assertEquals(700.0, conta.getBalance(), 0.0001);
        //assertEquals(1003, conta.getAccountNumber());
    }
    
    @Test
    public void testeWithDraw() {
        BankAccount conta = new BankAccount(500.00);
        conta.withDraw(150.00);
        assertEquals(350.0, conta.getBalance(), 0.0001);
        //assertEquals(1004, conta.getAccountNumber());
    }
    */
    
}
