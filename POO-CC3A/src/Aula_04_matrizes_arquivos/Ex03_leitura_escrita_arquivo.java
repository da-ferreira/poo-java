
package Aula_04_matrizes_arquivos;

import static Aula_04_matrizes_arquivos.Ex01_leitura_escrita_matrizes.exibeMatriz;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author david-ferreira
 */

public class Ex03_leitura_escrita_arquivo {
    public static void main(String[] args) throws IOException {  // o main esta tratando as exceçõe geradas abaixo.
        
        // localizacao do arquivo.
        int matriz[][] = leMatrizArquivo("C:\\Users\\ferre\\Documents\\NetBeansProjects\\POO-CC3A\\src\\Aula_04_matrizes_arquivos\\entrada.txt");
        exibeMatriz(matriz);
    } 

    public static int[][] leMatrizArquivo(String file) throws FileNotFoundException, IOException {  // exceção
        BufferedReader in = new BufferedReader(new FileReader(file));
        
        String linha = in.readLine();  // leitura da primeira linha.
        String linhas[] = linha.split(" ");  // separador
        
        int matriz[][] = new int[Integer.parseInt(linhas[0])]
                                [Integer.parseInt(linhas[1])];
        
        for (int i=0; i < matriz.length; i++) {
            linha = in.readLine();
            linhas = linha.split(" ");
            
            for (int j=0; j < matriz[0].length; j++)
                matriz[i][j] = Integer.parseInt(linhas[j]);
        }
        
        in.close();  // fechando o arquivo lógico.
        return matriz;
    }
}
    