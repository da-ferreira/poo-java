
package aula_07_relacionamentos;

import org.junit.Test;
import static org.junit.Assert.*;
import Aula_07_relacionamentos.Carro;
import Aula_07_relacionamentos.Gasolina;
import Aula_07_relacionamentos.Alcool;

/**
 * @author david-ferreira
 */

public class CarroTest {
   @Test
    public void tanqueDeGasolinaTest() { 
        Carro car = new Carro(); 
        car.encherTanque(new Gasolina(10.0)); 
        car.andar(14.0);    
        assertEquals(9.0, car.getCombustivel(), 0.001); 
    }   
    
    @Test
    public void tanqueDeAlcoolTest() { 
        Carro car = new Carro(); 
        car.encherTanque(new Alcool(10.0)); 
        car.andar(28.0);
        assertEquals(8.0, car.getCombustivel(), 0.001); 
    }
}
