
package Aula_03_vetores_e_funcoes;

import static Aula_03_vetores_e_funcoes.Ex01_InverterNumeroComFuncao.leInteiroPositivo;
import static Aula_03_vetores_e_funcoes.Ex02_MaiorDoVetor.exibeVetor;
import static Aula_03_vetores_e_funcoes.Ex02_MaiorDoVetor.leVetorAleatorio;
import static Aula_03_vetores_e_funcoes.Ex05_BubbleSort.bubbleSort;
import java.util.Scanner;

public class Ex06_BuscaBinaria {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int dimensao = leInteiroPositivo();
        int vetor[] = leVetorAleatorio(dimensao);
        
        bubbleSort(vetor);  // ordenando o vetor
        System.out.print("Elementos do vetor ordenado: ");
        exibeVetor(vetor);
        
        System.out.print("\nDigite o numero para buscar: ");
        int elemento = in.nextInt();
        int posicao = buscaBinaria(vetor, elemento);
        
        if (posicao != -1) {
            System.out.printf("%d está na posição %d.\n", elemento, posicao);
        }
        else {
            System.out.printf("%d não está no vetor.\n", elemento);
        }
    }
    
    public static int buscaBinaria(int vetor[], int item) {
        int inicio = 0;
        int fim = vetor.length - 1;
        
        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            
            if (item == vetor[meio]) {
                return meio;
            }
            else if (item < vetor[meio]) {
                fim = meio - 1;
            }
            else if (item > vetor[meio]) {
                inicio = meio + 1;
            }
        }
        
        return -1;  // o elemento não está no vetor.
   }
}
