
package Aula_02_selecao_laco;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class Ex03_ordenaTresNumeros_comFuncao {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite o 1° numero: ");
        int n1 = in.nextInt();
        
        System.out.print("Digite o 2° numero: ");
        int n2 = in.nextInt();
        
        System.out.print("Digite o 3° numero: ");
        int n3 = in.nextInt();
        
        // Usando uma lista porque em Java tipos primitivos sao passados como um valor
        // e nao como referencia; a lista eh passada como referencia.
        int[] valores = {n1, n2, n3};
        
        // Colocando o menor de todos no n1.
        if (n1 > n2 || n1 > n3) 
            if (n2 < n3) {
                troca(n1, n2);  
            }
            else {
                troca(n1, n3);
            }  

        // Intermediário entre n2 e n3
        if (n2 > n3) 
            troca(n2, n3);

        System.out.printf("Os valores ordenados são: %d, %d, e %d.\n", n1, n2, n3);
    }
    
    /* Função que troca valores.
    /  public: eh a visibilidade do programa
       void: não retorna valor */
    public static void troca(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }
 }
