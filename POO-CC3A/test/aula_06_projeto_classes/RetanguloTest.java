
package aula_06_projeto_classes;

import org.junit.Test;
import Aula_06_projeto_classes.Retangulo;
import static org.junit.Assert.assertEquals;

public class RetanguloTest {
    
    @Test
    public void testeConstrutor() {
          Retangulo r = new Retangulo(5.0, 10.0, 20.0, 30.0);
          assertEquals(5.0, r.getX(), 0.0001);
    }
    
    @Test
    public void testeArea() {
          Retangulo r = new Retangulo(5, 10, 20, 30);
          assertEquals(600.0, r.area());
    }
    
    @Test
    public void testeTransladar() {
          Retangulo r = new Retangulo(5, 10, 20, 30);
          assertEquals (5.0, r.getX(), 0.0001);
          r.transladar(10, 10);
          assertEquals (15.0, r.getX(), 0.0001);
          assertEquals (20.0, r.getY(), 0.0001);
    }
    
}
