
package Aula_01_Basico;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class Ex04_calculoMedia {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Informe a primeira nota: ");
        double nota1 = in.nextDouble();
        
        System.out.print("Informe a segunda nota: ");
        double nota2 = in.nextDouble();
        
        System.out.printf("Sua média é %.2f.\n", (nota1 + nota2) / 2);
    }
}
