
package Aula_03_vetores_e_funcoes;

import java.util.Scanner;

public class Ex01_InverterNumeroComFuncao {
    public static void main(String[] args) {
        int numero = leInteiroPositivo();  // chamando a função leInteiroPositivo
        int numero_invertido = inverterNumero(numero);  // chamando a função inverterNumero
        
        System.out.printf("O numero invertido eh %d.\n", numero_invertido);
    }
    
    public static int leInteiroPositivo() {
        Scanner in = new Scanner(System.in);
        int number;
        
        do {
            System.out.print("Digite um numero inteiro e positivo: ");
            number = in.nextInt();
            
        } while (number <= 0);
        
        return number;
    }

    public static int inverterNumero(int numero) {
        int resto;
        int n_invertido = 0;
        
        while (numero > 0) {
            resto = numero % 10;
            n_invertido = (n_invertido * 10) + resto;
            numero /= 10;
        }
        
        return n_invertido;
    }
}
