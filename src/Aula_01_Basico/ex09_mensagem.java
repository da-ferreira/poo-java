
package Aula_01_Basico;

import java.util.Scanner;

/**
 * @author ferreira
 */

public class ex09_mensagem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite seu nome: ");
        String nome = in.nextLine();
        
        System.out.print("Digite seu sexo [M/F]: ");
        char sexo = in.nextLine().charAt(0);
        
        System.out.print("Digite sua idade: ");
        int idade = in.nextInt();
        
        if (sexo == 'F' && idade < 40)
            System.out.printf("Seja bem vindo, %s.\n", nome);
    }
}
