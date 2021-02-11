
package Aula_01_Basico;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class Ex07_parImpar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite um numero natural: ");
        int numero = in.nextInt();
        
        if (numero % 2 == 0){
            System.out.printf("%d é par\n", numero);
        }
        else {
            System.out.printf("%d é impar\n", numero);
        }
    }
}
