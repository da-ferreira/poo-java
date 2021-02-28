
package jogo_da_velha;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import static jogo_da_velha.FuncoesProcedimentos.initialize;
import static jogo_da_velha.FuncoesProcedimentos.status;
import static jogo_da_velha.FuncoesProcedimentos.step;
import static jogo_da_velha.Utilitarios.clearScreen;
import static jogo_da_velha.Utilitarios.jogarNovamente;
import static jogo_da_velha.Utilitarios.leInteiro;
import static jogo_da_velha.Utilitarios.mostrarJogo;

/**
 * @author david-ferreira
 */

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        game();
        System.out.println("\n -=-= VOLTE SEMPRE! =-=-\n");
    }
    
    // Função geral do jogo, onde conterá toda lógica e funcionamento do jogo da velha.
    public static void game() throws InterruptedException {
        Scanner in = new Scanner(System.in);
        Random random = new Random();
        boolean sair = false;

        System.out.print("Digite seu nome: ");
        String nome = in.nextLine().trim().toUpperCase();  // trim() remove espaço no inicio e fim.
        System.out.printf("\nSEJA BEM VIDO, %s!\n", nome);  
        
        while (! sair) {
            char jogo_da_velha[][] = initialize();  // JOGO DA VELHA.

            System.out.println("\nEscolha um símbolo para jogar: ");
            int simbolo;

            do {
                System.out.println("1. O");
                System.out.print("2. X\n>> ");
                simbolo = in.nextInt();

                if (simbolo  != 1 && simbolo != 2)
                    System.out.println("Por favor, informe o símbolo corretamente.");

            } while (simbolo  != 1 && simbolo != 2); 

            final char JOGADOR;  // simbolo do jogador.
            final char MAQUINA;  // simbolo da maquina.

            if (simbolo == 1) {
                JOGADOR = 'O';
                MAQUINA = 'X';
            }
            else {
                JOGADOR = 'X';
                MAQUINA = 'O';
            }

            System.out.println("Tenha um bom jogo...");
            TimeUnit.SECONDS.sleep(1);
            clearScreen();

           /*
            * Escolhe aleatoriamente um valor entre true e false.
            * Se o valor for true, o jogador começa jogando,
            * caso contrario, a maquina começa jogando.
            */
            boolean intercalador = random.nextBoolean();
            boolean sair_jogada = false;

            while (! sair_jogada) {
                if (intercalador) {  // usuario jogando
                    mostrarJogo(jogo_da_velha);

                    int linha = leInteiro("\nInforme a linha que deseja jogar: ");
                    int coluna = leInteiro("\nInforme a coluna que deseja jogar: ");

                    while (! step(jogo_da_velha, linha - 1, coluna - 1, JOGADOR)) {
                        System.out.println("Este quadrado já foi preenchido. Por favor escolha outro.");
                        linha = leInteiro("\nInforme a linha que deseja jogar: ");
                        coluna = leInteiro("\nInforme a coluna que deseja jogar: ");
                    }

                    clearScreen();
                    intercalador = false;
                }
                else {  // maquina jogando

                    // gerando um numero aleatorio entre 1 até 4 para a linha e coluna
                    int linha = (int) (1 + Math.random() * (4 - 1));  
                    int coluna = (int) (1 + Math.random() * (4 - 1));

                    // Pode acontecer de os numeros gerados (linha e coluna) já estiverem preenchidos.
                    // Neste caso, gera-se outros até der um quadrado vazio.
                    while (! step(jogo_da_velha, linha - 1, coluna - 1, MAQUINA)) {
                        linha = (int) (1 + Math.random() * (4 - 1));  
                        coluna = (int) (1 + Math.random() * (4 - 1));
                    }

                    clearScreen();
                    intercalador = true;

                }

                int estado_jogo = status(jogo_da_velha);

                switch (estado_jogo) {
                    case 0:
                        mostrarJogo(jogo_da_velha);
                        
                        System.out.println("\n-=-=- DEU VELHA, TENTE NOVAMENTE :( -=-=-");
                        
                        if (! jogarNovamente()) {
                            sair_jogada = true;
                            sair = true;
                        }
                        else {
                            sair_jogada = true;
                        }
                        break;
                    
                    case 1:
                        mostrarJogo(jogo_da_velha);
                        
                        if (JOGADOR == 'O') {
                            System.out.println("\n-=-=- PARABÉNS, VOCÊ GANHOU :) -=-=-");
                        }
                        else {
                            System.out.println("\n-=-=- VOCÊ PERDEU, TENTE NOVAMENTE :( -=-=-");
                        }
                        
                        if (! jogarNovamente()) {
                            sair_jogada = true;
                            sair = true;
                        }
                        else {
                            sair_jogada = true;
                        }
                        break;
                    
                    case 2:
                        mostrarJogo(jogo_da_velha);
                        
                        if (JOGADOR == 'X') {
                            System.out.println("\n-=-=- PARABÉNS, VOCÊ GANHOU :) -=-=-");
                        }
                        else {
                            System.out.println("\n-=-=- VOCÊ PERDEU, TENTE NOVAMENTE :( -=-=-");
                        }
                        
                        if (! jogarNovamente()) {
                            sair_jogada = true;
                            sair = true;
                        }
                        else {
                            sair_jogada = true;
                        }
                        break;
                }
            }
        }
    }  
}
  
