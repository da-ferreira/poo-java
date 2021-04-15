
package Aula_04_matrizes_arquivos;

import static Aula_04_matrizes_arquivos.Ex01_leitura_escrita_matrizes.exibeMatriz;
import static Aula_04_matrizes_arquivos.Ex03_leitura_escrita_arquivo.leMatrizArquivo;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author david-ferreira
 */

public class Ex04_BuscaMatriz {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        
        int matriz[][] = leMatrizArquivo("C:\\Users\\ferre\\Documents\\NetBeansProjects\\POO-CC3A\\src\\Aula_04_matrizes_arquivos\\entrada.txt");
        exibeMatriz(matriz);
        
        System.out.print("Qual elemento deseja buscar na matriz: ");
        int elemento  = in.nextInt();
        int index[] = buscaLinearMatriz(matriz, elemento);
        
        if (index[0] == -1) {
            System.out.printf("%d não está na matriz.\n", elemento);
        }
        else {
            System.out.printf("%d está na linha %d e coluna %d.\n", elemento, index[0], index[1]);
        }
    }
    
    public static int[] buscaLinearMatriz(int matriz[][], int element) {
       /*
        * Guarda o indice da linha e da coluna.
        * Assumo que o elemento não está na matriz.
        */
        int indice[] = {-1, -1};
        
        for (int i=0; i < matriz.length; i++)
            for (int j=0; j < matriz[0].length; j++) {
                if (matriz[i][j] == element) {
                    indice[0] = i;
                    indice[1] = j;
                    return indice;
                }
            }
        
        return indice;  // elemento não está na matriz.
    }
}
