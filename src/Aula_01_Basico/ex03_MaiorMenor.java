
package Aula_01_Basico;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class ex03_MaiorMenor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite o primeiro numero: ");
        double n1 = in.nextDouble();
        
        System.out.print("Digite o segundo numero: ");
        double n2 = in.nextDouble();
        
        if (n1 >= n2) {
            System.out.printf("O maior numero é %.2f\n", n1);
            System.out.printf("O menor numero é %.2f\n", n2);
        }
        else {
            System.out.printf("O maior numero é %.2f\n", n2);
            System.out.printf("O menor numero é %.2f\n", n1);
        }
    }
}
