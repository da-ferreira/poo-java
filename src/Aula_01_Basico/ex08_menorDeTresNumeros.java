
package Aula_01_Basico;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class ex08_menorDeTresNumeros {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite o primeiro numero: ");
        int n1 = in.nextInt();
        
        System.out.print("Digite o segundo numero: ");
        int n2 = in.nextInt();
        
        System.out.print("Digite o terceiro numero: ");
        int n3 = in.nextInt();
        
        if (n1 < n2 && n1 < n3) {
            System.out.printf("%d é o menor número\n", n1);
        }
        else {
            if (n2 < n1 && n2 < n3) {
                System.out.printf("%d é o menor número\n", n2);
            }
            else {
                if (n3 < n1 && n3 < n2) {
                    System.out.printf("%d é o menor número\n", n3);
                }
                else {
                    System.out.printf("Os tres numeros são iguais a %d\n", n1);
                }
            }
        }
    } 
}
