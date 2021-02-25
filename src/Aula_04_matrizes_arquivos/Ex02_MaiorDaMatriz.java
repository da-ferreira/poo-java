
package Aula_04_matrizes_arquivos;

import static Aula_03_vetores_e_funcoes.Ex01_InverterNumeroComFuncao.leInteiroPositivo;
import static Aula_04_matrizes_arquivos.Ex01_leitura_escrita_matrizes.exibeMatriz;
import static Aula_04_matrizes_arquivos.Ex01_leitura_escrita_matrizes.leMatrizAleatorio;
import java.util.Scanner;

/**
 * @author david-ferreira
 */

public class Ex02_MaiorDaMatriz {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Informe o numero de linhas e colunas da matriz");
        
        int linhas = leInteiroPositivo();
        int colunas = leInteiroPositivo();
        
        int matriz[][] = leMatrizAleatorio(linhas, colunas);  // preenche a matriz com numeros aleatórios.
        exibeMatriz(matriz);  // exibe a matriz.
        
        System.out.printf("O maior elemento da matriz é %d.\n", maiorMatriz(matriz));
    }

    public static int maiorMatriz(int matriz[][]) {
        int maior = matriz[0][0];
        
        for (int i=0; i < matriz.length; i++)
            for (int j=0; j < matriz[0].length; j++) {
                if (matriz[i][j] > maior)
                    maior = matriz[i][j];
            }
        
        return maior;
    }
}
