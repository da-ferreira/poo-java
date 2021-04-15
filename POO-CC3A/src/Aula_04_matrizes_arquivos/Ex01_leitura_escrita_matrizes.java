
package Aula_04_matrizes_arquivos;

import static Aula_03_vetores_e_funcoes.Ex01_InverterNumeroComFuncao.leInteiroPositivo;
import java.util.Scanner;

/**
 * @author david-ferreira
 */

public class Ex01_leitura_escrita_matrizes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Informe o numero de linhas e colunas da matriz");
        
        int linhas = leInteiroPositivo();
        int colunas = leInteiroPositivo();
        
        int matriz[][] = leMatrizAleatorio(linhas, colunas);  // preenche a matriz com numeros aleatórios.
        exibeMatriz(matriz);  // exibe a matriz.
    }

    public static int[][] leMatrizAleatorio(int linhas, int colunas) {
        int matriz[][] = new int[linhas][colunas];
        
        for (int i=0; i < matriz.length; i++)
            for (int j=0; j < matriz[0].length; j++)
                matriz[i][j] = (int) (10 + Math.random() * (100 - 10));  // numeros entre 10 e 100.
        
        return matriz;
    }

    public static void exibeMatriz(int matriz[][]) {
        for (int i=0; i < matriz.length; i++) {
            for (int j=0; j < matriz[0].length; j++)
                System.out.printf("%d ", matriz[i][j]);
            
            System.out.println();  // pulando linha
        }
    }
}
