
package jogo_da_velha;

import java.util.Scanner;

/**
 * @author david-ferreira
 */

public class Utilitarios {
   /*
    * Método para limpar a tela.
    * É improvisado, pois não achei nenhum que ja vem no java,
    * tipo o "cls".
    */
    public static void clearScreen() {  
        for (int i=0; i < 100; i++)
            System.out.println("");
    }
    
    // Método que mostrará o jogo da velha formatado.
    public static void mostrarJogo(char jogo[][]) {
        System.out.println("");
        
        for (int i=0; i < 3; i++) {
            System.out.printf("%d     %c  |  %c  |  %c  ", i + 1, jogo[i][0], jogo[i][1], jogo[i][2]);
            
            if (i != 2)
                System.out.println("\n    -----------------");
        }
        
        System.out.println("\n\n      1     2     3  ");
    }
    
   /*
    * Le um numero inteiro. A string serve como mensagem de interacao.
    * Esse método será usado nas leituras de linha e coluna
    * que o jogador escolherá para fazer as jogadas.
    */
    public static int leInteiro(String mensagem) {
        Scanner in = new Scanner(System.in);
        System.out.println(mensagem);
        int numero;
        
        do {
            System.out.print(">> ");
            numero = in.nextInt();
            
            if (numero < 0 || numero > 3)
                System.out.println("Por favor, informe o numero corretamente.");
        
        } while (numero < 0 || numero > 3);
        
        return numero;
    }
    
    public static boolean jogarNovamente() {
        Scanner in = new Scanner(System.in);
        char opcao;
        
        System.out.println("\nDeseja jogar novamente? [S(sim), N(nao)]: ");
        
        do {
            System.out.print(">> ");
            opcao = in.nextLine().toUpperCase().charAt(0);  // pega o primeiro caractere.
            
            if (opcao != 'S' && opcao != 'N')
                System.out.println("Por favor, informe somente [S(sim), N(nao)].");
            
        } while (opcao != 'S' && opcao != 'N');
        
        return opcao == 'S';
    }
}
