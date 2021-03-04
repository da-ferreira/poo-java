
package Aula_05_classes_objetos;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author david-ferreira
 */

public class Ex01_TestaRetangulo {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();  // criando o retangulo nulo.
        System.out.println("R1: " + r1);
        System.out.println(r1.getHeight());
        
        Rectangle r2 = new Rectangle(5, 10, 20, 30);
        System.out.println("R2: " + r2);
        System.out.println(r2.height);
        System.out.println(r2.getHeight());
        
        Rectangle r3 = new Rectangle(20, 30);
        System.out.println("R3: " + r3);
        System.out.println(r3.height);
        System.out.println(r3.getHeight());
        
        /*
        r3.translate(5, 15);
        System.out.println(r3);
        */
        
        // r2 é o parametro implicito, ja o r3 é o parametro explicito.
        // O método verifica se há ou nao intersecção de r2 e r3.
        System.out.println(r2.intersects(r3));
        
        // O método retorna o retangulo da intersecção de r2 e r3
        Rectangle r4 = r2.intersection(r3);
        System.out.println("R4: " + r4);
        
        // Passando o ponto a partir da classe Point
        // Passando a dimensão a partir da classe Dimension
        Rectangle r5 = new Rectangle(new Point(3, 8), new Dimension(10, 20));
        System.out.println("R5: " + r5);
    }
}
