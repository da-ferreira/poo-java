
package Aula_03_vetores_e_funcoes;

import static Aula_03_vetores_e_funcoes.Ex01_InverterNumeroComFuncao.leInteiroPositivo;
import static Aula_03_vetores_e_funcoes.Ex02_MaiorDoVetor.exibeVetor;
import static Aula_03_vetores_e_funcoes.Ex02_MaiorDoVetor.leVetorAleatorio;
import java.util.Scanner;

public class Ex04_BuscaLinear {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int dimensao = leInteiroPositivo();
        int vetor[] = leVetorAleatorio(dimensao);
         
        System.out.print("Elementos do vetor: ");
        exibeVetor(vetor);
        
        System.out.print("\nDigite o numero para buscar: ");
        int elemento = in.nextInt();
        
        int posicao = buscaLinear(vetor, elemento);
        
        if (posicao != -1) {
            System.out.printf("%d está na posição %d.\n", elemento, posicao);
        }
        else {
            System.out.printf("%d não está no vetor.\n", elemento);
        }
    }

    public static int buscaLinear(int vetor[], int element) {
        for (int i=0; i < vetor.length; i++)
            if (vetor[i] == element) {
                return i;
            }
        
        return -1; // o elemento nao esta no vetor.
    }
}
