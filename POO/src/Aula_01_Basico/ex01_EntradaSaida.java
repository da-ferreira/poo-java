
package Aula_01_Basico;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class ex01_EntradaSaida {
    public static void main(String[] args) {
        // Cria Scanner para obter dados de entrada a partir de janela de comando.
        Scanner in = new Scanner(System.in);
        
        // Lendo a idade
        System.out.print("Digite sua idade: ");
        int idade = in.nextInt();  // lê o inteiro para idade
        
        // Lendo peso
        System.out.print("Digite seu peso: ");
        double peso = in.nextDouble();
        
        // Lendo nome
        in = new Scanner(System.in);  // fazendo um novo Scanner
        System.out.print("Digite seu nome: ");
        String nome = in.nextLine();
        
        // Printando informancões
        System.out.printf("\nSeu nome é: %s\n", nome);
        System.out.printf("Seu peso é %.2f\n", peso);
        System.out.printf("Sua idade é %d.\n\n", idade);
        
        // Primeiros caracters, tal qual nome[0] em python
        in = new Scanner(System.in);
        System.out.print("Escolha a opção [a/b]: ");
        char opcao = in.nextLine().charAt(0);  // pegando o primeiro caracter
        System.out.printf("A sua opcão: %s\n", opcao);
        
        opcao = 'F'; // tipo char so aceita aspas simples
        System.out.printf("Opção mudada para: %s\n", opcao);
    }
}
