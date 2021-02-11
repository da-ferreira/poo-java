
package Aula_02_selecao_laco;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class Ex02_ordenaTresNumeros_semFuncao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite o 1° numero: ");
        int n1 = in.nextInt();
        
        System.out.print("Digite o 2° numero: ");
        int n2 = in.nextInt();
        
        System.out.print("Digite o 3° numero: ");
        int n3 = in.nextInt();
        
        int temp;
        
        // Colocando o menor de todos no n1.
        if (n1 > n2 || n1 > n3) 
            if (n2 < n3) {
                temp = n1;
                n1 = n2;
                n2 = temp;
            }
            else {
                temp = n1;
                n1 = n3;
                n3 = temp;
            }
        
        // Intermediário entre n2 e n3
        if (n2 > n3) {
            temp = n2;
            n2 = n3;
            n3 = temp;
        }
        System.out.printf("Os valores ordenados são: %d, %d, e %d.\n", n1, n2, n3);
    }
}
