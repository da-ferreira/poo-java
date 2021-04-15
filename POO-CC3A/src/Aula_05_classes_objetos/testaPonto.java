
package Aula_05_classes_objetos;

/**
 * @author david-ferreira
 */

public class testaPonto {
    public static void main(String[] args) {
        Ponto p1 = new Ponto();
        System.out.println("P1 = " + p1);
        
        Ponto p2 = new Ponto(5, 10);
        System.out.println("P2 = " + p2);
        
        System.out.println(p1.igual(p2));
        
        p1.transladar(7, 14);
        System.out.println("P1 = " + p1);
        
        p1.setX(1);
        p1.setY(1);
        p2.setX(4);
        p2.setY(3);
        
        System.out.println(p1.distancia(p2));
    }
}
