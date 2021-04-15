
package Aula_03_vetores_e_funcoes;

import static Aula_03_vetores_e_funcoes.Ex01_InverterNumeroComFuncao.leInteiroPositivo;
import static Aula_03_vetores_e_funcoes.Ex02_MaiorDoVetor.exibeVetor;
import static Aula_03_vetores_e_funcoes.Ex02_MaiorDoVetor.leVetorAleatorio;

public class Ex05_BubbleSort {
    public static void main(String[] args) {
        int dimensao = leInteiroPositivo();
        int vetor[] = leVetorAleatorio(dimensao);
         
        System.out.print("Elementos do vetor: ");
        exibeVetor(vetor);
        
        bubbleSort(vetor);
        
        System.out.print("\nElementos do vetor ordenado: ");
        exibeVetor(vetor);
        
    }

    public static void bubbleSort(int vetor[]) {
        for (int i=0; i < vetor.length - 1; i++) {
            // Area ordenada, jogando os maiores para o final.
            // Assim, a cada passada a area ordenada aumenta.
            int tamanho = vetor.length - (i + 1);
            
            for (int j=0; j < tamanho; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    // Troca (swap)
                    int temp = vetor[j];  
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }       
    }
}
