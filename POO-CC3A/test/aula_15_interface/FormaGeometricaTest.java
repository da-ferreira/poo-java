
package aula_15_interface;

import org.junit.Test;
import static org.junit.Assert.*;
import Aula_15_Interface.Circulo;
import Aula_15_Interface.Retangulo;
import Aula_15_Interface.FormaGeometrica;
import java.util.ArrayList;
import java.util.List;

/**
 * @author daferreira
 */

public class FormaGeometricaTest {
    @Test
    public void circuloTest(){
        Circulo c1 = new Circulo(2.5);
        assertEquals(2.50, c1.getRaio(), 0.0001);
        assertEquals(19.63495408, c1.areaCalculavel(), 0.00001);
    }
    @Test
    public void retanguloTest(){
        Retangulo r1 = new Retangulo(3.0, 5.2);
        Retangulo r2 = new Retangulo(1.5, 3.6);
        assertEquals(3.0, r1.getLargura(), 0.0001);
        assertEquals(5.40, r2.areaCalculavel(), 0.0001);
    }
    
    @Test
    public void formaGeometricaTest(){
        List<FormaGeometrica> formas = new ArrayList<>();  // Casting up
        
        formas.add(new Circulo(2.5));
        formas.add(new Circulo(1.33));
        formas.add(new Retangulo(3.0, 5.2));
        formas.add(new Retangulo(1.5, 3.6));
        
        assertEquals(2.5, ((Circulo) formas.get(0)).getRaio(), 0.01);  // Casting down
        assertEquals(5.4, formas.get(3).areaCalculavel(), 0.01);
    }
}
