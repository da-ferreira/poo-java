
package Aula_02_selecao_laco;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class Ex04_imc {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite seu peso: ");
        float peso = in.nextFloat();
        
        System.out.print("Digite sua altura: ");
        float altura = in.nextFloat();
        
        float imc = peso / (altura * altura);
        System.out.printf("Seu IMC: %.2f\n", imc);
        
        if (imc < 18.5) {
            System.out.println("Voce esta abaixo do peso");
        }
        else {
            if (imc < 25.0) {
                System.out.println("Voce esta com peso normal");
            }
            else {
                if (imc < 30.0) {
                    System.out.println("Voce esta com sobrepeso");
                }
                else {
                    System.out.println("Voce esta com obesidade");
                }
            }   
        }
        
    }
}
