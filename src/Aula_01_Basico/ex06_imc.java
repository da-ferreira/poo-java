
package Aula_01_Basico;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class ex06_imc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite seu peso [em kg]: ");
        double peso = in.nextDouble();
        
        System.out.print("Digite sua altura [em metros]: ");
        double altura = in.nextDouble();
        
        System.out.printf("Seu IMC é %.2f\n.", peso / (altura * altura));
    }
}
