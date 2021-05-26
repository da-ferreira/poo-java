
package aula_15_interface;

import org.junit.Test;
import static org.junit.Assert.*;
import Aula_15_Interface.Bank;
import Aula_15_Interface.SavingsAccount;

/**
 * @author daferreira
 */

public class BankTestFile {  
    @Test
    public void testeConstrutor() {
        Bank banco = new Bank("entrada4.txt");
        assertEquals(10, banco.size());
        assertNotNull(banco);
    }
    
    @Test
    public void testeSavingsAccount() {
        Bank banco = new Bank("entrada4.txt");
        assertEquals(2045, banco.getAccounts().get(2).getAccountNumber());
        assertEquals(1890.0, banco.getAccounts().get(2).getBalance(),0.01);  // Poupança
        assertTrue(banco.getAccounts().get(2) instanceof SavingsAccount);
    }
    
    @Test
    public void sortTest(){
        Bank banco = new Bank("entrada4.txt");
        banco.sortBalanceDecreasing();
        
       assertEquals(531, banco.getAccounts().get(9).getAccountNumber());
       assertEquals(388.0, banco.getAccounts().get(9).getBalance(),0.01);  // Taxa = 3.0
       assertEquals(2062, banco.getAccounts().get(8).getAccountNumber());  // 400,00
       assertEquals("Guilherme Freitas", banco.getAccounts().get(0).getOwner());
    }
    
    @Test
    public void regularAccountsTest(){
        Bank banco = new Bank("entrada4.txt");
        banco.sortBalanceDecreasing();
        
       assertEquals(2, banco.regularAccounts().size());
       assertEquals(2062, banco.regularAccounts().get(1).getAccountNumber());
       assertEquals("Regina Celia", banco.regularAccounts().get(0).getOwner());
    }
    
    @Test
    public void savingsAccountsTest(){
        Bank banco = new Bank("entrada4.txt");
        banco.sortBalanceDecreasing();
        
       assertEquals(2, banco.savingsAccounts().size());
       assertEquals(2045, banco.savingsAccounts().get(0).getAccountNumber());
       assertEquals("Vinicius Lopes", banco.savingsAccounts().get(1).getOwner());
    }
    
    @Test
    public void lawAccountsTest(){
        Bank banco = new Bank("entrada4.txt");
        banco.sortBalance();
        
        assertEquals(6, banco.lawAccounts().size());
        assertEquals(531, banco.lawAccounts().get(0).getAccountNumber());
    }
    
    @Test
    public void getAccountTypeTest(){
        Bank banco = new Bank("entrada4.txt");
        assertEquals(10, banco.getAccounts().size());
       assertEquals("CLA", banco.getAccountType(banco.getAccounts().get(0)));
    }
}
