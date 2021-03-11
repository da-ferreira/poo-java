
package Aula_03_vetores_e_funcoes;

import static Aula_03_vetores_e_funcoes.Ex01_InverterNumeroComFuncao.leInteiroPositivo;
import static Aula_03_vetores_e_funcoes.Ex02_MaiorDoVetor.exibeVetor;
import static Aula_03_vetores_e_funcoes.Ex02_MaiorDoVetor.leVetorAleatorio;
import static Aula_03_vetores_e_funcoes.Ex06_BuscaBinaria.buscaBinaria;


public class Ex07_InterseccaoDeDoisVetores {
    public static void main(String[] args) {
        int dimensao1 = leInteiroPositivo();
        int vetor1[] = leVetorAleatorio(dimensao1);
        System.out.print("Elementos do vetor1: ");
        exibeVetor(vetor1);
        
        System.out.println("");
        
        int dimensao2 = leInteiroPositivo();
        int vetor2[] = leVetorAleatorio(dimensao2);
        System.out.print("Elementos do vetor2: ");
        exibeVetor(vetor2);
        
        int interseccao[] = new int[dimensao1];
        int tamanho = intersecaoVetores(interseccao, vetor1, vetor2);
        
        System.out.print("\n\nElementos do vetor interseccionado: ");
        exibeVetorTamanho(interseccao, tamanho);
        System.out.println("");
    }

    public static int intersecaoVetores(int interseccao[], int vetor1[], int vetor2[]) {
        int k = 0;  // quantidade
        
        for (int i=0; i < vetor1.length; i++) {
            if (buscaBinaria(vetor2, vetor1[i]) != -1) {
                if (buscaBinaria(interseccao, vetor1[i]) == -1) { // ou seja, se o elemento ja nao está no vetor interseccionado.
                    interseccao[k] = vetor1[i];
                    k++;
                }
            }
        }
        return k;
    }
    
    public static void exibeVetorTamanho(int vetor[], int k) {  // retorna um vetor de inteiros, com k posicoes.
        for (int i=0; i < k; i++) 
            System.out.print(vetor[i] + " ");
    }
}
