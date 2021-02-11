
package Aula_02_selecao_laco;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class Ex09_inverteNumero {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numero;
        
        do {
            System.out.print("Digite um numero inteiro e positivo: ");
            numero = in.nextInt();
            
        } while (numero <= 0);
        
        int numero_invertido = 0;
        int resto;
        
        while (numero > 0) {
            resto = numero % 10;
            numero_invertido = (numero_invertido * 10) + resto;
            numero /= 10;
        }
        
        System.out.printf("O numero invertido eh %d.\n", numero_invertido);
    }
}
