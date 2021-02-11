
package Aula_02_selecao_laco;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class Ex06_maiorCom_N_elementos_while {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite a quantidade de numeros: ");
        int quantidade = in.nextInt();
        
        int maior = 0;
        int i = 0;
        
        while (i < quantidade) {
            System.out.printf("Digite o %d° numero: ", i + 1);
            int numero = in.nextInt();
            
            if (i == 0) {
                maior = numero;
            }
            else {
                if (numero > maior) 
                    maior = numero;
            }
            
            i++;
        }
        
        System.out.printf("O maior numero digitado eh %d.\n", maior);
    }
}
