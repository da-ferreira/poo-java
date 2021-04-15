
package Aula_02_selecao_laco;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class Ex05_combustivel_comElseIf {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Digite o tipo de combustivel");
        System.out.print("<A: Alcool, D: Diesel, G: Gasolina>: ");
        char opcao = in.nextLine().charAt(0);  // pegando o primeiro caracterer, a opcao escolhida.
        
        System.out.print("Digite a quantidade de litros: ");
        float litros = in.nextFloat();
        
        if (opcao == 'A' | opcao == 'a') {
            System.out.printf("Total de alcool: %.2f\n", litros * 1.7997);
        }
        else if (opcao == 'D' | opcao == 'd') {
            System.out.printf("Total de diesel: %.2f\n", litros * 0.9798);
        }
        else if (opcao == 'G' | opcao == 'g') {
            System.out.printf("Total de gasolina: %.2f\n", litros * 2.1009);
        }
        else {
            System.out.println("Opcao Invalida");
        }
    }
}
