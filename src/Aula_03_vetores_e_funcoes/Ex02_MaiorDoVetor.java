
package Aula_03_vetores_e_funcoes;

import static Aula_03_vetores_e_funcoes.Ex01_InverterNumeroComFuncao.leInteiroPositivo;
import java.util.Scanner;

public class Ex02_MaiorDoVetor {
    public static void main(String[] args) {
        int dimensao = leInteiroPositivo();  // le a dimensão do vetor
        //int vetor[] = leVetor(dimensao);  // declarando e chamando função para preencher.
        
        int vetor[] = leVetorAleatorio(dimensao);
        
        System.out.print("Elementos do vetor: ");
        exibeVetor(vetor);
        
        System.out.printf("\nO maior elemento do vetor eh %d.\n", maiorVetor(vetor));
    }

    public static int[] leVetor(int tamanho) {  // retorna um vetor de inteiros.
        int vetor[] = new int[tamanho];
        Scanner in = new Scanner(System.in);
        
        for (int i=0; i < tamanho; i++) {
            System.out.printf("Digite o %dº numero: ", i + 1);
            vetor[i] = in.nextInt();
        }
        
        return vetor;
    }
    
    public static int[] leVetorAleatorio(int tamanho) {  // retorna um vetor de inteiros.
        int vetor[] = new int[tamanho];
        
        for (int i=0; i < tamanho; i++) {
            vetor[i] = (int) (Math.random() * 100);  // Aleatorios entre 0 e 100.
        }
        
        return vetor;
    }
    
    public static void exibeVetor(int vetor[]) {  // retorna um vetor de inteiros.
        for (int item: vetor) {
            System.out.print(item + " ");
        }
    }

    public static int maiorVetor(int[] vetor) {
        int maior = vetor[0];
        
        for (int i=1; i < vetor.length; i++)
            if (vetor[i] > maior)
                maior = vetor[i];
        
        return maior;
    }
}
