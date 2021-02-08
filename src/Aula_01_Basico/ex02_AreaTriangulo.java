
package Aula_01_Basico;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class ex02_AreaTriangulo {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite a base: ");
        double base = in.nextDouble();
        
        System.out.print("Digite a altura: ");
        double altura = in.nextDouble();
        
        System.out.printf("A área do triangulo é %.2f\n", (base * altura) / 2);
    }
}
