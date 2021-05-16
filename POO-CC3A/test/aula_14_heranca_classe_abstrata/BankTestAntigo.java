
package aula_14_heranca_classe_abstrata;

import org.junit.Test;
import static org.junit.Assert.*;
import Aula_14_Heranca_Classe_Abstrata.BankAntigo;
import Aula_14_Heranca_Classe_Abstrata.LawAccountAntigo;
import Aula_12_Heranca.SavingsAccount;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author david-ferreira
 */


public class BankTestAntigo {
    @Test
    public void testeContrutor() {
        BankAntigo banco = new BankAntigo();
        assertNotNull(banco);
    }
    
    @Test
    public void testeAddSavingsAccount() {
        BankAntigo banco = new BankAntigo();
        assertNotNull(banco);
        
        SavingsAccount conta = new SavingsAccount(0.05, "Joao Carneiro", 123, 500.00, "abc123");
        banco.addAccount(conta);
        
        assertEquals(0.05, conta.getInterestRate(), 0.0001);
        assertEquals(525.0, conta.getBalance(), 0.0001);
        assertEquals("Joao Carneiro", conta.getOwner());
        assertEquals(123, conta.getAccountNumber());
    }
    
    @Test
    public void testeAddLawAccount() {
        BankAntigo banco = new BankAntigo();
        assertNotNull(banco);
        
        SimpleDateFormat formata = new SimpleDateFormat("dd/MM/yyyy");
        LawAccountAntigo conta;
        
        try {
            conta = new LawAccountAntigo("Processo Trabalista", formata.parse("10/01/2018"), formata.parse("13/05/2021"), 10.0, 
                                                                                  "Joao Carneiro", 123, 1000.00, "abc123");
            
            assertEquals("10/01/2018", formata.format(conta.getStart()));
            assertEquals("13/05/2021", formata.format(conta.getEnd()));
            assertEquals("Processo Trabalista", conta.getAim());
            assertEquals(900.00, conta.getBalance(), 0.0001);
            assertEquals(10.0, conta.getAdmFee(), 0.0001);
            assertEquals(123, conta.getAccountNumber());
            assertEquals("Joao Carneiro", conta.getOwner());
            
        } catch (ParseException ex) {
            Logger.getLogger(BankTestAntigo.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
}
    