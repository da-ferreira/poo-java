
package jogo_da_velha;

/**
 * @author david-ferreira
 */

public class FuncoesProcedimentos {
    public static char[][] initialize() {
        char jogo[][] = {
            {' ', ' ', ' '},  // os espaços representam que a posição não foi preenchida
            {' ', ' ', ' '},
            {' ', ' ', ' '}
        };
        
        return jogo;
    }
    
    public static boolean step(char jogo[][], int linha, int coluna, char jogador) {
        if (jogo[linha][coluna] == ' ') {
            jogo[linha][coluna] = jogador;
            return true;  // a posição estava vazia e conseguiu ser preenchida.
        }
        
        return false;  // a posicao ja estava preenchida.
    }
    
   /*
    * -1 (o jogo pode continuar)
    *  0 (ocorreu um empate)
    *  1 (O venceu)
    *  2 (X venceu)
    */
    public static int status(char jogo[][]) {
        
        // Passando pelas linhas e vendo se alguém ganhou.
        for (int i=0; i < 3; i++) {
            if (jogo[i][0] == jogo[i][1] && jogo[i][0] == jogo[i][2]) {  // se a linha tem 3 caracteres igual ('O', 'X' ou ' ')
                if (jogo[i][0] == 'O') {
                    return 1;  // bolinha venceu.
                }
                else if (jogo[i][0] == 'X') {
                    return 2; // xis venceu.
                }
            }
        }
        
        // Passando pelas colunas e vendo se alguém ganhou.
        for (int i=0; i < 3; i++) {
            if (jogo[0][i] == jogo[1][i] && jogo[0][i] == jogo[2][i]) {  // se a coluna tem 3 caracteres igual ('O', 'X' ou ' ')
                if (jogo[0][i] == 'O') {
                    return 1;  // bolinha venceu.
                }
                else if (jogo[0][i] == 'X') {
                    return 2; // xis venceu.
                }
            }
        }
        
        // Passando pela diagonal principal
        if (jogo[0][0] == jogo[1][1] && jogo[0][0] == jogo[2][2]){
            if (jogo[0][0] == 'O') {
                return 1;
            }
            else if (jogo[0][0] == 'X') {
                return 2;
            }
        }
        
        // Passando pela diagonal secundaria.
        if (jogo[0][2] == jogo[1][1] && jogo[0][2] == jogo[2][0]){
            if (jogo[0][2] == 'O') {
                return 1;
            }
            else if (jogo[0][2] == 'X') {
                return 2;
            }
        }
        
       /*
        * Testando se deu empate.
        * Percorre a matriz toda, e adiciona a uma variavel o numero
        * de char's == ' '. Se o numero for 0, deu empate. Caso contrário
        * continua o jogo.
        */
       int espacos_vazios = 0;
       
       for (int i=0; i < 3; i++) {
           for (int j=0; j < 3; j++) {
               if (jogo[i][j] == ' ')
                   espacos_vazios++;
           }
       }
       
       if (espacos_vazios == 0)
           return 0;  // ocorreu um empate
       
       return -1;  // o jogo pode continuar.
    }
}
