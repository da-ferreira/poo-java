
package Aula_02_selecao_laco;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class Ex01_maiorDeTresNumeros {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite o 1° numero: ");
        int n1 = in.nextInt();
        
        System.out.print("Digite o 2° numero: ");
        int n2 = in.nextInt();
        
        System.out.print("Digite o 3° numero: ");
        int n3 = in.nextInt();
        
        int maior;
        
        if (n1 > n2 && n1 > n3) {
            maior = n1;
        }
        else {
            if (n2 > n1 && n2 > n3) {
                maior = n2;
            }
            else {
                maior = n3;
            }
        }
        
        System.out.printf("O maior dos números é %d\n", maior);
    }
}
